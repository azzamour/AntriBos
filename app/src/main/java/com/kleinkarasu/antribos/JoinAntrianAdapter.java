package com.kleinkarasu.antribos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muhammad Azzam on 01/11/2017.
 */

public class JoinAntrianAdapter extends RecyclerView.Adapter<JoinAntrianAdapter.ViewHolder> {
    private List<Mitra> mitras;
    private LayoutInflater inflater;
    private final MitraAdapterOnClickHandler onClickListener;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nama;
        private TextView alamat;
        private TextView jamBuka;
        public ViewHolder(View v) {
            super(v);
            nama = (TextView) itemView.findViewById(R.id.tv_nama);
            alamat = (TextView) v.findViewById(R.id.tv_alamat);
            jamBuka = (TextView) v.findViewById(R.id.tv_jam_buka);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int postiton = getAdapterPosition();
            Mitra mitra = mitras.get(postiton);

            onClickListener.onClick(mitra);
        }
    }

    public JoinAntrianAdapter(Context context, List<Mitra> mitras, MitraAdapterOnClickHandler onClickListener) {
        this.mitras = mitras;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public JoinAntrianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = inflater.inflate(R.layout.card_join_antrian, parent, false);
        return new JoinAntrianAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mitra mitra = mitras.get(position);
        holder.nama.setText(mitra.getNama());
        holder.alamat.setText(mitra.getAlamat());
        holder.jamBuka.setText("Open Today "+mitra.getJamBuka());
    }

    @Override
    public int getItemCount() {
        if (mitras != null) {
            return mitras.size();
        }

        return 0;
    }

    public interface MitraAdapterOnClickHandler {
        void onClick(Mitra mitra);
    }
}
