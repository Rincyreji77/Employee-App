package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getEmployeecode,getName,getDesignation,getMobileno;

Dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        ed1=(EditText)findViewById(R.id.emplycode);
        ed2=(EditText)findViewById(R.id.name);
        ed3=(EditText)findViewById(R.id.degnt);
        ed4=(EditText)findViewById(R.id.mob);
        b1=(AppCompatButton)findViewById(R.id.sub);

        mydb=new Dbhelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmployeecode=ed1.getText().toString();
                getName=ed2.getText().toString();
                getDesignation=ed3.getText().toString();
                getMobileno=ed4.getText().toString();

                boolean status=mydb.insertEmployee(getEmployeecode,getName,getDesignation,getMobileno);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"Successfully Inserted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Something Error",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}