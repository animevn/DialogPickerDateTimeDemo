package com.haanhgs.app.dialogpickerdatetimedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bnTime, R.id.bnDate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnTime:
                break;
            case R.id.bnDate:
                break;
        }
    }
}
