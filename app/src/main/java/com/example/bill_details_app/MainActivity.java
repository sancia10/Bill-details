package com.example.bill_details_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MainActivity1 {
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button login_button  = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, profile.class));
            }});
}


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
           openprofile();
        }

    }
    public void openprofile() {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

}