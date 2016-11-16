package com.ayedevelopers.onetouchbalance;



/**
 * Created by mufasil on 06-06-2015.
 */

import android.app.Application;

public class GlobalClass extends Application{

    private String mCodecb;
    private String mCodesb;
    private String mCodecc;
    private String mCodedb;



    public String getmCodecb(){
        return mCodecb;
    }
    public void setmCodecb(String gmCodecb){
        mCodecb=gmCodecb;
    }
    public String getmCodesb(){
        return mCodesb;
    }
    public void setmCodesb(String gmCodesb){
        mCodesb=gmCodesb;
    }
    public String getmCodedb(){
        return mCodedb;
    }
    public void setmCodedb(String gmCodedb){
        mCodedb=gmCodedb;
    }
    public String getmCodecc(){
        return mCodecc;
    }
    public void setmCodecc(String gmCodecc){
        mCodecc=gmCodecc;
    }
}
