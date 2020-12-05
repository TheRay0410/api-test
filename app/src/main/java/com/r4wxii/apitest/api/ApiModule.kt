package com.r4wxii.apitest.api

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {
    @Binds
    @Singleton
    abstract fun provideFeedlyApi(apiImpl: FeedlyApiImpl): FeedlyApi

    @Module
    @InstallIn(SingletonComponent::class)
    internal object HttpClientModule {
        @Provides
        @Singleton
        fun provideHttpClient(): HttpClient = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json { ignoreUnknownKeys = true })
            }
        }
    }
}