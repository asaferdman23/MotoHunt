package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

public class MissionEightClass extends BasicActivity {
    EditText alon1E, alon2E, beitE, gilE, hazahavE, mercazE, paisE, kehilatyE;
    Button finishMissionEightButton;
    boolean goodAnswer = false;

    @Override
    protected void setNextTask() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_eight);
        init();
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


    public void init() {
        super.init();
        Log.i("asaf", "onClick: goodAnswer on create=  " + goodAnswer);
        alon1E = findViewById(R.id.edit_alon0);
        alon2E = findViewById(R.id.edit_alon1);
        beitE = findViewById(R.id.edit_beit1);
        gilE = findViewById(R.id.edit_gil1);
        hazahavE = findViewById(R.id.edit_hazahav1);
        mercazE = findViewById(R.id.edit_mercaz1);
        paisE = findViewById(R.id.edit_pais1);
        kehilatyE = findViewById(R.id.edit_kehilaty1);
        finishMissionEightButton = findViewById(R.id.finish_mission_eight1);
        finishMissionEightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alon1S = alon1E.getText().toString();
                String alon2S = alon2E.getText().toString();
                String beitS = beitE.getText().toString();
                String gilS = gilE.getText().toString();
                String hazahavS = hazahavE.getText().toString();
                String mercazS = mercazE.getText().toString();
                String paisS = paisE.getText().toString();
                String kehilatyS = kehilatyE.getText().toString();
                String[] answers = {alon1S, alon2S, beitS, gilS, hazahavS, mercazS, paisS, kehilatyS};
                goodAnswer = answers[0].equals("אלון")
                        && answers[1].equals("אלון")
                        && answers[2].equals("בית")
                        && answers[3].equals("גיל")
                        && answers[4].equals("הזהב")
                        && answers[5].equals("מרכז")
                        && answers[6].equals("פיס")
                        && answers[7].equals("קהילתי");
                for (int i = 0; i < answers.length; i++) {
                    if (answers[i].isEmpty()) {
                        TastyToast.makeText(MissionEightClass.this, "You cant leave an empty field!",
                                TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                        return;
                    } else if (goodAnswer) {
                        isFinishedTask = true;
                        saveFinishedTask();
                        Log.i("asaf", "onClick: goodAnswer =  " + goodAnswer);
                        mNextTask = 0;
                        endActivity();
                    } else {
                        isFinishedTask = false;
                        saveFinishedTask();
                        TastyToast.makeText(MissionEightClass.this, "Wrong answer",
                                TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }
                }
            }
        });

    }
}
