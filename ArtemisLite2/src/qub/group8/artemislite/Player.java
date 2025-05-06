/**
 * 
 */
package qub.group8.artemislite;

/**
 * List and ArrayList classes imported to be used to store Square objects.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the Players that will be taking part in the ArtemisLite
 * game.
 * 
 * This class implements the Comparable interface, which is used to compare
 * Player objects based on their firstRollScore.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class Player implements Comparable<Player> {

	/**
	 * String variable which will hold the name of a Player object.
	 */
	private String playerName;

	/**
	 * int variable which will hold the playerID (i.e. player number) of a Player
	 * object.
	 * 
	 * Must be a value greater than or equal to 1.
	 */
	private int playerID;

	/**
	 * int variable which will hold the position (i.e. Square number) of a Player
	 * object on the virtual game board.
	 * 
	 * Must be a value greater than or equal to 1.
	 */
	private int playerPosition;

	/**
	 * int variable which will hold the score that a Player object rolls with their
	 * first roll of the dice. This will be used to determine the playing order for
	 * each Player object in the game.
	 * 
	 * Must be a value greater than or equal to 0.
	 */
	private int firstRollScore;

	/**
	 * int variable which will hold the amount of funds of a Player object.
	 * 
	 * Must be a value greater than or equal to 0.
	 */
	private int playerFunds;

	/**
	 * List of Square objects which will store the Elements that a Player object
	 * owns.
	 */
	private List<Element> playerElements;

	/**
	 * boolean variable which will be used to assess if a Player object has gone
	 * bankrupt. If at least one Player object becomes bankrupt, the game ends.
	 */
	private boolean isBankrupt;

	/**
	 * Constructor with arguments for the Player class - Creates Player Objects that
	 * will represent the individual players that are playing the game.
	 * 
	 * @param playerName  - String that represents the name of the Player.
	 * @param playerID    - int that represents the number of each Player.
	 * @param playerFunds - int that represents that number of funds that each
	 *                    Player begins the game with.
	 * @throws IllegalArgumentException - IllegalArgumentException thrown if
	 *                                  playerID is set as less than 1,
	 *                                  firstRollScore is set as less than 0 or
	 *                                  playerFunds is set as less than 0.
	 */
	public Player(String playerName, int playerID, int playerFunds) throws IllegalArgumentException {
		this.playerName = playerName;
		this.setPlayerID(playerID);
		this.setPlayerPosition(1);
		this.setFirstRollScore(0);
		this.setPlayerFunds(playerFunds);
		this.playerElements = new ArrayList<Element>();
		this.isBankrupt = false;
	}

	/**
	 * A method that returns the playerName of a Player object.
	 * 
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * A method that returns the playerID (i.e. player number) of a Player object.
	 * 
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * A method that sets the playerID (i.e. player number) of a Player object.
	 * 
	 * @param playerID - Must be a value greater than or equal to 1.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  playerID is set as less than 1.
	 */
	public void setPlayerID(int playerID) throws IllegalArgumentException {
		if (playerID >= 1) {
			this.playerID = playerID;
		} else {
			throw new IllegalArgumentException("Invalid playerID provided. Must be greater than or equal to 1.");
		}
	}

	/**
	 * A method that returns the playerPosition on the virtual game board of a
	 * Player object.
	 * 
	 * @return the playerPosition
	 */
	public int getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * A method that sets the playerPosition on the virtual game board of a Player
	 * object.
	 * 
	 * @param playerPosition - Must be a value greater than or equal to 1.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  playerPosition is set as less than 1.
	 */
	public void setPlayerPosition(int playerPosition) throws IllegalArgumentException {
		if (playerPosition >= 1) {
			this.playerPosition = playerPosition;
		} else {
			throw new IllegalArgumentException(
					"Invalid playerPosition provided. Must be greater than or equal to 1.");
		}
	}

	/**
	 * A method that returns the firstRollScore of a Player object.
	 * 
	 * @return the firstRollScore
	 */
	public int getFirstRollScore() {
		return firstRollScore;
	}

	/**
	 * A method that sets the firstRollScore of a Player object.
	 * 
	 * @param firstRollScore - Must be a value greater than or equal to 0.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  firstRollScore is set as less than 0.
	 */
	public void setFirstRollScore(int firstRollScore) throws IllegalArgumentException {
		if (firstRollScore >= 0) {
			this.firstRollScore = firstRollScore;
		} else {
			throw new IllegalArgumentException("Invalid firstRollScore provided. Must be 0 or greater.");
		}
	}

	/**
	 * A method that returns the playerFunds of a Player object.
	 * 
	 * @return the playerFunds
	 */
	public int getPlayerFunds() {
		return playerFunds;
	}

	/**
	 * A method that sets the playerFunds of a Player object.
	 * 
	 * @param playerFunds - Must be a value greater than or equal to 0.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  playerFunds is set as less than 0.
	 */
	public void setPlayerFunds(int playerFunds) throws IllegalArgumentException {
		if (playerFunds >= 0) {
			this.playerFunds = playerFunds;
		} else {
			throw new IllegalArgumentException("Invalid playerFunds provided. Must be 0 or greater.");
		}
	}

	/**
	 * A method that returns the playerElements List of a Player object.
	 * 
	 * @return the playerElements
	 */
	public List<Element> getPlayerElements() {
		return playerElements;
	}

	/**
	 * A method that adds a single specified Element to the playerElements List of a
	 * Player object.
	 * 
	 * This method will be called whenever a player purchases an Element.
	 * 
	 * @param element - the Element object that will be added the playerElements
	 *                List.
	 */
	public void addPlayerElement(Element element) {
		this.playerElements.add(element);
	}

	/**
	 * A method that returns the bankrupt status of a Player object.
	 * 
	 * @return isBankrupt
	 */
	public boolean isBankrupt() {
		return isBankrupt;
	}

	/**
	 * A method that sets the bankrupt status of a Player object.
	 * 
	 * @param isBankrupt - the isBankrupt to set
	 */
	public void setBankrupt(boolean isBankrupt) {
		this.isBankrupt = isBankrupt;
	}

	/**
	 * A method that displays the funds balance of a Player object.
	 */
	public void displayPlayerFunds() {
		System.out.printf("\n%s has %d Commitment Coins remaining.\n", this.playerName, this.playerFunds);
	}

	/**
	 * A method that displays the elements owned by a Player object.
	 */
	public void displayElementsOwned() {

		/* Checks if the Player owns any elements. */
		if (playerElements.size() == 0) {
			System.out.printf("%s does not own any Elements yet.\n", this.playerName);
		} else {

			/* Sorts Elements by their SystemType. */
			Collections.sort(playerElements);

			/*
			 * Loops through the playerElements list and prints details of each Element to
			 * screen.
			 */
			for (int loop = 0; loop < playerElements.size(); loop++) {

				/* Storing details of the Elements in variables */
				String squareName = playerElements.get(loop).getSquareName();
				String systemType = playerElements.get(loop).getSystemType();
				int developmentLevel = playerElements.get(loop).getDevelopmentLevel();

				/*
				 * Creating an empty String variable to hold details of development level that
				 * will print to screen.
				 */
				String developmentLevelString;

				/*
				 * Checking if developmentLevel is 0, if so "Undeveloped" will print to screen.
				 */
				if (developmentLevel == 0) {
					developmentLevelString = "Undeveloped";
				} else if (developmentLevel == 3) {

					/*
					 * If developmentLevel is 3, the Level and Major Development Status will print
					 * to screen.
					 */
					developmentLevelString = "Level " + developmentLevel + ": Major Development Status Complete";
				} else {

					/* If developmentLevel is 1 or 2, the Level will print to screen. */
					developmentLevelString = "Level " + developmentLevel;
				}

				/* Print to screen details about the Element owned. */
				System.out.printf("%d: %s - %s - %s\n", loop + 1, squareName, systemType, developmentLevelString);
			}
		}
	}

	/**
	 * A method that displays the status of a Player object, including funds balance
	 * and details of Elements owned.
	 */
	public void displayStatus() {
		System.out.println("\n\n|*****| Current Cadet Status |*****|\n");
		System.out.printf("Cadet Name: %s\n", this.playerName);
		System.out.printf("Cadet ID: %d\n", this.playerID);
		System.out.printf("Cadet Funds: %d Commitment Coins\n", this.playerFunds);
		System.out.println("Elements Owned: \n");
		displayElementsOwned();
	}

	/**
	 * A method that will compare the firstRollScore of Player objects.
	 * 
	 * This method will be called when the playing order is being determined.
	 */
	@Override
	public int compareTo(Player otherPlayer) {
		return Integer.compare(otherPlayer.getFirstRollScore(), getFirstRollScore());
	}
}