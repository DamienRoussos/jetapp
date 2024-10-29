package com.example.jetapp.data.di

import com.example.jetapp.data.api.JetApi
import com.example.jetapp.data.datasource.RestaurantRemoteDataSource
import com.example.jetapp.data.datasource.RestaurantRemoteDataSourceImpl
import com.example.jetapp.data.repository.RestaurantRepositoryImpl
import com.example.jetapp.domain.repository.RestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Reusable
    abstract fun provideRestaurantRepository(repository: RestaurantRepositoryImpl): RestaurantRepository

    @Binds
    abstract fun provideRestaurantRemoteDataSource(dataSourceImpl: RestaurantRemoteDataSourceImpl): RestaurantRemoteDataSource

    companion object {
        @Provides
        fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

        @Provides
        fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit = Retrofit.Builder()
            .baseUrl("https://uk.api.just-eat.io/restaurants/")
            .addConverterFactory(gsonConverterFactory)
            .build()

        @Provides
        fun provideJetApi(retrofit: Retrofit): JetApi = retrofit.create(JetApi::class.java)
    }
}