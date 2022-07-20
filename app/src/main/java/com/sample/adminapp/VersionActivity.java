package com.sample.adminapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

public class VersionActivity extends AppCompatActivity {
    TextView backPress;
    SharedPreferences sharedPreferences;
    SharedPrefManager sharedPrefManager;
    FirebaseDatabase firebaseDatabase;
    DatabaseConnectivity databaseConnectivity = new DatabaseConnectivity();
    TextView changeVersionBtn;
    EditText appVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        FirebaseApp.initializeApp(this);
        backPress = findViewById(R.id.backPress);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        sharedPreferences = getSharedPreferences("path", MODE_PRIVATE);

        appVersion = findViewById(R.id.appVersion);
        changeVersionBtn = findViewById(R.id.changeVersionBtn);

        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        setVersion();
        changeVersion();
    }

    private void setVersion() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseConnectivity.getDatabasePath(this).child("VersionNameYoYoIq").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot != null) {
                    String versionName = String.valueOf(snapshot.getValue());
                    appVersion.setText(versionName);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }

    private void changeVersion() {
    }
}