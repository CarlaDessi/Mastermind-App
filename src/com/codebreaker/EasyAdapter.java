package com.codebreaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class EasyAdapter extends ArrayAdapter<Guess> {


	public EasyAdapter(Context context){  
		super(context, R.layout.easy_list_item);
		//set the layout of each list item
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent){
		View v = convertView;
		if(v==null) {
			LayoutInflater vi = (LayoutInflater)LayoutInflater.from(parent.getContext());
			v=vi.inflate(R.layout.easy_list_item, null);
		}

		ImageView circle1=(ImageView) v.findViewById(R.id.circle1);
		ImageView circle2=(ImageView) v.findViewById(R.id.circle2);
		ImageView circle3=(ImageView) v.findViewById(R.id.circle3);
		//declaring the image views of the circles in each guess in the list item


		Guess item = getItem(pos);
		circle1.setImageResource(item.getColour(0).getImageId());
		circle2.setImageResource(item.getColour(1).getImageId());
		circle3.setImageResource(item.getColour(2).getImageId());
		//getting the colour of the circle from the guess item


		ImageView peg1=(ImageView) v.findViewById(R.id.peg1);
		ImageView peg2=(ImageView) v.findViewById(R.id.peg2);
		ImageView peg3=(ImageView) v.findViewById(R.id.peg3);
		//declaring the image views of the pegs in each guess in the list item


		peg1.setImageResource(R.drawable.scoregrey);
		peg2.setImageResource(R.drawable.scoregrey);	
		peg3.setImageResource(R.drawable.scoregrey);
		//setting the 3 pegs to grey as default


		if (item.whiteCount==1){
			peg1.setImageResource(R.drawable.scorewhite);
		}
		if (item.whiteCount==2){
			peg1.setImageResource(R.drawable.scorewhite);
			peg2.setImageResource(R.drawable.scorewhite);
		}
		if (item.whiteCount==3){
			peg1.setImageResource(R.drawable.scorewhite);
			peg2.setImageResource(R.drawable.scorewhite);
			peg3.setImageResource(R.drawable.scorewhite);
		}

		if (item.blackCount==1){
			peg1.setImageResource(R.drawable.scoreblack);

			if(item.whiteCount==1){
				peg2.setImageResource(R.drawable.scorewhite);

			}

			if(item.whiteCount==2){
				peg2.setImageResource(R.drawable.scorewhite);
				peg3.setImageResource(R.drawable.scorewhite);
			}
			if(item.whiteCount==3){
				peg2.setImageResource(R.drawable.scorewhite);
				peg3.setImageResource(R.drawable.scorewhite);

			}

		}

		if (item.blackCount==2){
			peg1.setImageResource(R.drawable.scoreblack);
			peg2.setImageResource(R.drawable.scoreblack);

			if(item.whiteCount==1){
				peg3.setImageResource(R.drawable.scorewhite);

			}

		}

		if (item.blackCount==3){
			peg1.setImageResource(R.drawable.scoreblack);
			peg2.setImageResource(R.drawable.scoreblack);	
			peg3.setImageResource(R.drawable.scoreblack);

			EasyGame.sendScore(getContext());
			//calls the method sendScore from the EasyGame class (because the right code was guessed)

		}
		if (item.whiteCount==3){
			peg1.setImageResource(R.drawable.scorewhite);
			peg2.setImageResource(R.drawable.scorewhite);	
			peg3.setImageResource(R.drawable.scorewhite);



		}
		//if statements to work out when the pegs should change to black or white

		return v;
	}
}