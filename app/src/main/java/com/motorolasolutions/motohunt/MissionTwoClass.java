package com.motorolasolutions.motohunt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jsibbold.zoomage.ZoomageView;
import com.sdsmdg.tastytoast.TastyToast;

import org.w3c.dom.Text;

import javax.security.auth.login.LoginException;

public class MissionTwoClass extends BasicActivity {
    Button mFinishButton;
    EditText missionTwoInput;
    String theSolution = "234811111315";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_two);

        init();
    }

    @Override
    protected void setNextTask() {
        mNextTask = 2;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void init() {
        super.init();
        ZoomageView zv = findViewById(R.id.myZoomageView);
        zv.setVisibility(View.INVISIBLE);
        TextView tv = findViewById(R.id.mission_welcome_text);
        tv.setTextSize(20);
        tv.setText("Answer is 12 digits total \nEnter the answer without spaces");
        missionTwoInput = findViewById(R.id.mission_two_input);
        mFinishButton = findViewById(R.id.finish_mission_two_button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String solutionGuess = missionTwoInput.getText().toString();
                if (solutionGuess.equals(theSolution)) {
                    final Runnable mNextTaskRunnable = () -> {
                        Intent intent = new Intent(getApplicationContext(),RiddleTwo.class);
                        startActivity(intent);
                    };
                    mHandler.postDelayed(mNextTaskRunnable, 2500);
                    TastyToast.makeText(getApplicationContext(),"Good Job! now Riddle!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                } else {
                    isFinishedTask = false;
                    saveFinishedTask();
                    TastyToast.makeText(getApplicationContext(), "Wrong , Try again! ", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            }
        });
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
