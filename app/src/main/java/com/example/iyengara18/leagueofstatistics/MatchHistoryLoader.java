package com.example.iyengara18.leagueofstatistics;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class MatchHistoryLoader extends AsyncTaskLoader<List<MatchHistoryInfo>> {

    private String mUrl;

    public MatchHistoryLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }
    @Override
    public List<MatchHistoryInfo> loadInBackground(){
        if(mUrl == null){
            return null;
        }
        List<MatchHistoryInfo> masteries = QueryUtils.fetchMatchData(mUrl);
        return masteries;
    }
}
