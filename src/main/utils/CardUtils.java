package main.utils;

import main.exceptions.InvalidCardRankException;
import main.exceptions.InvalidSuitException;
import main.types.CardSuit;

/**
 * 
 * Card model helper class
 *
 */
public class CardUtils {

	/*
		getting the rank of each card
	 	or throw an error if the input is incorrect
	*/
	public static int getRank(char charRank) throws Exception {
		switch (charRank) {

		case 'A':
			return 14;
		case 'K':
			return 13;
		case 'Q':
			return 12;
		case 'J':
			return 11;
		case 'T':
			return 10;
		default:
			// this will either finds the number value of the char
			// or fails to get the number value
			int x;
			try {
				x = Character.getNumericValue(charRank);
				if (x >= 2 && x < 10)
					return x;
				else
					throw new InvalidCardRankException("Card rank is out of range for " + charRank);
			} catch (Error err) {
				throw new InvalidCardRankException("Invalid card rank!", err);
			}
		}
	}

	/*
	 * getting the suit for the card
	 * fails if input is incorrect
	 */
	public static CardSuit getSuit(char charSuit) throws Exception {
		switch (charSuit) {
		case 'h':
			return CardSuit.HEART;
		case 'd':
			return CardSuit.DIMOND;
		case 's':
			return CardSuit.SPADS;
		case 'c':
			return CardSuit.CLUB;
		default:
			throw new InvalidSuitException("Invalid suit for " + charSuit);
		}
	}
}
