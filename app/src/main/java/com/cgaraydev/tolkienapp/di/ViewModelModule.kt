package com.cgaraydev.tolkienapp.di

import com.cgaraydev.tolkienapp.presentation.books.BooksViewModel
import com.cgaraydev.tolkienapp.presentation.characters.CharactersViewModel
import com.cgaraydev.tolkienapp.presentation.events.EventsViewModel
import com.cgaraydev.tolkienapp.presentation.languages.LanguagesViewModel
import com.cgaraydev.tolkienapp.presentation.locations.LocationsViewModel
import com.cgaraydev.tolkienapp.presentation.others.OthersViewModel
import com.cgaraydev.tolkienapp.presentation.races.RacesViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideCharactersViewModel(): CharactersViewModel {
        return CharactersViewModel(FirebaseFirestore.getInstance())
    }

    @Provides
    @ViewModelScoped
    fun provideLocationsViewModel(): LocationsViewModel {
        return LocationsViewModel(FirebaseFirestore.getInstance())
    }

    @Provides
    @ViewModelScoped
    fun provideRacesViewModel(): RacesViewModel {
        return RacesViewModel(FirebaseFirestore.getInstance())
    }

    @Provides
    @ViewModelScoped
    fun provideEventsViewModel(): EventsViewModel {
        return EventsViewModel(FirebaseFirestore.getInstance())
    }

    @Provides
    @ViewModelScoped
    fun provideLanguagesViewModel(): LanguagesViewModel {
        return LanguagesViewModel(FirebaseFirestore.getInstance())
    }

    @Provides
    @ViewModelScoped
    fun provideOthersViewModel(): OthersViewModel {
        return OthersViewModel(FirebaseFirestore.getInstance())
    }

    @Provides
    @ViewModelScoped
    fun provideBooksViewModel(): BooksViewModel {
        return BooksViewModel(FirebaseFirestore.getInstance())
    }

}