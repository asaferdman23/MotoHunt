package com.motorolasolutions.motohunt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MissionSevenClass extends BasicActivity {
    Button finishButton;

    @Override
    protected void setNextTask() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_seven);
    }

    public void init() {
        super.init();
        finishButton = findViewById(R.id.finish_mission_one);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText edittext = new EditText(MissionSevenClass.this);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MissionSevenClass.this);
                builder1.setMessage("What is the code you got from Dor Perets??");
                builder1.setCancelable(true);
                builder1.setPositiveButton("Finish",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String theEditTextValue = edittext.getText().toString();
                                if (!theEditTextValue.equals("23")){
                                    Toast.makeText(getApplicationContext(), R.string.try_again, Toast.LENGTH_SHORT).show();
                                    return;
                                } else {
                                    mNextTask = 0;
                                    endActivity();
                                }
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onKeyDown(int key_code, KeyEvent key_event) {
        if (key_code== KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(key_code, key_event);
            return true;
        }
        return false;
    }
}
