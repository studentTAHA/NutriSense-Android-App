package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private EditText inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inputLoginEmail);
        inputPassword = findViewById(R.id.inputLoginPassword);
        Button login = findViewById(R.id.btnLogin);
        TextView register = findViewById(R.id.linkRegister);
        TextView forgot = findViewById(R.id.linkForgot);

        login.setOnClickListener(v -> {
            String email = inputEmail.getText().toString().trim();
            String password = inputPassword.getText().toString();

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                inputEmail.setError("Enter a valid email address");
                inputEmail.requestFocus();
            } else if (password.isEmpty()) {
                inputPassword.setError("Enter your password");
                inputPassword.requestFocus();
            } else {
                String savedEmail = getSharedPreferences("NutriSense", MODE_PRIVATE)
                        .getString("email", "demo@nutrisense.com");
                String savedPassword = getSharedPreferences("NutriSense", MODE_PRIVATE)
                        .getString("password", "123456");

                if (email.equalsIgnoreCase(savedEmail) && password.equals(savedPassword)) {
                    getSharedPreferences("NutriSense", MODE_PRIVATE).edit()
                            .putBoolean("loggedIn", true).apply();
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(this,
                            "Demo login: demo@nutrisense.com / 123456. Or register first.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));
        forgot.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }
}
