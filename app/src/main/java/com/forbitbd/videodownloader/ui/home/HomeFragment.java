package com.forbitbd.videodownloader.ui.home;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.forbitbd.videodownloader.Constant;
import com.forbitbd.videodownloader.R;
import com.forbitbd.videodownloader.downloadService.DownloadService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import pub.devrel.easypermissions.EasyPermissions;

public class HomeFragment extends Fragment implements HomeContract.View{

    private HomePresenter mPresenter;
    private static final String TAG = "HomeFragment";
    private static final int READ_WRITE_PERMISSION=3000;
    private EditText video_url;
    private MaterialButton btndownload;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new HomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        video_url = view.findViewById(R.id.url);
        btndownload = view.findViewById(R.id.download);
        btndownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               requestFileAfterPermission();
            }
        });
        return view;
    }

    private void requestFileAfterPermission() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(getContext(), perms)) {
            downLoadRequest();
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "App need to Permission for Location",
                    READ_WRITE_PERMISSION, perms);
        }
    }

    private void downLoadRequest() {
        String input = video_url.getText().toString();
        Intent intent = new Intent(getContext(), DownloadService.class);
        intent.putExtra(Constant.URL,input);
        getContext().startService(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
