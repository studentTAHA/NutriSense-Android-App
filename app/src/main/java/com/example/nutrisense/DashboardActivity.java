package com.example.nutrisense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends Activity {
    private final String[] moduleNames = {
            "Meal Logging", "Calorie & BMI", "Water Tracker",
            "Heart Rate", "Progress Reports", "Diet Suggestions"
    };
    private final String[] moduleIcons = {"🍎", "📊", "💧", "❤️", "📈", "🥗"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String name = getSharedPreferences("NutriSense", MODE_PRIVATE)
                .getString("name", "NutriSense User");
        TextView welcome = findViewById(R.id.txtWelcome);
        welcome.setText("Hello, " + name + "!");

        int[] cardIds = {R.id.cardMeal, R.id.cardCalories, R.id.cardWater,
                R.id.cardHeart, R.id.cardProgress, R.id.cardDiet};

        for (int i = 0; i < cardIds.length; i++) {
            final int index = i;
            TextView card = findViewById(cardIds[i]);
            card.setText(moduleIcons[i] + "\n\n" + moduleNames[i]);
            card.setOnClickListener(v -> {
                Intent intent = new Intent(DashboardActivity.this, ModuleActivity.class);
                intent.putExtra("moduleName", moduleNames[index]);
                intent.putExtra("moduleIcon", moduleIcons[index]);
                startActivity(intent);
            });
        }

        findViewById(R.id.btnOpenProfile).setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
    }
}
