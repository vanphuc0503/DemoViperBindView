package com.example.demoviperbindview.data.di

import javax.inject.Qualifier

object QualifierAnnotation {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class New

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Crew
}