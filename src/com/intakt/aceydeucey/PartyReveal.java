package com.intakt.aceydeucey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/*
 * activity to display cards resulting from PartyDeal
 */
public class PartyReveal extends Activity implements OnClickListener {

	// view vars
	ImageButton cardSlotLeft;
	ImageButton cardSlotCenter;
	ImageButton cardSlotRight;

	int cardLowLoc;
	int cardPlayerLoc;
	int cardHighLoc;

	// set view. retreive extras and populate vars. reveal solution. await click
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayoutgame);

		Bundle b = getIntent().getExtras();
		cardLowLoc = b.getInt("cardlow", -1);
		cardPlayerLoc = b.getInt("cardplayer", -1);
		cardHighLoc = b.getInt("cardhigh", -1);

		cardSlotLeft = (ImageButton) findViewById(R.id.gamecardleft);
		cardSlotCenter = (ImageButton) findViewById(R.id.gamecardcenter);
		cardSlotRight = (ImageButton) findViewById(R.id.gamecardright);

		displayReveal();
	}

	// reveal solution
	private void displayReveal() {
		cardSlotLeft.setImageResource(cardLowLoc);
		cardSlotCenter.setImageResource(cardPlayerLoc);
		cardSlotRight.setImageResource(cardHighLoc);

		cardSlotLeft.setOnClickListener(this);
		cardSlotCenter.setOnClickListener(this);
		cardSlotRight.setOnClickListener(this);

	}

	// on click start new activity PartyDeal and finish self
	public void onClick(View v) {
		Intent deal = new Intent(this, PartyDeal.class);
		startActivity(deal);
		overridePendingTransition(0, 0);
		Log.i("onClick - SingleDeal", "new activity started, finishing self");
		finish();

	}
}
