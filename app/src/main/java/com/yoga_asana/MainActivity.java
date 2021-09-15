package com.yoga_asana;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.yoga_asana.adapter.ListAdapter;
import com.yoga_asana.model.YogaDetailModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdMobAdView;
    Toolbar toolbar;
    TextView toolbar_title_text;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ListAdapter adapter;
    ArrayList<YogaDetailModel> list;
    String []title_arr,yoga_steps_arr,yoga_benefits_arr,precautions_arr;
    TypedArray tp;
    int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();

        mAdMobAdView = (AdView) findViewById(R.id.admob_adview);
        AdRequest adRequest = new AdRequest.Builder()
             //  .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
               /*  .addTestDevice("26D932C1F8FA1407702FC623889D39A7")*/// Add your real device id here
                .build();
        mAdMobAdView.loadAd(adRequest);


        toolbar_title_text= (TextView) findViewById(R.id.toolbar_title_text);
        toolbar_title_text.setText("25 योग आसन");
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                getList();
            }
        });

    }

    /*Method to in initialize toolbar*/
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void getList(){
        YogaDetailModel model=null;
        list=new ArrayList<>();
        int[] ar = getResources().getIntArray(R.array.img_or_gif_indication_array);
        title_arr=getResources().getStringArray(R.array.title_array);
        yoga_steps_arr=getResources().getStringArray(R.array.steps_array);
        yoga_benefits_arr=getResources().getStringArray(R.array.benefits_array);
        precautions_arr=getResources().getStringArray(R.array.precautions_array);

        for(int i=0;i<title_arr.length;i++){
            model=new YogaDetailModel();
            model.setYogaTitle(title_arr[i]);
            model.setStepsOfYoga(yoga_steps_arr[i]);
            model.setBenefitsOfYoga(yoga_benefits_arr[i]);
            model.setPrecautions(precautions_arr[i]);
            model.setGifOrNormal(ar[i]);
            model.setPosition(i);

            list.add(model);
        }

        tp=getResources().obtainTypedArray(R.array.thumb_img_array);
        images=new int[tp.length()];
        for(int i=0;i<images.length;i++){
            int id=tp.getResourceId(i,-1);
            if(id!=-1){
                images[i]= tp.getResourceId(i,-1);
            }
        }
        tp.recycle();

        adapter=new ListAdapter(list,this,images);
        recyclerView.setAdapter(adapter);
    }

    public void clickMore(View view){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.kids_learning_fun_learning"));
            startActivity(intent);
        }catch (Exception e){}
    }
}
