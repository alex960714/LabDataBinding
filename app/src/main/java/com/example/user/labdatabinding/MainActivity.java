package com.example.user.labdatabinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.EditText;
import com.example.user.labdatabinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private TimeCount timeCount = new TimeCount();

    private View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            int startHour, startMin, endHour, endMin;
            try {
                startHour = Integer.parseInt(((EditText) findViewById(R.id.editTextStartHour))
                        .getText().toString());
            }catch (Exception e){
                startHour = 0;

            }

            try {
                startMin = Integer.parseInt(((EditText) findViewById(R.id.editTextStartMin))
                        .getText().toString());
            }catch (Exception e){
                startMin = 0;
            }

            try {
                endHour = Integer.parseInt(((EditText) findViewById(R.id.editTextEndHour))
                        .getText().toString());
            }catch (Exception e){
                endHour = 0;
            }

            try {
                endMin = Integer.parseInt(((EditText) findViewById(R.id.editTextEndMin))
                        .getText().toString());
            }catch (Exception e){
                endMin = 0;
            }

            timeCount.setHours(startHour, endHour);
            timeCount.setMin(startMin, endMin);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);
        binding.setTime(timeCount);

        findViewById(R.id.editTextStartHour).setOnFocusChangeListener(listener);
        findViewById(R.id.editTextEndHour).setOnFocusChangeListener(listener);
        findViewById(R.id.editTextStartMin).setOnFocusChangeListener(listener);
        findViewById(R.id.editTextEndMin).setOnFocusChangeListener(listener);
    }
}
