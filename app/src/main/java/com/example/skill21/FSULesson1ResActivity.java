package com.example.skill21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FSULesson1ResActivity extends AppCompatActivity {

    private final String[] correctAnswers = {"4", "5", "6"};
    String userAnswer1, userAnswer2, userAnswer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fsulesson1_res);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userAnswer1 = getIntent().getStringExtra("answer1");
        userAnswer2 = getIntent().getStringExtra("answer2");
        userAnswer3 = getIntent().getStringExtra("answer3");
        String[] userAnswers = {userAnswer1, userAnswer2, userAnswer3};
        checkAnswers(userAnswers);
    }

    private static float trust_fsu_lesson_1;
    private void checkAnswers(String[] userAnswers) {
        boolean check = true;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] != null && !userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                check = false;
                break;
            }
        }
        int trushniye = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] != null && userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                trushniye++;
            }
        }
        trust_fsu_lesson_1 = (float) trushniye / correctAnswers.length;
        if (check) {
            Toast.makeText(this, "pobeda",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "pizda",Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, userAnswer3, Toast.LENGTH_LONG).show();

    }
    public void toCard1(View v) {
        Intent intent;
        intent = new Intent(this, Card1Activity.class);
        startActivity(intent);
        finish();
    }
}

