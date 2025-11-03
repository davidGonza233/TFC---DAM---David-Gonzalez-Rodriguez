package com.example.tfc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tfc.ui.login.LoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ajuste EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mostrar LoginFragment inicialmente
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.login_container, new LoginFragment())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.bottom_navigation, new LoginFragment())
                    .commit();
        }

        // Configurar listener del BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_search) {
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_profile) {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_setting) {
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
                // Abrir SettingsActivity
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
            }

            return true;
        });
    }
}
