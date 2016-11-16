package com.ayedevelopers.onetouchbalance;



import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {



    String mCoderc;
    int backButtonCount;
    EditText medit1;
    String medit;

    private Toolbar toolbar;


    /*private void addShortcut() {
        //Adding shortcut for MainActivity
        //on Home screen
       Intent shortcutIntent = new Intent(getApplicationContext(),MainActivity.class);

        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "My Balance");
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.ic));

        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(addIntent);
   } */

    /**
     * Back button listener.
     * Will close the application if the back button pressed twice.
     */
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press again to exit.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }



    public void rc(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        medit1=null;
        medit1 = (EditText) findViewById(R.id.editText);
        medit=null;
        medit = medit1.getText().toString();
        //String meditn = null;
        String ussdCode = "*" + mCoderc + "*" + medit + Uri.encode("#");

        if (isNullnum(medit)) {
            medit1.setError("Invalid Number");
        }
        else
        {
            intent.setData(Uri.parse("tel:" + ussdCode));
            startActivity(intent);
        }

    }

    private boolean isNullnum(String num) {
        if (num != null && num.length()==0) {
            return true;

        }

        else {
            String rc_pattern="[0-9]+";
            Pattern pattern=Pattern.compile(rc_pattern);
            Matcher matcher=pattern.matcher(num);
            return !matcher.matches();
           // return false;
        }
    }


    public void widget(View v){
        startActivity(new Intent(MainActivity.this,HelpActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bg

        //getWindow().setBackgroundDrawableResource(R.drawable.bgg) ;
        //AdMob
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call

        //Global variable declaration
        final GlobalClass globalVariable = (GlobalClass)getApplicationContext();


        /*//Buttons
        Button call=(Button) findViewById(R.id.callbut);
        Button sms=(Button) findViewById(R.id.smsbut);
        Button data = (Button) findViewById(R.id.databut);
        Button care = (Button) findViewById(R.id.splbut);*/
        
        //imageview network logo
        ImageView img= (ImageView) findViewById(R.id.carrierLogo);
        //Get System TELEPHONY service reference
        TelephonyManager tManager = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

        //Get carrier name (Network Operator Name)
        String carrierName = tManager.getNetworkOperatorName();
        //Toast network selection
        Context context = getApplicationContext();
        CharSequence text = carrierName + " network detected.";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        //Get country
        //*String countryCode = tManager.getSimCountryIso();





        /**Carrier name on Textview
        TextView carrierView = (TextView)findViewById(R.id.carrierView);
        carrierView.setText(carrierName);
         */

        //Network&Ussds(if elseif)
        if(carrierName.equals("IDEA")||carrierName.equals("!dea")||carrierName.equals("Idea")){
        globalVariable.setmCodecb("*" + "121" + Uri.encode("#"));
        globalVariable.setmCodesb("*" + "167" +"*"+"01"+ Uri.encode("#"));
        globalVariable.setmCodedb("*" + "125" + Uri.encode("#"));
        globalVariable.setmCodecc("tel:198");
        mCoderc="457";
        img.setImageResource(R.drawable.idea);
        }

        else if (carrierName.equals("Airtel")||carrierName.equals("AIRTEL")||carrierName.equals("airtel")||carrierName.equals("IND airtel")||carrierName.equals("Airtel Kerala")||carrierName.equals("AirTel")) {
            globalVariable.setmCodecb("*" + "123" + Uri.encode("#"));
            globalVariable.setmCodesb( "*" + "123" + "*" + "7" +Uri.encode("#"));
            globalVariable.setmCodedb("*" + "123" + "*" + "10" +Uri.encode("#"));
            globalVariable.setmCodecc("tel:198");
            mCoderc="101";
            img.setImageResource(R.drawable.airtel);

        }
        else if (carrierName.equals("Vodafone IN")||carrierName.equals("Hutch")||carrierName.equals("Vodafone")||carrierName.equals("VODAFONE")){
            globalVariable.setmCodecb("*" + "111" + "*" + "2" + Uri.encode("#"));
            globalVariable.setmCodesb( "*" + "142" + Uri.encode("#"));
            globalVariable.setmCodedb("*" + "111" + "*" + "6" + "*" + "2" + Uri.encode("#"));
            globalVariable.setmCodecc("tel:199");
            mCoderc="140";
            img.setImageResource(R.drawable.vodafone);
        }
        else if (carrierName.equals("BSNL")||carrierName.equals("BSNL MOBILE")||carrierName.equals("CellOne")||carrierName.equals("BPL MOBILE")||carrierName.equals("BSNL Mobile")){
            globalVariable.setmCodecb("*" + "123" + Uri.encode("#"));
            globalVariable.setmCodesb("*" + "123" + "*" + "1" +Uri.encode("#"));
            globalVariable.setmCodedb("*" + "124" + "*" + "4" +Uri.encode("#"));
            globalVariable.setmCodecc("tel:198");
            mCoderc="123";
            img.setImageResource(R.drawable.bsnl);
        }
        else if (carrierName.equals("Tata Docomo")||carrierName.equals("TATA DOCOMO")){
            globalVariable.setmCodecb("*" + "111" + Uri.encode("#"));
            globalVariable.setmCodesb("*" + "111" + "*" + "1" +Uri.encode("#"));
            globalVariable.setmCodedb("*" + "111" + "*" + "1" + Uri.encode("#"));
            globalVariable.setmCodecc("tel:198");
            mCoderc="135"+"*"+"2";
            img.setImageResource(R.drawable.docomo);
        }
        else if (carrierName.equals("reliance")||carrierName.equals("Reliance")||carrierName.equals("RELIANCE")){
            globalVariable.setmCodecb("*" + "367" + Uri.encode("#"));
            globalVariable.setmCodesb("*" + "367" + "*" + "2" +Uri.encode("#"));
            globalVariable.setmCodedb("*" + "367" + "*" + "3" + Uri.encode("#"));
            globalVariable.setmCodecc("tel:198");
            mCoderc="368";
            img.setImageResource(R.drawable.reliance);
        }

        else if(carrierName.equals("Aircel")||carrierName.equals("aircel")||carrierName.equals("AIRCEL")){
            globalVariable.setmCodecb("*" + "125" + Uri.encode("#"));
            globalVariable.setmCodesb("*" + "126" + "*" + "2" +Uri.encode("#"));
            globalVariable.setmCodedb("*" + "126" + "*" + "1" + Uri.encode("#"));
            globalVariable.setmCodecc("tel:198");
            mCoderc="124";
            img.setImageResource(R.drawable.aircel);
        }

       else if (carrierName.equals("du")||carrierName.equals("DU")||carrierName.equals("Du")){
            globalVariable.setmCodecb("*" + "135" + Uri.encode("#"));
            globalVariable.setmCodesb("*" + "135" + Uri.encode("#"));
            globalVariable.setmCodedb("*" + "135" + Uri.encode("#"));
            globalVariable.setmCodecc("tel:155");
            mCoderc ="135";
            img.setImageResource(R.drawable.du);
        }
        else if (carrierName.equals("etisalat")||carrierName.equals("Etisalat")||carrierName.equals("ETISALAT")){
            globalVariable.setmCodecb("*" + "121" + Uri.encode("#"));
            globalVariable.setmCodesb("*" + "121" + Uri.encode("#"));
            globalVariable.setmCodedb("*" + "170" + Uri.encode("#"));
            globalVariable.setmCodecc("tel:101");
            mCoderc="121";
            img.setImageResource(R.drawable.ets);
        }
        else{
            Toast.makeText(this, "Check your Network Coverage and Close & Restart the application and widget.", Toast.LENGTH_LONG).show();
            globalVariable.setmCodecb("");
            globalVariable.setmCodesb("");
            globalVariable.setmCodedb("");
            globalVariable.setmCodecc("tel:198");
            mCoderc = "";
            img.setImageResource(R.drawable.blnk);
        }

      /*  //Buttons onClick
        call.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String ussdCode = globalVariable.getmCodecb();
                intent.setData(Uri.parse("tel:" + ussdCode));
                startActivity(intent);
            }
        });
        sms.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_CALL);
                String ussdCode = globalVariable.getmCodesb();
                intent.setData(Uri.parse("tel:" + ussdCode));
                startActivity(intent);
            }

        });

        data.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_CALL);
                String ussdCode = globalVariable.getmCodedb();
                intent.setData(Uri.parse("tel:" + ussdCode));
                startActivity(intent);
            }

        });

        care.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String Customercare = globalVariable.getmCodecc();
                callIntent.setData(Uri.parse(Customercare));
                startActivity(callIntent);
            }

        });*/





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_help,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(MainActivity.this,SecActivity.class));


        }
        if (id == R.id.action_help) {
            startActivity(new Intent(MainActivity.this,HelpActivity.class));


        }

        return super.onOptionsItemSelected(item);
    }
}
