package com.antribos.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Azzam on 21/09/2017.
 */

public class InfoAntrianAdapter extends RecyclerView.Adapter<InfoAntrianAdapter.ViewHolder> {
    private ArrayList<Loket> lokets;
    private LayoutInflater inflater;
    private final LoketAdapterOnClickHandler onClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        private TextView loketName;
        private TextView antrianSaatIni;
        private TextView next;
        private TextView antrianSisa;

        public ViewHolder(View v) {
            super(v);
            loketName = (TextView) itemView.findViewById(R.id.tv_loket_name);
            antrianSaatIni = (TextView) v.findViewById(R.id.antrian_saat_ini);
            next = (TextView) v.findViewById(R.id.tv_next);
            antrianSisa = (TextView) itemView.findViewById(R.id.tv_loket_sisa);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int postiton = getAdapterPosition();
            Loket loket = lokets.get(postiton);

            onClickListener.onClick(loket);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public InfoAntrianAdapter(Context context, ArrayList<Loket> lokets, LoketAdapterOnClickHandler onClickListener) {
        this.lokets = lokets;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public InfoAntrianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View view = inflater.inflate(R.layout.card_info_antrian, parent, false);
        return new InfoAntrianAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Loket loket = lokets.get(position);
        holder.loketName.setText(loket.getNama());
        holder.antrianSaatIni.setText(loket.nowString());
        holder.next.setText(loket.nextString());
        holder.antrianSisa.setText("SISA ANTRIAN " + loket.getSisa());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (lokets != null) {
            return lokets.size();
        }

        return 0;
    }

    public interface LoketAdapterOnClickHandler {
        void onClick(Loket loket);
    }
}
