package com.antribos.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad Azzam on 03/09/2017.
 */

public class JoinAntrianFragment extends Fragment implements JoinAntrianAdapter.MitraAdapterOnClickHandler {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private DatabaseReference mDatabase;

    private ProgressDialog progressDialog;

    private final List<Mitra> mitras = new ArrayList<Mitra>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.join_antrian, container, false);
        progressDialog = new ProgressDialog(getContext());

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_join_antrian);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new JoinAntrianAdapter(getContext(), mitras, this);
        mRecyclerView.setAdapter(mAdapter);

        progressDialog.setMessage("Loading Mitra...");
        progressDialog.show();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("mitra-dev-dev").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                mitras.clear();
                for(DataSnapshot child : children) {
                    Mitra mitra = child.getValue(Mitra.class);
                    mitras.add(mitra);
                }
                mAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
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
        getActivity().setTitle("Join Antrian");


    }

    @Override
    public void onClick(Mitra mitra) {
        Intent intent = new Intent(getContext(), InfoAntrianActivity.class);
        intent.putExtra("mitra", mitra);
        startActivity(intent);
    }
}
