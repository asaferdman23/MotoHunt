package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MissionFourClass extends BasicActivity {
    Button mFinishMissionFour;
    ListView listView;
    //ArrayAdapter<String> adapter;
    ArrayList<Answers> answersArrayList;
    Answers answers;
    RecyclerView.Adapter adapters;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    //ArrayList<EditTextAnswers> editTextAnswersArray;
    EditText edt;
    private static final String TAG = "MissionFourClass";


    @Override
    protected void setNextTask() {
        mNextTask = 4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mision_four_a);
        recyclerView = findViewById(R.id.my_recycler_view_expenses);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        answersArrayList = new ArrayList<>();



        adapters = new AnswersAdapter(answersArrayList);
        answersArrayList.add(new Answers(1, 1));
        answersArrayList.add(new Answers(2, 2));
        answersArrayList.add(new Answers(3, 3));
        answersArrayList.add(new Answers(4, 4));
        answersArrayList.add(new Answers(5, 5));
        answersArrayList.add(new Answers(6, 6));
        answersArrayList.add(new Answers(7, 7));
        answersArrayList.add(new Answers(8, 8));
        answersArrayList.add(new Answers(9, 9));
        answersArrayList.add(new Answers(10, 10));
        recyclerView.setAdapter(adapters);
        //adapters.notifyDataSetChanged();
        //listView = findViewById(R.id.list_view_data);
        //EditTextAnswersAdapter editTextAnswersAdapter = new EditTextAnswersAdapter(MissionFourClass.this, R.layout.listview_adapter, editTextAnswersArray);
        // AnswersAdapter answersAdapter = new AnswersAdapter(MissionFourClass.this, R.layout.listview_adapter, answersArrayList);

        //listView.setAdapter(editTextAnswersAdapter);

        // listView.getAdapter().toString().isEmpty();
        mFinishMissionFour = findViewById(R.id.finishbutton_mission_four);
        mFinishMissionFour.setOnClickListener(view -> {

        });
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG, "onClick mission 4 edittext: ");
//                for (int i = 0; i <= listView.getCount(); i++) {
//                    int edit = Integer.parseInt(editTextAnswersAdapter.getView(i, view, listView).toString());
//                    String haim = String.valueOf(edit);
//                    if (haim.isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Maniac", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                }
//                //if (edot.isEmpty())
//                //  Toast.makeText(getApplicationContext(), "Maniac", Toast.LENGTH_SHORT).show();
//            }
//        });
//        init();
    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id =item.getItemId();
//        if(id==R.id.item_done){
//            StringBuilder itemSelected = new StringBuilder("good");
//                    for (int i=0;i<listView.getCount();i++){
//                        if (listView.isItemChecked(i)){
//                            itemSelected.append(listView.getItemAtPosition(i)).append("/n");
//                        }
//                    }
//            Toast.makeText(this, itemSelected.toString(),Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.mission_four_list,menu);
//        return true;
//    }


    public void init() {
        super.init();
    }
}
