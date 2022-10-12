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
import com.motorolasolutions.motohunt.databinding.LayoutMissionEightBinding;


public class CameraScannerActivity extends BasicActivity {
    private static final String TAG = CameraScannerActivity.class.getName();
    public static final String MISSION_NUMBER = "MISSION_NUMBER";
    public static String selectedMission;
    SharedPreferences mSharedPreferences;
    TextView welcomeText;
    Button mOpenCameraButton;


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
            selectedMission = content;
            saveMissionNumber();
            Log.i("asaf", "taking onActivityResult from : " + selectedMission);
            switch (content) {
                case "Welcome Home":
                    Intent intent = new Intent(getApplicationContext(), MissionOneClass.class);
                    startActivity(intent);
                    break;
                case "Hello2":
                    Intent intent2 = new Intent(getApplicationContext(), MissiontwoClass.class);
                    startActivity(intent2);
                    break;
                case "Hello3":
                    Intent intent3 = new Intent(getApplicationContext(), MissionThreeClass.class);
                    startActivity(intent3);
                    break;
                case "Hello4":
                    Intent intent4 = new Intent(getApplicationContext(), MissionFourClass.class);
                    startActivity(intent4);
                    break;
                case "Hello5":
                    Intent intent5 = new Intent(getApplicationContext(), GuessWhoActivity.class);
                    startActivity(intent5);
                    break;
                case "Hello6":
                    Intent intent6 = new Intent(getApplicationContext(), MissionSixClass.class);
                    startActivity(intent6);
                    break;
                case "Hello7":
                    Intent intent7 = new Intent(getApplicationContext(), MissionSevenClass.class);
                    startActivity(intent7);
                    break;
                case "Hello8":
                    Intent intent8 = new Intent(getApplicationContext(), MissionEightClass.class);
                    startActivity(intent8);
                    break;
            }
        } else {
            Toast.makeText(getApplicationContext(), R.string.wrong_qr_code, Toast.LENGTH_SHORT).show();
        }
    }
}