package com.haanhgs.app.dialogpicker;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Model extends ViewModel {

    private final MutableLiveData<String> date = new MutableLiveData<>();
    private final MutableLiveData<String> time = new MutableLiveData<>();

    public MutableLiveData<String> getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date.setValue(date);
    }

    public MutableLiveData<String> getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time.setValue(time);
    }
}
