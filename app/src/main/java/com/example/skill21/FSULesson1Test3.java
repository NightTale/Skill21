package com.example.skill21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FSULesson1Test3 extends AppCompatActivity {

    private EditText answer3;
    private final String[] correctAnswers = {"4", "5", "6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fsulesson1_test3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        answer3 = findViewById(R.id.fsulesson1_question3);

    }
    public void toFSULesson1Test2(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson1Test2.class);
        startActivity(intent);
    }
    public void toFSULesson1(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson1.class);
        startActivity(intent);
        finish();
    }

    public void toFSULesson1Result(View v) {
        String userAnswer3 = answer3.getText().toString().trim();

        Intent intent;
        intent = new Intent(this, FSULesson1ResActivity.class);
        intent.putExtra("answer3", userAnswer3);

        startActivity(intent);
    }
}