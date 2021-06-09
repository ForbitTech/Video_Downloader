package com.forbitbd.videodownloader;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.forbitbd.videodownloader.R;


public class SettingsFragment extends Fragment implements View.OnClickListener {

    private TextView tv1, tv2, tv3, tv4, tv5, tv6;


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_settings, container, false);


        tv1 = view.findViewById(R.id.info);
        tv2 = view.findViewById(R.id.demo);
        tv3 = view.findViewById(R.id.share);
        tv4 = view.findViewById(R.id.privacy);
        tv5 = view.findViewById(R.id.rateapp);
        tv6 = view.findViewById(R.id.moreapps);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.info){

        }else if (id == R.id.demo){

        }else if (id == R.id.share){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.forbitbd.videodownloader");
            startActivity(Intent.createChooser(sharingIntent, "BTEB Result"));
        }else if (id == R.id.privacy){

        }else if (id == R.id.rateapp){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.forbitbd.videodownloader"));
            startActivity(intent);
        }else if (id == R.id.moreapps){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Forbit+Bangladesh&hl=en"));
            startActivity(intent);
        }
    }
}