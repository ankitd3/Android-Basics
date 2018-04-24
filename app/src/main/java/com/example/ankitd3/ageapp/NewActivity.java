package com.example.ankitd3.ageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class NewActivity extends AppCompatActivity {

    Button flip;
    ImageView im;
    Random r;
    int c=0;
    Button q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        r=new Random();
        im=(ImageView)findViewById(R.id.im);
        q=(Button)findViewById(R.id.quiz);
        flip=(Button)findViewById(R.id.flip);

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=r.nextInt(2);
                if(c==0){
                    im.setImageResource(R.drawable.head);
                    Toast.makeText(NewActivity.this,"HEADS",Toast.LENGTH_SHORT).show();
                }
                else {
                    im.setImageResource(R.drawable.tail);
                    Toast.makeText(NewActivity.this,"TAILS",Toast.LENGTH_SHORT).show();
                }

                RotateAnimation rot = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rot.setDuration(1000);

                im.startAnimation(rot);

            }
        });

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewActivity.this,Quiz.class));
            }
        });
    }
}
