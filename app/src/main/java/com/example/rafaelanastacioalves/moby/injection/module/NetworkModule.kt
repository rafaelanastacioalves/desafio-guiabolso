package com.example.rafaelanastacioalves.moby.injection.module

import com.example.rafaelanastacioalves.moby.BuildConfig
import com.example.rafaelanastacioalves.moby.retrofit.APIClient
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * Module which provides all required dependencies about network
 */

@Module
@Suppress("unused")
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun providesAPIClient(retrofit: Retrofit): APIClient {
        return retrofit.create(APIClient::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        val builder = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

        val httpClient = OkHttpClient.Builder()

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val retrofit = builder.client(httpClient
                .addInterceptor(interceptor)
                .build()).build()
        return retrofit
    }
}