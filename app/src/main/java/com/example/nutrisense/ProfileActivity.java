package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String name = getSharedPreferences("NutriSense", MODE_PRIVATE)
                .getString("name", "Demo User");
        String email = getSharedPreferences("NutriSense", MODE_PRIVATE)
                .getString("email", "demo@nutrisense.com");

        ((TextView) findViewById(R.id.txtProfileName)).setText(name);
        ((TextView) findViewById(R.id.txtProfileEmail)).setText(email);

        findViewById(R.id.btnLogout).setOnClickListener(v -> {
            getSharedPreferences("NutriSense", MODE_PRIVATE).edit()
                    .putBoolean("loggedIn", false).apply();
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
