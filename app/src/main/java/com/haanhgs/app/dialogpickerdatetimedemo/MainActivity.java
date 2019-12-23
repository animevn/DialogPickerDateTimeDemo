package com.haanhgs.app.dialogpickerdatetimedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//using interface will need to implement saveinstance and restart interface or else
//interface null & app crashes when configurations change.
//really should be migrated to livedata and all will be free.
public class MainActivity extends AppCompatActivity implements DatePicker.ReturnDate, TimePicker.ReturnTime{

    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.bnTime)
    Button bnTime;
    @BindView(R.id.bnDate)
    Button bnDate;

    private static final String MESSAGE = "message";

    private void loadInstanceState(Bundle bundle){
        if (bundle != null){
            tvTime.setText(bundle.getString(MESSAGE));
            DatePicker date = (DatePicker)getSupportFragmentManager().findFragmentByTag("date");
            if (date != null) date.setListener(this);
            TimePicker time = (TimePicker)getSupportFragmentManager().findFragmentByTag("time");
            if (time != null) time.setListener(this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MESSAGE, tvTime.getText().toString());
    }

    private void openDatePicker(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DatePicker fragment = (DatePicker) getSupportFragmentManager().findFragmentByTag("date");
        if (fragment == null){
            DatePicker datePicker = new DatePicker();
            datePicker.setListener(this);
            datePicker.show(getSupportFragmentManager(), "date");
        }

    }

    private void openTimePicker(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        TimePicker fragment = (TimePicker) getSupportFragmentManager().findFragmentByTag("time");
        if (fragment == null){
            TimePicker timePicker = new TimePicker();
            timePicker.setListener(this);
            timePicker.show(getSupportFragmentManager(), "time");
        }
    }

    @OnClick({R.id.bnTime, R.id.bnDate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnTime:
                openTimePicker();
                break;
            case R.id.bnDate:
                openDatePicker();
                break;
        }
    }

    @Override
    public void date(int year, int month, int day) {
        String string = "You've chosen year: " + year +
                " and month: " + month +
                " and day: " + day;
        tvTime.setText(string);
    }

    @Override
    public void time(int hourOfDay, int minute) {
        String string = "You've chosen hour: " + hourOfDay + " and min: " + minute;
        tvTime.setText(string);
    }
}
