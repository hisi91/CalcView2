package com.goobinmob.calcview;

import android.util.Log;

/**
 * Created by dell on 20/12/2015.
 */
public class Calc {

    int n1,n2,f;

    public Calc() {
        n1=(int) (Math.random()*10);
        n2=(int) (Math.random()*10);
        f=(int) (Math.random()*10);
    }

    public int getN1() {
        if (n1<10&&n1>0) return n1;
        else return 0;
    }

    public int getN2() {
        if (n2<10&&n2>0) return n2;
        else return 0;
    }

    public int getF() {
        return f;
    }

}
