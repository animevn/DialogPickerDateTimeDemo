package com.haanhgs.app.dialogpicker.viewmodel;

import com.haanhgs.app.dialogpicker.model.Repo;
import com.haanhgs.app.dialogpicker.model.Time;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private Repo repo = new Repo();

    public MutableLiveData<Time> getLiveData() {
        return repo.getLiveData();
    }

    public void setDate(String date) {
        repo.setDate(date);
    }

    public void setTime(String time) {
        repo.setDate(time);
    }
}
