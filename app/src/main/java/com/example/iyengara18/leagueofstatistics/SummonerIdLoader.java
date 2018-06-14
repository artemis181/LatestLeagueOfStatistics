package com.example.iyengara18.leagueofstatistics;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;

public class SummonerIdLoader extends AsyncTaskLoader<ArrayList> {

    private String mUrl;

    public SummonerIdLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }
    @Override
    public ArrayList loadInBackground(){
        ArrayList x = QueryUtils.fetchSummonerId(mUrl);
        return x;
    }
}
