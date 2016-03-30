package net.archeryc.gankio.api;

import android.util.Log;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by .cc on 2016/3/30.
 */
public class Api {

    private static String BASE_URL ="https://api.github.com/";

    Retrofit retrofit;
    OkHttpClient okHttpClient;

    public Api() {

        okHttpClient = new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RequestInterface.GithubService getRepos() {
        return retrofit.create(RequestInterface.GithubService.class);
    }
}
