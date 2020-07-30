package com.example.tureng2.Sub_Core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tureng2.R;

import java.util.ArrayList;

public class NounVerbDataRecyclerViewAdapter extends RecyclerView.Adapter<NounVerbDataRecyclerViewAdapter.MyViewHolder> {


    ArrayList<NounVerbDataB1> mDataList;
    LayoutInflater inflater;


    public NounVerbDataRecyclerViewAdapter(Context context, ArrayList<NounVerbDataB1> data) {
        inflater = LayoutInflater.from(context);
        mDataList = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_info_b1, parent, false); // xml'den çevirip java'ya dönüştürüpü view'in içine atıyor. false değeri ise hepsini direk atama çünkü recycler view
        //anlık oluşturuyor.

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NounVerbDataB1 nounVerbDataB1 = mDataList.get(position);
        holder.setData(nounVerbDataB1, position);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mNoun;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mNoun = itemView.findViewById(R.id.tv_info);
        }

        public void setData(NounVerbDataB1 nounVerbDataB1, int position) {
            this.mNoun.setText(nounVerbDataB1.getNouns());
        }
    }

}
