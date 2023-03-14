package com.example.demoviperbindview.presentation.di

import com.example.demoviperbindview.presentation.ui.main.fragment.main.MainContract
import com.example.demoviperbindview.presentation.ui.main.fragment.main.MainInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class InteractorModule {

    @Singleton
    @Binds
    abstract fun providerMainInteractor(mainInteractor: MainInteractor): MainContract.Interactor
}