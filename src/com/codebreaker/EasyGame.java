/**
 * CodeBreaker by Carla Dessi, 15/01/2012
 * The aim of the game is to work out a randomly generated colour code
 * There are 3 different difficulties easy, medium or hard which include solving a three digit code,
 * four digit code or five digit code.
 * The black pegs show the user when a guess has a right colour in the right place and the white ones show
 * when there is a right colour in the wrong place.
 */


package com.codebreaker;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class EasyGame extends Activity implements OnClickListener, OnKeyListener {

	//initialising the counters
	public int buttonCount = 1;
	public int guessCount = 0;
	public static int scoreCount = 13;

	private Colour[] solution;

	//initialising the guesses in the colour class
	public Colour guess1;
	public Colour guess2;
	public Colour guess3;

	//initialising the empty images
	public ImageView empty1;
	public ImageView empty2;
	public ImageView empty3;

	//inititalising the strings
	public String listitem;
	public String answer;

	//initialising the answers in the colour class
	public Colour answer1;
	public Colour answer2;
	public Colour answer3;

	//initialising the array adapter & list view
	public ArrayAdapter<Guess> mAdapter;
	public ArrayList<Guess> mStrings = new ArrayList<Guess>();
	private ListView listView;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.easy_game);
		//setting the layout

		randomSolution();
		//calling the random Solution method

		final ImageButton yellow = (ImageButton) findViewById(R.id.buttonYellow);  
		final ImageButton red = (ImageButton) findViewById(R.id.buttonRed); 
		final ImageButton green = (ImageButton) findViewById(R.id.buttonGreen);
		final ImageButton blue = (ImageButton) findViewById(R.id.buttonBlue);  
		final ImageButton pink = (ImageButton) findViewById(R.id.buttonPink); 
		final ImageButton orange = (ImageButton) findViewById(R.id.buttonOrange); 
		//declaring the colour buttons from the layout

		final Button clear = (Button) findViewById(R.id.ClearButton); 
		final Button guess = (Button) findViewById(R.id.GuessButton); 
		//declaring the guess & clear buttons from the layout

		yellow.setBackgroundColor(android.R.color.transparent);
		red.setBackgroundColor(android.R.color.transparent);
		green.setBackgroundColor(android.R.color.transparent);
		blue.setBackgroundColor(android.R.color.transparent);
		pink.setBackgroundColor(android.R.color.transparent);
		orange.setBackgroundColor(android.R.color.transparent);
		//setting the background of the colour buttons to transparent


		empty1 = (ImageView) findViewById(R.id.empty1);
		empty2 = (ImageView) findViewById(R.id.empty2);
		empty3 = (ImageView) findViewById(R.id.empty3);
		//linking the declared image view to the name

		mAdapter = new EasyAdapter(this);
		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(mAdapter);
		//linking the adapter


		yellow.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   

				switch (buttonCount) {
				case 1:  
					empty1.setImageResource(R.drawable.yellow);
					buttonCount++;
					guess1= Colour.YELLOW;
					break;
				case 2:  
					empty2.setImageResource(R.drawable.yellow);
					buttonCount++;
					guess2=Colour.YELLOW;
					break;
				case 3:  
					empty3.setImageResource(R.drawable.yellow);
					buttonCount++;
					guess3=Colour.YELLOW;
					break;

				}
			}
		});

		red.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   

				switch (buttonCount) {
				case 1:  
					empty1.setImageResource(R.drawable.red);
					buttonCount++;
					guess1=Colour.RED;
					break;
				case 2:  
					empty2.setImageResource(R.drawable.red);
					buttonCount++;
					guess2=Colour.RED;
					break;
				case 3:  
					empty3.setImageResource(R.drawable.red);
					buttonCount++;
					guess3=Colour.RED;
					break;

				}
			}
		});

		green.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {

				switch (buttonCount) {
				case 1:  
					empty1.setImageResource(R.drawable.green);
					buttonCount++;
					guess1=Colour.GREEN;
					break;
				case 2:  
					empty2.setImageResource(R.drawable.green);
					buttonCount++;
					guess2=Colour.GREEN;
					break;
				case 3:  
					empty3.setImageResource(R.drawable.green);
					buttonCount++;
					guess3=Colour.GREEN;
					break;

				}
			}
		});

		blue.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   

				switch (buttonCount) {
				case 1:  
					empty1.setImageResource(R.drawable.blue);
					buttonCount++;
					guess1=Colour.BLUE;
					break;
				case 2:  
					empty2.setImageResource(R.drawable.blue);
					buttonCount++;
					guess2=Colour.BLUE;
					break;
				case 3:  
					empty3.setImageResource(R.drawable.blue);
					buttonCount++;
					guess3=Colour.BLUE;
					break;

				}
			}
		});

		pink.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   

				switch (buttonCount) {
				case 1:  
					empty1.setImageResource(R.drawable.pink);
					buttonCount++;
					guess1=Colour.PINK;
					break;
				case 2:  
					empty2.setImageResource(R.drawable.pink);
					buttonCount++;
					guess2=Colour.PINK;
					break;
				case 3:  
					empty3.setImageResource(R.drawable.pink);
					buttonCount++;
					guess3=Colour.PINK;
					break;

				}
			}
		});

		orange.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   

				switch (buttonCount) {
				case 1:  
					empty1.setImageResource(R.drawable.orange);
					buttonCount++;
					guess1=Colour.ORANGE;
					break;
				case 2:  
					empty2.setImageResource(R.drawable.orange);
					buttonCount++;
					guess2=Colour.ORANGE;
					break;
				case 3:  
					empty3.setImageResource(R.drawable.orange);
					buttonCount++;
					guess3=Colour.ORANGE;
					break;

				}
			}
		});

		/*switch statements in the on click listeners for each colour button, changing the empty image to the
		 * corresponding colour, also making it move on to the next circle by using the button counter.
		 */

		clear.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   

				resetGuess();

			}

		});
		//onclick listener for the clear button, calling the reset guess method

		guess.setOnClickListener(new View.OnClickListener() {    
			public void onClick (View v)   {   


				sendGuess();
				resetGuess();

				guessCount++;
				scoreCount = scoreCount-1;

			}

		});
		/*onclick listener for the guess button, calling the send guess method & reset guess method, 
		 * adding one to the guess counter to work out when to stop the game,
		 * minusing one from the score count to work out the final score
		 */


	}

	public void onClick(View v) {

		sendGuess();

	}

	//calling the send guess method



	public void sendGuess() {

		if (guess3==null){
			Toast toast=Toast.makeText(this, "Please Enter A Guess", Toast.LENGTH_SHORT);  
			toast.show();
			//so the guess has to be full
		}

		else {
			Guess guess = new Guess (new Colour[] {guess1, guess2, guess3}, solution);
			mAdapter.add(guess);
			//adding the guess to the guess adapter

			AlertDialog.Builder loseDialog = new AlertDialog.Builder(this);
			loseDialog.setTitle("Game Over")
			.setMessage("Do you want to play again ?")
			.setCancelable(false)
			.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent intent = new Intent(EasyGame.this, EasyGame.class);
					startActivity(intent);
				}
			})
			.setNegativeButton("Main Menu", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					EasyGame.this.finish();
				}
			});
			//creating a lose dialog for when the maximum amount of guesses have been entered

			AlertDialog lose = loseDialog.create();

			if(guessCount==13){

				lose.show();

			}
			//executing the lose dialog if the guess count is 13

		}


		guess1=null;
		guess2=null;
		guess3=null;
		//resetting the guesses
	}


	public void resetGuess() {

		empty1.setImageResource(R.drawable.empty);
		empty2.setImageResource(R.drawable.empty);
		empty3.setImageResource(R.drawable.empty);

		buttonCount=1;

		guess1=null;
		guess2=null;
		guess3=null;
		// so the guess doesn't automatically repeat if you press guess without entering a new guess

	}	

	public static void sendScore(Context c) {
		Intent it = new Intent(c,DatabaseActivity.class);
		it.putExtra("score", scoreCount);
		scoreCount=13;
		c.startActivity(it);
		//sending the score to the database
	}

	private void randomSolution() {
		Random code = new Random();
		Colour[] colours = Colour.values();
		//creating a random solution from the colours

		solution = new Colour[] { 
				colours[code.nextInt(colours.length)],
				colours[code.nextInt(colours.length)],
				colours[code.nextInt(colours.length)]
		};
		//storing the solution in an array
	}

	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_CENTER:
			case KeyEvent.KEYCODE_ENTER:
				sendGuess();
				return true;
			}
		}
		return false;
	}


}
