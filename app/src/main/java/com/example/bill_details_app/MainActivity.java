package com.example.bill_details_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static String TAG = "test";
    private Button login_button;
    private EditText uid;
    private EditText pwd;

    void test( String name,  String add, String phone, String userid, String pasword) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("add", add);
        user.put("phone",phone);
        user.put("userid",userid);
        user.put("password",pasword);
        //+++++++user.put("phone", phone);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.e(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Error adding document", e);
                    }
                });

        // Create a reference to the cities collection
        CollectionReference users = db.collection("users");
        // Create a query against the collection.
        Query query = users.whereEqualTo("userid", "jaison10");




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access a Cloud Firestore instance from your Activity

        test("Sancia", "Manglore", "9963029323", "sancia10", "sancia4ever");

        test("Jaison", "Manglore", "9497886214", "jaison10", "jaison4ever");

        login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.login_button) {
                    openprofile();
                }
            }
        });

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient GoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);



    }

    private void updateUI(GoogleSignInAccount account) {
        Log.d("The result is", String.valueOf(account));
    }


    public void openprofile() {
        EditText uid=findViewById(R. id. username);
        EditText pwd=findViewById(R. id. password);
        String uidvalue=uid.getText().toString();
        String pwdvalue =pwd.getText().toString();

        Intent intent = new Intent(this, profile.class);



        try {
            Bundle bundle = new Bundle();

//Add your data to bundle
            bundle.putString("USERNAME", uidvalue);
            bundle.putString("PASSWORD", pwdvalue);
//Add the bundle to the intent
            intent.putExtras(bundle);
        }
        catch (Exception e){
            Log.d("Exception:", "Ëxception need to be handled");
        }
        startActivity(intent);
    }

}