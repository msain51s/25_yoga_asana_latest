package com.yoga_asana;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.whygraphics.gifview.gif.GIFView;
import com.yoga_asana.model.YogaDetailModel;
import com.yoga_asana.utility.Application;
import com.yoga_asana.utility.FontType;
import com.yoga_asana.utility.Utils;

public class YogaDetatailActivity extends AppCompatActivity {
    InterstitialAd mAdMobInterstitialAd;
    Toolbar toolbar;
    TextView toolbar_title_text;
    GIFView imageView_gif;
    ImageView imageView;
    TextView yogaSteps,benefitsOfYoga,precautions;
    YogaDetailModel model;
    Typeface roboto_regular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_detatail);
        initToolBar();

        roboto_regular= Utils.getCustomFont(Application.mContext, FontType.ROBOTO_REGULAR);
        toolbar_title_text= (TextView) findViewById(R.id.toolbar_title_text);
        imageView_gif= (GIFView) findViewById(R.id.detail_image_gif);
        yogaSteps= (TextView) findViewById(R.id.yoga_steps_detail_text);
        benefitsOfYoga= (TextView) findViewById(R.id.benefits_of_yoga_detail_text);
        precautions= (TextView) findViewById(R.id.precautions_of_yoga_detail_text);
        imageView= (ImageView) findViewById(R.id.detail_image);

        yogaSteps.setTypeface(roboto_regular);
        benefitsOfYoga.setTypeface(roboto_regular);
        precautions.setTypeface(roboto_regular);

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        InterstitialAd.load(this,getString(R.string.interstitial_detail), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mAdMobInterstitialAd = interstitialAd;
                        if (mAdMobInterstitialAd != null) {
                            mAdMobInterstitialAd.show(YogaDetatailActivity.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mAdMobInterstitialAd = null;
                    }
                });

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            model= (YogaDetailModel) bundle.get("model");
            yogaSteps.setText(model.getStepsOfYoga());
            benefitsOfYoga.setText(model.getBenefitsOfYoga());
            precautions.setText(model.getPrecautions());

            toolbar_title_text.setText(model.getYogaTitle());

            if(model.getGifOrNormal()==1) {
                imageView_gif.setVisibility(View.VISIBLE);
                imageView_gif.setGifResource("asset:_"+model.getPosition());
            }
            else {
                imageView.setVisibility(View.VISIBLE);
                Glide.with(this)
                        .load(bundle.getInt("image"))
                        .into(imageView);
            }
        }
    }

    /*Method to in initialize toolbar*/
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
           finish();
        }
        return super.onOptionsItemSelected(item);

    }
}
