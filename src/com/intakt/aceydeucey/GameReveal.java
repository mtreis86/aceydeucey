package com.intakt.aceydeucey;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/*
 * activity to display cards resulting from GameDeal
 */
public class GameReveal extends Activity implements OnClickListener {

	// instance vars
	Bundle extras;

	int cardLow;
	int cardPlayer;
	int cardHigh;

	String currentPlayerName;
	ArrayList<String> playerNames = new ArrayList<String>();
	ArrayList<Integer> playerScores = new ArrayList<Integer>();

	// view vars
	TextView playerName;

	ImageButton cardSlotLeft;
	ImageButton cardSlotCenter;
	ImageButton cardSlotRight;
	Button buttonScores;

	// create the view, retreive extras, set player name, and reveal solution,
	// then await click
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayoutgame);

		extras = getIntent().getExtras();

		playerName = (TextView) findViewById(R.id.gametext);
		cardSlotLeft = (ImageButton) findViewById(R.id.gamecardleft);
		cardSlotLeft.setOnClickListener(this);
		cardSlotCenter = (ImageButton) findViewById(R.id.gamecardcenter);
		cardSlotCenter.setOnClickListener(this);
		cardSlotRight = (ImageButton) findViewById(R.id.gamecardright);
		cardSlotRight.setOnClickListener(this);
		
		buttonScores = (Button) findViewById(R.id.gamebuttonr);
		buttonScores.setBackgroundResource(R.drawable.btn);
		buttonScores.setText("Scores");
		buttonScores.setOnClickListener(this);

		getExtras();
		setPlayerName();
		revealSolution();
	}

	// pull extras from previous activity
	public void getExtras() {
		playerNames = extras.getStringArrayList("playernames");
		playerScores = extras.getIntegerArrayList("playerscores");

		cardLow = extras.getInt("cardlow");
		cardPlayer = extras.getInt("cardplayer");
		cardHigh = extras.getInt("cardhigh");

		currentPlayerName = extras.getString("currentplayer");
	}

	// display player name on top of screen
	private void setPlayerName() {
		Log.i("gamedeal", "starting cleartable");
		playerName.setText(currentPlayerName);
	}

	// display both cards
	public void revealSolution() {
		cardSlotLeft.setImageResource(cardLow);
		cardSlotCenter.setImageResource(cardPlayer);
		cardSlotRight.setImageResource(cardHigh);
	}

	// on click either finish and go back to GameDeal, or start Scores
	public void onClick(View v) {
		if (v.getId() == R.id.gamebuttonr) {
			displayScores();
			finish();
		} else {
			finish();
		}
	}

	// passes data to new activity Scores then finishes self
	public void displayScores() {
		Intent i = new Intent(this, Score.class);
		Bundle extrasToPass = new Bundle();
		extrasToPass.putStringArrayList("playernames", playerNames);
		extrasToPass.putIntegerArrayList("playerscores", playerScores);
		i.putExtras(extrasToPass);
		startActivity(i);
		overridePendingTransition(0, 0);
		finish();
	}

}
