package com.example.nutrisense;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ModuleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        String moduleName = getIntent().getStringExtra("moduleName");
        String moduleIcon = getIntent().getStringExtra("moduleIcon");

        TextView title = findViewById(R.id.txtModuleTitle);
        TextView description = findViewById(R.id.txtModuleDescription);
        title.setText((moduleIcon == null ? "🌿" : moduleIcon) + "  " +
                (moduleName == null ? "NutriSense Module" : moduleName));
        description.setText("This is the " + moduleName +
                " section of NutriSense. This assignment demonstrates screen navigation. " +
                "Detailed tracking can be added in a future version.");
        findViewById(R.id.btnBackDashboard).setOnClickListener(v -> finish());
    }
}
