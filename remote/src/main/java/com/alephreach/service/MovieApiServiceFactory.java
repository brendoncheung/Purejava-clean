package com.alephreach.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class MovieApiServiceFactory {

    public final static String API_KEY = "6fffa22d1ba58423a952b48709479f7d";

    public static MovieApiService newInstance(Boolean isDebug) {
        OkHttpClient client = provideHttpClient(provideLoggingInterceptor(isDebug));

        return provideMovieApiService(client);
    }

    private static MovieApiService provideMovieApiService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(MovieApiService.class);
    }

    private static OkHttpClient provideHttpClient(HttpLoggingInterceptor logger) {

        return new OkHttpClient.Builder()
                .addInterceptor(logger)
                .callTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build();
    }

    private static HttpLoggingInterceptor provideLoggingInterceptor(Boolean isDebug) {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();

        if (isDebug) {
            logger.level(HttpLoggingInterceptor.Level.BODY);
        } else {
            logger.level(HttpLoggingInterceptor.Level.BODY);
        }
        return logger;
    }






}
