package com.motorolasolutions.motohunt;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rm.rmswitch.RMAbstractSwitch;
import com.rm.rmswitch.RMTristateSwitch;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

public class MissionFourClass extends BasicActivity {
    private static final int OPTIONS_NUM = 10;
    Button mFinishMissionFour;
    EditText[] mEditTextsArray;
    RMTristateSwitch[] mSwitchesArray;
    ArrayList<String> mAnswerValues;
    boolean[] singleValid;
    boolean isRight = false;
    private String switchTextID;
    private static final String TAG = "MissionFourClass";

    public void init() {
        super.init();
        mAnswerValues = new ArrayList<>();
        singleValid = new boolean[OPTIONS_NUM];
        initSwitchesArray();
        mFinishMissionFour = findViewById(R.id.finish_mission_four);
        //checkSwitch();

        mFinishMissionFour.setOnClickListener(view -> {
            //createDialog(true, isTouched? "Great!" : "Shit!");
            Log.i("asaf", "the boolean isRight = dffdfdfdf" +isRight);
            if (isRight) {
                mNextTask = 0;
                endActivity();
            } else {
                createDialog(false, "Try again!");
            }
        });
    }

    private void createDialog(boolean mState, String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(MissionFourClass.this).create();
        alertDialog.setMessage(mState ? "you right!" : msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }

    @Override
    protected void setNextTask() {
        mNextTask = 4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_four);
        init();
    }

    private void initSwitchesArray() {
        mSwitchesArray = new RMTristateSwitch[OPTIONS_NUM];
        for (int i = 0; i < OPTIONS_NUM; i++) {
            switchTextID = "switch" + i;
            mSwitchesArray[i] = findViewById(getResources().getIdentifier(switchTextID, "id", getPackageName()));
            mSwitchesArray[i].setSwitchDesign(RMTristateSwitch.DESIGN_ANDROID);
            mSwitchesArray[i].setState(RMAbstractSwitch.STATE_MIDDLE);
        }
    }

//    private void checkSwitch() {
//        for (int i = 0; i < OPTIONS_NUM; i++) {
//            int finalI = i;
//            mSwitchesArray[i].addSwitchObserver(new RMTristateSwitch.RMTristateSwitchObserver() {
//                @Override
//                public void onCheckStateChange(RMTristateSwitch switchView, @RMTristateSwitch.State int state) {
//                    int id = finalI;
//                    if (mSwitchesArray[id].getState(RMAbstractSwitch.STATE_lef)){
//                        Log.i("asaf", "onCheckStateChange: finalI =" + id);
//                    }
//                }
//            });
//        }
//    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
