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

        String [] userAnswers = getIntent().getStringArrayExtra("answer3");
        checkAnswers1(userAnswers);
    }

    private static float trust_fsu_lesson_1;
    private void checkAnswers1(String[] userAnswers) {
        int trushniye = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] != null && userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                trushniye++;
            }
        }
        trust_fsu_lesson_1 = (float) trushniye / correctAnswers.length;
        Toast.makeText(this, "Правильно " + Integer.toString((int) trushniye) + " из " + Integer.toString(correctAnswers.length) + "!", Toast.LENGTH_LONG).show();

    }
    public void toCard1(View v) {
        Intent intent;
        intent = new Intent(this, Card1Activity.class);
        startActivity(intent);
        finish();
    }
}

