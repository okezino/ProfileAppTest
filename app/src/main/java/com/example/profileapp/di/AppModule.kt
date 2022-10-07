package com.example.profileapp.di

import com.example.profileapp.data.remote.ProfileApiService
import com.example.profileapp.data.repository.UserProfileRepositoryImp
import com.example.profileapp.domain.repository.UserProfileRepository
import com.example.profileapp.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideQuoteApiService(interceptor: Interceptor): ProfileApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client( OkHttpClient.Builder()
                .addInterceptor(interceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfileApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(profileApiService: ProfileApiService): UserProfileRepository{
     return UserProfileRepositoryImp(profileApiService)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}