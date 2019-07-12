package com.responsi.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People {
    @SerializedName("results")
    List<ResultData> data;
    @SerializedName("info")
    Info info;

    public List<ResultData> getData() {
        return data;
    }

    public void setData(List<ResultData> data) {
        this.data = data;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
