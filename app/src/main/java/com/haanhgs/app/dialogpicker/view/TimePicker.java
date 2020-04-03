package com.haanhgs.app.dialogpicker.view;

import android.app.Dialog;
import android.app.TimePickerDialog;
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
public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

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
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(activity).get(MyViewModel.class);
        final Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(context, this, hour, minute, true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        String string = "You've chosen hour: " + hourOfDay + " and min: " + minute;
        model.setTime(string);
    }
}
