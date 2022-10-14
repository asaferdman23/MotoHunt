package com.motorolasolutions.motohunt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AnswersAdapter extends ArrayAdapter<Answers> {
    private Context mContext;
    private int mResource;

    public AnswersAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public AnswersAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public AnswersAdapter(@NonNull Context context, int resource, @NonNull Answers[] objects) {
        super(context, resource, objects);
    }

    public AnswersAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Answers[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public AnswersAdapter(@NonNull Context context, int resource, @NonNull List<Answers> objects) {
        super(context, resource, objects);

        this.mContext=context;
        this.mResource =resource;
    }

    public AnswersAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Answers> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(mContext);
        convertView=layoutInflater.inflate(mResource,parent,false);
        EditText editText  = convertView.findViewById(R.id.mission_four_input1a);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);
        editText.setId(getItem(position).getEditText());
        checkBox.setId(getItem(position).getCheckBox());
        return convertView;

    }
}
