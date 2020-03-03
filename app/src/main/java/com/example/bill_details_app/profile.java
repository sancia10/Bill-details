package com.example.bill_details_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class profile extends AppCompatActivity {
    TextView Name, Address, phone;

    Button enter_previous;
    DatabaseReference reff;
    Member classprofile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        enter_previous = (Button) findViewById(R.id.enter_previous);
        Address = (TextView) findViewById(R.id.Address) ;
        phone = (TextView) findViewById(R.id.phone);
        Name=(TextView) findViewById(R.id.Name);

        enter_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendetails_user();

            }
        });
        enter_previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Long phone=Long.parseLong(enter_previous.getText().toString().trim());
//                classprofile.getName(Name.getText().toString().trim());
//                classprofile.getName(Name);
//                reff.child(String.valueOf(DatabaseReference))
            }
        });

       reff = FirebaseDatabase.getInstance().getReference().child("Member");
        classprofile=new Member() {
            @NonNull
            @Override
            public Class<?> getDeclaringClass() {
                return null;
            }

            @NonNull
            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getModifiers() {
                return 0;
            }

            @Override
            public boolean isSynthetic() {
                return false;
            }
        };
    }

    public  void opendetails_user() {
        Intent intent = new Intent(this, details_user.class);
        startActivity(intent);

    }
}