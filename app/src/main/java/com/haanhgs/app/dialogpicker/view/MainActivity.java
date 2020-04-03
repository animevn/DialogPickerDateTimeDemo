package com.haanhgs.app.dialogpicker.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haanhgs.app.dialogpicker.R;
import com.haanhgs.app.dialogpicker.viewmodel.MyViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.bnTime)
    Button bnTime;
    @BindView(R.id.bnDate)
    Button bnDate;

    private static final String MESSAGE = "message";
    @BindView(R.id.tvDate)
    TextView tvDate;
    private MyViewModel viewModel;

    private void updateTextView() {
        viewModel.getDate().observe(this, string -> tvDate.setText(string));
        viewModel.getTime().observe(this, string -> tvTime.setText(string));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        updateTextView();
    }

    private void openDatePicker() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DatePicker fragment = (DatePicker) getSupportFragmentManager().findFragmentByTag("date");
        if (fragment == null) {
            DatePicker datePicker = new DatePicker();
            datePicker.show(getSupportFragmentManager(), "date");
        }
    }

    private void openTimePicker() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        TimePicker fragment = (TimePicker) getSupportFragmentManager().findFragmentByTag("time");
        if (fragment == null) {
            TimePicker timePicker = new TimePicker();
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
}
