package com.motorolasolutions.motohunt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jsibbold.zoomage.ZoomageView;
import com.sdsmdg.tastytoast.TastyToast;

public class RiddleSeven extends BasicActivity {
    Button mFinishButton;
    EditText answer;
    String theSolution = "frontcloset";
    ZoomageView img;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_two);
        init();
    }

    @Override
    protected void setNextTask() {
        mNextTask = 999;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void init() {
        super.init();

        answer = findViewById(R.id.mission_two_input);
        title = findViewById(R.id.mission_welcome_text);
        title.setText("2 Words answer - Write without space");
        title.setTextSize(19);
        answer.setInputType(InputType.TYPE_CLASS_TEXT);
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
