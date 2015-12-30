package com.goobinmob.calcview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity implements View.OnClickListener{

    static int score,start;
    Result R1;
    TextView textView,textView2,rl2nbscore;
    public FontsCalc tv;
    RelativeLayout relativeLayout;
    Button rl1btodd,rl1bteven,rl2restart;
    CountDownTimer timer;
    Intent i;
    static long tm;
    Animation set,set2;
    FrameLayout fl2;
    ImageView sharpeDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.rl1calcview);
        tv = (FontsCalc) findViewById(R.id.rl1tv);
        textView2 = (TextView) findViewById(R.id.rl1score);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl1);
        rl1bteven=(Button) this.findViewById(R.id.rl1bteven);
        rl1btodd=(Button) this.findViewById(R.id.rl1btodd);
        fl2=(FrameLayout) findViewById(R.id.fllayout);
        rl2nbscore=(TextView) findViewById(R.id.rl2nbscore);
        rl2restart=(Button) this.findViewById(R.id.rl2restart);
        sharpeDrawable=(ImageView) findViewById(R.id.rl1imageview1);

        score=0;
        start=0;
        tm=0;
        timer=new CountDownCalc(5000,100);
        set = AnimationUtils.loadAnimation(this, R.anim.animationset);

        set2 = AnimationUtils.loadAnimation(this, R.anim.animationset2);


        Typeface face=Typeface.createFromAsset(getAssets(),"Fonts/android_7.ttf");
        textView.setTypeface(face);

        Typeface face2=Typeface.createFromAsset(getAssets(),"Fonts/jfrocsol.ttf");
        textView2.setTypeface(face2);


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        textView.setOnClickListener(this);

        rl1bteven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId()==rl1bteven.getId()&&R1.getResBoolean()){
                    score++;
                    textView2.setText(String.valueOf(score));
                    timer.cancel();
                    timer= new CountDownCalc(5000-tm,100);
                    tm = (long) tm + 50;
                    R1=new Result();
                    textView.setText( R1.getResString());
                    timer.start();
                    }
                else{
                    textView.setText("Game...Over");
                    rl2nbscore.setText(String.valueOf(score));
                    fl2.setVisibility(View.VISIBLE);
                    fl2.bringToFront();
                    timer.cancel();
                }


            }
        });
        rl1btodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==rl1btodd.getId()&&!R1.getResBoolean()){
                    score++;
                    textView2.setText(String.valueOf(score));
                    timer.cancel();
                    timer= new CountDownCalc(5000-tm,100);
                    tm = (long) tm + 50;
                    R1=new Result();
                    textView.setText( R1.getResString());
                    timer.start();
                } else {
                    textView.setText("Game...Over");
                    //rl1btodd.setEnabled(false);
                    //rl1bteven.setEnabled(false);
                    rl2nbscore.setText(String.valueOf(score));
                    fl2.setVisibility(View.VISIBLE);
                    fl2.bringToFront();
                    timer.cancel();
                }


            }
        });

        rl2restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }




    public class CountDownCalc extends CountDownTimer {



        public CountDownCalc(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long miller=millisUntilFinished;
            String timedown=String.format("%02d:%1d", TimeUnit.MILLISECONDS.toSeconds(miller),(int) (TimeUnit.MILLISECONDS.toMillis(miller)-TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(miller)))/100);//,TimeUnit.MILLISECONDS.toMillis(miller)-TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(miller))
            System.out.println(timedown);
            tv.setText(timedown);

        }

        @Override
        public void onFinish() {
            tv.setText("00:00");
            rl2nbscore.setText(String.valueOf(score));
            fl2.setVisibility(View.VISIBLE);
            fl2.bringToFront();

        }
    }



        public void onClick(View v) {
            tv.setText("30");
            R1 = new Result();
            Log.e("erreur", String.valueOf(tm));
            timer.cancel();
            timer= new CountDownCalc(5000-tm,100);
            tm = (long) tm + 50;
            textView2.setTextColor(Color.parseColor("#0" + String.valueOf((int) (Math.random() * 9)) + "0" + String.valueOf((int) (Math.random() * 9)) + "0" + String.valueOf((int) (Math.random() * 9))));
            textView.setText(R1.getResString());
            rl1btodd.setEnabled(true);
            rl1bteven.setEnabled(true);
            timer.start();
            textView.clearAnimation();
            sharpeDrawable.clearAnimation();

        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
        textView.startAnimation(set);
        sharpeDrawable.startAnimation(set2);


        }
}
