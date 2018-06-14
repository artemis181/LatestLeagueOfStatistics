package com.example.iyengara18.leagueofstatistics;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Info_Tab_Layout extends AppCompatActivity {
    ViewPager vPager;
    TabLayout tabLayout;
    SampleFragmentPagerAdapter fragAdapt;
    TextView name;
    private static final String EXTRA_SUMNAME = "com.example.iyengara18.leagueofstatistics.name";
    private static final String EXTRA_SUMID = "com.example.iyengara18.leagueofstatistics.id";
    private static final String EXTRA_ACCID = "com.example.iyengara18.leagueofstatistics.acc";
    String summonerName;
    public static int summonerId;
    public static int accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tab_layout);
        vPager = findViewById(R.id.viewPager);
        fragAdapt = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        vPager.setAdapter(fragAdapt);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vPager);
        name = findViewById(R.id.nameView);
        summonerName=getIntent().getStringExtra(EXTRA_SUMNAME);
        summonerId=getIntent().getIntExtra(EXTRA_SUMID, 0);
        accountId=getIntent().getIntExtra(EXTRA_ACCID, 0);
        name.setText(getIntent().getStringExtra(EXTRA_SUMNAME));
    }

    public static Intent newIntent(Context packageContext,String summonerName, int sumId, int accId){
        Intent i = new Intent(packageContext, Info_Tab_Layout.class);
        i.putExtra(EXTRA_SUMNAME, summonerName);
        i.putExtra(EXTRA_SUMID, sumId);
        i.putExtra(EXTRA_ACCID, accId);
        return i;
    }
}
