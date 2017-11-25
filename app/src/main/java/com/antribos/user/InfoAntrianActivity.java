package com.antribos.user;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoAntrianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_antrian);

        Bundle bundle = new Bundle();
        Mitra mitra = (Mitra) getIntent().getSerializableExtra("mitra");
        bundle.putSerializable("mitra", mitra);

        getSupportActionBar().setTitle(mitra.getNama());

        Fragment fragment = new InfoAntrianFragment();
        fragment.setArguments(bundle);

        if (getSupportFragmentManager().findFragmentByTag("Dashboard") == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_dashboard, fragment, "Dashboard")
                    .commit();
        }
    }
}
