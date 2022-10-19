package com.motorolasolutions.motohunt;

import static com.motorolasolutions.motohunt.CameraScannerActivity.MISSION_NUMBER;
import static com.motorolasolutions.motohunt.CameraScannerActivity.selectedMission;
import static com.motorolasolutions.motohunt.PathChooserActivity.OPTIONS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MissionManagerClass extends BasicActivity {
    TextView youArrived;
    SharedPreferences mSharedPreferences;
    String missionSelected;
    String pathSelected;

    @Override
    protected void setNextTask() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferences = getSharedPreferences("MISSION_PREF", Context.MODE_PRIVATE);
        mSharedPreferences = getSharedPreferences("OPTION", Context.MODE_PRIVATE);
        missionSelected = mSharedPreferences.getString(MISSION_NUMBER, selectedMission);
        Log.i("asaf", "missionSelected from onCreate is : " + missionSelected);
        youArrived = findViewById(R.id.mission_welcome_text);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}