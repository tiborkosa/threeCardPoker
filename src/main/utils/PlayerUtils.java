package main.utils;

import java.util.Arrays;

import main.models.Card;
import main.types.RankTypes;

/**
 * 
 * Player model helper class
 *
 */
public class PlayerUtils {

	public static byte rankHand(Card[] cards) {

		// sort the cards. NOTE: we implemented the comparable interface to be able to
		// use Arrays.sort
		Arrays.sort(cards);

		// hand rank would be used to compare player hand (cards)

		// no pair 0
		// pair 1;
		// flush 2
		// straight 3
		// three of a kind add 4;
		// straight flush would be 5

		boolean isStraight = checkForStraight(cards);
		boolean isFlush = checkForFlush(cards);
		var numberOfPairs = countNumberOfSameCards(cards);

		if (isStraight && isFlush)
			return RankTypes.ROYAL_FLUSH;
		if (numberOfPairs == 3)
			return RankTypes.THREE_PAIR;
		if (isStraight)
			return RankTypes.STRAIGHT;
		if (isFlush)
			return RankTypes.FLUSH;
		if (numberOfPairs == 2)
			return RankTypes.ONE_PAIR;
		return RankTypes.HIGH_CARD;
	}

	/*
	 * will return the number of pairs possible values with three cards are: 1 - no
	 * pair 2 - one pair 3 - three of a kind
	 */
	public static byte countNumberOfSameCards(Card[] cards) {
		byte pairs = 1;
		// because cards are in sorted order we can just loop through
		var prev = cards[0];
		for (int i = 1; i < cards.length; i++) {
			if (prev.compareTo(cards[i]) == 0) {
				pairs++;
			}
			prev = cards[i];
		}

		return pairs;
	}

	// checking for flush
	public static boolean checkForFlush(Card[] cards) {

		for (int i = 1; i < cards.length; i++) {
			if (cards[0].getSuit() != cards[i].getSuit()) {
				return false;
			}
		}
		return true;
	}

	// checking for straight
	public static boolean checkForStraight(Card[] cards) {

		/*
		 * possible straight 2,3,4 ... 14,2,3 ... 12,13,14 where 14 is Ace
		 */
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getRank() != 14 && cards[i - 1].getRank() != cards[i].getRank() - 1) {
				return false;
			}
		}

		/*
		 * if we get this far we have a possible straight first we have to check the
		 * above cases
		 */

		if (cards[cards.length - 1].getRank() == 14) {
			if (cards[0].getRank() != 2 && cards[cards.length - 2].getRank() != 13) {
				return false;
			}
		}
		return true;
	}

	// we could check the high card and pairs by converting the ranks to double for comparison
	public static Double getDoubleCardValue(Card[] cards, boolean isPair) {
		String concatenatedCardsRank = "";
		if (isPair && cards[0].getRank() == cards[1].getRank()) {
			// we push the high card to the back and pairs to the front
			// the middle in three cards is one of the pair
			concatenatedCardsRank = cards[0].getRank() + "" + cards[1].getRank() + "" + cards[2].getRank();
		} else {
			concatenatedCardsRank = cards[2].getRank() + "" + cards[1].getRank() + "" + cards[0].getRank();
		}

		double d = Double.parseDouble(concatenatedCardsRank);

		if (d > 100000)
			return d / 1000;

		if (d > 10000)
			return d / 100;
		if (d > 1000)
			return d / 10;
		return d;
	}
}
