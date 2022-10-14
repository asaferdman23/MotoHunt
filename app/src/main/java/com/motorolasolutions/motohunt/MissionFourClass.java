package com.motorolasolutions.motohunt;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MissionFourClass extends BasicActivity {
    Button mFinishMissionFour;
    ListView listView;
    ArrayAdapter<String> adapter;
    //View[] editTexts = new View[10];
    String[] array ={"asaf","haim"};

    @Override
    protected void setNextTask() {
        mNextTask = 4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mision_four_a);
        Log.i("asaf", "onCreate: ");
        Log.i("asaf", "init init before set ADAPTER: ");
        //editTexts = findViewById(R.id.mission_four_input1a);
        listView = findViewById(R.id.list_view_data);
        adapter = new ArrayAdapter<String>(MissionFourClass.this, android.R.layout.simple_list_item_multiple_choice,array);
        listView.setAdapter(adapter);
        Log.i("asaf", "init init AFTER set ADAPTER: ");
        //mFinishMissionFour = findViewById(R.id.finish_mission_four);
//        init();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        if(id==R.id.item_done){
            StringBuilder itemSelected = new StringBuilder("good");
                    for (int i=0;i<listView.getCount();i++){
                        if (listView.isItemChecked(i)){
                            itemSelected.append(listView.getItemAtPosition(i)).append("/n");
                        }
                    }
            Toast.makeText(this, itemSelected.toString(),Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mission_four_list,menu);
        return true;
    }


    public void init() {
        super.init();
    }
}
