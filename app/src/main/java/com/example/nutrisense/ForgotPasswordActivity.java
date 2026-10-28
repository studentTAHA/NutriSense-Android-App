package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends Activity {
    private EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailInput = findViewById(R.id.inputRecoveryEmail);
        Button recover = findViewById(R.id.btnRecover);

        recover.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Enter a valid email address");
                emailInput.requestFocus();
                return;
            }

            String savedEmail = getSharedPreferences("NutriSense", MODE_PRIVATE)
                    .getString("email", "demo@nutrisense.com");
            if (!email.equalsIgnoreCase(savedEmail)) {
                Toast.makeText(this, "Email not found. Register or use your saved email.",
                        Toast.LENGTH_LONG).show();
                return;
            }

            getSharedPreferences("NutriSense", MODE_PRIVATE).edit()
                    .putString("recoveryEmail", email).apply();
            Toast.makeText(this, "Demo recovery accepted. You can set a new password now.",
                    Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, ResetPasswordActivity.class));
        });
    }
}
