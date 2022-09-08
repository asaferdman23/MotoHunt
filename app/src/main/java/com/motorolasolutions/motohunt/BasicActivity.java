package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


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
 */
public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

}
