package qub.group8.artemislite;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Adam Vaughan Megan Dallat Lauren McCann Claire McDermott
 *
 */
class PlayerTest {

	/* Arranging test variables. */
	Player player;
	String playerName;
	int playerIDValidLow, playerIDValidHigh, playerIDInvalid, playerPositionValidLow, playerPositionValidHigh,
			playerPositionInvalid, playerFirstRollScoreValidLow, playerFirstRollScoreValidHigh,
			playerFirstRollScoreInvalid, playerFundsValidLow, playerFundsValidHigh, playerFundsInvalid;

	SquareName squareName;
	SystemType systemType;
	String squareDescription, squareDevelopmentMessage1, squareDevelopmentMessage2, squareDevelopmentMessage3;
	int squarePurchaseCost, squareDevelopmentCost;

	Element element;

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		/* Arranging test data. */
		playerName = "Jim";

		playerIDValidLow = 1;
		playerIDValidHigh = 4;
		playerIDInvalid = 0;

		playerPositionValidLow = 1;
		playerPositionValidHigh = 12;
		playerPositionInvalid = 0;

		playerFirstRollScoreValidLow = 0;
		playerFirstRollScoreValidHigh = 12;
		playerFirstRollScoreInvalid = -1;

		playerFundsValidLow = 0;
		playerFundsValidHigh = 1000;
		playerFundsInvalid = -1;

		player = new Player(playerName, playerIDValidLow, playerFundsValidHigh);

		squareName = SquareName.CRAWLER_TRANSPORTER;
		systemType = SystemType.LAUNCH_COMPLEX;

		squareDescription = "Test description";
		squareDevelopmentMessage1 = "Test development message 1";
		squareDevelopmentMessage2 = "Test development message 2";
		squareDevelopmentMessage3 = "Test development message 3";

		squarePurchaseCost = 100;
		squareDevelopmentCost = 50;

