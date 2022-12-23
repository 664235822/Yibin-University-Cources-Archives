package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button hundred;
    Button add;
    Button minus;
    Button multiply;
    Button divide;
    Button equals;

    TextView textView;

    boolean bCalculate = true;

    int lastNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        hundred = findViewById(R.id.hundred);
        add = findViewById(R.id.add);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        textView = findViewById(R.id.textView);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("1");
                    bCalculate = false;
                } else {
                    textView.append("1");
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("2");
                    bCalculate = false;
                } else {
                    textView.append("2");
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("3");
                    bCalculate = false;
                } else {
                    textView.append("3");
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("4");
                    bCalculate = false;
                } else {
                    textView.append("4");
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("5");
                    bCalculate = false;
                } else {
                    textView.append("5");
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("6");
                    bCalculate = false;
                } else {
                    textView.append("6");
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("7");
                    bCalculate = false;
                } else {
                    textView.append("7");
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("8");
                    bCalculate = false;
                } else {
                    textView.append("8");
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("9");
                    bCalculate = false;
                } else {
                    textView.append("9");
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("0");
                    bCalculate = false;
                } else {
                    if (!textView.getText().toString().equals("0")) {
                        textView.append("0");
                    }

                }
            }
        });

        hundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bCalculate) {
                    textView.setText("0");
                    bCalculate = false;
                } else {
                    if (!textView.getText().toString().equals("0")) {
                        textView.append("00");
                    }
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bCalculate) {
                    lastNum += Integer.parseInt(textView.getText().toString());
                    bCalculate = true;
                    textView.setText(lastNum);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bCalculate) {
                    lastNum -= Integer.parseInt(textView.getText().toString());
                    bCalculate = true;
                    textView.setText(lastNum);
                }

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bCalculate) {
                    lastNum *= Integer.parseInt(textView.getText().toString());
                    bCalculate = true;
                    textView.setText(lastNum);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bCalculate) {
                    lastNum /= Integer.parseInt(textView.getText().toString());
                    bCalculate = true;
                    textView.setText(lastNum);
                }
            }
        });
    }
}