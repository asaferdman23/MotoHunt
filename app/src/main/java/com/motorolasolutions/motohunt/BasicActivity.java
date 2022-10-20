package com.motorolasolutions.motohunt;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.Locale;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


/**
 * this class have Toolbar ready.
 * Need to do extend this class:
 * and in function init() , that should be called from onCreate
 * write super.init();
 * add in layout :
 * <include
 * android:id="@+id/include_app_bar"
 * layout="@layout/toolbar" />
 * <p>
 * and then
 * android:layout_marginTop="44dp"
 * <p>
 * in your toppest view
 * <p>
 * later, add the FAB button IN HERE
 * <p>
 * also, this class will start timer (since its the same for all activities
 * will end timer
 * will Toast good job
 * will send to next activity / task / hint / qr
 */
public abstract class BasicActivity extends AppCompatActivity {
    private static final String TAG = BasicActivity.class.getName();
    KonfettiView konfettiView;
    Handler mHandler;
    TextView mTimer;
    private int seconds;
    private boolean running;
    private String time;
    static boolean isFinishedTask = false;

    int mNextTask;

    protected abstract void setNextTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void init() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        konfettiView = findViewById(R.id.viewKonfetti);
        konfettiView.bringToFront();
        mHandler = new Handler();
        mTimer = findViewById(R.id.timer_view);
        if (mTimer != null) {
            initTimer();
            runTimer();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

//
//    private void saveTime() {
//        SharedPreferences timePreferences; = getSharedPreferences("TIME", Context.MODE_PRIVATE);
//        SharedPreferences.Editor edit = mSharedPreferences.edit();
//        edit.putString(TEAM_NAME, team.getText().toString());
//        edit.putInt(TEAM_COUNT, teamMembersCount);
//        edit.putStringSet(MEMBERS, mMembers);
//        edit.apply();
//    }

    protected void endActivity() {
        // this should be at the end of any activity, after finishing the mission
        // TODO: End Timer + Save in here
        running = false;
        //saveTime();
        Log.i(TAG, "endActivity: time is =  " + time);
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);
        // audioPlayer();
        TastyToast.makeText(this, getResources().getString(R.string.end_activity),
                TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

        final Runnable mNextTaskRunnable = () -> {
            Log.i("Asaf", "endActivity goes to mNextTask = : " + mNextTask);
            switch (mNextTask) {
                case 0:
                    Intent qrCodeIntent = new Intent(getApplicationContext(), CameraScannerActivity.class);
                    qrCodeIntent.putExtra("nextTaskString",getClass().toString());
                    Log.i("asaf", "endActivity: sending intent with name =" +getClass().toString());
                    startActivity(qrCodeIntent);
                    break;
                case 1:   // QR Code
                    Intent missionOneIntent = new Intent(getApplicationContext(), MissionOneClass.class);
                    startActivity(missionOneIntent);
                    break;
                case 2:
                    Intent missionTwoIntent = new Intent(getApplicationContext(), MissionTwoClass.class);
                    startActivity(missionTwoIntent);
                    // next activity
                    // send intent to next activity
                    break;
                case 3:
                    Intent missionThreeIntent = new Intent(getApplicationContext(), MissionThreeClass.class);
                    startActivity(missionThreeIntent);// next activity
                    // send intent to next activity
                    break;
                case 4:             // next activity
                    // send intent to next activity
                    break;
                case 5:
                    // send intent to the guess who activity next activity
                    Intent guessWhoIntent = new Intent(getApplicationContext(), GuessWhoActivity.class);
                    startActivity(guessWhoIntent);
                    break;
                case 6:             // next activity
                    // send intent to next activity
                    break;
                case 7:             // next activity
                    // send intent to next activity
                    break;
                case 8:             // next activity
                    // send intent to next activity
                    break;
                case 9:             // next activity
                    // send intent to next activity
                    break;
                case 999:
                    //send to finish page
                    //end timer
                default:
                    break;
            }
        };
        mHandler.postDelayed(mNextTaskRunnable, 3000);
    }

    private void audioPlayer() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.applause);
        mp.start();
    }

    private void initTimer() {
        mTimer.setTextColor(getResources().getColor(R.color.motoBlue));
        seconds = 0;
        running = true;
    }

    private void runTimer() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                mTimer.setText(time);

                if (running) {
                    seconds++;
                }
                mHandler.postDelayed(this, 1000);
            }
        });
    }
//
//    @Override
//    public void onBackPressed() {
//    }
//
//    @Override
//    public boolean onKeyDown(int key_code, KeyEvent key_event) {
//        if (key_code== KeyEvent.KEYCODE_BACK) {
//            super.onKeyDown(key_code, key_event);
//            return true;
//        }
//        return false;
//    }
}
