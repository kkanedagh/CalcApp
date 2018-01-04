package jp.techacademy.kaneda.kenichi.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import android.util.Log;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("VALUE1");
        String value2 = intent.getStringExtra("VALUE2");
        String value3 = intent.getStringExtra("VALUE3");

        TextView textView = (TextView) findViewById(R.id.textView);

        if(isNumber(value1) == true && isNumber(value2) == true) {

            //変換
            Double value1_d = Double.valueOf(value1);
            Double value2_d = Double.valueOf(value2);

            if (value3.equals("+")) {
                double ans = value1_d + value2_d;
                Log.d("javatestlog", "+ルート" + ans);
                textView.setText(String.valueOf(ans));
            } else if (value3.equals("-")) {
                double ans = value1_d - value2_d;
                Log.d("javatestlog", "-ルート" + ans);
                textView.setText(String.valueOf(ans));
            } else if (value3.equals("×")) {
                double ans = value1_d * value2_d;
                Log.d("javatestlog", "*ルート" + ans);
                textView.setText(String.valueOf(ans));
            } else {
                if(value2_d == 0) {
                    textView.setText("計算できません。");
                } else {
                    double ans = value1_d / value2_d;
                    Log.d("javatestlog", "/ルート" + ans);
                    textView.setText(String.valueOf(ans));
                }
            }
        } else {
            textView.setText("数値を入力してください。");
        }
    }

    public boolean isNumber(String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (NumberFormatException nfex) {
            return false;
        }
    }
}
