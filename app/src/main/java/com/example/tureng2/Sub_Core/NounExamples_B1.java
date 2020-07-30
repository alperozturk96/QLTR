package com.example.tureng2.Sub_Core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tureng2.R;

public class NounExamples_B1 extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nounsverbs_example_b1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);


        NounVerbDataRecyclerViewAdapter nounVerbDataRecyclerViewAdapter = new NounVerbDataRecyclerViewAdapter(getActivity(), NounVerbDataB1.getData(true));

        recyclerView.setAdapter(nounVerbDataRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}
