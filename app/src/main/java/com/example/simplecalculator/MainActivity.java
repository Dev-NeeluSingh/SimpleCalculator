package com.example.simplecalculator;

import static com.example.simplecalculator.calculations.evaluate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    String toCalculate = "";
    TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00, btnDec, btnEqual, btnPlus, ques, btnMinus, btnMulti, btnDiv, btnC, btnPer, ans;
    ImageView btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btn0 = findViewById(R.id.btn0);
        btn00 = findViewById(R.id.btn00);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDec = findViewById(R.id.btnDec);
        btnEqual = findViewById(R.id.btnEqual);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnPer = findViewById(R.id.btnPer);
        btnC = findViewById(R.id.btnC);
        btnBack = findViewById(R.id.btnBack);

        ques = findViewById(R.id.ques);
        ans = findViewById(R.id.ans);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("0");
            }

        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("00");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("3");
            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("9");
            }

        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(".");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("-");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("×");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("÷");
            }

        });

        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum("%");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ques.setText("");
                toCalculate = "";
                ans.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ques.getText().toString().equals("")) {
                    ques.setText(ques.getText().toString().substring(0, ques.getText().toString().length() - 1));
                    toCalculate = toCalculate.substring(0, toCalculate.length() - 1);
                    ans.setText("");
                } else {
                    ques.setText("");
                    toCalculate = "";
                    ans.setText("");
                }
            }
        });
    }

    public void inputNum(final String num) {
        if (ques == null) {
            ques.setText(num);
            toCalculate = num;
        } else {
            if (num.equals("÷")) {
                toCalculate = toCalculate.concat("/");
            } else if (num.equals("×")) {
                toCalculate = toCalculate.concat("*");
            } else if (num.equals("%")) {
                toCalculate = toCalculate.concat("/100*");
            } else {
                toCalculate = toCalculate.concat(num);
            }
            ques.setText(ques.getText().toString().concat(num));
        }
        try {
            result();
        } catch (Exception e) {
            ans.setText("Error");
        }
    }

    public void result() {
        ans.setText(Double.toString(evaluate(toCalculate)));
    }
}
