package com.example.bhawook54545434.docalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button allclear, percent, div, sev, eig, nin, fou, fiv, six, one, two, thr, zer, dot, equ, plu, min, mul, back;
    TextView t1, t2;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Change the color of status bar
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.stbar));

        allclear = findViewById(R.id.allclear_btn);
        percent = findViewById(R.id.percentage_btn);
        div = findViewById(R.id.divide_btn);
        sev = findViewById(R.id.seven_btn);
        eig = findViewById(R.id.eight_btn);
        nin = findViewById(R.id.nine_btn);
        fou = findViewById(R.id.four_btn);
        fiv = findViewById(R.id.five_btn);
        six = findViewById(R.id.six_btn);
        one = findViewById(R.id.one_btn);
        two = findViewById(R.id.two_btn);
        thr = findViewById(R.id.three_btn);
        zer = findViewById(R.id.zero_btn);
        dot = findViewById(R.id.dot_btn);
        equ = findViewById(R.id.equals_btn);
        plu = findViewById(R.id.plus_btn);
        min = findViewById(R.id.minus_btn);
        mul = findViewById(R.id.multiply_btn);
        back = findViewById(R.id.back_button);
        t1 = findViewById(R.id.input_txt);
        t2 = findViewById(R.id.output_txt);

        zer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '0');
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '1');
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '2');
            }
        });

        thr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '3');
            }
        });

        fou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '4');
            }
        });

        fiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '5');
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '6');
            }
        });

        sev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '7');
            }
        });

        eig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '8');
            }
        });

        nin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '9');
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '.');
            }
        });

        allclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                t2.setText("");
            }
        });

        plu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '+');
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '-');
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '×');
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + '%');
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                t1.setText(data + "÷");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!t1.getText().toString().equals("")) {
                    String value = t1.getText().toString();
                    if (value.length() > 0) {
                        value = value.substring(0, value.length() - 1);
                        t1.setText(value);
                    }
                }
            }
        });


        equ.setOnClickListener(new View.OnClickListener() {  
            @Override
            public void onClick(View v) {
                data = t1.getText().toString();
                data = data.replaceAll("×", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                t2.setText(finalResult);

            }
        });

    }
}