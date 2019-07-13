package com.responsi.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.responsi.mvp.adapter.PeopleAdapter;
import com.responsi.mvp.model.ResultData;
import com.responsi.mvp.presenterimp.MainPresenterImp;
import com.responsi.mvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenterImp mainPresenterImp;
    PeopleAdapter peopleAdapter;
    List<ResultData> resultDataList;
    RecyclerView mRecPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        mRecPeople = findViewById(R.id.rv_data);

        mainPresenterImp = new MainPresenterImp(this);

        resultDataList = new ArrayList<>();
        peopleAdapter = new PeopleAdapter(this, resultDataList);
        peopleAdapter.setHasStableIds(true);

        mRecPeople.setLayoutManager(new LinearLayoutManager(this));
        mRecPeople.setHasFixedSize(true);
        mRecPeople.setNestedScrollingEnabled(false);

        mRecPeople.setAdapter(peopleAdapter);

        mainPresenterImp.callPeopleData("10", "en");
    }

    @Override
    public void setPeopleData(List<ResultData> resultData) {
        Log.i("xxxx", "set Data " + resultData);
        resultDataList.addAll(resultData);

        Log.i("xxxx", "set Data " + resultDataList.size());



        peopleAdapter.notifyDataSetChanged();
    }
}
