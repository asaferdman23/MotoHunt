package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.view.View;

public class MissionOneClass extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_one);
    }

    @Override
    protected void setNextTask() {
        mNextTask = 2;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
