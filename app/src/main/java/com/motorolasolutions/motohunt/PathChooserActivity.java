package com.motorolasolutions.motohunt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Collections;

public class PathChooserActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView mWelcomeText;
    Button mFinishButton;
    SharedPreferences mSharedPreferences;
    Spinner spinner;
    public static final String OPTIONS = "OPTIONS";
    public static final String OPTION = "OPTION";
    String spinnerContent;
    // private static final String TEAM_COUNT = "TEAM_COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        spinner = (Spinner) findViewById(R.id.spinner_entrance);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.context_route, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        mFinishButton= findViewById(R.id.set_your_route_button);
        mWelcomeText =findViewById(R.id.welcome_text);

        mFinishButton.setOnClickListener(view -> {
            saveOption();
            Intent intent = new Intent(this,TeamSetActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void saveOption() {
        spinnerContent =spinner.getSelectedItem().toString();
        mSharedPreferences = getSharedPreferences(OPTION, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(OPTIONS, spinnerContent);
        String spin=spinnerContent;
        Log.i("asaf", "saveOption: is" +spin );
        edit.apply();
    }
}