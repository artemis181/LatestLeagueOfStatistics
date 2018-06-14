package com.example.iyengara18.leagueofstatistics;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList>{
    EditText sumName;
    Button begin;
    String name;
    int summonerId=48132143;
    int accountId=211078242;
    private static final int SUMMONER_ID=1;
    private static final String API_KEY = "RGAPI-f80b5a21-1256-49f2-b546-1ea3bc2b840b";
    private static String REQUEST_SUMMONER_ID_URL = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/";
            private static String REQUEST_SUMMONER_ID_TWO = "?api_key=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumName = findViewById(R.id.enterNameView);
        begin = findViewById(R.id.startBut);
        begin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        name = sumName.getText().toString();
        getSupportLoaderManager().initLoader(SUMMONER_ID, null,this);
        Intent i = Info_Tab_Layout.newIntent(MainActivity.this, name, summonerId, accountId);
        startActivity(i);
    }

    @Override
    public Loader<ArrayList> onCreateLoader(int i, Bundle bundle) {
        return new SummonerIdLoader(this, REQUEST_SUMMONER_ID_URL+name+REQUEST_SUMMONER_ID_TWO+API_KEY);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList> loader, ArrayList x){
        summonerId = (int)x.get(0);
        accountId = (int)x.get(1);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList> loader){
    }
}
