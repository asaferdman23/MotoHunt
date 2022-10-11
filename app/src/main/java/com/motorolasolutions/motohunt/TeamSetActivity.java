package com.motorolasolutions.motohunt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.HashSet;
import java.util.Set;

public class TeamSetActivity extends BasicActivity {
    private static final String MEMBERS = "TEAM_MEMBERS";
    private static final String TEAM_NAME = "TEAM";
    private static final String TEAM_COUNT = "TEAM_COUNT";
    AutoCompleteTextView mTeamMemberName1, mTeamMemberName2, mTeamMemberName3, mTeamMemberName4, mTeamMemberName5, mTeamMemberName6;
    EditText mTeam;
    int mTeamMembersCount;
    String mTeamName;
    Button button;
    SharedPreferences mSharedPreferences;
    Set<String> mMembers;
    protected String[] optionsList;

    @Override
    protected void setNextTask() {
        mNextTask = 1; // Hint
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_team);
        init();
    }

    @Override
    public void init() {
        super.init();
        mTeam = findViewById(R.id.team_name_input);
        optionsList = getResources().getStringArray(R.array.options_list);
        mTeamMemberName1 =(AutoCompleteTextView)findViewById(R.id.team_member_name1);
        mTeamMemberName2 = (AutoCompleteTextView)findViewById(R.id.team_member_name2);
        mTeamMemberName3 = (AutoCompleteTextView)findViewById(R.id.team_member_name3);
        mTeamMemberName4 = (AutoCompleteTextView)findViewById(R.id.team_member_name4);
        mTeamMemberName5 = (AutoCompleteTextView)findViewById(R.id.team_member_name5);
        mTeamMemberName6 = (AutoCompleteTextView)findViewById(R.id.team_member_name6);
        mMembers = new HashSet<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, optionsList);
        mTeamMemberName1.setThreshold(2);
        mTeamMemberName2.setThreshold(2);
        mTeamMemberName3.setThreshold(2);
        mTeamMemberName4.setThreshold(2);
        mTeamMemberName5.setThreshold(2);
        mTeamMemberName6.setThreshold(2);
        mTeamMemberName1.setAdapter(adapter);
        mTeamMemberName2.setAdapter(adapter);
        mTeamMemberName3.setAdapter(adapter);
        mTeamMemberName4.setAdapter(adapter);
        mTeamMemberName5.setAdapter(adapter);
        mTeamMemberName6.setAdapter(adapter);


        button = findViewById(R.id.set_your_team_button);
        button.setOnClickListener(view -> {
            mTeamName = mTeam.getText().toString();
            if (mTeamName.isEmpty()) {
                Toast.makeText(getApplicationContext(), "You can't leave this field empty", Toast.LENGTH_SHORT).show();
                return;
            }
            mTeamMembersCount = 0;
            check(mTeamMemberName1);
            check(mTeamMemberName2);
            check(mTeamMemberName3);
            check(mTeamMemberName4);
            check(mTeamMemberName5);
            check(mTeamMemberName6);
            if (mTeamMembersCount >= 4) {
                saveTeam();
                endActivity();
            } else {
                // some toast that say something doesnt make sense
                TastyToast.makeText(getApplicationContext(), getResources().getString(R.string.empty_field),
                        TastyToast.LENGTH_LONG, TastyToast.ERROR);
            }
        });
    }

    private void check(AutoCompleteTextView editName) {
        // if the editText is not good enough,show some toast.
        if (editName == null || editName.getText().toString().isEmpty()) {
            return;
        } else {
            String name = editName.getText().toString();
            mMembers.add(name);
            mTeamMembersCount++;
        }
    }

    private void saveTeam() {
        mSharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(TEAM_NAME, mTeam.getText().toString());
        edit.putInt(TEAM_COUNT, mTeamMembersCount);
        edit.putStringSet(MEMBERS, mMembers);
        edit.apply();
    }

    private void loadList() {
        mSharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        Set<String> savedSet = mSharedPreferences.getStringSet(MEMBERS, null);
        String teamName = mSharedPreferences.getString(TEAM_NAME, null);
        if (savedSet != null && teamName != null) {
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