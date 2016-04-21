package net.archeryc.gankio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.archeryc.gankio.POJO.ImagePOJO;
import net.archeryc.gankio.imageLoader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 24706 on 2016/4/21.
 */
public class MainActivityAdapter extends RecyclerView.Adapter{

    List<ImagePOJO.Results> infos;
    Context mContext;

    public MainActivityAdapter(Context mContext) {
        this.mContext = mContext;
        infos = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder= (ItemViewHolder) holder;
        ImagePOJO.Results info=infos.get(position);
        ImageLoader.loadImage(mContext,info.getUrl(),itemViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public void addItems(List<ImagePOJO.Results> items) {
        infos.addAll(items);
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imv_item);
        }
    }
}
