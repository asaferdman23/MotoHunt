package com.motorolasolutions.motohunt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class TeamSetActivity extends BasicActivity {
    private static final String MEMBERS = "TEAM_MEMBERS";
    private static final String TEAM_NAME = "TEAM";
    private static final String TEAM_COUNT = "TEAM_COUNT";
    EditText team , name1 ,name2 ,name3 ,name4 ,name5, name6;
    int teamMembersCount;
    Button button ;
    SharedPreferences mSharedPreferences;
    Set<String> mMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_team);
        init();

    }

    @Override
    public void init() {
        super.init();
        team = findViewById(R.id.editText1);
        name1 = findViewById(R.id.editText2);
        name2 = findViewById(R.id.editText3);
        name3 = findViewById(R.id.editText4);
        name4 = findViewById(R.id.editText5);
        name5 = findViewById(R.id.editText6);
        name6 = findViewById(R.id.editText7);

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            teamMembersCount = 0;
            check(name1);
            check(name2);
            check(name3);
            check(name4);
            check(name5);
            check(name6);
            if (teamMembersCount >= 4)
                saveTeam();
            else {
                // some toast that say something doesnt make sense
            }
        });
    }

    private void check(EditText editName) {
        if (editName == null || editName.getText() == null)
            return;
        String name = name1.getText().toString();
        if (name.equals(""))
            return;
        //if name check is not good perhaps, some toast that say something doesnt make sense.
        mMembers.add(name);
        teamMembersCount++;
    }

    private void saveTeam() {
        mSharedPreferences= getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=mSharedPreferences.edit();
        edit.putString(TEAM_NAME,team.getText().toString());
        edit.putInt(TEAM_COUNT,teamMembersCount);
        edit.putStringSet(MEMBERS,mMembers);
        edit.apply();
    }

    private void loadList() {
        mSharedPreferences= getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        Set<String> savedSet = mSharedPreferences.getStringSet(MEMBERS,null);
        String teamName = mSharedPreferences.getString(TEAM_NAME,null);
        if (savedSet != null && teamName != null){
            mMembers = savedSet;
            reloadNamesAndTeam(teamName, mMembers);
        }

    }

    private void reloadNamesAndTeam(String teamName, Set<String> mMembers) {
        for (String member : mMembers) {
            if (member != null && !member.isEmpty()) {
                //add to the editText
            }
        }
    }
}