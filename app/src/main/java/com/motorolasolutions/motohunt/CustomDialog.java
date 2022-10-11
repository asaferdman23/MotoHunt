package com.motorolasolutions.motohunt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.view.ContextThemeWrapper;

import java.util.Objects;

public class CustomDialog extends AppCompatDialogFragment {

    private AutoCompleteTextView editTextAns;
    boolean firstTime = true;
    protected String[] optionsList;

    public void showDialog(Activity activity, String msg, int index){
        optionsList = activity.getResources().getStringArray(R.array.options_list);
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
        LayoutInflater inflater = activity.getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_layout,null);
        TextView question = view.findViewById(R.id.question_dialog);
        question.setText(msg);
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
                if (activity instanceof GuessWhoActivity){
                    ((GuessWhoActivity) activity).checkAns(index, answer);
                }
            }
        });
        editTextAns = (AutoCompleteTextView) view.findViewById(R.id.answer_dialog);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (activity, android.R.layout.select_dialog_item, optionsList);
        editTextAns.setThreshold(2);
        editTextAns.setAdapter(adapter);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
