package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.exceptions.InsufficientCardException;
import main.exceptions.TooManyCardsException;
import main.models.Card;
import main.models.Player;

class PlayerModelTest {

	private static Card card1 = null;
	private static Card card2 = null;
	private static Card card3 = null;
	private static Card card4 = null;
	private static Player player = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		card1 = new Card("2c");
		card2 = new Card("As");
		card3 = new Card("4d");
		card4 = new Card("Jc");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		card1 = null;
		card2 = null;
		card3 = null;
		card4 = null;
		player = null;
	}

	@Test
	@DisplayName("Should throw exception if not enough cards dealt")
	public void shouldFailForHandRank() throws Exception {
		player = new Player();
		Assertions.assertThrows(InsufficientCardException.class, () -> player.getHandRank());
	}

	@Test
	@DisplayName("Should throw exception if too many cards given to player")
	public void shouldFailForTooManyCardsDelt() throws Exception {
		player = new Player();
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card3);
		Assertions.assertThrows(TooManyCardsException.class, () -> player.addCard(card4));
	}

	@Test
	@DisplayName("Should create a default Player instance")
	public void shouldCreateDefaultPlayer() throws Exception {
		player = new Player();
		Assertions.assertEquals(3, player.getCards().length);
	}
	
	@Test
	@DisplayName("Should have a card hand rank 0 (high card)")
	public void shouldHaveZeroHandRank() throws Exception {
		player = new Player();
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card3);
		
		Assertions.assertEquals(0, player.getHandRank());
	}
	
	// CompareTo method is tested in other file because of too many edge cases
	
	

}
