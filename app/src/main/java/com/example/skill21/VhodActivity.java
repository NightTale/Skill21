package com.example.skill21;

import android.app.Activity;
import android.content.Context;
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
import java.util.Properties;

public class VhodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vhod);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void toHome(View v) {
        Activity activity = VhodActivity.this;
        Thread thread = new Thread(()->CheckLoginToServer(activity));
        thread.start();
    }
    public void CheckLoginToServer(Activity activity)
    {
        try {
            String SERVER_IP = PropertiesUtil.getProperty("server.ip", getApplicationContext());
            int SERVER_PORT = Integer.parseInt(PropertiesUtil.getProperty("server.port",getApplicationContext()));
            try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                Log.i("ConServ", "Connected to server");
                EditText editText = findViewById(R.id.Login);
                String log = editText.getText().toString();
                editText = findViewById(R.id.Password);
                String pas = editText.getText().toString();
                writer.write("1");
                writer.newLine();
                writer.flush();
                writer.write(log);
                writer.newLine();
                writer.flush();
                writer.write(pas);
                writer.newLine();
                writer.flush();
                int a = reader.read();
                if (a == 1) {
                    Log.i("InfoLogin", "Вы вошли");
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, "Вы вошли", Toast.LENGTH_LONG).show();
                            Intent intent;
                            intent = new Intent(activity, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                } else {
                    Log.i("InfoLogin", "Вы не вошли");
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, "Вы не вошли", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } catch (Exception ex) {
                Log.d("ErrConServ", ex.getMessage());
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void toReg(View v) {
        Intent intent;
        intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

}