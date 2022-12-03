package com.example.localavtkyznetsov;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localavtkyznetsov.Second;

public class MainActivity extends AppCompatActivity{
    Button cButton;
    EditText login;
    EditText password;
    TextView warrning;

    int numberOfRemainingLoginAttempts = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cButton = (Button) findViewById(R.id.bt);
        login = (EditText) findViewById(R.id.vvodT);
        password = (EditText) findViewById(R.id.vvodP);
        warrning = (TextView) findViewById(R.id.mes);

        View.OnClickListener GoTo  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, Second.class);
                    startActivity(intent);
                }
                else {
                    numberOfRemainingLoginAttempts = numberOfRemainingLoginAttempts - 1;
                    if (numberOfRemainingLoginAttempts < 1){
                        finish();
                    }
                    else {
                        warrning.setText("У вас осталось " + numberOfRemainingLoginAttempts + " попыток!!!");
                    }
                }
            }
        };
        cButton.setOnClickListener(GoTo);
    }
}