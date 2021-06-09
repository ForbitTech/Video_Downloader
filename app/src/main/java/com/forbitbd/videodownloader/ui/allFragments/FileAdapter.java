package com.forbitbd.videodownloader.ui.allFragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.videodownloader.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FileHolder> {

    private List<File> fileList;
    private Context context;
    private LayoutInflater inflater;

    public FileAdapter(Context context) {
        this.fileList = new ArrayList<>();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_file,parent,false);
        return new FileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileHolder holder, int position) {
        File file = fileList.get(position);
        holder.bind(file);
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public void addFiles(List<File> fileList){
        this.fileList = fileList;
        notifyDataSetChanged();
    }

    class FileHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage;
        private TextView tvName;

        public FileHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            ivImage = itemView.findViewById(R.id.image);
        }

        public void bind(File file){
            tvName.setText(file.getName());
        }
    }
}
