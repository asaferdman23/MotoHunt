package com.motorolasolutions.motohunt;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sdsmdg.tastytoast.TastyToast;

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
 *         android:id="@+id/include_app_bar"
 *         layout="@layout/toolbar" />
 *
 * and then
 * android:layout_marginTop="44dp"
 *
 * in your toppest view
 *
 * later, add the FAB button IN HERE
 *
 * also, this class will start timer (since its the same for all activities
 * will end timer
 * will Toast good job
 * will send to next activity / task / hint / qr
 */
public abstract class BasicActivity extends AppCompatActivity {

    KonfettiView konfettiView;
    Handler mHandler;

    int nextTask;

    protected abstract void setNextTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void init(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        konfettiView = findViewById(R.id.viewKonfetti);
        konfettiView.bringToFront();
        mHandler = new Handler();
        // TODO: Start Timer in here
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    protected void endActivity() {
        // this should be at the end of any activity, after finishing the mission
        // TODO: End Timer + Save in here
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
        //  audioPlayer();
        TastyToast.makeText(this, getResources().getString(R.string.end_activity),
                TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

        final Runnable mNextTaskRunnable = () -> {
            switch (nextTask) {
                case 0:             // QR Code
                    // something
                    break;
                case 1:             // Show Hint
                    // something
                    break;
                case 2:             // next activity
                    // send intent to next activity
                    break;
                default:
                    break;
            }
        };
        mHandler.postDelayed(mNextTaskRunnable, 6500);
    }

    private void audioPlayer(){
        MediaPlayer mp=MediaPlayer.create(getApplicationContext(),R.raw.applause);
        mp.start();
    }
}
