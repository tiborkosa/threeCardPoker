package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.models.Card;
import main.utils.PlayerUtils;

class PlayerUtilTest {

	// NOTE: testing only for three card poker
	
	@Test
	@DisplayName("Cards should have no pair (1)")
	public void shouldHaveNoPair() throws Exception {
		Card[] cards = {new Card("Ac"),new Card("2s"),new Card("4c")};
	
		Assertions.assertEquals(1, PlayerUtils.countNumberOfSameCards(cards));
	}
	
	@Test
	@DisplayName("Cards should have one pair (2)")
	public void shouldHaveOnePair() throws Exception {
		Card[] cards = {new Card("Ac"),new Card("As"),new Card("4c")};
	
		Assertions.assertEquals(2, PlayerUtils.countNumberOfSameCards(cards));
	}
	
	@Test
	@DisplayName("Cards should have three of a kind (3)")
	public void shouldHaveThreeOfAKind() throws Exception {
		Card[] cards = {new Card("9c"),new Card("9s"),new Card("9c")};
	
		Assertions.assertEquals(3, PlayerUtils.countNumberOfSameCards(cards));
	}
	
	@Test
	@DisplayName("Hand should be flush)")
	public void shouldHaveFlush() throws Exception {
		Card[] cards = {new Card("9c"),new Card("8c"),new Card("Qc")};
	
		Assertions.assertEquals(true, PlayerUtils.checkForFlush(cards));
	}
	
	@Test
	@DisplayName("Hand should not be flush)")
	public void shouldNotHaveFlush() throws Exception {
		Card[] cards = {new Card("9s"),new Card("8s"),new Card("Qc")};
	
		Assertions.assertEquals(false, PlayerUtils.checkForFlush(cards));
	}
	
	@Test
	@DisplayName("Hand should not be straight)")
	public void shouldNotHaveStraight() throws Exception {
		Card[] cards = {new Card("2s"),new Card("4s"),new Card("Ac")};
	
		Assertions.assertEquals(false, PlayerUtils.checkForStraight(cards));
	}
	
	@Test
	@DisplayName("Hand should be straight with Ace and 2)")
	public void shouldBeStraight() throws Exception {
		Card[] cards = {new Card("2s"),new Card("3s"),new Card("Ac")};
	
		Assertions.assertEquals(true, PlayerUtils.checkForStraight(cards));
	}
	
	@Test
	@DisplayName("Hand should be Ace high straight)")
	public void shouldBeAceStraight() throws Exception {
		Card[] cards = {new Card("Qs"),new Card("Ks"),new Card("Ac")};
	
		Assertions.assertEquals(true, PlayerUtils.checkForStraight(cards));
	}
	
	@Test
	@DisplayName("Card string value comparison)")
	public void shouldBeEqualStringValue() throws Exception {
		Card[] c1 = {new Card("Qs"),new Card("Ks"),new Card("Ac")};
		
		Assertions.assertEquals(141.312, PlayerUtils.getDoubleCardValue(c1, false));
	}

}
