package com.motorolasolutions.motohunt;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rm.rmswitch.RMTristateSwitch;

import java.util.ArrayList;

public class MissionFourClass extends BasicActivity {
    private static final int OPTIONS_NUM = 10;
    Button mFinishMissionFour;
    EditText[] mEditTextsArray;
    RMTristateSwitch[] mSwitchesArray;
    ArrayList<String> mAnswerValues;
    boolean[] singleValid;
    private static final String ANSWER_ONE = String.valueOf(R.string.answer_a);
    private static final String ANSWER_TWO = String.valueOf(R.string.answer_b);
    private static final String ANSWER_THREE = String.valueOf(R.string.answer_c);
    private static final String ANSWER_FOUR = String.valueOf(R.string.answer_d);
    private static final String ANSWER_FIVE = String.valueOf(R.string.answer_e);
    private static final String ANSWER_SIX = String.valueOf(R.string.answer_f);
    private static final String ANSWER_SEVEN = String.valueOf(R.string.answer_g);
    private static final String ANSWER_EIGHT = String.valueOf(R.string.answer_h);
    private static final String ANSWER_NINE = String.valueOf(R.string.answer_i);
    private static final String ANSWER_ten = String.valueOf(R.string.answer_j);
    private static final String TAG = "MissionFourClass";

    public void init() {
        super.init();
        mAnswerValues = new ArrayList<>();
        singleValid = new boolean[OPTIONS_NUM];
        initSwitchesArray();
        mFinishMissionFour = findViewById(R.id.finish_mission_four);
        mFinishMissionFour.setOnClickListener(view -> {
            boolean configValid = true;
            for (int i = 0; i < OPTIONS_NUM; i++) {
                configValid &= singleValid[i];
            }
            if (configValid) {
                Toast.makeText(getApplicationContext(), "I got your answer, and thinking.", Toast.LENGTH_LONG).show();
            }else {
                createDialog(false, "Dsds");
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
    private void checkSwitch() {
//       int options;
//       switch (options){
//           case 1:
//
//       }


//        mSwitchesArray[index].setState(checked ? RMTristateSwitch.STATE_LEFT : RMTristateSwitch.STATE_RIGHT);
//        singleValid[index] = checked;
    }

    private void initSwitchesArray() {
        mSwitchesArray = new RMTristateSwitch [OPTIONS_NUM];
        String switchTextID;
        for (int i = 1; i <OPTIONS_NUM; i++) {
            switchTextID = "switch"+i;
            mSwitchesArray[i] = findViewById(getResources().getIdentifier(switchTextID, "id", getPackageName()));
            mSwitchesArray[i].setSwitchDesign(RMTristateSwitch.DESIGN_LARGE);
        }
    }
//
//    void checkAll(){
//        for (int i = 1; i <= OPTIONS_NUM; i++) {
//            if (mSwitchesArray[i]=){
//                return;
//            }
//        }
//    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
    boolean doChecks(int index) {
//        int numToCheck = mAnswerValues[index];
//        if (numToCheck > Defs.MAX_BRIGHTNESS_VALUE || numToCheck < Defs.MIN_BRIGHTNESS_VALUE) {
//            return false;
//       }
//        for (int i = 0; i < index; i++) {
//            if (numToCheck < mAnswerValues[i]) {
//                return false;
//            }
//        }
        return true;
    }
    private class myTextWatcher implements TextWatcher {
        int index;
        public myTextWatcher(int index) {
            this.index = index;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            boolean checked = false;
            if (editable.length() > 0){
                //int newVal = Integer.parseInt(editable.toString());
                String guestAnswer = editable.toString();
                mAnswerValues.add(guestAnswer);
                //checked = doChecks(index);
                //checkAll();
                Log.i("asaf", "afterTextChanged: " +mAnswerValues);
            }
            //changePic(checked, index);
        }
    }
}
