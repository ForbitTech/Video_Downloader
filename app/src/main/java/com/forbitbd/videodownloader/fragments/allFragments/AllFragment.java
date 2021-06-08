package com.forbitbd.videodownloader.fragments.allFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.os.FileUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.videodownloader.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AllFragment extends Fragment implements AllFragmentContract.View {

    private List<File> fileList = new ArrayList<>();

    private FileAdapter adapter;
    private AllFragmentPresenter mPresenter;

    public AllFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new AllFragmentPresenter(this);

        adapter = new FileAdapter(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        mPresenter.getAllFiles();


    }


    private void listFile(String directory){

        File dir= new File(directory);

        File[] files = dir.listFiles();

        if(files !=null){
            for (File x: files){
                if(x.isFile()){
                    fileList.add(x);
                }else if(x.isDirectory()){
                    listFile(x.getAbsolutePath());
                }
            }
        }

    }

    @Override
    public void getAllFiles() {
        String file = Environment.getExternalStorageDirectory().toString()+ File.separator+getString(R.string.app_name);
        listFile(file);

        adapter.addFiles(fileList);
    }
}