package main.models;

import main.exceptions.InsufficientCardException;
import main.exceptions.TooManyCardsException;
import main.types.RankTypes;
import main.utils.PlayerUtils;

/**
 * 
 * Player class to hold the cards
 * 
 * Implements Comparable interface to determine the better hand
 *
 */
public class Player implements Comparable<Player> {

	// card holder
	private Card[] cards;
	// ranking player hand. See PlayerUtils class or Instruction.md for more
	// information
	private byte handRank;
	// to avoid index out of bounce exception
	private byte numCards;
	public final static byte DEFAULT_NUMBER_OF_CARDS = 3;

	// default constructor
	public Player() {
		this.cards = new Card[DEFAULT_NUMBER_OF_CARDS];
		this.handRank = 0;
		this.numCards = 0;
	}

	public int getHandRank() {
		if (numCards != cards.length)
			throw new InsufficientCardException("Cannot rank hand until all cards are not dealt!");
		return handRank;
	}

	public void addCard(Card card) throws TooManyCardsException {
		if (numCards == cards.length)
			throw new TooManyCardsException("Cannot deal more than " + numCards);

		cards[numCards++] = card;
		if (numCards == cards.length) {
			this.handRank = PlayerUtils.rankHand(this.cards);
		}

	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	@Override
	public int compareTo(Player otherHand) {
		// checking if ranks are not equal and return greater
		if (this.handRank != otherHand.handRank) {
			if (this.handRank > otherHand.handRank)
				return 1;
			if (this.handRank < otherHand.handRank)
				return -1;
		} else {
			switch (this.handRank) {
			case RankTypes.HIGH_CARD: 
			case RankTypes.FLUSH: { 
				// we could use the getDoubleCardValue method but this is faster
				for (int i = this.cards.length - 1; i >= 0; i--) {
					if (this.cards[i].compareTo(otherHand.cards[i]) != 0) {
						return this.cards[i].compareTo(otherHand.cards[i]);
					}
				}
				break;
			}
			case RankTypes.ONE_PAIR: {
				double d1 = PlayerUtils.getDoubleCardValue(this.cards, true);
				double d2 = PlayerUtils.getDoubleCardValue(otherHand.cards, true);

				if (d1 > d2)
					return 1;
				if (d1 < d2)
					return -1;

				break;
			}
			default: // three of a kind, straight, royal flush
				// we can either compare the first or the last
				return this.cards[0].compareTo(otherHand.cards[0]);
			}
		}
		return 0; // the hands must be equal
	}
}
