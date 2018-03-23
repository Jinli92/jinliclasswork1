package com.example.jinliyu.androidb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //get intent which started this activity

        String dataReceived = getIntent().getExtras().getString("myKey");
        TextView resTextVew = findViewById(R.id.textView2);
        resTextVew.setText(dataReceived);
    }

    public void handleClick(View view) {
        EditText hEditText  = findViewById(R.id.editTextHome);
        String home = hEditText.getText().toString();
        Intent  intent = new Intent();
        intent.putExtra("homekey",home);
        setResult(RESULT_OK,intent);
        finish();
    }
}
