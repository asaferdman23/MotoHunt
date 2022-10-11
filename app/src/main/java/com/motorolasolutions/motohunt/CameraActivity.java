package com.motorolasolutions.motohunt;

import androidx.annotation.Nullable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class CameraActivity extends BasicActivity {
    private static final String TAG = CameraActivity.class.getName();
    public static final String MISSION_NUMBER = "MISSION_NUMBER";
    public static String selectedMission;
    SharedPreferences mSharedPreferences;
    TextView welcomeText;
    Button mOpenCameraButton;
    String missionA = "Welcome Home";
    String missionB = "Hello2";
    String missionC = "Hello3";
    String missionD = "Hello4";
    String missionE = "Hello5";
    String missionF = "Hello6";
    String missionG = "Hello7";
    String missionH = "Hello8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        welcomeText = findViewById(R.id.welcome_text);
        mOpenCameraButton = findViewById(R.id.open_camera_button);

        mOpenCameraButton.setOnClickListener(v -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            //Set flash option
            intentIntegrator.setPrompt(String.valueOf(R.string.flash_option));
            intentIntegrator.setBeepEnabled(true);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.setCaptureActivity(CaptureClass.class);
            intentIntegrator.initiateScan();
        });
    }

    private void saveMissionNumber() {
        mSharedPreferences = getSharedPreferences("MISSION_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(MISSION_NUMBER, selectedMission);
        edit.apply();
    }

    @Override
    protected void setNextTask() {
        mNextTask = 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String content = intentResult.getContents();
        if (content != null) {
            if (content.equals(missionA) || content.equals(missionB) || content.equals(missionC) || content.equals(missionD) || content.equals(missionE) ||
                    content.equals(missionF) || content.equals(missionG) || content.equals(missionH)) {
                selectedMission = content;
                Log.i("asaf", "taking onActivityResult from : " +selectedMission);
                saveMissionNumber();
                Intent intent = new Intent(getApplicationContext(), MissionClass.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), R.string.wrong_qr_code, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), R.string.try_again, Toast.LENGTH_SHORT).show();
        }
    }
}