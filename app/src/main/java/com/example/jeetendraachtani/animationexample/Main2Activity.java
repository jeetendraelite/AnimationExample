package com.example.jeetendraachtani.animationexample;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.layout2)
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        linearLayout.setBackgroundResource(R.drawable.animation_color);
        Thread thread = new Thread(){
            @Override
            public void run() {
               try{
                    sleep(5000);
               }
               catch (Exception e){
                  e.printStackTrace();
               }
               finally {
                   Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                   startActivity(intent);
               }

            }
        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AnimationDrawable animationDrawable= (AnimationDrawable)linearLayout.getBackground();

        if(hasFocus){
            animationDrawable.start();
        }else{
            animationDrawable.stop();
        }
    }
}
