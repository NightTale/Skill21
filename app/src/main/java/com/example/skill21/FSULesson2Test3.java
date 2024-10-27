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

public class FSULesson2Test3 extends AppCompatActivity {

    private EditText answer3;
    public static String [] userAnswers;
    private final String[] correctAnswers = {"4", "5", "6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fsulesson2_test3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        answer3 = findViewById(R.id.fsulesson2_question3);

    }
    public void toFSULesson2Test2(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson2Test2.class);
        startActivity(intent);
    }
    public void toFSULesson2(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson2.class);
        startActivity(intent);
        finish();
    }

    public void toFSULesson2Result(View v) {
        userAnswers = getIntent().getStringArrayExtra("answer2");
        String userAnswer3 = answer3.getText().toString().trim();
        userAnswers[2] = userAnswer3;

        Intent intent;
        intent = new Intent(this, FSULesson2ResActivity.class);
        intent.putExtra("answer3", userAnswers);
        startActivity(intent);
        finish();
    }
}