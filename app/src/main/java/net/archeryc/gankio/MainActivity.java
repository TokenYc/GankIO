package net.archeryc.gankio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jiongbull.jlog.JLog;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JLog.init(this)
                .setDebug(BuildConfig.DEBUG);

        Api api = new Api();

        RequestInterface.GithubService service = api.getRepos();

        Call<List<Repo>> repos = service.listRepos("tokenyc");


        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.d("yangchen", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });


    }
}
