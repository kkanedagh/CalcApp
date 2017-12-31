package jp.techacademy.kaneda.kenichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", String.valueOf(mEditText1.getText()));
        intent.putExtra("VALUE2", String.valueOf(mEditText2.getText()));

        switch(v.getId()) {
            case R.id.button1:
                // Button1押下時
                intent.putExtra("VALUE3", "+");
                break;
            case R.id.button2:
                // Button2押下時
                intent.putExtra("VALUE3", "-");
                break;
            case R.id.button3:
                // Button3押下時
                intent.putExtra("VALUE3", "×");
                break;
            case R.id.button4:
                // Button4押下時
                intent.putExtra("VALUE3", "÷");
                break;
        }

        startActivity(intent);
    }
}
