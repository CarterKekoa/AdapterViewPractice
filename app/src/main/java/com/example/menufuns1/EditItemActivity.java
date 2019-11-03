package com.example.menufuns1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_edit_item);
        //task: create a ListView
        ListView listView = new ListView(this);
        //set the content view to be the listview
        setContentView(listView);
        // no layout needed!
        //create a list of items (halloween strings)
        List<String> items = new ArrayList<>();
        items.add("Bats");
        items.add("Student debt");
        items.add("Midterms");

        //create an array adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, items);
        listView.setAdapter(arrayAdapter);
        //set the list view to support multiple selections
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);    //modal is a dialog you have to interact with
        //set the multi choice listener
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

        //make sure your items show up in the list view


        //add the up button (arrow) to go back to the previous activity
        //two options for what the "previous activity" can be
        //1) parent activity (defined in AndroidManifest.xml)
        //2) the activity under this one on the activity call stack
        // we will do 2) today
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home: //android defined id
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
