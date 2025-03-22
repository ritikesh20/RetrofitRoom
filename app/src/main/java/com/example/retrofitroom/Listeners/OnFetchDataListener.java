package com.example.retrofitroom.Listeners;

import com.example.retrofitroom.model.NewsHeadline;

import java.util.List;

public interface OnFetchDataListener<T> {

    void onFetchData(List<NewsHeadline> data, String message);
    void onError(String message);

}
