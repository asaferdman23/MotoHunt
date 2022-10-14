package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

public class MissionThreeClass extends BasicActivity {
    Button mFinishBtn;
    EditText mAnswerOne, mAnswerTwo, mAnswerThree, mAnswerFour, mAnswerFive;
    int checking =0;
    @Override
    protected void setNextTask() {
        mNextTask = 3;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_three);
        init();
    }

    public void init() {
        super.init();
        mFinishBtn = findViewById(R.id.finish_mission_three_button);
        mAnswerOne = findViewById(R.id.mission_three_input1);
        mAnswerTwo = findViewById(R.id.mission_three_input2);
        mAnswerThree = findViewById(R.id.mission_three_input3);
        mAnswerFour = findViewById(R.id.mission_three_input4);
        mAnswerFive = findViewById(R.id.mission_three_input5);
        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(mAnswerOne);
                check(mAnswerTwo);
                check(mAnswerThree);
                check(mAnswerFour);
                check(mAnswerFive);
                if (checking == 5){
                    Log.i("asaf", "onClick needs to go end activity: ");
                    endActivity();
                } else {
                    TastyToast.makeText(getApplicationContext(),"One or more of the fields are empty" ,TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            }
        });
    }

    private void check(EditText editAnswer) {
        // if the editText is not good enough,show some toast.
        String answerWritten = editAnswer.getText().toString();
        if (answerWritten.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.try_again, Toast.LENGTH_SHORT).show();
            return;
        } else {
            checking++;
        }
    }
}
