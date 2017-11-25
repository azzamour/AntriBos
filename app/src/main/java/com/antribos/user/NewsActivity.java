package com.antribos.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Bundle bundle = new Bundle();
        News news = (News) getIntent().getSerializableExtra("news");
        bundle.putSerializable("news", news);

        if (getSupportFragmentManager().findFragmentByTag("news") == null) {
            NewsFragment fragment = new NewsFragment();
            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_details, fragment)
                    .commit();
        }
    }
}
