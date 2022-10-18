package com.motorolasolutions.motohunt;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.MyViewHolder> {
    View rootView;
    Context mContext;
    EditText editText;
    CheckBox checkBox;
    Button checkAnswerButton;
    String writtenAnswer;
    boolean isTextChanges = false;

    private ArrayList<Answers> answersEditText;

    ArrayList<String> answersArrayContent = new ArrayList<String>();

    public AnswersAdapter(ArrayList<Answers> answersEditText) {
        this.answersEditText = answersEditText;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        EditText editText;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.mission_four_input1a);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_adapter, parent, false);
        mContext = parent.getContext();
        rootView = ((Activity) mContext).getWindow().getDecorView().findViewById(android.R.id.content);
        checkAnswerButton = rootView.findViewById(R.id.finishbutton_mission_four);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        EditText editText = holder.editText;
        CheckBox checkBox = holder.checkBox;
        int idForEditTexts = answersEditText.get(position).getEditText();
        Log.i("asaf", "idForEditTexts size is = : " + idForEditTexts);
        int idForCheckboxes = answersEditText.get(position).getCheckBox();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isTextChanges = true;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                writtenAnswer = editable.toString();
                if (isTextChanges) {
                    isTextChanges = false;
                }
                for (int i=0;i<=idForEditTexts;i++){
                    answersArrayContent.set(idForEditTexts,writtenAnswer);
                }

            }
        });

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> mAnswersListContent = new ArrayList<>();
                if (!answersArrayContent.isEmpty()) {
                    for (int i=0;i<=answersArrayContent.size();i++){
                        if (!answersArrayContent.get(i).isEmpty()){
                            mAnswersListContent.add(answersArrayContent.get(i));
                        } else {
                            return;
                        }
                    }
                    //answersArrayContent.set(idForEditTexts, writtenAnswer);
                    Log.i("asaf", "checkAnswerButton: " + answersArrayContent);
                } else {
                    Toast.makeText(mContext.getApplicationContext(), "vfdfgfng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return answersEditText.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    //    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        EditText editText = holder.editText;
//        CheckBox
//
//
//    }
}
