package com.example.viewmodelandlivedatademo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class DataList {

    @SerializedName("Data")
    @Expose
    private List<Items> data = null;

    public List<Items> getData() {
        return data;
    }

    public void setData(List<Items> data) {
        this.data = data;
    }

}
