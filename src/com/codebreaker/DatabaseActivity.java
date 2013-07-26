package com.codebreaker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatabaseActivity extends Activity implements OnClickListener{

	Button enterScore;
	EditText sqlName;
	TextView sqlScore;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entername);

		enterScore =(Button) findViewById(R.id.enterScore);
		sqlName=(EditText) findViewById(R.id.etSQLName);
		sqlScore=(TextView) findViewById(R.id.etSQLScore);

		Intent sender = getIntent();
		int pScore = sender.getExtras().getInt("score");
		String yScore = Integer.toString(pScore);
		sqlScore.setText(yScore);


		enterScore.setOnClickListener(this);
	}

	public void onClick(View arg0) {

		switch (arg0.getId()){ // Determining which button is pressed
		case R.id.enterScore: //Clicking update
			boolean scoreWork = true;
			try{
				String name = sqlName.getText().toString();
				String score = sqlScore.getText().toString();

				CodeBreakerDB entry = new CodeBreakerDB(DatabaseActivity.this); //Creating a new instance of MasterMind game
				entry.open();
				entry.createScoreEntry(name, score); //Passing both strings
				entry.close();

			}
			catch (Exception e){

				scoreWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Error");
				TextView tv = new TextView(this);
				d.setContentView(tv);
				d.show(); //display dialog


			}
			finally {
				if (scoreWork){
					Intent intent = new Intent(DatabaseActivity.this, ScoreActivity.class);
					startActivity(intent);

				}

			}

			break;

		}
	}
}