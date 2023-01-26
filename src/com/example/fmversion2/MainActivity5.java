package com.example.fmversion2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends Activity implements OnClickListener
{
	private static final int MENU_One = Menu.FIRST;
    private static final int MENU_Two = Menu.FIRST + 1;
    private static final int MENU_Three = Menu.FIRST + 2;
    private static final int MENU_Four = Menu.FIRST + 3;
    private static final int MENU_Five = Menu.FIRST + 4;
    private static final int MENU_Six = Menu.FIRST + 5;
    
    String day;
	
	private Button[] button = new Button[9];
	
	private String[] course = new String[8];
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		
		button[0] = (Button) findViewById(R.id.button1);
		button[1] = (Button) findViewById(R.id.button2);
		button[2] = (Button) findViewById(R.id.button3);
		button[3] = (Button) findViewById(R.id.button4);
		button[4] = (Button) findViewById(R.id.button5);
		button[5] = (Button) findViewById(R.id.button6);
		button[6] = (Button) findViewById(R.id.button7);
		button[7] = (Button) findViewById(R.id.button8);
		button[8] = (Button) findViewById(R.id.button9);
		
		
		String[] course = new String[9];
		
		                      //01234567890123
		course[0] = new String("CSE 401   BP ");
		course[1] = new String("CSE 405   BA ");
		course[2] = new String("CSE 407   JR ");
		course[3] = new String("MATH 407  MBH");
		course[4] = new String(" EE 403   SA ");
		course[5] = new String("CSE 402 A BP ");
		course[6] = new String("CSE 406 A BA ");
		course[7] = new String("CSE 408   MA ");
		course[8] = new String("EE 404 A  SA ");

		
		for(int i = 0; i<9; i++)
		{
			String courseName = course[i].substring(0,9);
			String teacherName = course[i].substring(10, 13);
			
			button[i].setBottom(Color.parseColor("#000000"));
			button[i].setText(courseName + "\n" + teacherName);
			button[i].setTextSize(25);
			button[i].setBackgroundResource(R.drawable.layers);
	        
			
			button[i].setOnClickListener(this);		
		}
		
		
	
	}
	
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
	
	@Override
	public void onClick(View v) 
	{
		String[] course = new String[9];
		
        //01234567890123
		course[0] = new String("CSE 401   BP ");
		course[1] = new String("CSE 405   BA ");
		course[2] = new String("CSE 407   JR ");
		course[3] = new String("MATH 407  MBH");
		course[4] = new String(" EE 403   SA ");
		course[5] = new String("CSE 402 A BP ");
		course[6] = new String("CSE 406 A BA ");
		course[7] = new String("CSE 408   MA ");
		course[8] = new String("EE 404 A  SA ");
		
		switch (v.getId()) 
		{
	     case R.id.button1:
	    	 Intent intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[0]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;
	      
	     case R.id.button2:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[1]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;
	      
	     case R.id.button3:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[2]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;
	      
	     case R.id.button4:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[3]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;
	      
	     case R.id.button5:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[4]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;

	     case R.id.button6:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[5]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;
	      
	     case R.id.button7:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[6]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;

	     case R.id.button8:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[7]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;
	      
	     case R.id.button9:
	    	 intent = new Intent(MainActivity5.this, NewActivity.class);
			 intent.putExtra("message2", course[8]);
			 intent.putExtra("message", day);
			 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			 finish();
			 startActivity(intent);
	      break;

	  }
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
	
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{

		if(item.getItemId()==MENU_One) 
		{
			Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
		}
		else if(item.getItemId()==MENU_Two)
		{
			Intent intent = new Intent(MainActivity5.this, Next_Activity.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
			
		}
		else if(item.getItemId()==MENU_Three)
		{
			
			
		}
		else if(item.getItemId()==MENU_Four)
		{
			Intent intent = new Intent(MainActivity5.this, MainActivity3.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
		}
		else if(item.getItemId()==MENU_Five)
		{
			Intent intent = new Intent(MainActivity5.this, MainActivity5.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
				
		}
		else if(item.getItemId()==MENU_Six)
		{
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity5.this);
		     
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