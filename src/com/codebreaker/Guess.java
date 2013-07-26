package com.codebreaker;

import java.util.Arrays;

public class Guess{

	int blackCount;
	int whiteCount;
	//declaring ints for counting the coloured pegs

	@Override
	public String toString() {
		return Arrays.toString(colours) ;
	}
	//putting the colours from the array into a string

	private Colour[] colours;


	public Guess(Colour[] guess, Colour[] solution) {
		super();
		this.colours = guess;

		Colour[] guessCpy = guess.clone();
		Colour[] solutionCpy = solution.clone();
		blackCount = checkCorrect(guessCpy, solutionCpy);
		whiteCount = checkColour(guessCpy, solutionCpy);

	}

	private int checkColour(Colour[] guessCpy, Colour[] solutionCpy) {
		int result = 0;
		for (int i=0; i<solutionCpy.length; i++){
			if(solutionCpy[i]!=null)

			{
				for(int j=0; j<guessCpy.length; j++) {
					if(guessCpy[j]==solutionCpy[i]){
						result++;
						guessCpy[j]=null;
						solutionCpy[i]=null;
						break;

					}
				}		//working out how many of the colours in the guess are right	
			}
		}

		return result;

	}

	public int getBlackCount() {
		return blackCount;
	}

	public int getWhiteCount() {
		return whiteCount;
	}

	private int checkCorrect(Colour[] guessCpy, Colour[] solutionCpy) {
		int result = 0;

		for (int i=0; i<solutionCpy.length; i++){
			if(guessCpy[i]==solutionCpy[i]){
				result++;
				guessCpy[i]=null;
				solutionCpy[i]=null;
			} //working out how many of the colours in the guess are in the right place
		}

		return result;
	}

	public Colour getColour(int i) {
		return colours[i];
	}


}