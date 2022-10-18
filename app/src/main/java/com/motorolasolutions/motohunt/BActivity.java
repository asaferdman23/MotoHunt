package com.motorolasolutions.motohunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mEditText=findViewById(R.id.editText);
        mButton=findViewById(R.id.button);
    }
}