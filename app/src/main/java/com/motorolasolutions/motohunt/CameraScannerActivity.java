package com.motorolasolutions.motohunt;

import static com.motorolasolutions.motohunt.PathChooserActivity.OPTION;
import static com.motorolasolutions.motohunt.PathChooserActivity.OPTIONS;


import androidx.annotation.Nullable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.sdsmdg.tastytoast.TastyToast;


public class CameraScannerActivity extends BasicActivity {
    private static final String TAG = CameraScannerActivity.class.getName();
    public static final String MISSION_NUMBER = "MISSION_NUMBER";
    public static String selectedMission;
    SharedPreferences mSharedPreferences;
    TextView welcomeText;
    Button mOpenCameraButton;
    ImageView mHintImage;
    String mPathSelected;
    String spinnerSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        welcomeText = findViewById(R.id.welcome_text);
        mOpenCameraButton = findViewById(R.id.open_camera_button);
        mHintImage = findViewById(R.id.hint_picture);
        mOpenCameraButton.setOnClickListener(v -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            //Set flash option
            intentIntegrator.setPrompt(String.valueOf(R.string.flash_option));
            intentIntegrator.setBeepEnabled(true);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.setCaptureActivity(CaptureClass.class);
            intentIntegrator.initiateScan();
        });
        hintsPicker();
    }

    private void saveMissionNumber() {
        mSharedPreferences = getSharedPreferences("MISSION_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(MISSION_NUMBER, selectedMission);
        edit.apply();
    }

    private void getOption() {
//        mSharedPreferences = getSharedPreferences("OPTION", Context.MODE_PRIVATE);
        mSharedPreferences = getSharedPreferences(OPTION, Context.MODE_PRIVATE);
        mPathSelected = mSharedPreferences.getString(OPTIONS, spinnerSharedPref);
        Log.i("asaf", "getOption: is " + mPathSelected);
    }

    public void hintsPicker() {
        getOption();
        Intent mNextMissionIntent = getIntent();
        String hintPicker = mNextMissionIntent.getStringExtra("nextTaskString");
        if (mPathSelected.equals("A")) {
            switch (hintPicker) {
                case "class com.motorolasolutions.motohunt.TeamSetActivity":
                    mHintImage.setImageResource(R.drawable.hint_1);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleOne":
                    mHintImage.setImageResource(R.drawable.hint_2);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleTwo":
                    mHintImage.setImageResource(R.drawable.hint_3);
                    break;
                case "class com.motorolasolutions.motohunt.MissionThreeClass":
                    mHintImage.setImageResource(R.drawable.hint_4);
                    break;
//                case "class com.motorolasolutions.motohunt.RiddleEight":
//                    mHintImage.setImageResource(R.drawable.hint_8);
//                    break;
                case "class com.motorolasolutions.motohunt.MissionEightClass":
                    mHintImage.setImageResource(R.drawable.hint_5);
                    break;
                case "class com.motorolasolutions.motohunt.GuessWhoActivity":
                    mHintImage.setImageResource(R.drawable.hint_6);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleSeven":
                    mHintImage.setImageResource(R.drawable.hint_7);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleSix":
                    mHintImage.setImageResource(R.drawable.hint_8);
                    break;
            }
        } else {
            switch (hintPicker) {
                case "class com.motorolasolutions.motohunt.TeamSetActivity":
                    mHintImage.setImageResource(R.drawable.hint_7);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleSeven":
                    mHintImage.setImageResource(R.drawable.hint_6);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleSix":
                    mHintImage.setImageResource(R.drawable.hint_5);
                    break;
                case "class com.motorolasolutions.motohunt.GuessWhoActivity":
                    mHintImage.setImageResource(R.drawable.hint_4);
                    break;
                case "class com.motorolasolutions.motohunt.MissionEightClass":
                    mHintImage.setImageResource(R.drawable.hint_3);
                    break;
                case "class com.motorolasolutions.motohunt.MissionThreeClass":
                    mHintImage.setImageResource(R.drawable.hint_2);
                    break;
                case "class com.motorolasolutions.motohunt.RiddleTwo":
                    mHintImage.setImageResource(R.drawable.hint_1);
                    break;
                    case "class com.motorolasolutions.motohunt.RiddleOne":
                    mHintImage.setImageResource(R.drawable.hint_8);
                    break;
            }
        }
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
        if (content != null && isFinishedTask) {
            selectedMission = content;
            saveMissionNumber();
            Log.i("asaf", "taking onActivityResult from : " + selectedMission);
            switch (content) {
                case "Hello1":
                    Intent intent = new Intent(getApplicationContext(), MissionOneClass.class);
                    startActivity(intent);
                    break;
                case "Hello2":
                    Intent intent2 = new Intent(getApplicationContext(), MissionTwoClass.class);
                    startActivity(intent2);
                    break;
                case "Hello3":
                    Intent intent3 = new Intent(getApplicationContext(), MissionThreeClass.class);
                    startActivity(intent3);
                    break;
                case "Hello4":
                    Intent intent4 = new Intent(getApplicationContext(), MissionEightClass.class);
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
                    Intent intent8 = new Intent(getApplicationContext(), MissionFourClass.class);
                    startActivity(intent8);
                    break;
            }
        } else if (!isFinishedTask) {
            TastyToast.makeText(CameraScannerActivity.this, "You can't move to another mission! ", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onKeyDown(int key_code, KeyEvent key_event) {
        if (key_code == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(key_code, key_event);
            return true;
        }
        return false;
    }
}