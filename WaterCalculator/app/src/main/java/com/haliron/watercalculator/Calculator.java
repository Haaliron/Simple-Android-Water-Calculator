package com.haliron.watercalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Calculator extends AppCompatActivity
{
    ImageView backButton;
    EditText inputText1,inputText2,inputText3,inputText4;
    ImageView inputImage1,inputImage2,inputImage3,inputImage4;
    Animation scaleUp,scaleDown;
    Button submitButton;
    TextView bannerText,sonucText;
    String key;
    double inp1,inp2,inp3,inp4,sonuc;


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

        setContentView(R.layout.activity_calculator);

        scaleUp = AnimationUtils.loadAnimation(Calculator.this,R.anim.scale_up_anim);
        scaleDown = AnimationUtils.loadAnimation(Calculator.this,R.anim.scale_down_anim);

        backButton = findViewById(R.id.backButton);
        inputText1 = findViewById(R.id.inputText1);
        inputText2 = findViewById(R.id.inputText2);
        inputText3 = findViewById(R.id.inputText3);
        inputText4 = findViewById(R.id.inputText4);

        inputImage1 = findViewById(R.id.inputImage1);
        inputImage2 = findViewById(R.id.inputImage2);
        inputImage3 = findViewById(R.id.inputImage3);
        inputImage4 = findViewById(R.id.inputImage4);

        submitButton = findViewById(R.id.submitButton);
         bannerText = findViewById(R.id.bannerText);
         sonucText = findViewById(R.id.sonuc);

        key = getIntent().getStringExtra("keyID");




        if(key.equals("1"))
        {
            bannerText.setText("Motor Verimi Hesaplama");

            inputText1.setHint("Güç (kW)");
            inputImage1.setImageResource(R.drawable.power);

            inputText2.setHint("Debi (m³/h)");
            inputImage2.setImageResource(R.drawable.debi);

            inputText3.setHint("Basma Yüksekliği (mSS)");
            inputImage3.setImageResource(R.drawable.pump);

            inputText4.setHint("Hidrolik Verim (%)");
            inputImage4.setImageResource(R.drawable.statistics);
        }

        if(key.equals("2"))
        {
            bannerText.setText("Debi Hesaplama");

            inputText1.setHint("Güç (kW)");
            inputImage1.setImageResource(R.drawable.power);

            inputText2.setHint("Basma Yüksekliği (mSS)");
            inputImage2.setImageResource(R.drawable.pump);

            inputText3.setHint("Hidrolik Verim (%)");
            inputImage3.setImageResource(R.drawable.statistics);

            inputText4.setHint("Motor Verimi (%)");
            inputImage4.setImageResource(R.drawable.motor);
        }

        if(key.equals("3"))
        {
            bannerText.setText("Basma Yüksekliği Hesaplama");

            inputText1.setHint("Güç (kW)");
            inputImage1.setImageResource(R.drawable.power);

            inputText2.setHint("Debi (m³/h)");
            inputImage2.setImageResource(R.drawable.debi);

            inputText3.setHint("Motor Verimi (%)");
            inputImage3.setImageResource(R.drawable.motor);

            inputText4.setHint("Hidrolik Verim (%)");
            inputImage4.setImageResource(R.drawable.statistics);
        }

        if(key.equals("4"))
        {
            bannerText.setText("Güç Hesaplama");

            inputText1.setHint("Basma Yüksekliği (mSS)");
            inputImage1.setImageResource(R.drawable.pump);

            inputText2.setHint("Debi (m³/h)");
            inputImage2.setImageResource(R.drawable.debi);

            inputText3.setHint("Motor Verimi (%)");
            inputImage3.setImageResource(R.drawable.motor);

            inputText4.setHint("Hidrolik Verim (%)");
            inputImage4.setImageResource(R.drawable.statistics);
        }
        if(key.equals("5"))
        {
            bannerText.setText("Hidrolik Verimi Hesaplama");

            inputText1.setHint("Güç (kW)");
            inputImage1.setImageResource(R.drawable.power);

            inputText2.setHint("Debi (m³/h)");
            inputImage2.setImageResource(R.drawable.debi);

            inputText3.setHint("Basma Yüksekliği (mSS)");
            inputImage3.setImageResource(R.drawable.pump);

            inputText4.setHint("Motor Verimi (%)");
            inputImage4.setImageResource(R.drawable.motor);
        }


        submitButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        submitButton.startAnimation(scaleUp);

                        return true;

                    case MotionEvent.ACTION_UP:
                        submitButton.startAnimation(scaleDown);
                        submitFunction();
                        return  true;
                }
                return false;
            }
        });

        backButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        backButton.startAnimation(scaleUp);

                        return true;

                    case MotionEvent.ACTION_UP:
                        backButton.startAnimation(scaleDown);
                        backFunction();
                        return  true;
                }
                return false;
            }
        });
    }

    public void backFunction()
    {
        finish();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }


    public void submitFunction()
    {
        if(key.equals("1"))
        {
            inp1 =  Double.parseDouble(inputText1.getText().toString());
            inp2 = Double.parseDouble(inputText2.getText().toString());
            inp3 = Double.parseDouble(inputText3.getText().toString());
            inp4 = Double.parseDouble(inputText4.getText().toString());

            sonuc = (inp2 * inp3) / (inp1/100 * inp4/100 *367.2);

            sonucText.setText(String.valueOf(sonuc + " (%)"));
        }

       else if(key.equals("2"))
        {
            inp1 =   Double.parseDouble(inputText1.getText().toString());
            inp2 =  Double.parseDouble(inputText2.getText().toString());
            inp3 =  Double.parseDouble(inputText3.getText().toString());
            inp4 =  Double.parseDouble(inputText4.getText().toString());

           sonuc = inp3 / 100 * inp1 * inp4 / 100* 367.2 / inp2;

            sonucText.setText(String.valueOf(sonuc + " (m³/h)"));
        }

       else if(key.equals("3"))
        {
            inp1 =   Double.parseDouble(inputText1.getText().toString());
            inp2 =  Double.parseDouble(inputText2.getText().toString());
            inp3 =  Double.parseDouble(inputText3.getText().toString());
            inp4 =  Double.parseDouble(inputText4.getText().toString());

            sonuc = inp4 / 100 * inp1 * inp3 / 100* 367.2 / inp2;

            sonucText.setText(String.valueOf(sonuc + " (mSS)"));

        }

       else if(key.equals("4"))
        {
            inp1 =   Double.parseDouble(inputText1.getText().toString());
            inp2 =  Double.parseDouble(inputText2.getText().toString());
            inp3 =  Double.parseDouble(inputText3.getText().toString());
            inp4 =  Double.parseDouble(inputText4.getText().toString());

            sonuc = (inp2 * inp1) / (inp4/100 * inp3/100 *367.2);

            sonucText.setText(String.valueOf(sonuc + " (kW)"));

        }

       else if(key.equals("5"))
        {
            inp1 =   Double.parseDouble(inputText1.getText().toString());
            inp2 =  Double.parseDouble(inputText2.getText().toString());
            inp3 =  Double.parseDouble(inputText3.getText().toString());
            inp4 =  Double.parseDouble(inputText4.getText().toString());

            sonuc = (inp2  * inp3) / (inp1/100 * inp4/100 *367.2);

            sonucText.setText(String.valueOf(sonuc + " (%)"));
        }


       AlertDialog.Builder  builder = new AlertDialog.Builder(Calculator.this);
        builder.setTitle("Sonuç");
        builder.setMessage(sonucText.getText());
        builder.setNeutralButton("Tamam", null);builder.show();
    }
}