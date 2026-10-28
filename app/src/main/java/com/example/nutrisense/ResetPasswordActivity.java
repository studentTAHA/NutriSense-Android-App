package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends Activity {
    private EditText newPasswordInput, confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPasswordInput = findViewById(R.id.inputNewPassword);
        confirmPasswordInput = findViewById(R.id.inputNewConfirmPassword);
        Button save = findViewById(R.id.btnSavePassword);

        save.setOnClickListener(v -> {
            String password = newPasswordInput.getText().toString();
            String confirm = confirmPasswordInput.getText().toString();

            if (password.length() < 6) {
                newPasswordInput.setError("Use at least 6 characters");
                newPasswordInput.requestFocus();
            } else if (!password.equals(confirm)) {
                confirmPasswordInput.setError("Passwords do not match");
                confirmPasswordInput.requestFocus();
            } else {
                String email = getSharedPreferences("NutriSense", MODE_PRIVATE)
                        .getString("recoveryEmail", "");
                if (email.isEmpty()) {
                    Toast.makeText(this, "Start recovery from Forgot Password first.",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, ForgotPasswordActivity.class));
                    finish();
                    return;
                }

                getSharedPreferences("NutriSense", MODE_PRIVATE).edit()
                        .putString("password", password)
                        .remove("recoveryEmail")
                        .apply();
                Toast.makeText(this, "Password updated. Please log in.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
