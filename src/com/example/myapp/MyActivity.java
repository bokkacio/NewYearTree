package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private DrawView drawView;
    private LinearLayout newYearTreeView, actionButtonsView;
    private Button lightOn, lightOff;
    private boolean isTreeOn = false;

    private LightSequenceManager lightManager = new LightSequenceManager();

    //runs without a timer by reposting this handler at the end of the runnable
    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            lightManager.RenewLightColors();
            RedrawViewLights();

            //выполнять два раза в секунду
            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initUiComponents();
    }

    private void initUiComponents()
    {
        newYearTreeView = (LinearLayout)findViewById(R.id.newYearTreeView);
        actionButtonsView = (LinearLayout)findViewById(R.id.actionButtonsView);

        actionButtonsView.setBackgroundColor(Color.GRAY);

        lightOn = (Button)findViewById(R.id.but_lightOn);
        lightOff = (Button)findViewById(R.id.but_lightOff);

        lightOn.setOnClickListener(this);
        lightOff.setOnClickListener(this);

        //A structure describing general information about a display, such as its size, density, and font scaling.
        DisplayMetrics dm = new DisplayMetrics();

        //Retrieve the window manager for showing custom windows. -> Returns the Display upon which this WindowManager instance will create new windows. -> Gets display metrics based on the real size of this display.
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        drawView = new DrawView(this, dm.heightPixels, dm.widthPixels);
        drawView.setBackgroundColor(Color.GRAY);
        newYearTreeView.addView(drawView);
    }

    private void RedrawViewLights()
    {
        int[] currentColors = lightManager.GetCurrentColors();
        drawView.SetLights(currentColors);
        newYearTreeView.invalidate();
    }

    @Override
    public void onPause() {
        super.onPause();
        timerHandler.removeCallbacks(timerRunnable);
        isTreeOn = false;
    }

    @Override
    public void onClick(View clickedView)
    {
        switch (clickedView.getId())
        {
            case R.id.but_lightOn:
                lightTreeOn();
                break;
            case R.id.but_lightOff:
                lightTreeOff();
                break;
        }
    }

    private void lightTreeOn() {
        if(isTreeOn == true)
            return;

        timerHandler.postDelayed(timerRunnable, 0);
        isTreeOn = true;
    }

    private void lightTreeOff()
    {
        //Remove any pending posts of Runnable that are in the message queue.
        timerHandler.removeCallbacks(timerRunnable);
        lightManager.SetDefaultColors();
        RedrawViewLights();
        isTreeOn = false;
    }
}
