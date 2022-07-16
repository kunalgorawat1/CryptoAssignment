package com.example.cryptoassignment.di

import com.example.cryptoassignment.common.Constants
import com.example.cryptoassignment.data.remote.DemoApi
import com.example.cryptoassignment.data.repository.HomeRepositoryImplementation
import com.example.cryptoassignment.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDemoApi(): DemoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DemoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(api: DemoApi): HomeRepository {
        return HomeRepositoryImplementation(api)
    }
}