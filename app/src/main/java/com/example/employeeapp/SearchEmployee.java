package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchEmployee extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getEmployeecode,getName,getDesignation,getMobile;
Dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);
        ed1=(EditText)findViewById(R.id.emplycd);
        ed2=(EditText)findViewById(R.id.nm);
        ed3=(EditText)findViewById(R.id.degntn);
        ed4=(EditText)findViewById(R.id.mobno);
        b1=(AppCompatButton)findViewById(R.id.srch);

        mydb=new Dbhelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmployeecode=ed1.getText().toString();
                Cursor c=mydb.SearchEmployee(getEmployeecode);
                if(c.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"Employee is not Found",Toast.LENGTH_LONG).show();
                }
                else {
                    while (c.moveToNext())
                    {
                        getName=c.getString(2);
                        getDesignation=c.getString(3);
                        getMobile=c.getString(4);
                    }
                    ed2.setText(getName);
                    ed3.setText(getDesignation);
                    ed4.setText(getMobile);
                }
            }
        });
    }
}