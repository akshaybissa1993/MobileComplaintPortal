package com.cmapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Index extends Activity {
	
	Button info,lodge,remind,status,feedback,contact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		
		info = (Button)findViewById(R.id.gen_info);
		lodge = (Button)findViewById(R.id.lod_comp);
		remind = (Button)findViewById(R.id.remind_us);
		status = (Button)findViewById(R.id.com_status);
		feedback = (Button)findViewById(R.id.feedback);
		contact = (Button)findViewById(R.id.contact);
	}	
	
		public void info (View v)
		{
			Intent intent = new Intent(Index.this,Information.class);
            startActivity(intent);
		}
		
		public void lodge (View v)
		{
			Intent intent = new Intent(Index.this,Lodging.class);
            startActivity(intent);
		}
		
		public void remind (View v)
		{
			Intent intent = new Intent(Index.this,Reminder.class);
            startActivity(intent);
		}
		
		public void status (View v)
		{
			Intent intent = new Intent(Index.this,Status.class);
            startActivity(intent);
		}
		
		public void feedback (View v)
		{
			Intent intent = new Intent(Index.this,Feedback.class);
            startActivity(intent);
		}
		
		public void contact (View v)
		{
			Intent intent = new Intent(Index.this,Contact.class);
            startActivity(intent);
		}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

}
