package com.example.jinliyu.androidb12;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {
    public static String TAG = MainActivity.class.getSimpleName();
    EditText nameEditText;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView res = findViewById(R.id.textViewMain);
        String string = data.getStringExtra(Constants.KEY3);
        res.setText(string);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String string = nameEditText.getText().toString();
        outState.putString(Constants.KEY1, string);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "activity got created ");


        nameEditText = (EditText) findViewById(R.id.editTextName);
        nameEditText.setOnFocusChangeListener(this);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setPrompt("select country");
        spinner.setOnItemSelectedListener(this);


        nameEditText = (EditText) findViewById(R.id.editTextName);
        if (savedInstanceState != null) {
            nameEditText.setText(savedInstanceState.getString(Constants.KEY1));
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "activity got resumed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "activity got paused");
        add(1, 4);
    }

    public void add(int a, int b) {
        Log.i(TAG, ">???");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, getResources().getString(R.string.activity_stopped));

    }


    @Override
    public void onFocusChange(View view, boolean isFocussed) {

        if (isFocussed) {
            Toast.makeText(this, "focussed", Toast.LENGTH_SHORT).show();
        } else if (!isFocussed) {
            Toast.makeText(this, "lost focus", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "postion clicked = " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void clickHandleb12(View view) {

        switch (view.getId()) {
            case R.id.button3:

                String name = nameEditText.getText().toString();
                //    Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

                Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
                //explicit intent --name of activity to be started
                hIntent.putExtra(Constants.KEY2, name);
                //   startActivity(hIntent);
                startActivityForResult(hIntent, 007);
                //start an activity and receive result back
                break;

            case R.id.button2:
                EditText pwdEditText = (EditText) findViewById(R.id.editTextPassword);
                String password = pwdEditText.getText().toString();
                Toast.makeText(this, password, Toast.LENGTH_SHORT).show();

              /*  Intent dIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123345"));//it will dial"123345"
                //"Intent" invokes activity of my application and other applications
                startActivity(dIntent);

                */

                final String CALCULATOR_PACKAGE = "com.android.calculator2";
                final String CALCULATOR_CLASS = "com.android.calculator2.Calculator";
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(new ComponentName(
                        CALCULATOR_PACKAGE,
                        CALCULATOR_CLASS));

                startActivity(intent);
                break;


        }
    }


    public void oncheckboxclick(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox:
                if (checked)
                    Toast.makeText(this, "save password!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "don't save password!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}