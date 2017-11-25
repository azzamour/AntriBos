package com.antribos.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Muhammad Azzam on 03/09/2017.
 */

public class Beranda extends Fragment implements View.OnClickListener, NewsAdapter.NewsAdapterOnClickHandler {
    RelativeLayout rlClinic;
    MainActivity mainActivity;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference mDatabase;

    private final ArrayList<News> newss = new ArrayList<News>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beranda, container, false);
        mainActivity = (MainActivity) getActivity();

        rlClinic = (RelativeLayout) view.findViewById(R.id.rl_clinic);
        rlClinic.setOnClickListener(this);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_news);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NewsAdapter(getContext(), newss, this);
        mRecyclerView.setAdapter(mAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("News").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newss.clear();
                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    News news = child.getValue(News.class);
                    newss.add(news);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Beranda");
    }

    @Override
    public void onClick(View view) {
        if (view == rlClinic) {
            Fragment fragment = new JoinAntrianFragment();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
            mainActivity.navigationView.getMenu().getItem(1).setChecked(true);
        }
    }

    @Override
    public void onClick(News news) {
        Intent intent = new Intent(getContext(), NewsActivity.class);
        intent.putExtra("news", news);
        startActivity(intent);
    }
}
