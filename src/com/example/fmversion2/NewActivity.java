package com.example.fmversion2;

import android.app.Activity;




import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class NewActivity extends Activity 
{
	private static final int MENU_One = Menu.FIRST;
    private static final int MENU_Two = Menu.FIRST + 1;
    private static final int MENU_Three = Menu.FIRST + 2;
    private static final int MENU_Four = Menu.FIRST + 3;
    private static final int MENU_Five = Menu.FIRST + 4;
    private static final int MENU_Six = Menu.FIRST + 5;

    String day;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
			
        ScrollView sv = new ScrollView(this);
        sv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        
        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        
        ll.setOrientation(1);
        
        sv.addView(ll);
        
        Bundle bundle = getIntent().getExtras();
        day = bundle.getString("message");
        String course = bundle.getString("message2");
        
        String courseName = course.substring(0,9);
		String teacherName = course.substring(10, 13);
        
        ShowClass one = new ShowClass(day);
        ArrayList<String> list = one.teacherClassCalculation(courseName); 
        
        
        TextView even = new TextView(this);
        even.setGravity(Gravity.CENTER);
        even.setText((courseName + "\n" + teacherName));   
        even.setBackgroundResource(R.drawable.cell_shape3);
        even.setTextSize(35);
        even.setTextColor(Color.parseColor("#000000"));
        
        ll.addView(even);
        
        for(int i = 0; i < list.size() ; i++) 
        {
            TextView b = new TextView(this);
            b.setGravity(Gravity.CENTER);
            
            if(i%2==0)
            	b.setBackgroundResource(R.drawable.cell_shape);
            else
            	b.setBackgroundResource(R.drawable.cell_shape2);
            
          
        	   b.setText(list.get(i));
        	   b.setTextSize(25);
        	   b.setTextColor(Color.parseColor("#000000"));
            
            ll.addView(b);
        }
        
        this.setContentView(sv);
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
			Intent intent = new Intent(NewActivity.this, MainActivity2.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
		}
		else if(item.getItemId()==MENU_Two)
		{
			Intent intent = new Intent(NewActivity.this, Next_Activity.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
			
		}
		else if(item.getItemId()==MENU_Three)
		{
			Intent intent = new Intent(NewActivity.this, MainActivity4.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);

			
		}
		else if(item.getItemId()==MENU_Four)
		{
			Intent intent = new Intent(NewActivity.this, MainActivity3.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
		}
		else if(item.getItemId()==MENU_Five)
		{
			Intent intent = new Intent(NewActivity.this, MainActivity5.class);
			intent.putExtra("message", day);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			finish();
			startActivity(intent);
				
		}
		else if(item.getItemId()==MENU_Six)
		{
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NewActivity.this);
		     
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
