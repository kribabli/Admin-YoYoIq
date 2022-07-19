package com.sample.adminapp;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        backPress = findViewById(R.id.backPress);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        sharedPreferences = getSharedPreferences("path", MODE_PRIVATE);

        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        changeVersion();
    }

    private void changeVersion() {
        firebaseDatabase = FirebaseDatabase.getInstance();

        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
            Log.d("TAG", "ShowInfo: "
                    + "PackageName = " + info.packageName
                    + "\nVersionCode = " + info.versionCode
                    + "\nVersionName = " + info.versionName
                    + "\nPermissions = " + info.permissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

//        databaseConnectivity.getDatabasePath(this).child("VersionNameYoYoIq").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                Log.d("TAG", "onDataChange: " + snapshot);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//
//            }
//        });
    }
}