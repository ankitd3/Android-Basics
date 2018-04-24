package com.example.ankitd3.ageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView m;
    EditText num1;
    EditText num2;
    Button add;
    Button sub;
    Button mul;
    Button div;
    Button coin;

    EditText enter;
    Button age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m=(TextView)findViewById(R.id.msg);
        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);

        age=(Button)findViewById(R.id.age);
        enter=(EditText)findViewById(R.id.enterAge);
        coin=(Button)findViewById(R.id.coin);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1=num1.getText().toString();
                String st2=num2.getText().toString();
                int number1=Integer.parseInt(st1);
                int number2=Integer.parseInt(st2);

                m.setText("Addition is : ".concat(Integer.toString(number1+number2)));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1=num1.getText().toString();
                String st2=num2.getText().toString();
                int number1=Integer.parseInt(st1);
                int number2=Integer.parseInt(st2);

                m.setText("Subtraction is : ".concat(Integer.toString(number1-number2)));

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1=num1.getText().toString();
                String st2=num2.getText().toString();
                int number1=Integer.parseInt(st1);
                int number2=Integer.parseInt(st2);

                m.setText("Multiplication is : ".concat(Integer.toString(number1*number2)));
                //Toast.makeText(MainActivity.this,"cool",Toast.LENGTH_SHORT).show();

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1=num1.getText().toString();
                String st2=num2.getText().toString();
                int number1=Integer.parseInt(st1);
                int number2=Integer.parseInt(st2);

                try {
                    m.setText("Division is : ".concat(Integer.toString(number1 / number2)));
                }
                catch (ArithmeticException e){
                    Toast.makeText(MainActivity.this,"Divide By 0",Toast.LENGTH_SHORT).show();
                }
            }
        });

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age_string=enter.getText().toString();
                int a=Integer.parseInt(age_string);

                if(a>17){
                    m.setText("Above 18");
                }
                else {
                    m.setText("Below 18");
                }
            }
        });

        coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });


    }
}