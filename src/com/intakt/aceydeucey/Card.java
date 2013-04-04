package com.intakt.aceydeucey;

import java.util.Random;

import android.util.Log;

/*
 * this is for creating cards. cards have value 1-13 for twos through aces. aces are always high
 * use newHand to deal cards as it compares the two to ensure only one instance of card per hand
 * returns a card list of card objects
*/
public class Card {

	//static vars
	private static final Random randgen = new Random();
	
	//instance vars
	public int cardNum;
	public int cardVal;
	public int cardImg;
	
	//constructor - input as number of decks to pull cards out of
	public Card(int numDecks) {
		this.cardNum = randgen.nextInt(numDecks*52);
		this.cardVal = setCardVal(this);
		this.cardImg = setCardImg(this);
	}
	
	//checks to see if the cards are the same one return card to redeal if fails. return -1 if passes
	private static int areCardsLegit(Card[] cards) {
		if (cards[0].cardNum == cards[1].cardNum) return 1;
		if (cards[0].cardNum == cards[2].cardNum) return 2;
		if (cards[1].cardNum == cards[2].cardNum) return 2;
		else return -1;
	}
	
	//get a new hand
	public static Card[] getNewHand(int numDecks) {
		//generate three cards
		Card card1 = new Card(numDecks);
		Card card2 = new Card(numDecks);
		Card card3 = new Card(numDecks);
		
		Card[] cards = {card1,card2,card3};
		
		// if one cards is the same number within the deck, get a new card	
		while (areCardsLegit(cards) != -1) {
			Log.i("card", "cards match. redealing");
			if (areCardsLegit(cards) == 1) card2 = new Card(numDecks);
			if (areCardsLegit(cards) == 2) card3 = new Card(numDecks);
			cards = new Card[] {card1,card2,card3};
		}
		
		if (card3.cardVal < card1.cardVal) cards = new Card[] {card3,card2,card1};
		if (card1.cardVal < card3.cardVal) cards = new Card[] {card1,card2,card3};
		
		Log.i("card", "dealing cards: " + card1.cardVal + ", " + card2.cardVal + ", " + card3.cardVal);
		return cards;
	}
	
	//returns card value 1-13 regardless of number of decks involved - eg all 2's within 300 decks would have a value 1
	private int setCardVal(Card myCard) {
		int cardNumb = myCard.cardNum;
		while ((cardNumb / 52.0) > 1.0) {
			cardNumb = cardNumb-52;
		}
		cardNumb = cardNumb/4;
		return (cardNumb+2);
	}
	
	//return integer location for the image of each card based on its number within a deck. if failure returns -1
	private int setCardImg(Card myCard) {
		int cardLoc = -1;
		int cardNumber = myCard.cardNum;
		Log.i("getCardImg", "myCard num is "+ cardNumber);
		switch(cardNumber) {
			case 0: cardLoc = R.drawable.clubs_2;
				break;
			case 1: cardLoc = R.drawable.diamonds_2;
				break;
			case 2: cardLoc = R.drawable.hearts_2;
				break;
			case 3: cardLoc = R.drawable.spades_2;
				break;
			case 4: cardLoc = R.drawable.clubs_3;
				break;
			case 5: cardLoc = R.drawable.diamonds_3;
				break;
			case 6: cardLoc = R.drawable.hearts_3;
				break;
			case 7: cardLoc = R.drawable.spades_3;
				break;
			case 8: cardLoc = R.drawable.clubs_4;
				break;
			case 9: cardLoc = R.drawable.diamonds_4;
				break;
			case 10: cardLoc = R.drawable.hearts_4;
				break;
			case 11: cardLoc = R.drawable.spades_4;
				break;
			case 12: cardLoc = R.drawable.clubs_5;
				break;
			case 13: cardLoc = R.drawable.diamonds_5;
				break;
			case 14: cardLoc = R.drawable.hearts_5;
				break;
			case 15: cardLoc = R.drawable.spades_5;
				break;
			case 16: cardLoc = R.drawable.clubs_6;
				break;
			case 17: cardLoc = R.drawable.diamonds_6;
				break;
			case 18: cardLoc = R.drawable.hearts_6;
				break;
			case 19: cardLoc = R.drawable.spades_6;
				break;
			case 20: cardLoc = R.drawable.clubs_7;
				break;
			case 21: cardLoc = R.drawable.diamonds_7;
				break;
			case 22: cardLoc = R.drawable.hearts_7;
				break;
			case 23: cardLoc = R.drawable.spades_7;
				break;
			case 24: cardLoc = R.drawable.clubs_8;
				break;
			case 25: cardLoc = R.drawable.diamonds_8;
				break;
			case 26: cardLoc = R.drawable.hearts_8;
				break;
			case 27: cardLoc = R.drawable.spades_8;
				break;
			case 28: cardLoc = R.drawable.clubs_9;
				break;
			case 29: cardLoc = R.drawable.diamonds_9;
				break;
			case 30: cardLoc = R.drawable.hearts_9;
				break;
			case 31: cardLoc = R.drawable.spades_9;
				break;
			case 32: cardLoc = R.drawable.clubs_10;
				break;
			case 33: cardLoc = R.drawable.diamonds_10;
				break;
			case 34: cardLoc = R.drawable.hearts_10;
				break;
			case 35: cardLoc = R.drawable.spades_10;
				break;
			case 36: cardLoc = R.drawable.clubs_j;
				break;
			case 37: cardLoc = R.drawable.diamonds_j;
				break;
			case 38: cardLoc = R.drawable.hearts_j;
				break;
			case 39: cardLoc = R.drawable.spades_j;
				break;
			case 40: cardLoc = R.drawable.clubs_q;
				break;
			case 41: cardLoc = R.drawable.diamonds_q;
				break;
			case 42: cardLoc = R.drawable.hearts_q;
				break;
			case 43: cardLoc = R.drawable.spades_q;
				break;
			case 44: cardLoc = R.drawable.clubs_k;
				break;
			case 45: cardLoc = R.drawable.diamonds_k;
				break;
			case 46: cardLoc = R.drawable.hearts_k;
				break;
			case 47: cardLoc = R.drawable.spades_k;
				break;
			case 48: cardLoc = R.drawable.clubs_a;
				break;
			case 49: cardLoc = R.drawable.diamonds_a;
				break;
			case 50: cardLoc = R.drawable.hearts_a;
				break;
			case 51: cardLoc = R.drawable.spades_a;
				break;
		}
		return cardLoc;
	}

}
