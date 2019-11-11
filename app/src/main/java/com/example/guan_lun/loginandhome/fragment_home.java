package com.example.guan_lun.loginandhome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.guan_lun.loginandhome.RecyclerView.RVAdapter;

import java.io.Console;
import java.util.ArrayList;
import java.util.Locale;

public class fragment_home extends Fragment {

    //private View m_voice;

    private static final String TAG = "HomeFragment";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();
    Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //m_voice = getView().findViewById(R.id.voice_icon);
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = v.findViewById(R.id.toolbar);

        if (toolbar == null) {
        System.out.println("toolbar >> null");}
        AppCompatActivity mAppCompatActivity = (AppCompatActivity) getActivity();
        mAppCompatActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = mAppCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }




        RecyclerView RV1 = v.findViewById(R.id.RV_上次訂購);
        RecyclerView RV2 = v.findViewById(R.id.RV_優惠專區);
        RecyclerView RV3 = v.findViewById(R.id.RV_附近的美食);
        RecyclerView RV4 = v.findViewById(R.id.RV_最新餐廳);
        getImages(RV1);
        getImages(RV2);
        getImages(RV3);
        getImages(RV4);


        return v;}



    /*public void getSpeechInput(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.TAIWAN);

        //for getPackageManager() in fragment, you have to pass the context
        //Context context;
        //context.getPackageManager();

        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(getActivity(), "你的手機不支援語音輸入", Toast.LENGTH_SHORT).show();
        }
    }

    PreferenceManager.OnActivityResultListener()*/

    private void getImages(RecyclerView RV){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Havasu Falls");
        mRatings.add("3.5");

        mImageUrls.add("https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Trondheim");
        mRatings.add("4.0");

        mImageUrls.add("https://images.unsplash.com/photo-1466978913421-dad2ebd01d17?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Portugal");
        mRatings.add("3.2");

        mImageUrls.add("https://images.unsplash.com/photo-1502301103665-0b95cc738daf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Rocky Mountain National Park");
        mRatings.add("4.5");


        mImageUrls.add("https://images.unsplash.com/photo-1514933651103-005eec06c04b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Mahahual");
        mRatings.add("4.7");

        mImageUrls.add("https://images.unsplash.com/photo-1498654896293-37aacf113fd9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Frozen Lake");
        mRatings.add("4.0");


        mImageUrls.add("https://images.unsplash.com/photo-1521017432531-fbd92d768814?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("White Sands Desert");
        mRatings.add("3.9");

        mImageUrls.add("https://images.unsplash.com/photo-1551632436-cbf8dd35adfa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Austrailia");
        mRatings.add("4.1");

        mImageUrls.add("https://images.unsplash.com/photo-1551218372-a8789b81b253?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        mNames.add("Washington");
        mRatings.add("3.7");

        initRecyclerView(RV);

    }

    private void initRecyclerView(RecyclerView RV){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = RV;
        //RecyclerView recyclerView = v.findViewById(R.id.RV_優惠區);
        recyclerView.setLayoutManager(layoutManager);
        RVAdapter adapter = new RVAdapter(getActivity(), mNames, mImageUrls, mRatings);
        recyclerView.setAdapter(adapter);
    }
    }


