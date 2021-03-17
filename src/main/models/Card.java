package main.models;

import main.types.CardSuit;
import main.utils.CardUtils;

/**
 * 
 * Card class the represents a single card in the deck Implements the Comparable
 * interface for sorting
 *
 */
public class Card implements Comparable<Card> {

	private CardSuit suit;
	private int rank;

	/**
	 * Card constructors that validates the card if card rank or suit is invalid
	 * will throw an Exception (see CardUtils class or Instructions.md for more
	 * information)
	 * 
	 * @param rank represents the card rank or number
	 * @param suit represents the card suit (Diamond, Heart, Spades, Club)
	 * @throws Exception if the card rank or suit is invalid
	 */

	public Card(String cardData) throws Exception {
		if (cardData.length() > 2)
			throw new IllegalStateException("Invalid card data in Card constructor");
		this.suit = CardUtils.getSuit(cardData.charAt(1));
		this.rank = CardUtils.getRank(cardData.charAt(0));
	}

	Card(char rank, char suit) throws Exception {
		this.suit = CardUtils.getSuit(suit);
		this.rank = CardUtils.getRank(rank);
	}

	// getters and setters
	
	public CardSuit getSuit() {
		return suit;
	}

	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Card other) {
		if (this.rank > other.rank)
			return 1;
		if (this.rank < other.rank)
			return -1;
		return 0;
	}
}
