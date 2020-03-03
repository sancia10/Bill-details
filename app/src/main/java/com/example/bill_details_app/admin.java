package com.example.bill_details_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity implements View.OnClickListener{
    private Button button3;
    private Button buttonP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        button3 = (Button) findViewById(R.id.button3);
        buttonP = (Button) findViewById(R.id.buttonP);
        button3.setOnClickListener(this);
        buttonP.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button3) {
            openactivity_edit_profile();
        }

        if(view.getId() == R.id.buttonP)  {
            openEdit_previous_details();
        }


    }
    public void openactivity_edit_profile() {
        Intent intent = new Intent(this, Edit_profile.class );
        startActivity(intent);

    }
        public void openEdit_previous_details() {
        Intent intent = new Intent(this, Edit_previous_details.class );
        startActivity(intent);
        }
}
