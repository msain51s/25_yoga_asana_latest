package com.yoga_asana;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yoga_asana.model.YogaDetailModel;
import com.yoga_asana.utility.Application;
import com.yoga_asana.utility.FontType;
import com.yoga_asana.utility.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.whygraphics.gifview.gif.GIFView;

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

        mAdMobInterstitialAd = new InterstitialAd(this);
        mAdMobInterstitialAd.setAdUnitId(getString(R.string.interstitial_detail));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
               /* .addTestDevice("26D932C1F8FA1407702FC623889D39A7")*/// Add your real device id here
                .build();

        mAdMobInterstitialAd.loadAd(adRequest);
        mAdMobInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitialAd();
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

    private void showInterstitialAd() {
        if (mAdMobInterstitialAd.isLoaded()) {
            mAdMobInterstitialAd.show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
           finish();
        }
        return super.onOptionsItemSelected(item);

    }
}
