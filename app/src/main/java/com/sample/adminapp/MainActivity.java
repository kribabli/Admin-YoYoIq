package com.sample.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.NavigationView);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.defaultContest:
                Intent intent = new Intent(MainActivity.this, DefaultContest.class);
                startActivity(intent);
                break;
            case R.id.fixtureContest:
                Intent intent1 = new Intent(MainActivity.this, FixtureContest.class);
                startActivity(intent1);
                break;
            case R.id.leaderBoard:
                Intent intent2 = new Intent(MainActivity.this, LeaderBoard.class);
                startActivity(intent2);
                break;
            case R.id.kyc:
                Intent intent3 = new Intent(MainActivity.this, KYCActivity.class);
                startActivity(intent3);
                break;
            case R.id.banner:
                Intent intent4 = new Intent(MainActivity.this, BannerActivity.class);
                startActivity(intent4);
                break;
            case R.id.notification:
                Intent intent5 = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent5);
                break;
            case R.id.settings:
                Intent intent6 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent6);
                break;
            case R.id.changePass:
                Intent intent7 = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(intent7);
                break;
            case R.id.profile:
                Intent intent8 = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent8);
                break;
            case R.id.version:
                Intent intent9 = new Intent(MainActivity.this, VersionActivity.class);
                startActivity(intent9);
                break;
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}