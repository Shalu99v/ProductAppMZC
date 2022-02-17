package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1,b2;
String getProCode,getProName,getPrice;
Databasehelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        dbhelper=new Databasehelper(this);
        dbhelper.getWritableDatabase();

        ed1=(EditText) findViewById(R.id.procode);
        ed2=(EditText) findViewById(R.id.proname);
        ed3=(EditText) findViewById(R.id.addprice);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.backtomenu);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProCode=ed1.getText().toString();
                getProName=ed2.getText().toString();
                getPrice=ed3.getText().toString();
                Toast.makeText(getApplicationContext(),getProCode, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getProName,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getPrice,Toast.LENGTH_LONG).show();

                boolean result=dbhelper.InsertData(getProCode,getProName,getPrice);
                if (result==true)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");

                    Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed to insert",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}