package com.example.bill_details_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {
   private Button enter_previous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        enter_previous = (Button) findViewById(R.id.enter_previous);
       enter_previous.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openenterprevious() ;
           }
       });
    }
    public  void openenterprevious() {
    Intent intent = new Intent(this, enter_previous.class);
    startActivity(intent) Inte
    }}