package com.cgaraydev.tolkienapp.di

import android.content.Context
import com.cgaraydev.tolkienapp.utils.AudioManager
import com.cgaraydev.tolkienapp.utils.BestTimesManager
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideBestTimesManager(@ApplicationContext context: Context): BestTimesManager {
        return BestTimesManager(context)
    }

    @Provides
    @Singleton
    fun provideAudioManager(@ApplicationContext context: Context): AudioManager {
        return AudioManager(context)
    }

}

