package com.antribos.user;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsFragment extends Fragment implements View.OnClickListener {

    private TextView tv_loket_tersedia;
    private TextView tv_loket_now;
    private TextView tv_loket_next;
    private TextView tv_loket_sisa;

    private Button btn_booking;

    private Long sisa;
    private Long next;
    private Long now;
    private Long tersedia;

    private FirebaseDatabase db;
    private DatabaseReference dbRef;

    private Loket loket;

    public DetailsFragment() {
    }

    private String TAG = getClass().toString();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        loket = (Loket) getArguments().getSerializable("loket");

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("mitra-dev-dev").child("Medical Center ITS").child("loket").child(loket.getNama());

        tv_loket_now = (TextView) view.findViewById(R.id.tv_loket_now_detail);
        tv_loket_next = (TextView) view.findViewById(R.id.tv_loket_next_detail);
        tv_loket_sisa = (TextView) view.findViewById(R.id.tv_loket_sisa_detail);
        tv_loket_tersedia = (TextView) view.findViewById(R.id.tv_loket_tersedia_detail);

        btn_booking = (Button) view.findViewById(R.id.btn_booking);
        btn_booking.setOnClickListener(this);

        now = loket.getNow();
        next = loket.getNext();
        sisa = loket.getSisa();
        tersedia = loket.getTersedia();

        tv_loket_now.setText(loket.nowString());
        tv_loket_sisa.setText(sisa.toString());
        tv_loket_tersedia.setText(String.valueOf(tersedia));
        tv_loket_next.setText(loket.nextString());

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                loket = dataSnapshot.getValue(Loket.class);

                sisa = loket.getSisa();
                tersedia = loket.getTersedia();
                now = loket.getNow();
                next = loket.getNext();

                tv_loket_now.setText(loket.nowString());
                tv_loket_sisa.setText(sisa.toString());
                tv_loket_tersedia.setText(loket.tersediaString());
                tv_loket_next.setText(loket.nextString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == btn_booking) {
            startActivity(new Intent(getContext(), Terms.class));
            /*dbRef.child("tersedia").setValue(tersedia++);
            dbRef.child("sisa").setValue(sisa++);*/
        }
    }
}
