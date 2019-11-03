package com.example.menufuns1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startEditItemActivity();
    }

    private void startEditItemActivity() {
        Intent intent = new Intent(this, EditItemActivity.class);
        startActivity(intent);
    }

    // we need to inflate our main_menu.xml


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // get a reference to the MenuInflater
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // override a callback that executes whenever an options menu action is clicked

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.addMenuItem:
                startEditItemActivity();
                return true; // we have consumed/handled this click event
            // task: finish remaining two cases
            case R.id.preferencesMenuItem:
                Toast.makeText(this, "TODO: show preferences", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aboutMenuItem:
                Toast.makeText(this, "TODO: show about app", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
