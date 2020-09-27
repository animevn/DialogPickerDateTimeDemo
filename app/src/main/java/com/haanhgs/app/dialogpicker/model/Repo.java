package com.haanhgs.app.dialogpicker.model;

import androidx.lifecycle.MutableLiveData;

public class Repo {

    private MutableLiveData<Time> liveData = new MutableLiveData<>();
    private Time time = new Time();

    public Repo() {
        liveData.setValue(time);
    }

    public MutableLiveData<Time> getLiveData(){
        return liveData;
    }

    public void setDate(String date){
        time.setDate(date);
        liveData.setValue(time);
    }

    public void setTime(String time){
        this.time.setTime(time);
        liveData.setValue(this.time);
    }




}
