package com.responsi.mvp.presenterimp;

import android.util.Log;

import com.responsi.mvp.model.People;
import com.responsi.mvp.presenter.MainPresenter;
import com.responsi.mvp.service.APIService;
import com.responsi.mvp.service.ServiceGenerator;
import com.responsi.mvp.view.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImp implements MainPresenter {

    MainView mainView;
    APIService apiService;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
        if (apiService == null) {
            apiService = ServiceGenerator.createService();
        }
    }

    @Override
    public void callPeopleData(String results, String nat) {
        apiService.callPeople(results, nat)
                .enqueue(new Callback<People>() {
                    @Override
                    public void onResponse(Call<People> call, Response<People> response) {
                        if (response.isSuccessful()){
                            Log.i("xxxx", "Success : " + response.body().getData());
                            mainView.setPeopleData(response.body().getData());
                        }else{
                            Log.i("xxxx", "Unsuccess : " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<People> call, Throwable t) {
                        Log.i("xxxx", "Throw : " + t);
                    }
                });
    }
}
