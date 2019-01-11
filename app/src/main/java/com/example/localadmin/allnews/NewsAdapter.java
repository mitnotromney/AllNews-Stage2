package com.example.localadmin.allnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsItem> {
    public NewsAdapter(@NonNull Context context, @NonNull List<NewsItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;


        if (itemView == null)
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_news, parent, false);

        NewsItem currentNewsItem = getItem(position);

        TextView titleTextView = itemView.findViewById(R.id.title);
        titleTextView.setText(currentNewsItem.getTitle());

        TextView sectionTextView = itemView.findViewById(R.id.genre);
        sectionTextView.setText(currentNewsItem.getSection());

        TextView authorTextView = itemView.findViewById(R.id.author);
        authorTextView.setText(currentNewsItem.getAuthor());

        TextView dateTextView = itemView.findViewById(R.id.date);
        String date = getDateOnly(currentNewsItem.getDate());
        dateTextView.setText(date);

        return itemView;
    }

    private String getDateOnly(String date) {
        String[] parts = date.split("T");
        return parts[0];
    }
}
