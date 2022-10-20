package com.motorolasolutions.motohunt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;

import com.sdsmdg.tastytoast.TastyToast;

public class MissionSixClass extends BasicActivity{
    Button finishButton;
    private EditText editTextAns;

    @Override
    protected void setNextTask() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mission_six);
        init();
    }

    public void init() {
        super.init();
        finishButton = findViewById(R.id.finish_mission_six_button);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditText();
            }
        });
    }

    public void showEditText(){
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        LayoutInflater inflater = this.getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_layout,null);
        TextView question = view.findViewById(R.id.question_dialog);
        question.setText("What is the code you got from Dor Perets (050-9628408) ?");
        builder.setView(view);
        builder.setNegativeButton(R.string.cancel_dialog_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton(R.string.continue_dialog_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String answer = editTextAns.getText().toString();
                if (answer.equals("628")){
                    final Runnable mNextTaskRunnable = () -> {
                        Intent intent = new Intent(getApplicationContext(),RiddleSeven.class);
                        startActivity(intent);
                    };
                    mHandler.postDelayed(mNextTaskRunnable, 2500);
                    TastyToast.makeText(getApplicationContext(),"Good Job! now Riddle!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                } else {
                    isFinishedTask = false;
                    saveFinishedTask();
                    TastyToast.makeText(MissionSixClass.this, getResources().getString(R.string.try_again), TastyToast.LENGTH_LONG,TastyToast.ERROR).show();
                    return;
                }
            }
        });
        editTextAns = (EditText) view.findViewById(R.id.answer_dialog);
        editTextAns.setInputType(InputType.TYPE_CLASS_NUMBER);
        AlertDialog dialog2 = builder.create();
        dialog2.show();

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onKeyDown(int key_code, KeyEvent key_event) {
        if (key_code== KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(key_code, key_event);
            return true;
        }
        return false;
    }

}
