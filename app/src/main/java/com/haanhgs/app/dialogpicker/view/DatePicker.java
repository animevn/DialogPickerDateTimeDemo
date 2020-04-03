package com.haanhgs.app.dialogpicker.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.haanhgs.app.dialogpicker.viewmodel.MyViewModel;
import java.util.Calendar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

//to connect to viewmodel in mainactivity, we have to use fragment activity, not fragment itself
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private Context context;
    private FragmentActivity activity;
    private MyViewModel model;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        activity = getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        model = new ViewModelProvider(activity).get(MyViewModel.class);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(context, this, year, month, day);
    }

    //month starts from 0
    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth){
        String string = "You've chosen year: " + year +
                " and month: " + String.valueOf(month + 1) +
                " and day: " + dayOfMonth;
        model.setDate(string);
    }
}
