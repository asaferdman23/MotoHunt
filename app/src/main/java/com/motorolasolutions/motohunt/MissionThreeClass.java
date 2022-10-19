package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rm.rmswitch.RMTristateSwitch;
import com.sdsmdg.tastytoast.TastyToast;

public class MissionThreeClass extends BasicActivity {
    Button mFinishBtn;
    EditText mAnswerOne, mAnswerTwo, mAnswerThree, mAnswerFour, mAnswerFive;
    int checking = 0;

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
                String answer1 = mAnswerOne.getText().toString();
                String answer2 = mAnswerTwo.getText().toString();
                String answer3 = mAnswerThree.getText().toString();
                String answer4 = mAnswerFour.getText().toString();
                String answer5 = mAnswerFive.getText().toString();

                String[] answers = {answer1, answer2, answer3, answer4, answer5};
                for (int i = 1; i < answers.length; i++) {
                    String answerId = "answer" + i;
                    if (answers[i].isEmpty()) {
                        TastyToast.makeText(getApplicationContext(),"You can't leave one or more fields empty " ,TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        return;
                    }
                }
                if (answer1.equalsIgnoreCase(getResources().getString(R.string.answer_1_mirs)) && answer2.equalsIgnoreCase(getResources().getString(R.string.answer_2_apx_next)) &&
                        answer3.equalsIgnoreCase(getResources().getString(R.string.answer_3_prince)) && answer4.equalsIgnoreCase(getResources().getString(R.string.answer_4_lex)) &&
                        answer5.equalsIgnoreCase(getResources().getString(R.string.answer_5_stryker))) {
                    Log.i("asaf", "onClick needs to go end activity: ");
                    isFinishedTask = true;
                    mNextTask = 0;
                    endActivity();
                } else {
                    isFinishedTask = false;
                    TastyToast.makeText(getApplicationContext(), "Wrong answer!", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            }
        });
    }
}
