package com.example.skill21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FSULesson1Test2 extends AppCompatActivity {
    private EditText answer2;
    public static String [] userAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fsulesson1_test2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        answer2 = findViewById(R.id.fsulesson1_question2);
    }
    public void toFSULesson1Test1(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson1Test1.class);
        startActivity(intent);
    }
    public void toFSULesson1Test3(View v) {

        userAnswers = getIntent().getStringArrayExtra("answer1");
        String userAnswer2 = answer2.getText().toString().trim();
        userAnswers[1] = userAnswer2;

        Intent intent;
        intent = new Intent(this, FSULesson1Test3.class);
        intent.putExtra("answer2", userAnswers);
        startActivity(intent);
    }
    public void toFSULesson1(View v) {
        Intent intent;
        intent = new Intent(this, FSULesson1.class);
        startActivity(intent);
        finish();
    }
}