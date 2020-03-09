package com.example.bill_details_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Member;
import java.util.Map;

public class profile extends AppCompatActivity {
    TextView Name, Address, phone;

    Button enter_previous;
    Bundle bundle ;//= getIntent().getExtras();

    //Extract the data…
    String username ;//= bundle.getString("USERNAME");
    String password ;//= bundle.getString("PASSWORD");

    private static final String TAG = "profile";


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //DocumentReference docRef = db.collection("users").document("sancia10");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bundle = getIntent().getExtras();
         username = bundle.getString("USERNAME");
         password = bundle.getString("PASSWORD");

         Log.e(TAG, "username is " + username);

        db.collection("users")
                .whereEqualTo("userid", "jaison10").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task){
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.e(TAG, document.getId() + " => " + document.getData());
                        Map<String, Object> data = document.getData();
                        Log.e(TAG, "" + data.get("add") + " " + data.get("phone"));
                        Log.e(TAG, "In profile page");
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

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


        }


    public  void opendetails_user() {
        Intent intent = new Intent(this, details_user.class);
        startActivity(intent);

    }
}