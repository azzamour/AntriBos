package com.kleinkarasu.antribos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muhammad Azzam on 21/09/2017.
 */

public class InfoAntrianAdapter extends RecyclerView.Adapter<InfoAntrianAdapter.ViewHolder> {
    private List<Loket> lokets;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView antrianSaatIni;
        private TextView antrianTersedia;

        public ViewHolder(View v) {
            super(v);
            antrianSaatIni = (TextView) v.findViewById(R.id.tv_saat_ini);
            antrianTersedia = (TextView) v.findViewById(R.id.tv_tersedia);
        }

        public TextView getAntrianSaatIni() {
            return antrianSaatIni;
        }

        public void setAntrianSaatIni(TextView antrianSaatIni) {
            this.antrianSaatIni = antrianSaatIni;
        }

        public TextView getAntrianTersedia() {
            return antrianTersedia;
        }

        public void setAntrianTersedia(TextView antrianTersedia) {
            this.antrianTersedia = antrianTersedia;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public InfoAntrianAdapter(Context context, List<Loket> lokets) {
        this.lokets = lokets;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public InfoAntrianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(context)
                .inflate(R.layout.card_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.antrianSaatIni.setText("0");
        holder.antrianTersedia.setText("1");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return lokets.size();
    }
}
