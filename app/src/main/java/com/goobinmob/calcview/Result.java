package com.goobinmob.calcview;

import android.util.Log;

/**
 * Created by dell on 20/12/2015.
 */
public class Result {

    Calc c1=new Calc();


    public int getResult(){
        int reslt;
        if(c1.getF()>8) reslt=(c1.getN1()*5)+c1.getN2();
        else if(c1.getF()>7) reslt=c1.getN1()+(c1.getN2()*5);
        else if (c1.getF()>5) reslt=(c1.getN1()+10)+(c1.getN2()+10);
        else if(c1.getF()>2&&c1.getN1()>c1.getN2()) reslt=c1.getN1()-c1.getN2();
        else if(c1.getF()>2&&c1.getN1()<c1.getN2()) reslt=c1.getN2()-c1.getN1();
        else reslt=c1.getN1()*c1.getN2();
        return reslt;
    }


    public String getResString(){
        String formule;
            if(c1.getF()>8) formule=String.valueOf(c1.getN1()*5)+" + "+c1.getN2();
            else if(c1.getF()>7) formule=c1.getN1()+" + "+String.valueOf(c1.getN2()*5);
            else if (c1.getF()>5) formule=String.valueOf(c1.getN1()+10)+" + "+String.valueOf(c1.getN2()+10);
            else if(c1.getF()>2&&c1.getN1()>c1.getN2()) formule=String.valueOf(c1.getN1())+" - "+String.valueOf(c1.getN2());
            else if(c1.getF()>2&&c1.getN1()<c1.getN2()) formule=String.valueOf(c1.getN2())+" - "+String.valueOf(c1.getN1());
            else formule=c1.getN1()+" x "+c1.getN2();
        return formule;
    }

    public boolean getResBoolean(){
        Boolean res=true;
        if (getResult()%2==1) res=false;//odd impaire false;
        else if (getResult()%2==0) res=true;//even paire true;
        Log.e("Res",String.valueOf(getResult()%2)+"//"+String.valueOf(res)+"///"+String.valueOf(getResult())+"="+getResString());
        return res;
    }

}


