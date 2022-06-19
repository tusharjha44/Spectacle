package com.example.spectacle.presentation.di.core

import com.example.spectacle.data.api.SpectacleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun getRetrofitService(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun getSpectacleService(retrofit: Retrofit): SpectacleService{
        return retrofit.create(SpectacleService::class.java)
    }

}