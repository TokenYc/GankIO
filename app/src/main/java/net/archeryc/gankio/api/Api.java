package net.archeryc.gankio.api;

import net.archeryc.gankio.POJO.ImagePOJO;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;


/**
 * Created by .cc on 2016/3/30.
 */
public class Api {

    private static String BASE_URL = "http://gank.io/api/data/";

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


    public void getImages(int page, Callback<List<ImagePOJO>> callback) {
        Call<List<ImagePOJO>> call = retrofit.create(RequestInterface.ImageService.class).listImages(page);
        call.enqueue(callback);
    }
}
