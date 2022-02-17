package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchProductActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1,b2;
String getProductCode,getProductName,getSearchPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        ed1=(EditText) findViewById(R.id.productcode);
        ed2=(EditText) findViewById(R.id.productname);
        ed3=(EditText) findViewById(R.id.searchprice);
        b1=(AppCompatButton) findViewById(R.id.search);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProductCode=ed1.getText().toString();
                Toast.makeText(getApplicationContext(),getProductCode, Toast.LENGTH_LONG).show();
            }
        });
        b2=(AppCompatButton)findViewById(R.id.backtomenu);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}