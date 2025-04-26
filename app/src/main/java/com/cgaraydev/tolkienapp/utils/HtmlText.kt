package com.cgaraydev.tolkienapp.utils

import android.graphics.Typeface
import android.text.Spanned
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.util.Patterns
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import com.cgaraydev.tolkienapp.R
import com.cgaraydev.tolkienapp.navigation.Routes
import com.cgaraydev.tolkienapp.ui.theme.Golden
import com.cgaraydev.tolkienapp.ui.theme.QuizRed

@Composable
fun HtmlText(
    htmlText: String,
    modifier: Modifier = Modifier,
    navController: NavController,
    textStyle: TextStyle = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.cardo))
    ),
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
                                    color = if (isValidCustomLink(span.url)) Golden else QuizRed,
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
    Box(modifier = modifier) {
        ClickableText(
            text = annotatedString,
            style = textStyle,
            modifier = Modifier.fillMaxWidth(),
            onClick = { offset ->
                annotatedString.getStringAnnotations("LINK", offset, offset)
                    .firstOrNull()?.let { annotation ->
                        handleCustomLink(
                            url = annotation.item,
                            navController = navController,
                            onInvalid = onInvalidLink
                        )
                    }
            }
        )
    }

}

private fun handleCustomLink(
    url: String,
    navController: NavController,
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

        url.startsWith("race:") -> {
            val id = url.substringAfter("race:")
            if (id.isNotEmpty()) navController.navigate(Routes.RaceDetails.createRoute(id)) else onInvalid()
        }

        url.startsWith("event:") -> {
            val id = url.substringAfter("event:")
            if (id.isNotEmpty()) navController.navigate(Routes.EventDetails.createRoute(id)) else onInvalid()
        }

        url.startsWith("other:") -> {
            val id = url.substringAfter("other:")
            if (id.isNotEmpty()) navController.navigate(Routes.OtherDetails.createRoute(id)) else onInvalid()
        }

        url.startsWith("language:") -> {
            val id = url.substringAfter("language:")
            if (id.isNotEmpty()) navController.navigate(Routes.LanguageDetails.createRoute(id)) else onInvalid()
        }

        else -> onInvalid()
    }

}

private fun isValidCustomLink(url: String): Boolean {
    return when {
        url.startsWith("character:") -> url.substringAfter("character:").isNotEmpty()
        url.startsWith("location:") -> url.substringAfter("location:").isNotEmpty()
        url.startsWith("race:") -> url.substringAfter("race:").isNotEmpty()
        url.startsWith("event:") -> url.substringAfter("event:").isNotEmpty()
        url.startsWith("other:") -> url.substringAfter("other:").isNotEmpty()
        url.startsWith("language:") -> url.substringAfter("language:").isNotEmpty()
        else -> Patterns.WEB_URL.matcher(url).matches()
    }
}