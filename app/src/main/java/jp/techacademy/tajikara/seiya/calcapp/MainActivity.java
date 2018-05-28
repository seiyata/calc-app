package jp.techacademy.tajikara.seiya.calcapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText operand1EditText;
    EditText operand2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1EditText = (EditText) findViewById(R.id.operand1EditText);
        operand2EditText = (EditText) findViewById(R.id.operand2EditText);

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        Button subtractButton = (Button) findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(this);

        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(this);

        Button divideButton = (Button) findViewById(R.id.divideButton);
        divideButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String operand1Text = operand1EditText.getText().toString();
        String operand2Text = operand2EditText.getText().toString();
        double result = 0.0;

        if (operand1Text.length() > 0 && operand2Text.length() > 0) {
            double operand1 = Double.parseDouble(operand1Text);
            double operand2 = Double.parseDouble(operand2Text);
            if (v.getId() == R.id.addButton) {
                result = operand1 + operand2;
            } else if (v.getId() == R.id.subtractButton) {
                result = operand1 - operand2;
            } else if (v.getId() == R.id.multiplyButton) {
                result = operand1 * operand2;
            } else if (v.getId() == R.id.divideButton) {
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    Snackbar.make(v, "0で割ることはできません", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
            }
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);

        } else {
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
}
