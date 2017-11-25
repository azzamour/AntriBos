package com.antribos.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Azzam on 08/11/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<News> newss;
    private LayoutInflater inflater;
    private final NewsAdapterOnClickHandler onClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        private TextView tvTitle;
        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int postiton = getAdapterPosition();
            News news = newss.get(postiton);

            onClickListener.onClick(news);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsAdapter(Context context, ArrayList<News> newss, NewsAdapterOnClickHandler onClickListener) {
        this.newss = newss;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = inflater.inflate(R.layout.card_news, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = newss.get(position);
        holder.tvTitle.setText(news.getTitle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (newss != null) {
            return newss.size();
        }

        return 0;
    }

    public interface NewsAdapterOnClickHandler {
        void onClick(News news);
    }
}
