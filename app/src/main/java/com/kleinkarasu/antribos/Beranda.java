package com.kleinkarasu.antribos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Muhammad Azzam on 03/09/2017.
 */

public class Beranda extends Fragment implements View.OnClickListener {
    RelativeLayout rlClinic;
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beranda, container, false);
        mainActivity = (MainActivity) getActivity();

        rlClinic = (RelativeLayout) view.findViewById(R.id.rl_clinic);
        rlClinic.setOnClickListener(this);

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
            Fragment fragment = new JoinAntrian();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
            mainActivity.navigationView.getMenu().getItem(1).setChecked(true);
        }
    }
}
