package com.motorolasolutions.motohunt;

import android.os.Bundle;

public class MissionFourClass extends BasicActivity{


    @Override
    protected void setNextTask() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_three);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
