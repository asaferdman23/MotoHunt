package com.motorolasolutions.motohunt;

import static com.motorolasolutions.motohunt.CameraActivity.MISSION_NUMBER;
import static com.motorolasolutions.motohunt.CameraActivity.selectedMission;
import static com.motorolasolutions.motohunt.PathChooserActivity.OPTIONS;
import static com.motorolasolutions.motohunt.PathChooserActivity.spinnerContent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MissionClass extends AppCompatActivity {
    TextView youArrived;
    SharedPreferences mSharedPreferences;
    String missionSelected;
    String pathSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences("MISSION_PREF", Context.MODE_PRIVATE);
        mSharedPreferences = getSharedPreferences("OPTION", Context.MODE_PRIVATE);
        missionSelected = mSharedPreferences.getString(MISSION_NUMBER, selectedMission);
        Log.i("asaf", "missionSelected from onCreate is : " + missionSelected);
        pathSelected = mSharedPreferences.getString(OPTIONS, spinnerContent);
        youArrived = findViewById(R.id.mission_welcome_text);
        Log.i("Asaf", "onCreate from missionClass gets  =  " + missionSelected);
        switch (missionSelected) {
            case "Welcome Home":
                setContentView(R.layout.layout_mission_one);
                break;
            case "Hello2":
                setContentView(R.layout.layout_mission_two);
                break;
            case "Hello3":
                setContentView(R.layout.layout_mission_three);
                break;
            case "Hello4":
                setContentView(R.layout.layout_mission_four);
                break;
            case "Hello5":
                setContentView(R.layout.layout_mission_five);
                break;
            case "Hello6":
                setContentView(R.layout.layout_mission_six);
                break;
            case "Hello7":
                setContentView(R.layout.layout_mission_seven);
                break;
            case "Hello8":
                setContentView(R.layout.layout_mission_eight);
                break;
        }
    }

}