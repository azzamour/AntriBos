package com.kleinkarasu.antribos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class InfoAntrianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_antrian);

        Bundle bundle = new Bundle();
        Mitra mitra = (Mitra) getIntent().getSerializableExtra("mitra");
        bundle.putSerializable("mitra", mitra);

        getSupportActionBar().setTitle(mitra.getNama());

        if (getSupportFragmentManager().findFragmentByTag("Dashboard") == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_dashboard, new InfoAntrianFragment(), "Dashboard")
                    .commit();
        }
    }
}
