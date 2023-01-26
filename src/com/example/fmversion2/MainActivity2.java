package com.example.fmversion2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity2 extends Activity 
{
	private static final int MENU_One = Menu.FIRST;
    private static final int MENU_Two = Menu.FIRST + 1;
    private static final int MENU_Three = Menu.FIRST + 2;
    private static final int MENU_Four = Menu.FIRST + 3;
    private static final int MENU_Five = Menu.FIRST + 4;
    private static final int MENU_Six = Menu.FIRST + 5;
    
    ArrayList<String> notificationString = new ArrayList<String>(Arrays.asList(" "));
    
	private TextView showString;
	private TextView timerValue;
	String day="";

	private Handler customHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nextactivity_main);

		timerValue = (TextView) findViewById(R.id.timerValue);
		
		customHandler.postDelayed(updateTimerThread, 0);
	}
	
	@Override
    public boolean onPrepareOptionsMenu(Menu menu) 
    {
        menu.clear();
    
        menu.add(0, MENU_One, Menu.NONE, R.string.A);
        
        Bundle bundle = getIntent().getExtras();
        day = bundle.getString("message");
        
        if(day.equals("A"))
            menu.add(0, MENU_Two, Menu.NONE, R.string.B_1);
        else if(day.equals("B"))
        	menu.add(0, MENU_Two, Menu.NONE, R.string.B_2);
        else if(day.equals("C"))
        	menu.add(0, MENU_Two, Menu.NONE, R.string.B_3);
        else if(day.equals("D"))
        	menu.add(0, MENU_Two, Menu.NONE, R.string.B_4);
        else if(day.equals("E"))
        	menu.add(0, MENU_Two, Menu.NONE, R.string.B_5);
        
        menu.add(0, MENU_Three, Menu.NONE, R.string.C);
        menu.add(0, MENU_Four, Menu.NONE, R.string.D);
        menu.add(0, MENU_Five, Menu.NONE, R.string.E);
        menu.add(0, MENU_Six, Menu.NONE, R.string.F);
        
        return super.onPrepareOptionsMenu(menu);
    }


	private Runnable updateTimerThread = new Runnable() {

		public void run() 
		{
			Bundle bundle = getIntent().getExtras();
	        day = bundle.getString("message");
	        
			ShowClass c = new ShowClass(day);
			
			String displayString = c.nowClassCalulation();
			SpannableString ss1 = new SpannableString(displayString);
			
			
			String result = c.timeRemaining();			
			
			SpannableString ss2=  new SpannableString(result);
			ss2.setSpan(new RelativeSizeSpan(1.5f), 0, 8, 0); // set size
			
			SpannableString space = new SpannableString("\n");
			Spanned total =(Spanned) TextUtils.concat(ss1, space, ss2);
			
			String sample = new String(displayString);
			
			if(sample.charAt(0)!='N')
			{
			
				String temp = new String(sample.substring(15));
				
				StringBuilder builder = new StringBuilder(temp.length());
				
				for(int i=0; i<temp.length(); i++)
			    {
					if(temp.charAt(i)=='\n')
				        builder.append(' ');
					else
						builder.append(temp.charAt(i));
			    }
				
				String ok2=new String(builder.toString());
				String str1= new String(notificationString.get(0));
				
				if(str1.compareTo(ok2)!=0)
				{
					notificationString.remove(0);
					notificationString.add(ok2);
					
					showNotification();
				}
				
		   }
			else
			{
				String ok2=new String(sample);
				String str1= new String(notificationString.get(0));
				
				if(str1.compareTo(ok2)!=0)
				{
					notificationString.remove(0);
					notificationString.add(ok2);
				}
				
			}
			
			
			
			timerValue.setGravity(Gravity.CENTER);
			timerValue.setTextSize(30);
			
			
			timerValue.setText(total);
			
			customHandler.postDelayed(this, 1000);
		}
	};
	
	public void showNotification(){
		
		Bundle bundle = getIntent().getExtras();
	    String day = bundle.getString("message");
		
	    ArrayList<String> title = new ArrayList<String>(); 
	    String temp = new String(notificationString.get(0).substring(0,6));
	    
	    if(temp.compareTo(" Break")==0)
	    {
	    	title.clear();
	    	title.add("Break is started");
	    }
	    else
	    {
	    	title.clear();
	    	title.add("Class is started");
	    }
	    	
	    
	    Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
		intent.putExtra("message", day);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(),
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

		
		Notification mNotification = new Notification.Builder(this)
												.setContentTitle(title.get(0))
												.setContentText(notificationString.get(0))
												.setSmallIcon(R.drawable.ic_launcher)
												.setContentIntent(pIntent)
												.setSound(soundUri)
												.build();
		
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(0, mNotification);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main2, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		
		if(item.getItemId()==MENU_One) 
		{
			
		}
		else if(item.getItemId()==MENU_Two)
		{
			Intent intent = new Intent(MainActivity2.this, Next_Activity.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			//finish();
			startActivity(intent);
			
		}
		else if(item.getItemId()==MENU_Three)
		{
			Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			//finish();
			startActivity(intent);

		}
		else if(item.getItemId()==MENU_Four)
		{
			Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			//finish();
			startActivity(intent);
		}
		else if(item.getItemId()==MENU_Five)
		{
			Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			//finish();
			startActivity(intent);
				
		}
		else if(item.getItemId()==MENU_Six)
		{
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity2.this);
		     
			 alertDialogBuilder.setTitle("About");
			 alertDialogBuilder.setMessage("Developed By"+"\n"+"Nahin Ul Sadat (123063)"+"\n"+"RUET CSE '12");
			 
			 alertDialogBuilder.setNegativeButton("OK",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) 
					{
						dialog.cancel();
					}
				});
			 
			 
			 AlertDialog alertDialog = alertDialogBuilder.create();	
			 alertDialog.show();
		}

		return super.onOptionsItemSelected(item);
	}
}