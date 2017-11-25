package com.antribos.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class Terms extends AppCompatActivity implements View.OnClickListener {

    DisplayMetrics dm;
    int width, height;

    Button btnCancel, btnAgree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
        height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.45));

        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnAgree = (Button) findViewById(R.id.btn_agree);

        btnCancel.setOnClickListener(this);
        btnAgree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnCancel) {
            finish();
        }
        if(view == btnAgree) {

        }
    }
}
