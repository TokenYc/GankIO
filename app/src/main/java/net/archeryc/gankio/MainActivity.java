package net.archeryc.gankio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jiongbull.jlog.JLog;

import net.archeryc.gankio.POJO.ImagePOJO;
import net.archeryc.gankio.POJO.Repo;
import net.archeryc.gankio.api.Api;
import net.archeryc.gankio.api.RequestInterface;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = new Api();

        api.getImages(0, new Callback<List<ImagePOJO>>() {
            @Override
            public void onResponse(Call<List<ImagePOJO>> call, Response<List<ImagePOJO>> response) {

            }

            @Override
            public void onFailure(Call<List<ImagePOJO>> call, Throwable t) {

            }
        });

    }
}
