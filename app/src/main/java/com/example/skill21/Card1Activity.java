package com.example.skill21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.skill21.databinding.ActivityMainBinding;

public class Card1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        EdgeToEdge.enable(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void toHome(View v) {
        Intent intent;
        intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
    public void toFSULesson1(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson1.class);
        startActivity(intent);
    }
    public void toFSULesson2(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson2.class);
        startActivity(intent);
    }
}