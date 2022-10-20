package com.motorolasolutions.motohunt;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rm.rmswitch.RMAbstractSwitch;
import com.rm.rmswitch.RMTristateSwitch;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

public class MissionFourClass extends BasicActivity {
    private static final int OPTIONS_NUM = 10;
    Button mFinishMissionFour;
    EditText[] mEditTextsArray;
    RMTristateSwitch[] mSwitchesArray;
    ArrayList<String> mAnswerValues;
    boolean valid;
    int[] answers;
    int[] requested;
    boolean fullyFilled = true;
    private String switchTextID;
    private static final String TAG = "MissionFourClass";

    public void init() {
        super.init();
        mAnswerValues = new ArrayList<>();
        answers = new int[OPTIONS_NUM];
        requested = new int[]{-1, -1, 1, -1, 1, -1, 1, 1, 1, 1};
        initSwitchesArray();
        mFinishMissionFour = findViewById(R.id.finish_mission_four);
        //checkSwitch();

        mFinishMissionFour.setOnClickListener(view -> {
            //createDialog(true, isTouched? "Great!" : "Shit!");
            checkSwitch();
            if (valid) {
                Intent intent = new Intent(getApplicationContext(),RiddleEight.class);
                startActivity(intent);
            } else {
                if (!fullyFilled) {
                    isFinishedTask = false;
                    saveFinishedTask();
                    TastyToast.makeText(this, "Missing answers! forgot to scroll ? ",
                            TastyToast.LENGTH_LONG, TastyToast.WARNING);
                } else {
                    isFinishedTask = false;
                    TastyToast.makeText(this, "One of the answers are wrong!",
                            TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
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
            int finalI = i;
            mSwitchesArray[i].addSwitchObserver(new RMTristateSwitch.RMTristateSwitchObserver() {
                @Override
                public void onCheckStateChange(RMTristateSwitch switchView, @RMTristateSwitch.State int state) {
                    int id = finalI;
                    if (mSwitchesArray[id].getState() == RMTristateSwitch.STATE_LEFT) {
                        answers[id] = -1;
                    } else if (mSwitchesArray[id].getState() == RMTristateSwitch.STATE_RIGHT) {
                        answers[id] = 1;
                    } else {
                        answers[id] = 0;
                    }
                }
            });
        }
    }

    private void checkSwitch() {
        valid = true;
        fullyFilled = true;
        for (int i = 0; i < OPTIONS_NUM; i++) {
            valid = valid & (answers[i] == requested[i]);
            if (answers[i] == 0) {
                fullyFilled = false;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
