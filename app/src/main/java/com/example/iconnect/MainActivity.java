package com.example.iconnect;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView connectionsTextView = (TextView) findViewById(R.id.connectionsTextView);
        connectionsTextView.setText("Connections");
        FloatingActionButton addConnectionButton = findViewById(R.id.addConnectionButton);
        listView = (ListView) findViewById(R.id.listview);
        myDB = new DatabaseHelper(this);

        int groupTable = 1;
        final ArrayList<Integer> groupNumber = new ArrayList<>();
        final ArrayList<Connection> connectionList = new ArrayList<>();

        // Get the contents of the first database helper class
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "Add your connections",Toast.LENGTH_LONG).show();
        }else{
            // Read the contents of the database into arraylists
            while(data.moveToNext()){
                Connection connection = new Connection(data.getString(1), data.getString(2), data.getString(3),
                        data.getString(4), data.getString(5), data.getString(6));
                connectionList.add(connection);
                // If an item from the database is a person add a 0 to the groupNumber array list
                // else just add the groupTable variable value to the groupNumber array list and increment
                // the groupTable variable by one. This if/else statement is used for identifying if
                // the user selected a person or a group so the right data can be passed to the correct activity
                if (data.getString(2).equals("1")) {
                    groupNumber.add(0);
                }
                else {
                    groupNumber.add(groupTable);
                    groupTable++;
                }

                // Plug the custom array list in the custom array adapter to format the information correctly for the user to see
                ConnectionListAdapter adapter = new ConnectionListAdapter(this, R.layout.adapter_view_layout, connectionList);
                listView.setAdapter(adapter);

            }
            
        }
        final int maxGroupTable = groupTable;
        // If a person is selected in the list view take the user to the screen where a person is viewed
        // If a group is selected in the list view take the user to the screen where a group is viewed
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (connectionList.get(i).getId().equals("2")) {
                    openActivity_group(i, groupNumber, connectionList);
                }
                else if (connectionList.get(i).getId().equals("1")) {
                    Cursor data = myDB.getItemID(connectionList.get(i).getName(), connectionList.get(i).getId(), connectionList.get(i).getSubtitle(),
                            connectionList.get(i).getFrequency(), connectionList.get(i).getNote(), connectionList.get(i).getSetCount());
                    int itemID = -1;
                    while(data.moveToNext()) {
                        itemID = data.getInt(0);
                    }
                    if (itemID > -1) {
                        openActivity_person(i, groupNumber, connectionList, itemID);
                    }
                }
            }
        });

        // Take the user to the screen where you add a new connection
        addConnectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_add_new_connection(maxGroupTable);
            }
        });

    }

    // openActivity_add_new_connection function takes the user to the AddNewConnection.java class while passing data to that class
    public void openActivity_add_new_connection(int maxGroupTable) {
        Intent intent = new Intent(this, AddNewConnection.class);
        intent.putExtra("PREVIOUS", "Main");
        intent.putExtra("tableNumber", "0");
        intent.putExtra("newGroup", Integer.toString(maxGroupTable));
        startActivity(intent);
    }

    // openActivity_group function takes the user to the Group.java class while passing data to that class
    public void openActivity_group(int i, ArrayList<Integer> groupNumber, ArrayList<Connection> connectionList) {
        Intent intent = new Intent(this, Group.class);
        //intent.putExtra("groupName", theList.get(i));
        intent.putExtra("groupName", connectionList.get(i).getName());
        intent.putExtra("tableNumber", Integer.toString(groupNumber.get(i)));
        startActivity(intent);
    }

    // openActivity_person function takes the user to the Person.java class while passing data to that class
    public void openActivity_person(int i, ArrayList<Integer> groupNumber, ArrayList<Connection> connectionList, int itemID) {
        Intent intent = new Intent(this, Person.class);
        //intent.putExtra("personName", theList.get(i));
        intent.putExtra("personName", connectionList.get(i).getName());
        intent.putExtra("LOCATION", Integer.toString(i));
        intent.putExtra("ID", itemID);
        intent.putExtra("TABLE", Integer.toString(groupNumber.get(i)));
        intent.putExtra("LAST_ACTIVITY", "main");
        startActivity(intent);
    }

}
