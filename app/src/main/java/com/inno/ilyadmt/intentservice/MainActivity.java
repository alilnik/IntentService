package com.inno.ilyadmt.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean rur, us, eu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Start(View view) {
        switch (view.getId()) {
            case R.id.button:
                rur = true;
                break;
            case R.id.button3:
                us = true;
                break;
            case R.id.button5:
                eu = true;
                break;
        }
        myStartService();
    }

    void myStartService(){
        Intent intent = new Intent(this, ValuteService.class);
        intent.putExtra("rur", rur);
        intent.putExtra("us", us);
        intent.putExtra("eu", eu);
        startService(intent);
    }

    public void Stop(View view) {
        switch (view.getId()) {
            case R.id.button2:
                rur = false;
                break;
            case R.id.button4:
                eu = false;
                break;
            case R.id.button6:
                us = false;
                break;
        }
        myStartService();
    }
}