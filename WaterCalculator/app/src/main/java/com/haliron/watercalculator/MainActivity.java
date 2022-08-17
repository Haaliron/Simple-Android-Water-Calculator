package com.haliron.watercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Animation scaleUp,scaleDown;
    TextView engineButton,flowButton,hydrolicButton,powerButton,basmaButton;
    ImageView engineImage,flowImage,hydrolicImage,powerImage,basmaImage;
    EditText inputText1,inputText2,inputText3,inputText4;
    ImageView inputImage1,inputImage2,inputImage3,inputImage4;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
       View decorView = getWindow().getDecorView();
       decorView.setSystemUiVisibility
               (
                       View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                               | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                               | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                               | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                               | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                               | View.SYSTEM_UI_FLAG_FULLSCREEN
               );
        setContentView(R.layout.activity_main);

        scaleUp = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_up_anim);
        scaleDown = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_down_anim);

        engineButton = findViewById(R.id.engineText);
        flowButton = findViewById(R.id.flowText);
        powerButton = findViewById(R.id.powerText);
        hydrolicButton = findViewById(R.id.hydrolicText);
        basmaButton = findViewById(R.id.basmaText);

        engineImage = findViewById(R.id.engineImage);
        flowImage = findViewById(R.id.flowImage);
        powerImage = findViewById(R.id.powerImage);
        hydrolicImage = findViewById(R.id.hydrolicImage);
        basmaImage = findViewById(R.id.basmaImage);

        inputText1 = findViewById(R.id.inputText1);
        inputText2 = findViewById(R.id.inputText2);
        inputText3 = findViewById(R.id.inputText3);
        inputText4 = findViewById(R.id.inputText4);

        inputImage1 = findViewById(R.id.inputImage1);
        inputImage2 = findViewById(R.id.inputImage2);
        inputImage3 = findViewById(R.id.inputImage3);
        inputImage4 = findViewById(R.id.inputImage4);

        engineButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        engineImage.startAnimation(scaleUp);
                        engineButton.startAnimation(scaleUp);

                        return true;

                    case MotionEvent.ACTION_UP:
                        engineImage.startAnimation(scaleDown);
                        engineButton.startAnimation(scaleDown);

                        engineFunction();
                        return  true;
                }
                return false;
            }
        });

        flowButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        flowButton.startAnimation(scaleUp);
                        flowImage.startAnimation(scaleUp);
                        return true;

                    case MotionEvent.ACTION_UP:
                        flowButton.startAnimation(scaleDown);
                        flowImage.startAnimation(scaleDown);
                        flowFunction();
                        return  true;
                }
                return false;
            }
        });

        powerButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        powerButton.startAnimation(scaleUp);
                        powerImage.startAnimation(scaleUp);
                        return true;

                    case MotionEvent.ACTION_UP:
                        powerButton.startAnimation(scaleDown);
                        powerImage.startAnimation(scaleDown);
                        powerFunction();
                        return  true;
                }
                return false;
            }
        });

        hydrolicButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        hydrolicButton.startAnimation(scaleUp);
                        hydrolicImage.startAnimation(scaleUp);
                        return true;

                    case MotionEvent.ACTION_UP:
                        hydrolicButton.startAnimation(scaleDown);
                        hydrolicImage.startAnimation(scaleDown);
                        hydrolicFunction();
                        return  true;
                }
                return false;
            }
        });

        basmaButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        basmaButton.startAnimation(scaleUp);
                        basmaImage.startAnimation(scaleUp);
                        return true;

                    case MotionEvent.ACTION_UP:
                        basmaButton.startAnimation(scaleDown);
                        basmaImage.startAnimation(scaleDown);
                        basmaFunction();
                        return  true;
                }
                return false;
            }
        });
    }

    public void engineFunction()
    {
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        intent.putExtra("keyID","1");
        startActivity(intent);
    }

    public void flowFunction()
    {
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        intent.putExtra("keyID","2");
        startActivity(intent);
    }

    public void basmaFunction()
    {
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        intent.putExtra("keyID","3");
        startActivity(intent);
    }

    public void powerFunction()
    {
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        intent.putExtra("keyID","4");
        startActivity(intent);
    }

    public void hydrolicFunction()
    {
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        intent.putExtra("keyID","5");
        startActivity(intent);
    }


}