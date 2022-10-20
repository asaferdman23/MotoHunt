package com.motorolasolutions.motohunt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jsibbold.zoomage.ZoomageView;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EndGame extends BasicActivity {

    SharedPreferences mSharedPreferences;
    String teamName;
    long timerStart;
    private static final String TEAM_NAME = "TEAM";
    private static final String TEAM_COUNT = "TEAM_COUNT";
    private static final String START_TIME = "START_TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

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

    @SuppressLint("SetTextI18n")
    @Override
    public void init() {
        super.init();
        ZoomageView zv = findViewById(R.id.myZoomageView);
        TextView tv = findViewById(R.id.mission_welcome_text);
        TextView timer = findViewById(R.id.timer);
        loadList();
        long passedTime = System.nanoTime() - timerStart;
        long totalSecs = TimeUnit.SECONDS.convert(passedTime, TimeUnit.NANOSECONDS);
        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        String msg ="You did it! Great job MotoHunters!\n";
        tv.setText("Congratulations " + teamName + "!\n"+msg);
        timer.setText("Timer: "+timeString);
    }

    private void loadList() {
        mSharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        teamName = mSharedPreferences.getString(TEAM_NAME, "Motorolans");
        timerStart = mSharedPreferences.getLong(START_TIME, Long.parseLong("0"));
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
