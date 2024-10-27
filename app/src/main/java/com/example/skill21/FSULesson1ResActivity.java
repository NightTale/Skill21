package com.example.skill21;

import static com.example.skill21.R.drawable.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class FSULesson1ResActivity extends AppCompatActivity {

    private final String[] correctAnswers = {"4", "5", "6"};
    String userAnswer1, userAnswer2, userAnswer3;
    boolean [] checkedAnswers = {false,false,false};

    TextView textRes;

    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String [] userAnswers = getIntent().getStringArrayExtra("answer3");
        checkAnswers(userAnswers);


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fsulesson1_res);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textRes = (TextView)findViewById(R.id.lesson1test1res);
        if (checkedAnswers[0] == true){
            textRes.setBackgroundResource(result_ok_background);
        }
        else {
            textRes.setBackgroundResource(result_wrong_background);
        }
     //   textRes.setTextAppearance(R.style.ResultFalseStyle);
        textRes = (TextView)findViewById(R.id.lesson1test2res);
        if (checkedAnswers[1] == true){
            textRes.setBackgroundResource(result_ok_background);
        }
        else {
            textRes.setBackgroundResource(result_wrong_background);
        }
        textRes = (TextView)findViewById(R.id.lesson1test3res);
        if (checkedAnswers[2] == true){
            textRes.setBackgroundResource(result_ok_background);
        }
        else {
            textRes.setBackgroundResource(result_wrong_background);
        }

    }

    private static float trust_fsu_lesson_1;
    private void checkAnswers(String[] userAnswers) {
        boolean check = true;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] != null && userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                checkedAnswers[i] = true;
            }
            else{
                checkedAnswers[i] = false;
            }
        }



        int trushniye = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] != null && userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                trushniye++;
            }
        }
        trust_fsu_lesson_1 = (float) trushniye / correctAnswers.length;
        Toast.makeText(this, Float.toString(trust_fsu_lesson_1), Toast.LENGTH_LONG).show();

    }
    public void toCard1(View v) {
        Intent intent;
        intent = new Intent(this, Card1Activity.class);
        startActivity(intent);
        finish();
    }
}

