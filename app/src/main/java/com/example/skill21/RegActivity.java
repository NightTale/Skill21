package com.example.skill21;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.skill21.utils.PropertiesUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void RegButton(View view)
    {
        EditText email = findViewById(R.id.email_reg);
        EditText name = findViewById(R.id.user_reg);
        EditText password1 = findViewById(R.id.password_reg);
        EditText password2 = findViewById(R.id.password_reg2);

        if ((email.getText().toString().equals("") || name.getText().toString().equals("")) ||
                (password1.getText().toString().equals("") || password2.getText().toString().equals("")))
        {
            Toast.makeText(this,"Заполните все поля", Toast.LENGTH_LONG).show();
        }
        else {
            if (!password1.getText().toString().equals(password2.getText().toString()))
            {
                Toast.makeText(this, "Пароли не совпадают",Toast.LENGTH_LONG).show();
            }
            else
            {
                try
                {
                    Log.i("RegInfo","Процесс регистрации");
                    String SERVER_IP = PropertiesUtil.getProperty("server.ip",getApplicationContext());
                    int SERVER_PORT = Integer.parseInt(PropertiesUtil.getProperty("server.port",getApplicationContext()));
                    Activity activity = RegActivity.this;
                    Thread thread = new Thread(()->RegistrationAccountToServer(activity,SERVER_IP,SERVER_PORT));
                    thread.start();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }

            }

        }
    }
    public void RegistrationAccountToServer(Activity activity, String SERVER_IP, int SERVER_PORT)
    {
        try (Socket socket = new Socket(SERVER_IP,SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));)
        {
            Log.i("ConServ", "Connected to server");
            EditText editText = findViewById(R.id.email_reg);
            String enp[] = new String[3];
            enp[0] = editText.getText().toString();
            editText = findViewById(R.id.user_reg);
            enp[2] = editText.getText().toString();
            editText = findViewById(R.id.password_reg);
            enp[1] = editText.getText().toString();
            writer.write("2");
            writer.newLine();
            writer.flush();
            for (int i = 0; i < 3; i++)
            {
                writer.write(enp[i]);
                writer.newLine();
                writer.flush();
            }
            int code = reader.read();
            if (code == 1)
            {
                Log.i("InfoReg","Аккаунт успешно создан.");
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity,"Вы успешно зарегистрировались.",Toast.LENGTH_LONG).show();
                        Intent intent;
                        intent = new Intent(activity, VhodActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
            else
            {
                Log.i("RegInfo","Регистрация не удалась");
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity,"Регистрация не удалась",Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
        catch (Exception ex)
        {
            Log.d("RegistrationError",ex.getMessage());
        }
    }

    public void toVhod(View v) {
        Intent intent;
        intent = new Intent(this, VhodActivity.class);
        startActivity(intent);
        finish();
    }
}