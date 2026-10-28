package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button continueButton = findViewById(R.id.btnContinue);
        continueButton.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, LoginActivity.class)));
    }
}
