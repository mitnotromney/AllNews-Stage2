package com.example.localadmin.allnews;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsItem>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    private String url;

    public NewsLoader(Context context, String url) {
        super(context);
        Log.e(LOG_TAG, "NewsLoader()");
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.e(LOG_TAG, "onStartLoading()");
    }

    @Override
    public List<NewsItem> loadInBackground() {
        if (url == null) {
            return null;
        }
        Log.e(LOG_TAG, "loadInBackground()");
        return QueryUtils.fetchNewsStoriesData(url);
    }
}
