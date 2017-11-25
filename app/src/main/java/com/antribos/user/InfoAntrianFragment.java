package com.antribos.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class InfoAntrianFragment extends Fragment implements InfoAntrianAdapter.LoketAdapterOnClickHandler {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private DatabaseReference mDatabase;

    private ProgressDialog progressDialog;

    private final ArrayList<Loket> lokets = new ArrayList<Loket>();
    private Mitra mitra;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_antrian, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_loket);
        progressDialog = new ProgressDialog(getContext());

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new InfoAntrianAdapter(getContext(), lokets, this);
        mRecyclerView.setAdapter(mAdapter);

        mitra = (Mitra) getArguments().getSerializable("mitra");

        progressDialog.setMessage("Loading Info Antrian...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("mitra-dev-dev").child(mitra.getNama()).child("loket").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lokets.clear();
                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    Loket loket = child.getValue(Loket.class);
                    lokets.add(loket);
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
    public void onClick(Loket loket) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra("loket", loket);
        startActivity(intent);

        Log.d(TAG, "onClick: clicked");
    }
}
