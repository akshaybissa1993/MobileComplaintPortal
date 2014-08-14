package com.cmapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView click;
	ImageButton ebay_btn;
	ProgressBar prgs_bar;
	ConnectionDetector cd;
	Boolean isInternetPresent = false ;
	AlertDialog alertDialog ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cd = new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet(); 
		alertDialog = new AlertDialog.Builder(getBaseContext()).create();
	//	ebay_btn = (ImageButton)findViewById(R.id.imgBtn);
		prgs_bar = (ProgressBar)findViewById(R.id.prgssBar);
		
		 // check for Internet status 
        if (!isInternetPresent) {
        	
        	alertDialog.setTitle("NO Internet Connection");
        	alertDialog.setButton("RETRY", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        	alertDialog.setButton("EXIT", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	System.exit(0);
                }
            });
         
               
         }
        
		Thread t = new Thread(){
	      	public void run() {
        		for(int i=0;i<=100;i++)
        		{
        			prgs_bar.setProgress(i);
        			try{
        				sleep(50);
        				if(i>=100)
		        		{
	        				sleep(1000);
	        				Intent intent = new Intent(MainActivity.this,Index.class);
	        		        startActivity(intent);
		        		}
        			}
        			catch(Exception e){
        			 		}
        		}
	          }
	       };
	    t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}



