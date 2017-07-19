package com.inno.ilyadmt.intentservice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;



import static java.lang.Thread.sleep;

/**
 * Created by mjazz on 19.07.2017.
 */

public class ValuteService extends IntentService{
    StringBuilder message;
    volatile boolean rubMonitoring, usMonitoring, euMonitoring;
    Context context;
    private Handler handler = new Handler();

    public ValuteService() {
        super("sdfsdf");
    }
//    public ValuteService(String name, Context context) {
//        super(name);
//        this.context = context;
//    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                message = new StringBuilder("");
                for(;;){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message = new StringBuilder("");
                    if(rubMonitoring){
                        message.append("\n rub course is: " + 100);

                    }
                    if(usMonitoring){
                        message.append("\n us course is: " + 0);
                    }
                    if(euMonitoring){
                        message.append("\n eu course is: " + 1);
                    }
                    if(!"".equals(message.toString())){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), message.toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    else break;
                }
            }
        });
        rubMonitoring = intent.getBooleanExtra("rur", false);
        usMonitoring = intent.getBooleanExtra("us", false);
        euMonitoring = intent.getBooleanExtra("eu", false);
        thread.start();

    }
}
