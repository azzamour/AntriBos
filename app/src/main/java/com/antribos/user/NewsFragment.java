package com.antribos.user;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Muhammad Azzam on 08/11/2017.
 */

public class NewsFragment extends Fragment {
    News news;

    TextView tvTitle, tvContent;

    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        news = (News) getArguments().getSerializable("news");

        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvContent = (TextView) view.findViewById(R.id.tv_content);

        progressDialog = new ProgressDialog(getContext());

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("News").child("001");

        progressDialog.setMessage("Menampilkan Berita...");
        progressDialog.show();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                news = dataSnapshot.getValue(News.class);
                tvTitle.setText(news.getTitle());
                tvContent.setText(news.getContent());
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
    }
}
