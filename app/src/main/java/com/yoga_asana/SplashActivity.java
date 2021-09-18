package com.yoga_asana;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.whygraphics.gifview.gif.GIFView;

public class SplashActivity extends AppCompatActivity {

    View splash_bg_layout;
    GIFView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash_bg_layout=findViewById(R.id.splash_bg_layout);
        gifView= (GIFView) findViewById(R.id.splash_image_gif);
        gifView.setGifResource("asset:splash_bg1");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(SplashActivity.this, splash_bg_layout, "toolbar");
                    startActivity(intent, options.toBundle());
                }else{*/
                    startActivity(intent);
            //    }
            }
        },4000);
    }
}
