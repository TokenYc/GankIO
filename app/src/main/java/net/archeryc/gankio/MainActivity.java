package net.archeryc.gankio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    RecyclerView recyclerView;
    MainActivityAdapter adapter;
    GridLayoutManager gridLayoutManager;

    int mPage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = new Api();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MainActivityAdapter(this);
        recyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == adapter.getItemCount() && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    getImage(mPage);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
        getImage(mPage);


    }

    private void getImage(int page) {
        api.getImages(page, new Callback<ImagePOJO>() {
            @Override
            public void onResponse(Call<ImagePOJO> call, Response<ImagePOJO> response) {
                adapter.addItems(response.body().getResults());
                mPage++;
                JLog.d("添加数据到adapter中");
            }

            @Override
            public void onFailure(Call<ImagePOJO> call, Throwable t) {
                JLog.d("失败");
            }
        });
    }


}
