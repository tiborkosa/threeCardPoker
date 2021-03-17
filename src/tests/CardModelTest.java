package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.exceptions.InvalidCardRankException;
import main.exceptions.InvalidSuitException;
import main.models.Card;
import main.types.CardSuit;


class CardModelTest {

	private static main.models.Card card = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		card = new Card("Qc");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		card = null;
	}

	@Test
	@DisplayName("Should create a Card with Club suited")
	public void shouldBeClub() throws Exception {
		Assertions.assertEquals(CardSuit.CLUB, card.getSuit());
	}
	
	@Test
	@DisplayName("Should create a Card with Queen aka 12 ranked")
	public void shouldBeQueen() throws Exception {
		Assertions.assertEquals(12, card.getRank());
	}
	
	
	@Test
	@DisplayName("Should not create a card with invalid rank")
	public void shouldFailForInvalidRank() throws Exception {
		Assertions.assertThrows(InvalidCardRankException.class, () -> new Card("sc"));
	}
	
	@Test
	@DisplayName("Cards should be equal in rank")
	public void shouldHaveEqualRank() throws Exception {
		Card card1 = new Card("2c");
		Card card2 = new Card("2d");
		Assertions.assertEquals(0, card1.compareTo(card2));
	}
	
	@Test
	@DisplayName("Should not create a card with invalid suit")
	public void shouldFailForInvalidSuit() throws Exception {
		Assertions.assertThrows(InvalidSuitException.class, () -> new Card("Qa"));
	}

	@Test
	@DisplayName("Should not create a card with invalid constructor argument")
	public void shouldFailForInvalidConstructorArgument() throws Exception {
		Assertions.assertThrows(IllegalStateException.class, () -> new Card("Qca"));
	}
}
