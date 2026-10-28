package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    private EditText nameInput, emailInput, passwordInput, confirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.inputName);
        emailInput = findViewById(R.id.inputRegisterEmail);
        passwordInput = findViewById(R.id.inputRegisterPassword);
        confirmInput = findViewById(R.id.inputConfirmPassword);

        Button createAccount = findViewById(R.id.btnCreateAccount);
        createAccount.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        String confirm = confirmInput.getText().toString();

        if (name.isEmpty()) {
            nameInput.setError("Enter your name");
            nameInput.requestFocus();
        } else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Enter a valid email address");
            emailInput.requestFocus();
        } else if (password.length() < 6) {
            passwordInput.setError("Password must be at least 6 characters");
            passwordInput.requestFocus();
        } else if (!password.equals(confirm)) {
            confirmInput.setError("Passwords do not match");
            confirmInput.requestFocus();
        } else {
            getSharedPreferences("NutriSense", MODE_PRIVATE).edit()
                    .putString("name", name)
                    .putString("email", email)
                    .putString("password", password)
                    .apply();

            Toast.makeText(this, "Account created. Please log in.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
