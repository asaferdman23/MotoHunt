package com.motorolasolutions.motohunt;

import android.os.Bundle;

public class MissionThreeClass extends BasicActivity{
    @Override
    protected void setNextTask() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_three);
    }
}
