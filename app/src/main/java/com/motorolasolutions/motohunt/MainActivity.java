package com.motorolasolutions.motohunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hodaya.motohunt.R;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final String MEMBERS = "TEAM_MEMBERS";
    private static final String TEAM_NAME = "TEAM";
    EditText team , name1 ,name2 ,name3 ,name4 ,name5 ;
    Button button ;
    SharedPreferences mSharedPreferences;
    Set<String> mMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team=findViewById(R.id.editText1);
        name1=findViewById(R.id.editText2);
        name2=findViewById(R.id.editText3);
        name3=findViewById(R.id.editText4);
        name4=findViewById(R.id.editText5);
        name5=findViewById(R.id.editText6);

        mMembers.add(name1.getText().toString());
        mMembers.add(name2.getText().toString());
        mMembers.add(name3.getText().toString());
        mMembers.add(name4.getText().toString());
        mMembers.add(name5.getText().toString());

        button=findViewById(R.id.button);
        button.setOnClickListener(view -> {
            //if(team.getText().)
        });
    }

    private void saveTeam() {
        mSharedPreferences= getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=mSharedPreferences.edit();
        edit.putString(TEAM_NAME,team.getText().toString());
        edit.putStringSet(MEMBERS,mMembers);
        edit.apply();
    }

//    private void loadList() {
//        mSharedPreferences= getContext().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
//        Set<String> string_set = mSharedPreferences.getStringSet(TODO_LIST,null);
//        values=new ArrayList<>(string_set);
//    }
}