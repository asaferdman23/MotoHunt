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

public class MissionFourClass extends BasicActivity {
    private static final int OPTIONS_NUM = 10;
    Button mFinishMissionFour;
    EditText[] mEditTextsArray;
    RMTristateSwitch[] mSwitchesArray;
    ArrayList<String> mAnswerValues;
    boolean[] singleValid;
    static boolean isRight = false;
    private String switchTextID;
    private static final String TAG = "MissionFourClass";

    public void init() {
        super.init();
        mAnswerValues = new ArrayList<>();
        singleValid = new boolean[OPTIONS_NUM];
        initSwitchesArray();
        mFinishMissionFour = findViewById(R.id.finish_mission_four);
        mFinishMissionFour.setOnClickListener(view -> {
            checkSwitch();
            //createDialog(true, isTouched? "Great!" : "Shit!");
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

    private void checkSwitch() {
        for (int i = 0; i < OPTIONS_NUM; i++) {
            int finalI = i;
            mSwitchesArray[i].addSwitchObserver(new RMTristateSwitch.RMTristateSwitchObserver() {
                @Override
                public void onCheckStateChange(RMTristateSwitch switchView, @RMTristateSwitch.State int state) {
                    if ((finalI == 0 && state == RMTristateSwitch.STATE_LEFT) && (finalI == 1 && state == RMTristateSwitch.STATE_LEFT) && (finalI == 3 && state == RMTristateSwitch.STATE_LEFT) && (finalI == 5 && state == RMTristateSwitch.STATE_LEFT)
                        && (finalI == 2 && state == RMTristateSwitch.STATE_RIGHT) && (finalI == 4 && state == RMTristateSwitch.STATE_RIGHT) && (finalI ==6 && state == RMTristateSwitch.STATE_RIGHT) && (finalI == 7 && state == RMTristateSwitch.STATE_RIGHT)
                    && (finalI == 8 && state == RMTristateSwitch.STATE_RIGHT) &&(finalI == 9 && state == RMTristateSwitch.STATE_RIGHT)) {
                        isRight = true;
                    } else {
                        isRight =false;
                    }
                }
            });
        }
        if (isRight) {
            mNextTask = 0;
            endActivity();
        } else {
            createDialog(false, "Try again!");
        }
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
