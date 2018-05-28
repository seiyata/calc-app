package jp.techacademy.tajikara.seiya.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(result));
    }
}
