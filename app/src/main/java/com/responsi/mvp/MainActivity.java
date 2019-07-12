package com.responsi.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.responsi.mvp.model.ResultData;
import com.responsi.mvp.presenterimp.MainPresenterImp;
import com.responsi.mvp.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenterImp mainPresenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mainPresenterImp = new MainPresenterImp(this);

        mainPresenterImp.callPeopleData("10", "en");
    }

    @Override
    public void setPeopleData(List<ResultData> resultData) {
        Log.i("xxxx", "set Data " + resultData);
    }
}
