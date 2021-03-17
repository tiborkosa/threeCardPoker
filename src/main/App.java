package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import main.models.Card;
import main.models.Player;

/**
 * 
 * Main runner class that reads the input data from STDIN and determine the Poker
 * winner(s)
 * 
 * Will print the winner index or in case of multi-winner in sorted order
 *
 */
public class App {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		
		// maximum cards the one player can have
		final int MAXIMUM_CARDS = Player.DEFAULT_NUMBER_OF_CARDS;
		// collection of winner(s)
		List<Integer> result = new ArrayList<>();

		// current winner to compare to others
		Player currentWinner = null;

		// readers
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			String line = bufferedReader.readLine();
			// number of players
			int numPlayers = Integer.parseInt(line);

			// getting each player one by one
			for (int i = 0; i < numPlayers; i++) {

				line = bufferedReader.readLine();
				String[] segments = line.split(" ");

				// first segment is the player number
				int pos = Integer.parseInt(segments[0]);

				Player nextPlayer = new Player();

				// getting all the cards for the player
				for (int j = 1; j <= MAXIMUM_CARDS; j++) {
					nextPlayer.addCard(new Card(segments[j]));
				}

				// compare higher hand
				if (currentWinner != null) {
					if (nextPlayer.compareTo(currentWinner) > 0) {
						result = new ArrayList<>();
						result.add(pos);
						currentWinner = nextPlayer;
					} else if (currentWinner.compareTo(nextPlayer) == 0) {
						result.add(i);
					}
				} else {
					// get the first player so we can compare it to the rest
					currentWinner = nextPlayer;
					result.add(pos);
				}

			}
			// we are catching all errors and print the message to console
			// we can uncomment the below lines to get stack trace
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (Exception e) { // all errors that are thrown
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
				// unable to close readers
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}
		}

		// printing the result
		for (var idx : result)
			System.out.println(idx);

	}
}
