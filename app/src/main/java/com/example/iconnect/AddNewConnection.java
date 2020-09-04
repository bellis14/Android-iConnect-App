package com.example.iconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewConnection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_connection);
        TextView connectionAddTextView = (TextView) findViewById(R.id.connectionAddTextView);
        Button addGroup = (Button) findViewById(R.id.addGroup);
        Button addPerson = (Button) findViewById(R.id.addPerson);
        ImageButton back = (ImageButton) findViewById(R.id.backButton);
        Intent mIntent = getIntent();
        final String previousActivity = mIntent.getStringExtra("PREVIOUS");
        final String index = mIntent.getStringExtra("tableNumber");
        final String maxGroupTable = mIntent.getStringExtra("newGroup");

        // Take the user to the add new group screen
        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_add_new_Group(previousActivity, maxGroupTable, index);
            }
        });

        // Take the user to the add new person screen
        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_add_new_Person(previousActivity, index, "0");
            }
        });

        // Go to the previous screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

    // openActivity_add_new_Group function takes the user to the GroupAdd.java class while passing data to that class
    public void openActivity_add_new_Group(String previousActivity, String maxGroupTable, String index) {
        Intent intent = new Intent(this, GroupAdd.class);
        intent.putExtra("FROM ACTIVITY", previousActivity);
        intent.putExtra("tableNumber", index);
        intent.putExtra("newGroup", maxGroupTable);
        startActivity(intent);
    }

    // openActivity_add_new_Person function takes the user to the PersonAdd.java class while passing data to that class
    public void openActivity_add_new_Person(String previousActivity, String index, String maxGroupTable) {
        Intent intent = new Intent(this, PersonAdd.class);
        intent.putExtra("FROM ACTIVITY", previousActivity);
        intent.putExtra("PATHWAY", "addNewConnectionActivity");
        intent.putExtra("tableNumber", index);
        intent.putExtra("newGroup", maxGroupTable);
        startActivity(intent);
    }

    // openMainActivity function takes the user to the MainActivity.java class while passing data to that class
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}