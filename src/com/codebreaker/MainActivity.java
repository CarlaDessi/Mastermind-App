package com.codebreaker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

@SuppressLint({ "ResourceAsColor", "ResourceAsColor", "ResourceAsColor", "ResourceAsColor" }) public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final ImageButton easy = (ImageButton) findViewById(R.id.easyButton);
		final ImageButton medium = (ImageButton) findViewById(R.id.mediumButton);
		final ImageButton hard = (ImageButton) findViewById(R.id.hardButton);
		final ImageButton instructions = (ImageButton) findViewById(R.id.instructionButton);
		final ImageButton scores = (ImageButton) findViewById(R.id.scoreButton);
		//declaring image buttons

		easy.setBackgroundColor(android.R.color.transparent);
		medium.setBackgroundColor(android.R.color.transparent);
		hard.setBackgroundColor(android.R.color.transparent);
		instructions.setBackgroundColor(android.R.color.transparent);
		scores.setBackgroundColor(android.R.color.transparent);
		//setting the image buttons to transparent


		easy.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, EasyGame.class);
				startActivity(intent);
			}
		});
		medium.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MediumGame.class);
				startActivity(intent);
			}
		});
		hard.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, HardGame.class);
				startActivity(intent);
			}
		});
		instructions.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, InstructionsActivity.class);
				startActivity(intent);
			}
		});
		scores.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
				startActivity(intent);
			}
		});
		//setting on click listeners to all of the navigation buttons

	}

}
