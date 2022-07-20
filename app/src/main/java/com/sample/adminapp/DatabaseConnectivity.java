package com.sample.adminapp;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseConnectivity {

    // Realtime Firebase Connectivity
    public DatabaseReference getDatabasePath(Context context) {
        DatabaseReference databaseReferencePath = FirebaseDatabase.getInstance().getReference();
        return databaseReferencePath;
    }
}
