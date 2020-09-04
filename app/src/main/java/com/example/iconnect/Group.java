package com.example.iconnect;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Group extends AppCompatActivity {
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
    ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        TextView gName = findViewById(R.id.newGroup);
        FloatingActionButton addButton = findViewById(R.id.addButton);
        ImageButton back = findViewById(R.id.backButton);
        Intent mIntent = getIntent();
        final String grpName = mIntent.getStringExtra("groupName");
        final String table = mIntent.getStringExtra("tableNumber");
        gName.setText(grpName);

        // 11 database helper classes that we can save data to. This could be more efficient
        // by creating different tables perhaps or different files within the same database
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

        // List view to display all the information from the correct database helper class
        listView2 = findViewById(R.id.listview2);
        // Custom array list to contain all the information read in from the database helper class
        final ArrayList<Connection> connectionList = new ArrayList<>();

        // This switch statement helps determine which database helper class needs to be read
        // so the correct information is displayed in the listview
        switch (table) {
            case "1":
                // Get the contents of the correct database helper class
                Cursor data1 = myDB1.getListContents();
                if(data1.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    // Fill the custom array list with the data from the database helper
                    while(data1.moveToNext()){
                        Connection connection = new Connection(data1.getString(1), data1.getString(2), data1.getString(3),
                                data1.getString(4), data1.getString(5), data1.getString(6));
                        connectionList.add(connection);
                        // Plug the custom array list into a custom list adapter to be formatted correctly in the display screen
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            // Repeat the same steps but for a different database helper on each case statement
            case "2":
                Cursor data2 = myDB2.getListContents();
                if(data2.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data2.moveToNext()){
                        Connection connection = new Connection(data2.getString(1), data2.getString(2), data2.getString(3),
                                data2.getString(4), data2.getString(5), data2.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "3":
                Cursor data3 = myDB3.getListContents();
                if(data3.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data3.moveToNext()){
                        Connection connection = new Connection(data3.getString(1), data3.getString(2), data3.getString(3),
                                data3.getString(4), data3.getString(5), data3.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "4":
                Cursor data4 = myDB4.getListContents();
                if(data4.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else {
                    while (data4.moveToNext()) {
                        Connection connection = new Connection(data4.getString(1), data4.getString(2), data4.getString(3),
                                data4.getString(4), data4.getString(5), data4.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;

            case "5":
                Cursor data5 = myDB5.getListContents();
                if(data5.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data5.moveToNext()){
                        Connection connection = new Connection(data5.getString(1), data5.getString(2), data5.getString(3),
                                data5.getString(4), data5.getString(5), data5.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "6":
                Cursor data6 = myDB6.getListContents();
                if(data6.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data6.moveToNext()){
                        Connection connection = new Connection(data6.getString(1), data6.getString(2), data6.getString(3),
                                data6.getString(4), data6.getString(5), data6.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "7":
                Cursor data7 = myDB7.getListContents();
                if(data7.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data7.moveToNext()){
                        Connection connection = new Connection(data7.getString(1), data7.getString(2), data7.getString(3),
                                data7.getString(4), data7.getString(5), data7.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "8":
                Cursor data8 = myDB8.getListContents();
                if(data8.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data8.moveToNext()){
                        Connection connection = new Connection(data8.getString(1), data8.getString(2), data8.getString(3),
                                data8.getString(4), data8.getString(5), data8.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "9":
                Cursor data9 = myDB9.getListContents();
                if(data9.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data9.moveToNext()){
                        Connection connection = new Connection(data9.getString(1), data9.getString(2), data9.getString(3),
                                data9.getString(4), data9.getString(5), data9.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
            case "10":
                Cursor data10 = myDB10.getListContents();
                if(data10.getCount() == 0){
                    Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
                }else{
                    while(data10.moveToNext()){
                        Connection connection = new Connection(data10.getString(1), data10.getString(2), data10.getString(3),
                                data10.getString(4), data10.getString(5), data10.getString(6));
                        connectionList.add(connection);
                        ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                        listView2.setAdapter(adapter);
                    }
                }
                break;
        }

        // When an item in the list view is selected, go to the screen where the person is viewed with their information
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openActivity_person(i, table, grpName);
            }
        });

        // When the add button is pressed go to the screen where you add a new person
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_add_new_Person(table, grpName);
            }
        });

        // When the back button is pressed go to the previous screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }

    // openActivity_add_new_Person function takes the user to the PersonAdd.java class while passing data to that class
    public void openActivity_add_new_Person(String table, String grpName) {
        Intent intent = new Intent(this, PersonAdd.class);
        intent.putExtra("FROM ACTIVITY", "Group");
        intent.putExtra("newGroup", table);
        intent.putExtra("groupName", grpName);
        intent.putExtra("PATHWAY", "groupActivity");
        startActivity(intent);
    }

    // openActivity_person function takes the user to the Person.java class while passing data to that class
    public void openActivity_person(int i, String table, String grpName) {
        Intent intent = new Intent(this, Person.class);
        intent.putExtra("personName", listView2.getItemAtPosition(i).toString());
        intent.putExtra("LOCATION", Integer.toString(i));
        intent.putExtra("groupName", grpName);
        intent.putExtra("TABLE", table);
        intent.putExtra("ID", i + 1);
        intent.putExtra("LAST_ACTIVITY", "group");
        startActivity(intent);
    }

    // openMainActivity function takes the user to the MainActivity.java class
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}