package com.example.demoviperbindview.data.di

import com.example.demoviperbindview.data.network.NetworkResponseAdapterFactory
import com.example.demoviperbindview.data.service.remote.ApiKeyInterceptor
import com.example.demoviperbindview.data.service.remote.CrewApi
import com.example.demoviperbindview.data.service.remote.NewsApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    @QualifierAnnotation.New
    fun providesInterceptorNew(): Interceptor = ApiKeyInterceptor()

    @Singleton
    @Provides
    @QualifierAnnotation.New
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        @QualifierAnnotation.New interceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    @QualifierAnnotation.Crew
    fun providesOkHttpClientCrew(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    @QualifierAnnotation.New
    fun providerRetrofitNews(
        moshi: Moshi, @QualifierAnnotation.New okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    @QualifierAnnotation.Crew
    fun providerRetrofitCrew(
        moshi: Moshi, @QualifierAnnotation.Crew okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.spacexdata.com/v4/")
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(@QualifierAnnotation.New retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideCrewApi(@QualifierAnnotation.Crew retrofit: Retrofit): CrewApi =
        retrofit.create(CrewApi::class.java)

}