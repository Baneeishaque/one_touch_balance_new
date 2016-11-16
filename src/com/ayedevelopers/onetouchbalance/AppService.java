package com.ayedevelopers.onetouchbalance;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.widget.Toast;



/**
 * Created by mufasil on 16-07-2015.
 */
public class AppService extends Service {
    @Override
    public void onCreate() {

        //Global variable declaration
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        TelephonyManager tManager = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        //Get carrier name (Network Operator Name)
        String carrierName = tManager.getNetworkOperatorName();


            //Network&Ussds(if elseif)
            if (carrierName.equals("IDEA") || carrierName.equals("!dea") || carrierName.equals("Idea")) {
                globalVariable.setmCodecb("*" + "121" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "167" + "*" + "01" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "125" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:198");
            } else if (carrierName.equals("Airtel") || carrierName.equals("AIRTEL") || carrierName.equals("airtel") || carrierName.equals("IND airtel") || carrierName.equals("Airtel Kerala") || carrierName.equals("AirTel")) {
                globalVariable.setmCodecb("*" + "123" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "123" + "*" + "7" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "123" + "*" + "10" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:198");


            } else if (carrierName.equals("Vodafone IN") || carrierName.equals("Hutch") || carrierName.equals("Vodafone") || carrierName.equals("VODAFONE")) {
                globalVariable.setmCodecb("*" + "111" + "*" + "2" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "142" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "111" + "*" + "6" + "*" + "2" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:199");

            } else if (carrierName.equals("BSNL") || carrierName.equals("BSNL MOBILE") || carrierName.equals("CellOne") || carrierName.equals("BPL MOBILE") || carrierName.equals("BSNL Mobile")) {
                globalVariable.setmCodecb("*" + "123" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "123" + "*" + "1" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "124" + "*" + "4" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:198");

            } else if (carrierName.equals("Tata Docomo") || carrierName.equals("TATA DOCOMO")) {
                globalVariable.setmCodecb("*" + "111" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "111" + "*" + "1" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "111" + "*" + "1" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:198");

            } else if (carrierName.equals("reliance") || carrierName.equals("Reliance") || carrierName.equals("RELIANCE")) {
                globalVariable.setmCodecb("*" + "367" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "367" + "*" + "2" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "367" + "*" + "3" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:198");

            } else if (carrierName.equals("Aircel") || carrierName.equals("aircel") || carrierName.equals("AIRCEL")) {
                globalVariable.setmCodecb("*" + "125" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "126" + "*" + "2" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "126" + "*" + "1" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:198");

            } else if (carrierName.equals("du") || carrierName.equals("DU") || carrierName.equals("Du")) {
                globalVariable.setmCodecb("*" + "135" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "135" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "135" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:155");

            } else if (carrierName.equals("etisalat") || carrierName.equals("Etisalat") || carrierName.equals("ETISALAT")) {
                globalVariable.setmCodecb("*" + "121" + Uri.encode("#"));
                globalVariable.setmCodesb("*" + "121" + Uri.encode("#"));
                globalVariable.setmCodedb("*" + "170" + Uri.encode("#"));
                globalVariable.setmCodecc("tel:101");

            } else {
                Toast.makeText(this, "Sorry, Network not in db.Please mail us your network details.", Toast.LENGTH_LONG).show();
                globalVariable.setmCodecb("");
                globalVariable.setmCodesb("");
                globalVariable.setmCodedb("");
                globalVariable.setmCodecc("tel:198");

            }
            super.onCreate();

        }

        @Override
        public IBinder onBind (Intent intent){
return null;

    }}
