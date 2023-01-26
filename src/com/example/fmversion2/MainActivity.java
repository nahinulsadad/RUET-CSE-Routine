package com.example.fmversion2;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity 
	implements AdapterView.OnItemSelectedListener
{
	//private EditText etRadiusInput;
	private Button btn;
	private TextView txt;
	private String option;
	
	private static final String[] items = {"A", "B", "C", "D", "E"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//etRadiusInput = (EditText) findViewById(R.id.DayInput);
		btn = (Button) findViewById(R.id.OkButton);
		//txtAreaResult = (TextView) findViewById(R.id.textWarning);
			
		Spinner spin=(Spinner)findViewById(R.id.spinner);
		btn = (Button)findViewById(R.id.OkButton);
		txt = (TextView)findViewById(R.id.textView1);
		
		spin.setOnItemSelectedListener(this);
		
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);
		
		
		btn.setOnClickListener(new OnClickListener()
		{
			

			@Override
			public void onClick(View view) 
			{	
				Intent intent = new Intent(MainActivity.this, MainActivity2.class);
				intent.putExtra("message", option);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						
				finish();
						
				startActivity(intent);
			}
			
		});

	}
	
	public void onItemSelected(AdapterView<?> parent,View v, int position, long id) 
	{
		
		option = items[position];
	}

	public void onNothingSelected(AdapterView<?> parent) 
	{
		//selection.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId()==R.id.help) 
		{
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
		     
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
