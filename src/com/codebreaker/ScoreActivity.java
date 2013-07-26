package com.codebreaker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.scores);
		//setting the layout

		TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
		CodeBreakerDB info = new CodeBreakerDB(this);
		info.open(); 
		//Opening MasterMind class
		
		String data = info.getData(); 
		//Receiving String
		
		info.close();
		tv.setText(data); 
		//Setting content view to String

		
	}
}