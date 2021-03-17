package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.models.Card;
import main.models.Player;

class PlayerModeCompareToTest {
	
	// high card
	@Test
	@DisplayName("Hands should be equal")
	public void shouldHandsBeEqual() throws Exception {
		Player player = new Player();
		player.addCard(new Card("2c"));
		player.addCard(new Card("As"));
		player.addCard(new Card("4d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Ac"));
		otherPlayer.addCard(new Card("2s"));
		otherPlayer.addCard(new Card("4c"));
		
		Assertions.assertEquals(0, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("Player one hand should be stronger than player two")
	public void shouldPlayerOneBeatsPlayerTwo() throws Exception {
		Player player = new Player();
		player.addCard(new Card("2c"));
		player.addCard(new Card("As"));
		player.addCard(new Card("4d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Kc"));
		otherPlayer.addCard(new Card("2s"));
		otherPlayer.addCard(new Card("4c"));
		
		Assertions.assertEquals(1, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("Player two hand should be stronger than player one")
	public void shouldPlayerTwoBeatsPlayerOne() throws Exception {
		Player player = new Player();
		player.addCard(new Card("2c"));
		player.addCard(new Card("As"));
		player.addCard(new Card("4d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Ac"));
		otherPlayer.addCard(new Card("2s"));
		otherPlayer.addCard(new Card("Jc"));
		
		Assertions.assertEquals(-1, player.compareTo(otherPlayer));
	}
	
	// straight test
	@Test
	@DisplayName("Player one hand should beat other straight")
	public void shouldPlayerOneBeatOtherStraight() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("Ts"));
		player.addCard(new Card("9d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Ac"));
		otherPlayer.addCard(new Card("2s"));
		otherPlayer.addCard(new Card("3c"));
		
		Assertions.assertEquals(1, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("Both straights and equal")
	public void shouldBothStraightsBeEqual() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("Ts"));
		player.addCard(new Card("9d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Tc"));
		otherPlayer.addCard(new Card("9s"));
		otherPlayer.addCard(new Card("8c"));
		
		Assertions.assertEquals(0, player.compareTo(otherPlayer));
	}
	
	// triples
	@Test
	@DisplayName("Both triples should be equal")
	public void shouldBothTriplesBeEqual() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("8s"));
		player.addCard(new Card("8d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("8d"));
		otherPlayer.addCard(new Card("8c"));
		otherPlayer.addCard(new Card("8c"));
		Assertions.assertEquals(0, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("First triples should be greater than second")
	public void shouldFirstTripleBeatesSecond() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("8s"));
		player.addCard(new Card("8d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("4d"));
		otherPlayer.addCard(new Card("4c"));
		otherPlayer.addCard(new Card("4c"));
		Assertions.assertEquals(1, player.compareTo(otherPlayer));
	}
	
	// Royal Flush
	@Test
	@DisplayName("First royal flush should be greater than second")
	public void shouldFirstRoaylFlushBeatesSecond() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("9c"));
		player.addCard(new Card("Tc"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("7d"));
		otherPlayer.addCard(new Card("6d"));
		otherPlayer.addCard(new Card("8d"));
		Assertions.assertEquals(1, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("Equal royal flush")
	public void shouldRoyalFlushBeEqual() throws Exception {
		Player player = new Player();
		player.addCard(new Card("3d"));
		player.addCard(new Card("Ad"));
		player.addCard(new Card("2d"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("As"));
		otherPlayer.addCard(new Card("2s"));
		otherPlayer.addCard(new Card("3s"));
		Assertions.assertEquals(0, player.compareTo(otherPlayer));
	}
	// flush
	
	@Test
	@DisplayName("First flush should be greater than second")
	public void shouldFirstFlushBeatesSecond() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("2c"));
		player.addCard(new Card("Kc"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("7d"));
		otherPlayer.addCard(new Card("2d"));
		otherPlayer.addCard(new Card("8d"));
		Assertions.assertEquals(1, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("Equal flush")
	public void shouldFlushBeEqual() throws Exception {
		Player player = new Player();
		player.addCard(new Card("3d"));
		player.addCard(new Card("Jd"));
		player.addCard(new Card("Td"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Ts"));
		otherPlayer.addCard(new Card("Js"));
		otherPlayer.addCard(new Card("3s"));
		Assertions.assertEquals(0, player.compareTo(otherPlayer));
	}
	
	// two pairs
	
	@Test
	@DisplayName("First pair should be greater than second")
	public void shouldFirstPairBeatesSecond() throws Exception {
		Player player = new Player();
		player.addCard(new Card("8c"));
		player.addCard(new Card("8s"));
		player.addCard(new Card("Tc"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("7d"));
		otherPlayer.addCard(new Card("7c"));
		otherPlayer.addCard(new Card("Td"));
		Assertions.assertEquals(1, player.compareTo(otherPlayer));
	}
	
	@Test
	@DisplayName("Equal pairs flush")
	public void shouldPairsBeEqual() throws Exception {
		Player player = new Player();
		player.addCard(new Card("2d"));
		player.addCard(new Card("2h"));
		player.addCard(new Card("Kd"));
		
		var otherPlayer = new Player();
		otherPlayer.addCard(new Card("Kh"));
		otherPlayer.addCard(new Card("2s"));
		otherPlayer.addCard(new Card("2s"));
		Assertions.assertEquals(0, player.compareTo(otherPlayer));
	}
}
