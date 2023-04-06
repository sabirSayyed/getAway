package com.nescorp.getaway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button client = findViewById(R.id.button);
        EditText val = findViewById(R.id.editTextTextPersonName);
        Intent intent = new Intent(MainActivity.this ,callactivity.class);
        EditText phone = findViewById(R.id.phone);

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, val.getText().toString(), Toast.LENGTH_SHORT).show();
                intent.putExtra("client" , val.getText().toString());
                intent.putExtra("sid" , phone.getText().toString());
                startActivity(intent);
            }
        });
    }
}