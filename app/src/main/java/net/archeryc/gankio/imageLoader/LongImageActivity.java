package net.archeryc.gankio.imageLoader;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import net.archeryc.gankio.R;
import net.archeryc.gankio.utils.Util;


public class LongImageActivity extends AppCompatActivity {
    //http://pic2.ooopic.com/12/15/47/61bOOOPIC66_1024.jpg
    //http://ww3.sinaimg.cn/mw690/8345c393jw1f32xv7zd4gj20go24yaqv.jpg
    //http://ww3.sinaimg.cn/mw690/7279d218jw1f2xfvdzrm3j20c83rj4h0.jpg
    private static final String LONG_IMAGE_URL = "http://ww3.sinaimg.cn/mw690/7279d218jw1f2xfvdzrm3j20c83rj4h0.jpg";

    private ImageView imageView;
    private ImageView imv_progress;
    private LongClickDialog longClickDialog;
    private AnimationDrawable animationDrawable;

    private SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(final Bitmap bitmap, GlideAnimation glideAnimation) {
            // do something with the bitmap
            // for demonstration purposes, let's just set it to an ImageView
//            Matrix matrix = new Matrix();
//            matrix.setScale(2.0f, 2.0f);
//            Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            int width=bitmap.getWidth();
            float multiple=(float)(Util.screenWidth(LongImageActivity.this))/(width);
            Log.d("multiple", "multiple:" + multiple);
            Matrix matrix = new Matrix();
            matrix.setScale(multiple,multiple);
            Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),matrix,true);
            imageView.setImageBitmap(result);
            animationDrawable.stop();
            imv_progress.setVisibility(View.GONE);
            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickDialog.setBitmap(bitmap);
                    longClickDialog.show();
                    return false;
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_image);
        imv_progress = (ImageView) findViewById(R.id.imv_progress);
        animationDrawable= (AnimationDrawable) imv_progress.getBackground();
        imageView = (ImageView) findViewById(R.id.longImage);
        ImageLoader.loadImage(this, LONG_IMAGE_URL, target);
        animationDrawable.start();

        longClickDialog = new LongClickDialog(this);

    }
}
