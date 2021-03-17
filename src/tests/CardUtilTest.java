package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.exceptions.InvalidCardRankException;
import main.exceptions.InvalidSuitException;
import main.types.CardSuit;
import main.utils.CardUtils;

class CardUtilTest {

	@Test
	@DisplayName("Should return 10 for T")
	public void shouldGetValidRankForTen() throws Exception {
		Assertions.assertEquals(10, CardUtils.getRank('T'));
	}
	
	@Test
	@DisplayName("Should fail for incorect rank of 1")
	public void shouldThrowInvalidCardExceptionForOne() throws Exception {
		Assertions.assertThrows(InvalidCardRankException.class, () -> CardUtils.getRank('1'));
	}
	
	@Test
	@DisplayName("Should return valid card suit for heart")
	public void shouldGetValidSuitForHeart() throws Exception {
		Assertions.assertEquals(CardSuit.HEART, CardUtils.getSuit('h'));
	}
	
	@Test
	@DisplayName("Should fail for incorect suit g")
	public void shouldThrowInvalidSuitExceptionForG() throws Exception {
		Assertions.assertThrows(InvalidSuitException.class, () -> CardUtils.getSuit('g'));
	}
}
