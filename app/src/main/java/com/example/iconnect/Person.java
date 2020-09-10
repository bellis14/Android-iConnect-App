package com.example.iconnect;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Date;

/*************************************************************
 * Class: Person
 * Function: Display the information regarding the person selected
 * in the Group.java or MainActivity.java classes
 *************************************************************/
public class Person extends AppCompatActivity {
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
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        TextView pName = (TextView) findViewById(R.id.personTxtView);
        TextView contactDays = findViewById(R.id.daysTextView);
        TextView todayTextView = findViewById(R.id.todayTextView);
        Button connected = findViewById(R.id.connectedButton);
        Button dismiss = findViewById(R.id.dismissButton);
        ImageButton back = findViewById(R.id.backButton);
        TextView noteTv = findViewById(R.id.noteTextView);
        TextView daysToConnectTextView = findViewById(R.id.daysReminderTextView);
        Intent mIntent = getIntent();
        String daysLocation = mIntent.getStringExtra("LOCATION");
        final int location = Integer.parseInt(daysLocation);
        final String table = mIntent.getStringExtra("TABLE");
        final String grpName = mIntent.getStringExtra("groupName");
        final String lastActivity = mIntent.getStringExtra("LAST_ACTIVITY");
        selectedID = mIntent.getIntExtra("ID", -1);

        myDB = new DatabaseHelper(this);    //CLEAN: Find a way to use just one database class and not 11
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
        final ArrayList<Connection> connectionList = new ArrayList<>();

        // Read in the contents from the correct database helper class using the table variable
        // and add the data to the custom array list
        switch (table) {
            case "1":
                Cursor data1 = myDB1.getListContents();
                while(data1.moveToNext()){
                    Connection connection = new Connection(data1.getString(1), data1.getString(2), data1.getString(3), data1.getString(4),
                            data1.getString(5), data1.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "2":
                Cursor data2 = myDB2.getListContents();
                while(data2.moveToNext()){
                    Connection connection = new Connection(data2.getString(1), data2.getString(2), data2.getString(3), data2.getString(4),
                            data2.getString(5), data2.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "3":
                Cursor data3 = myDB3.getListContents();
                while(data3.moveToNext()){
                    Connection connection = new Connection(data3.getString(1), data3.getString(2), data3.getString(3), data3.getString(4),
                            data3.getString(5), data3.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "4":
                Cursor data4 = myDB4.getListContents();
                while(data4.moveToNext()){
                    Connection connection = new Connection(data4.getString(1), data4.getString(2), data4.getString(3), data4.getString(4),
                            data4.getString(5), data4.getString(6));
                    connectionList.add(connection);
                }
                break;

            case "5":
                Cursor data5 = myDB5.getListContents();
                while(data5.moveToNext()){
                    Connection connection = new Connection(data5.getString(1), data5.getString(2), data5.getString(3), data5.getString(4),
                            data5.getString(5), data5.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "6":
                Cursor data6 = myDB6.getListContents();
                while(data6.moveToNext()){
                    Connection connection = new Connection(data6.getString(1), data6.getString(2), data6.getString(3), data6.getString(4),
                            data6.getString(5), data6.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "7":
                Cursor data7 = myDB7.getListContents();
                while(data7.moveToNext()){
                    Connection connection = new Connection(data7.getString(1), data7.getString(2), data7.getString(3), data7.getString(4),
                            data7.getString(5), data7.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "8":
                Cursor data8 = myDB8.getListContents();
                while(data8.moveToNext()){
                    Connection connection = new Connection(data8.getString(1), data8.getString(2), data8.getString(3), data8.getString(4),
                            data8.getString(5), data8.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "9":
                Cursor data9 = myDB9.getListContents();
                while(data9.moveToNext()){
                    Connection connection = new Connection(data9.getString(1), data9.getString(2), data9.getString(3), data9.getString(4),
                            data9.getString(5), data9.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "10":
                Cursor data10 = myDB10.getListContents();
                while(data10.moveToNext()){
                    Connection connection = new Connection(data10.getString(1), data10.getString(2), data10.getString(3), data10.getString(4),
                            data10.getString(5), data10.getString(6));
                    connectionList.add(connection);
                }
                break;
            case "0":
                Cursor data = myDB.getListContents();
                while(data.moveToNext()){
                    Connection connection = new Connection(data.getString(1), data.getString(2), data.getString(3), data.getString(4),
                            data.getString(5), data.getString(6));
                    connectionList.add(connection);
                }
                break;
        }


        // Format the information correctly
        pName.setText(connectionList.get(location).getName());
        Date date = new Date();
        final int difference = Integer.parseInt(connectionList.get(location).getFrequency()) -
                (int) ((date.getTime() / 86400000) - Long.parseLong(connectionList.get(location).getSetCount()));

        if (difference <= 0) {
            contactDays.setText("");
            todayTextView.setText("Today");
            daysToConnectTextView.setText("to connect");
        }
        else if (difference == 1) {
            contactDays.setText(Integer.toString(difference));
            daysToConnectTextView.setText("day to connect");
        }
        else {
            contactDays.setText(Integer.toString(difference));
            daysToConnectTextView.setText("days to connect");
        }


        if(connectionList.get(location).getNote().equals("")) {
            noteTv.setText("");
        }
        else {
            noteTv.setText("Note: " + connectionList.get(location).getNote());
        }


        //when the connect button is pressed, reset the setCount variable for specified item in the correct database helper class
        connected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date = new Date();
                switch (table) {
                    case "0":
                        //18509
                        myDB.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "1":
                        myDB1.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "2":
                        myDB2.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "3":
                        myDB3.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "4":
                        myDB4.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "5":
                        myDB5.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "6":
                        myDB6.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "7":
                        myDB7.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "8":
                        myDB8.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "9":
                        myDB9.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                    case "10":
                        myDB10.updateDays(connectionList.get(location).getName(), connectionList.get(location).getId(), connectionList.get(location).getSubtitle(),
                                connectionList.get(location).getFrequency(), connectionList.get(location).getNote(), Integer.toString((int) (date.getTime() / 86400000)),
                                selectedID, connectionList.get(location).getSetCount());
                        break;
                }
                // Take the user back to the previous screen
                if (lastActivity.equals("group")) {
                    openActivity_group(grpName, table);
                }
                else {
                    openActivity_main();
                }
            }
        });

        //When the dismiss button is selected take the user to either the group or main screen
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastActivity.equals("group")) {
                    openActivity_group(grpName, table);
                }
                else {
                    openActivity_main();
                }
            }
        });

        // When the back button is selected take the user to either the group or main screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastActivity.equals("group")) {
                    openActivity_group(grpName, table);
                }
                else {
                    openActivity_main();
                }
            }
        });
    }

    // openActivity_main function takes the user to the MainActivity.java class while passing data to that class
    public void openActivity_main() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // openActivity_group function takes the user to the Group.java class while passing data to that class
    public void openActivity_group(String grpName, String table) {
        Intent intent = new Intent(this, Group.class);
        intent.putExtra("groupName", grpName);
        intent.putExtra("tableNumber", table);
        startActivity(intent);
    }
}