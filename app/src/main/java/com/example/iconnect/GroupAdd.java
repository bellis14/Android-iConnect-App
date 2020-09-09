package com.example.iconnect;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/************************************************************
 * Class: GroupAdd
 * Function: Create new groups in the MainActivity.java class
 * The group add class does not have the functionality to add groups
 * within groups
 ************************************************************/
public class GroupAdd extends AppCompatActivity {
    DatabaseHelper myDB;
    Button finishButton, add2GroupButton;
    ImageButton back;
    EditText groupName;
    TextView name, GroupTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_add);
        GroupTextView = findViewById(R.id.GroupTextView);
        name = findViewById(R.id.groupNameTextView);
        groupName = findViewById(R.id.inputGroupNameText);
        back = findViewById(R.id.backButton);
        name.setText("Name:");
        GroupTextView.setText("Group");
        finishButton = findViewById(R.id.groupFinishButton);
        add2GroupButton = findViewById(R.id.addtoGroupButton);
        Intent mIntent = getIntent();
        final String previousActivity2 = mIntent.getStringExtra("FROM ACTIVITY");
        final String maxGroupTable = mIntent.getStringExtra("newGroup");
        final String tableNumber = mIntent.getStringExtra("tableNumber");
        myDB = new DatabaseHelper(this);

        // Check to see if the correct text field is filled and if it is then add the information
        // to the first database helper class and take the user to the main screen
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection newConnection = new Connection(groupName.getText().toString());

                if (TextUtils.isEmpty(groupName.getText().toString()))
                {
                    Toast.makeText(GroupAdd.this, "Enter Group Name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AddData(newConnection);
                    openMainActivity();
                }

            }
        });

        //Check if the text field is filled or not then take the user to the add person screen
        add2GroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection newConnection = new Connection(groupName.getText().toString());

                if (TextUtils.isEmpty(groupName.getText().toString()))
                {
                    openActivity_add_Person("0", previousActivity2, tableNumber);
                }
                else
                {
                    AddData(newConnection);
                    openActivity_add_Person(maxGroupTable, previousActivity2, tableNumber);
                }
            }
        });

        // Go to the previous screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_addNewConnection(previousActivity2, tableNumber, maxGroupTable);
            }
        });
    }

    // Add the information from the text field to the first database helper class
    public void AddData(Connection newConnection) {
        newConnection.setId("2");
        newConnection.setSubtitle("Group");
        myDB.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
    }

    // openMainActivity function takes the user to the MainActivity.java class while passing data to that class
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // openActivity_addNewConnection function takes the user to the AddNewConnection.java class while passing data to that class
    public void openActivity_addNewConnection(String previousActivity2, String tableNumber, String maxGroupTable) {
        Intent intent = new Intent(this, AddNewConnection.class);
        intent.putExtra("PREVIOUS", previousActivity2);
        intent.putExtra("tableNumber", tableNumber);
        intent.putExtra("newGroup", maxGroupTable);
        startActivity(intent);
    }

    // openActivity_add_Person function takes the user to the PersonAdd.java class while passing data to that class
    public void openActivity_add_Person(String maxGroupTable, String previousActivity2, String tableNumber) {
        Intent intent = new Intent(this, PersonAdd.class);
        intent.putExtra("newGroup", maxGroupTable);
        intent.putExtra("FROM ACTIVITY", previousActivity2);
        intent.putExtra("tableNumber", tableNumber);
        intent.putExtra("PATHWAY", "groupAddActivity");
        startActivity(intent);
    }

}
