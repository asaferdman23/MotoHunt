package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MissionFourClass extends BasicActivity {
    Button mFinishMissionFour;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<Answers> answersArrayList;



    @Override
    protected void setNextTask() {
        mNextTask = 4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mision_four_a);
        answersArrayList = new ArrayList<>();
        answersArrayList.add(new Answers(1,1));
        answersArrayList.add(new Answers(2,2));
        answersArrayList.add(new Answers(3,3));
        answersArrayList.add(new Answers(4,4));
        answersArrayList.add(new Answers(5,5));
        answersArrayList.add(new Answers(6,6));
        answersArrayList.add(new Answers(7,7));
        answersArrayList.add(new Answers(8,8));
        answersArrayList.add(new Answers(9,9));
        answersArrayList.add(new Answers(10,10));

        listView = findViewById(R.id.list_view_data);
        AnswersAdapter answersAdapter =new AnswersAdapter(MissionFourClass.this,R.layout.listview_adapter,answersArrayList);
        listView.setAdapter(answersAdapter);

        //mFinishMissionFour = findViewById(R.id.finish_mission_four);
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
