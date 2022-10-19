package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jsibbold.zoomage.ZoomageView;
import com.sdsmdg.tastytoast.TastyToast;

public class RiddleSeven extends BasicActivity {
    Button mFinishButton;
    EditText answer;
    String theSolution = "frontcloset";
    ZoomageView img;

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

        answer = findViewById(R.id.mission_two_input);
        mFinishButton = findViewById(R.id.finish_mission_two_button);
        img = findViewById(R.id.myZoomageView);
        img.setImageResource(R.drawable.riddle_7);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String solutionGuess = answer.getText().toString();
                if (solutionGuess.equals(theSolution)) {

                    endActivity();
                } else {
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
