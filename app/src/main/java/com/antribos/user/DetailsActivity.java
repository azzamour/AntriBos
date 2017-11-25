package com.antribos.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = new Bundle();
        Loket loket = (Loket) getIntent().getSerializableExtra("loket");
        bundle.putSerializable("loket", loket);

        getSupportActionBar().setTitle(loket.getNama());

        if (getSupportFragmentManager().findFragmentByTag("Details") == null) {
            DetailsFragment fragment = new DetailsFragment();
            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_details, fragment)
                    .commit();
        }
    }
}
