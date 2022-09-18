package com.android.jalKachara;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button startBtn;
    protected Button stopBtn;
    protected Button leftBtn;
    protected Button rightBtn;
    protected Switch switchMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi() {
        startBtn=findViewById(R.id.startBtn);
        stopBtn=findViewById(R.id.stopBtn);
        leftBtn=findViewById(R.id.leftBtn);
        rightBtn=findViewById(R.id.rightBtn);
        switchMode = findViewById(R.id.switchMode);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    sendModeCmd(1);
                }else{
                    sendModeCmd(0);
                }
            }
        });
    }

    private void sendModeCmd(int i) {
        Toast.makeText(this,"selected Id for mode : "+i,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.equals(startBtn)) {
            sendStartStopCommand(1);
        }else if(v.equals(stopBtn)) {
            sendStartStopCommand(0);
        }else if(v.equals(leftBtn)) {
            sendLeftRightCommand(1);
        }else if(v.equals(rightBtn)) {
            sendLeftRightCommand(0);
        }
    }

    private void sendLeftRightCommand(int id) {
        Toast.makeText(this,"selected Id for Right and Left: "+id,Toast.LENGTH_LONG).show();
    }

    private void sendStartStopCommand(int id) {
        Toast.makeText(this,"selected Id for start and stop : "+id,Toast.LENGTH_LONG).show();
    }
}