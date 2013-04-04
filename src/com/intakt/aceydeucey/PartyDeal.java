package com.intakt.aceydeucey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/*
 * this is the main activity for playing the game - no score kept
 * cards are dealt then awaits click
 * then a new activity is started displaying the results
 */
public class PartyDeal extends Activity implements OnClickListener {

	// instance vars
	Card cardLow;
	Card cardHigh;
	Card cardPlayer;

	// view vars
	ImageButton cardSlotLeft;
	ImageButton cardSlotCenter;
	ImageButton cardSlotRight;

	// setup the view. get a new hand. display faceup card. await click.
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayoutgame);

		cardSlotLeft = (ImageButton) findViewById(R.id.gamecardleft);
		cardSlotCenter = (ImageButton) findViewById(R.id.gamecardcenter);
		cardSlotRight = (ImageButton) findViewById(R.id.gamecardright);

		getNewHand();
		displayDeal();
	}

	// display cardplayer. make cards clickable
	private void displayDeal() {
		cardSlotLeft.setImageResource(cardLow.cardImg);
		cardSlotRight.setImageResource(cardHigh.cardImg);
		
		cardSlotLeft.setOnClickListener(this);
		cardSlotCenter.setOnClickListener(this);
		cardSlotRight.setOnClickListener(this);
	}

	// generate three card objects from a list of cards
	private void getNewHand() {
		Card[] myHand = Card.getNewHand(1);
		cardLow = myHand[0];
		cardPlayer = myHand[1];
		cardHigh = myHand[2];
	}

	// start reveal activity. pass it data on card images. finish self.
	public void onClick(View v) {
		Intent reveal = new Intent(this, PartyReveal.class);
		Bundle b = new Bundle();
		b.putInt("cardlow", cardLow.cardImg);
		b.putInt("cardplayer", cardPlayer.cardImg);
		b.putInt("cardhigh", cardHigh.cardImg);
		reveal.putExtras(b);
		startActivity(reveal);
		overridePendingTransition(0, 0);
		finish();

	}

}
