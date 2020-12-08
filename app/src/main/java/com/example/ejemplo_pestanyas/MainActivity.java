package com.example.ejemplo_pestanyas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.menu_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment f = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                f = new HomeFragment();
                break;
            case R.id.navigation_dashboard:
                f = new DashboradFragment();
                break;
        }
        if (f != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, f).commit();

        }

        return true;
    }
}