package com.example.aptoide.di

import com.example.aptoide.data.AptoideApi
import com.example.aptoide.data.repository.AptoideRepositoryImpl
import com.example.aptoide.domain.repository.AptoideRepository
import com.example.aptoide.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesApiRequest(): AptoideApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BASIC
                    }).build()
            )
            .build()
            .create(AptoideApi::class.java)
    }

    @Provides
    @Singleton
    fun providesAptoideRepository(api: AptoideApi): AptoideRepository {
        return AptoideRepositoryImpl(api)
    }


}