package com.forbitbd.videodownloader.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.videodownloader.R;
import com.forbitbd.videodownloader.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class DownloadsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AllFragment allFragment;
    private VideoFragment videoFragment;
    private AudioFragment audioFragment;

    public DownloadsFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_downloads, container, false);

        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
        allFragment = new AllFragment();
        videoFragment = new VideoFragment();
        audioFragment = new AudioFragment();

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        viewPagerAdapter.addFragment(allFragment, "All");
        viewPagerAdapter.addFragment(videoFragment, "Video");
        viewPagerAdapter.addFragment(audioFragment,"Audio");
        viewPager.setAdapter(viewPagerAdapter);

        return view;
    }
}
