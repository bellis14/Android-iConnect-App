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
import java.util.Date;

/*************************************************************
 * Class: Person Add
 * Function: Add new connections to either the Group.java or
 * MainActivity.java class
 *************************************************************/
public class PersonAdd extends AppCompatActivity {
    DatabaseHelper myDB;
    DatabaseHelper1 myDB1;
    DatabaseHelper2 myDB2;
    DatabaseHelper3 myDB3;
    DatabaseHelper4 myDB4;
    DatabaseHelper5 myDB5;
    DatabaseHelper6 myDB6;
    DatabaseHelper7 myDB7;
    DatabaseHelper8 myDB8;
    DatabaseHelper9 myDB9;
    DatabaseHelper10 myDB10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_add);
        TextView PersonTextView = findViewById(R.id.PersonTextView);
        Button finishButton = findViewById(R.id.personFinishButton);
        Button add2GroupButton = findViewById(R.id.addtoGroupButton);
        ImageButton back = findViewById(R.id.backButton);
        final EditText name = findViewById(R.id.inputPersonNameText);
        final EditText subtitle = findViewById(R.id.inputSubtitleText);
        final EditText frequency = findViewById(R.id.inputContactFrequencyText);
        final EditText note = findViewById(R.id.inputNoteText);
        Intent mIntent = getIntent();
        final String pathway = mIntent.getStringExtra("PATHWAY");
        final String previousActivity = mIntent.getStringExtra("FROM ACTIVITY");
        final String tableNumber = mIntent.getStringExtra("tableNumber");
        final String maxGroupTable = mIntent.getStringExtra("newGroup");
        final String groupName = mIntent.getStringExtra("groupName");

        myDB = new DatabaseHelper(this);
        myDB1 = new DatabaseHelper1(this);
        myDB2 = new DatabaseHelper2(this);
        myDB3 = new DatabaseHelper3(this);
        myDB4 = new DatabaseHelper4(this);
        myDB5 = new DatabaseHelper5(this);
        myDB6 = new DatabaseHelper6(this);
        myDB7 = new DatabaseHelper7(this);
        myDB8 = new DatabaseHelper8(this);
        myDB9 = new DatabaseHelper9(this);
        myDB10 = new DatabaseHelper10(this);


        // Check to see if the correct text fields are filled and if they are then add the information
        // to the correct database helper class and take the user to either the group or main screen
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection newConnection = new Connection(name.getText().toString(), "1", subtitle.getText().toString(),
                        frequency.getText().toString(), note.getText().toString());
                Date date = new Date();
                newConnection.setSetCount(Integer.toString((int) (date.getTime() / 86400000)));

                if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(frequency.getText().toString()) ||
                        TextUtils.isEmpty(subtitle.getText().toString()))
                {
                    Toast.makeText(PersonAdd.this, "Fill Name, Frequency, and Subtitle", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AddData(newConnection, maxGroupTable);
                    if (previousActivity.equals("Group")) {
                        openActivity_group(maxGroupTable, groupName);
                    }
                    else {
                        openMainActivity();
                    }
                }
            }
        });

        // Check to see if the correct text fields are filled and if they are then add the information
        // to the correct database helper class and clear the current contents of the text fields so
        // an additional person can be created
        add2GroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection newConnection = new Connection(name.getText().toString(), "1", subtitle.getText().toString(),
                        frequency.getText().toString(), note.getText().toString());
                Date date = new Date();
                newConnection.setSetCount(Integer.toString((int) (date.getTime() / 86400000)));

                if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(frequency.getText().toString()) ||
                        TextUtils.isEmpty(subtitle.getText().toString()))
                {
                    Toast.makeText(PersonAdd.this, "Fill Name, Frequency, and Subtitle", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AddData(newConnection, maxGroupTable);
                }
                name.setText("");
                subtitle.setText("");
                frequency.setText("");
                note.setText("");
            }
        });

        // Go back to the previous screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pathway.equals("groupActivity")) {
                    openActivity_group(maxGroupTable, groupName);
                }
                else if (pathway.equals("addNewConnectionActivity")) {
                    openActivity_addNewConnection(previousActivity, tableNumber, maxGroupTable);
                }
                else if (pathway.equals("groupAddActivity")) {
                    openActivity_add_new_Group(previousActivity, tableNumber, maxGroupTable);
                }
            }
        });
    }

    //The AddData function uses the maxGrouptable variable to decide what database helper class to save the newly created
    //person to
    public void AddData(Connection newConnection, String maxGroupTable) {
        switch (maxGroupTable) {
            case "0":
                myDB.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "1":
                myDB1.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "2":
                myDB2.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "3":
                myDB3.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "4":
                myDB4.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "5":
                myDB5.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "6":
                myDB6.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "7":
                myDB7.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "8":
                myDB8.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "9":
                myDB9.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
            case "10":
                myDB10.addData(newConnection.getName(), newConnection.getId(), newConnection.getSubtitle(),
                        newConnection.getFrequency(), newConnection.getNote(), newConnection.getSetCount());
                break;
        }

    }

    // openMainActivity function takes the user to the MainActivity.java class while passing data to that class
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // openActivity_add_new_Group function takes the user to the GroupAdd.java class while passing data to that class
    public void openActivity_add_new_Group(String previousActivity, String tableNumber, String maxGroupTable) {
        Intent intent = new Intent(this, GroupAdd.class);
        intent.putExtra("FROM_ACTIVITY", previousActivity);
        intent.putExtra("newGroup", maxGroupTable);
        intent.putExtra("tableNumber", tableNumber);
        startActivity(intent);
    }

    // openActivity_addNewConnection function takes the user to the AddNewConnection.java class while passing data to that class
    public void openActivity_addNewConnection(String previousActivity, String tableNumber, String maxGroupTable) {
        Intent intent = new Intent(this, AddNewConnection.class);
        intent.putExtra("newGroup", maxGroupTable);
        intent.putExtra("tableNumber", tableNumber);
        intent.putExtra("PREVIOUS", previousActivity);
        startActivity(intent);
    }

    // openActivity_group function takes the user to the Group.java class while passing data to that class
    public void openActivity_group(String maxGroupTable, String groupName) {
        Intent intent = new Intent(this, Group.class);
        intent.putExtra("groupName", groupName);
        intent.putExtra("tableNumber", maxGroupTable);
        startActivity(intent);
    }

}