		element = new Element(squareName, squareDescription, systemType, null, squarePurchaseCost,
				squareDevelopmentCost, squareDevelopmentMessage1, squareDevelopmentMessage2, squareDevelopmentMessage3);
	}

	/**
	 * Testing the constructor of the Player class with valid values.
	 */
	@Test
	void testConstructorArgsValid() {

		player = new Player(playerName, playerIDValidHigh, playerFundsValidHigh);

		assertEquals(playerName, player.getPlayerName());
		assertEquals(playerIDValidHigh, player.getPlayerID());
		assertEquals(playerFundsValidHigh, player.getPlayerFunds());
	}

	/**
	 * Testing the constructor of the Player class with invalid values.
	 */
	@Test
	void testConstructorArgsInvalid() {

		IllegalArgumentException exceptionPlayerID = assertThrows(IllegalArgumentException.class, () -> {
			player = new Player(playerName, playerIDInvalid, playerFundsValidLow);
		});

		assertEquals("Invalid playerID provided. Must be greater than or equal to 1.", exceptionPlayerID.getMessage());

		IllegalArgumentException exceptionPlayerFunds = assertThrows(IllegalArgumentException.class, () -> {
			player = new Player(playerName, playerIDValidLow, playerFundsInvalid);
		});

		assertEquals("Invalid playerFunds provided. Must be 0 or greater.", exceptionPlayerFunds.getMessage());
	}

	/**
	 * Testing the getPlayerName method of the Player class.
	 */
	@Test
	void testGetPlayerName() {

		assertEquals(playerName, player.getPlayerName());
	}

	/**
	 * Testing the setPlayerID and getPlayerID methods of the Player class with
	 * valid values.
	 */
	@Test
	void testGetSetPlayerIDValid() {

		player.setPlayerID(playerIDValidLow);
		assertEquals(playerIDValidLow, player.getPlayerID());

		player.setPlayerID(playerIDValidHigh);
		assertEquals(playerIDValidHigh, player.getPlayerID());
	}

	/**
	 * Testing the setPlayerID method of the Player class with invalid values.
	 */
	@Test
	void testSetPlayerIDInvalid() {

		assertThrows(Exception.class, () -> {
			player.setPlayerID(playerIDInvalid);
		});
	}

	/**
	 * Testing the setPlayerPosition and getPlayerPosition methods of the Player
	 * class with valid values.
	 */
	@Test
	void testGetSetPlayerPositionValid() {

		player.setPlayerPosition(playerPositionValidLow);
		assertEquals(playerPositionValidLow, player.getPlayerPosition());

		player.setPlayerPosition(playerPositionValidHigh);
		assertEquals(playerPositionValidHigh, player.getPlayerPosition());
	}

	/**
	 * Testing the setPlayerPosition method of the Player class with invalid values.
	 */
	@Test
	void testSetPlayerPositionInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			player.setPlayerID(playerPositionInvalid);
		});
	}

	/**
	 * Testing the setFirstRollScore and getFirstRollScore methods of the Player
	 * class with valid values.
	 */
	@Test
	void testGetSetFirstRollScoreValid() {

		player.setFirstRollScore(playerFirstRollScoreValidLow);
		assertEquals(playerFirstRollScoreValidLow, player.getFirstRollScore());

		player.setFirstRollScore(playerFirstRollScoreValidHigh);
		assertEquals(playerFirstRollScoreValidHigh, player.getFirstRollScore());
	}

	/**
	 * Testing the setFirstRollScore method of the Player class with invalid values.
	 */
	@Test
	void testSetFirstRollScoreInvalid() {

		assertThrows(IllegalArgumentException.class, () -> {
			player.setFirstRollScore(playerFirstRollScoreInvalid);
		});
	}

	/**
	 * Testing the setPlayerFunds and getPlayerFunds methods of the Player class
	 * with valid values.
	 */
	@Test
	void testGetSetPlayerFundsValid() {

		player.setPlayerFunds(playerFundsValidLow);
		assertEquals(playerFundsValidLow, player.getPlayerFunds());

		player.setPlayerFunds(playerFundsValidHigh);
		assertEquals(playerFundsValidHigh, player.getPlayerFunds());
	}

	/**
	 * Testing the setPlayerFunds method of the Player class with invalid values.
	 */
	@Test
	void testGetSetPlayerFundsInvalid() {

		assertThrows(IllegalArgumentException.class, () -> {
			player.setPlayerFunds(playerFundsInvalid);
		});
	}

	/**
	 * Testing the addPlayerElement and getPlayerElements methods of the Player
	 * class.
	 */
	@Test
	void testAddGetPlayerElementValid() {

		player.addPlayerElement(element);
		assertTrue(player.getPlayerElements().size() == 1 && player.getPlayerElements().contains(element));
	}

	/**
	 * Testing the setBankrupt and isBankrupt methods of the Player class.
	 */
	@Test
	void testGetSetIsBankrupt() {

		player.setBankrupt(true);
		assertTrue(player.isBankrupt());

		player.setBankrupt(false);
		assertFalse(player.isBankrupt());
	}

	/**
	 * Testing the compareTo method of the Player class.
	 */
	@Test
	void testCompareTo() {

		Player player1 = new Player(playerName, playerIDValidLow, playerFundsValidLow);
		Player player2 = new Player(playerName, playerIDValidHigh, playerFundsValidHigh);
		Player player3 = new Player(playerName, playerIDValidHigh, playerFundsValidHigh);

		player1.setFirstRollScore(playerFirstRollScoreValidLow);
		player2.setFirstRollScore(playerFirstRollScoreValidHigh);
		player3.setFirstRollScore(playerFirstRollScoreValidHigh);

		assertEquals(1, player1.compareTo(player2));
		assertEquals(-1, player2.compareTo(player1));
		assertEquals(0, player2.compareTo(player3));
	}
}
