package com.ayedevelopers.onetouchbalance;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class OTP_MainActivity extends Activity {

	ProgressDialog dialog = null;
	EditText mobile;
	public static String otp;
	public static int SMS_get_status=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.otp_activity_main);
		
		mobile=(EditText)findViewById(R.id.editText1);
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void send_otp(View v)
	{
		//Toast.makeText(getApplicationContext(), SimpleOTPGenerator.random(6), Toast.LENGTH_LONG).show();
		otp=SimpleOTPGenerator.random(6);
		dialog = ProgressDialog.show(this, "", 
                "Sending Message...", true);
		 new Thread(new Runnable() {
			    public void run() {
			    	sign();		
			    	
			    }
			  }).start();
		 
	}
	
	void sign(){
		try{			
			 
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://alotsolutions.in/API/WebSMS/Http/v1.0a/index.php?"
					+ "username=BANEEDEMO&password=BANEEDEMO&sender=TXTMSG&to="+mobile.getText()+"&message="+otp+"&format=text"); // make sure the url is correct.
			
			
			//Execute HTTP Post Request
			// edited by James from coderzheaven.. from here....
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			final String response = httpclient.execute(httppost, responseHandler);
			
			runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(OTP_MainActivity.this,"Response from PHP : " + response,Toast.LENGTH_LONG).show();
					dialog.dismiss();
			    }
			});
			
			if(response.contains("Successfully")){
				runOnUiThread(new Runnable() {
				    

					public void run() {
				    	Toast.makeText(OTP_MainActivity.this,"Message Sended Successfully", Toast.LENGTH_SHORT).show();
				    	dialog.dismiss();
				    	dialog = ProgressDialog.show(OTP_MainActivity.this, "", 
				                "Waiting for Message...", true);
				    	
				    	Runnable r = new Runnable() {
				    	    @Override
				    	    public void run(){
				    	    	Toast.makeText(OTP_MainActivity.this,String.valueOf(SMS_get_status), Toast.LENGTH_SHORT).show();
				    	    	dialog.dismiss();
								
				    	    	if(SMS_get_status==1)
				    	    	{
				    	    		
									Intent target = new Intent(OTP_MainActivity.this,HomeActivity.class);
									startActivity(target);
				    	    		
				    	    	}
				    	    	else
				    	    	{
				    	    		Toast.makeText(OTP_MainActivity.this,"Got Some error,Contact Banee Ishaque K", Toast.LENGTH_SHORT).show();
				    	    	}
				    	    }
				    	};
				    	
				    	Handler h = new Handler();
				    	h.postDelayed(r, 15000);
						
				    	
						
				    	
				    }
				});
				
				
				
			}else{
				runOnUiThread(new Runnable() {
				    public void run() {
				    	dialog.dismiss();
				    	Toast.makeText(OTP_MainActivity.this,"Got Some error,Contact Banee Ishaque K", Toast.LENGTH_SHORT).show();
				    }
				});				
			}
			
		}catch(final Exception e){
			runOnUiThread(new Runnable() {
			    public void run() {
			    	dialog.dismiss();
			    	Toast.makeText(OTP_MainActivity.this,"Exception : " + e.getMessage(),Toast.LENGTH_LONG).show();
					
			    }
			});
			
		}
	}
}
