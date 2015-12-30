package com.goobinmob.calcview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by dell on 23/12/2015.
 */
public class MainActivity2 extends Activity{


    RelativeLayout rl2;
    RelativeLayout.LayoutParams rl2params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rl2= (RelativeLayout) findViewById(R.id.rl2layout);
        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



}
