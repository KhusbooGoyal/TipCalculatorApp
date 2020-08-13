package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterAmt;
    private SeekBar seekBar;
    private Button btn;
    private TextView result;
    private TextView tv;
    private int percentage;
    private float enteredBillFloat;
    private TextView totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmt = (EditText) findViewById(R.id.buildID);
        seekBar = (SeekBar) findViewById(R.id.percentageSeekbarID);
        btn = (Button) findViewById(R.id.calculateID);
        result = (TextView) findViewById(R.id.resultID);
        tv = (TextView) findViewById(R.id.textViewSeekbar);
        totalBill = (TextView) findViewById(R.id.totalBillID);

        btn.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v){

        calc();
    }

    @SuppressLint("SetTextI18n")
    public void calc(){
        float res= 0.0f;
        if(!enterAmt.getText().toString().equals("")){
            enteredBillFloat = Float.parseFloat(enterAmt.getText().toString());
            res = enteredBillFloat * percentage / 100;
            result.setText("Your tip will be $" + res);
            totalBill.setText("Total bill: $" + String.valueOf(enteredBillFloat + res));
        }
        else{
            Toast.makeText(MainActivity.this, "Please enter a bill amount", Toast.LENGTH_LONG).show();
        }

    }
}