package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MissionFourClass extends BasicActivity {
    private static final int OPTIONS_NUM = 10;
    Button mFinishMissionFour;
    EditText[] mEditTextsArray;
    Switch[] mSwitchesArray;
    int[] values;
    boolean[] singleValid;
    private static final String TAG = "MissionFourClass";

    public void init() {
        super.init();
        initEditTextArray();
        initSwitchesArray();
        mFinishMissionFour = findViewById(R.id.finish_mission_four);
        mFinishMissionFour.setOnClickListener(view -> {
        });
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
//    private void changePic(boolean checked, int index) {
//        mSwitchesArray[index].setImageResource(checked ? R.drawable.ic_check_circle : R.drawable.ic_error);
//        singleValid[index] = checked;
//    }

    private void initEditTextArray() {
        mEditTextsArray = new EditText[OPTIONS_NUM];
        String editTextID;
        for (int i = 0; i <=OPTIONS_NUM; i++) {
            editTextID = "input"+i;
            mEditTextsArray[i] = findViewById(getResources().getIdentifier(editTextID, "id", getPackageName()));
            mEditTextsArray[i].addTextChangedListener(new myTextWatcher(i));
        }
    }
    private void initSwitchesArray() {
        mSwitchesArray = new Switch[OPTIONS_NUM];
        String switchTextID;
        for (int i = 0; i <=OPTIONS_NUM; i++) {
            switchTextID = "switch"+i;
            mSwitchesArray[i] = findViewById(getResources().getIdentifier(switchTextID, "id", getPackageName()));
            mSwitchesArray[i].addTextChangedListener(new myTextWatcher(i));
        }
    }

    void checkAll(){
        for (int i = 0; i < OPTIONS_NUM; i++) {
            //changePic(doChecks(i), i);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    boolean doChecks(int index) {
        int numToCheck = values[index];
        if (numToCheck > Defs.MAX_BRIGHTNESS_VALUE || numToCheck < Defs.MIN_BRIGHTNESS_VALUE) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (numToCheck < values[i]) {
                return false;
            }
        }
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
//              String guestAnswer = editable.toString();
                int lastVal = values[index];
                values[index] = newVal;
                checked = doChecks(index);
                if (lastVal > 0 && lastVal < newVal) {
                    // Number higher than previous setting - checkAll again for validity.
                    checkAll();
                }
            }
            //changePic(checked, index);
        }
    }
}
