package com.example.project10_nnovales;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A fragment representing a list of Items.
 */
public class logFragment extends Fragment {
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    ArrayList<String> data = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public logFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log, container, false);
        recyclerView = view.findViewById(R.id.rView);
        customAdapter = new CustomAdapter(data);
        recyclerView.setAdapter(customAdapter);

        data.add("What is this");
        data.add("Hello world");
//        getParentFragmentManager().setFragmentResultListener("someKey", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
//                data.add(result.getString("some"));
//            }
//        });


        customAdapter.notifyDataSetChanged();
        return view;
    }
}