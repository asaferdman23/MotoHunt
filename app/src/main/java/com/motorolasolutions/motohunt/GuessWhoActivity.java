package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

public class GuessWhoActivity extends BasicActivity implements ItemClickListener{

    RecyclerView mRecyclerView;
    List<QuestionData> mQuestionList;
    boolean[] answeredCorrectly = new boolean[16];
    Button finishBtn;
    MyAdapter myAdapter;
    private String[] ansArr;
    private String[] questionsArr;

    @Override
    protected void setNextTask() {
        nextTask = 0; // or 1, or 2...
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_who);
        finishBtn = findViewById(R.id.button_finish);
        ansArr = getResources().getStringArray(R.array.answer_list_guess_who);
        questionsArr = getResources().getStringArray(R.array.questions_list_guess_who);
        init();
    }

    @Override
    public void init() {
        super.init();

        mRecyclerView = findViewById(R.id.recyclerViewHome);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mQuestionList = new ArrayList<>();
        mQuestionList.add(new QuestionData("Q1", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q2", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q3", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q4", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q5", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q6", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q7", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q8", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q9", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q10", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q11", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q12", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q13", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q14", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q15", R.drawable.box_question));
        mQuestionList.add(new QuestionData("Q16", R.drawable.box_question));

        myAdapter = new MyAdapter(this, mQuestionList);
        myAdapter.setClickListener(this);
        mRecyclerView.setAdapter(myAdapter);

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAll())
                    endActivity();
                else {
                    TastyToast.makeText(getApplicationContext(), getResources().getString(R.string.didnt_finish),
                            TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            }
        });
    }

    private boolean checkAll() {
        for (boolean flag : answeredCorrectly) {
            if (!flag)
                return false;
        }
        return true;
    }

    @Override
    public void onClick(View view, int position) {
        showQuestion(position);
    }

    private void showQuestion(int position) {
        CustomDialog dialog = new CustomDialog();
        dialog.showDialog(this, questionsArr[position], position);
    }

    protected void checkAns(int index, String ans) {
        if (ans == null || ans.isEmpty() || !ansArr[index].equalsIgnoreCase(ans)){
            answeredCorrectly[index] = false;
            myAdapter.changePicByPos(R.drawable.box_x, index);
        } else {
            answeredCorrectly[index] = true;
            myAdapter.changePicByPos(R.drawable.box_v, index);
        }

    }


}
