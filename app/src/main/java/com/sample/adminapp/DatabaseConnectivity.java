package com.sample.adminapp;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseConnectivity {

    // Realtime Firebase Connectivity
    public DatabaseReference getDatabasePath(Context context) {
        DatabaseReference databaseReferencePath = FirebaseDatabase.getInstance().getReference();
        Log.d("TAG", "getDatabasePath: "+databaseReferencePath);
        return databaseReferencePath;
    }
}
