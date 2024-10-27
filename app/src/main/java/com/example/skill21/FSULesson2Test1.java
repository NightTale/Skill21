package com.example.skill21;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FSULesson2Test1 extends AppCompatActivity {
    private EditText answer1;
    public static String[] userAnswers = {"", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        EdgeToEdge.enable(this);


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fsulesson2_test1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        answer1 = findViewById(R.id.fsulesson2_question1);
    }
    public void toFSULesson2(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson2.class);
        startActivity(intent);
    }
    public void toFSULesson2Test2(View v) {

        String userAnswer1 = answer1.getText().toString().trim();
        userAnswers[0] = userAnswer1;

        Intent intent;
        intent = new Intent(this, FSULesson2Test2.class);
        intent.putExtra("answer1", userAnswers);
        startActivity(intent);
    }
}