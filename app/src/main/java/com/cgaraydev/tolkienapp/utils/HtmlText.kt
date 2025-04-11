package com.cgaraydev.tolkienapp.utils

import android.graphics.Typeface
import android.text.Spanned
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.util.Patterns
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.ui.theme.Golden

@Composable
fun HtmlText(
    htmlText: String,
    modifier: Modifier = Modifier,
    navController: NavController,
    uriHandler: UriHandler = LocalUriHandler.current,
    onInvalidLink: () -> Unit = {},
) {

    val annotatedString = remember(htmlText) {
        val spanned = HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_COMPACT)
        buildAnnotatedString {
            append(spanned.toString())

            (spanned as? Spanned)?.let { spanned ->
                spanned.getSpans(0, spanned.length, Any::class.java).forEach { span ->
                    val start = spanned.getSpanStart(span)
                    val end = spanned.getSpanEnd(span)

                    when (span) {
                        is URLSpan -> {
                            addStyle(
                                style = SpanStyle(
                                    color = if (isValidCustomLink(span.url)) Golden else Color.Red,
                                    textDecoration = TextDecoration.None
                                ),
                                start = start,
                                end = end
                            )
                            addStringAnnotation(
                                tag = "LINK",
                                annotation = span.url,
                                start = start,
                                end = end
                            )
                        }
                        is StyleSpan -> {
                            when (span.style) {
                                Typeface.BOLD -> addStyle(
                                    style = SpanStyle(fontWeight = FontWeight.Bold),
                                    start = start,
                                    end = end
                                )
                                Typeface.ITALIC -> addStyle(
                                    style = SpanStyle(fontStyle = FontStyle.Italic),
                                    start = start,
                                    end = end
                                )
                            }
                        }
                    }
                }

            }
        }
    }
    ClickableText(
        text = annotatedString,
        modifier = modifier,
        style = TextStyle(color = Color.White, fontSize = 16.sp),
        onClick = { offset ->
            annotatedString.getStringAnnotations("LINK", offset, offset)
                .firstOrNull()?.let { annotation ->
                    handleCustomLink(
                        url = annotation.item,
                        navController = navController,
                        uriHandler = uriHandler,
                        onInvalid = onInvalidLink
                    )
                }
        }
    )
}

private fun handleCustomLink(
    url: String,
    navController: NavController,
    uriHandler: UriHandler,
    onInvalid: () -> Unit
) {
    when {
        url.startsWith("character:") -> {
            val id = url.substringAfter("character:")
            if (id.isNotEmpty()) navController.navigate(Routes.CharacterDetails.createRoute(id)) else onInvalid()
        }
        url.startsWith("location:") -> {
            val id = url.substringAfter("location:")
            if (id.isNotEmpty()) navController.navigate(Routes.LocationDetails.createRoute(id)) else onInvalid()
        }

        url.startsWith("http") -> uriHandler.openUri(url)
        else -> onInvalid()
    }

}

private fun isValidCustomLink(url: String): Boolean {
    return when {
        url.startsWith("character:") -> url.substringAfter("character:").isNotEmpty()
        url.startsWith("location:") -> url.substringAfter("location:").isNotEmpty()
        else -> Patterns.WEB_URL.matcher(url).matches()
    }
}