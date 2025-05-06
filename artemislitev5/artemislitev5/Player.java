/**
 * 
 */
package artemislitev5;

/**
 * List and ArrayList classes imported to be used to store Square objects.
 */
import java.util.ArrayList;
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
	 * Must be a value greater than or equal to 1 and less than or equal to 4.
	 */
	private int playerID;

	/**
	 * int variable which will hold the position (i.e. Square number) of a Player
	 * object on the virtual game board.
	 * 
	 * Must be a value greater than or equal to 1 and less than or equal to 12.
	 */
	private int playerPosition;

	/**
	 * int variable which will hold the score that a Player object rolls with their
	 * first roll of the dice. This will be used to determine the playing order for
	 * each Player object in the game.
	 * 
	 * Must be a value greater than or equal to 0 and less than or equal to 12.
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
	private List<Square> playerElements;

	/**
	 * boolean variable which will be used to assess if a Player object has gone
	 * bankrupt. If at least one Player object becomes bankrupt, the game ends.
	 */
	private boolean isBankrupt;

	/**
	 * boolean variable which will be used to assess if a Player object has landed
	 * on the UnpaidLeave Square. If so, fundsFrozen is set as true.
	 */
	private boolean fundsFrozen;

	/**
	 * Default constructor for Player class - Takes no arguments.
	 */
	public Player() {

	}

	public Player(String playerName, int playerID, int playerFunds) throws IllegalArgumentException {
		this.playerName = playerName;
		this.setPlayerID(playerID);
		this.playerPosition = 1;
		this.firstRollScore = 0;
		this.setPlayerFunds(playerFunds);
		this.playerElements = new ArrayList<Square>();
		this.isBankrupt = false;
		this.fundsFrozen = false;
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
	 * A method that sets the playerName of a Player object.
	 * 
	 * @param playerName - the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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
	 * @param playerID - Must be a value greater than or equal to 1 and less than or
	 *                 equal to 4.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  playerID is set as less than 1 or greater
	 *                                  than 4.
	 */
	public void setPlayerID(int playerID) throws IllegalArgumentException {
		if (playerID >= 1 && playerID <= 4) {
			this.playerID = playerID;
		} else {
			throw new IllegalArgumentException(
					"Invalid playerID provided. Must be 1 or greater and less than or equal to 4.");
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
	 * @param playerPosition - Must be a value greater than or equal to 1 and less
	 *                       than or equal to 12.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  playerPosition is set as less than 1 or
	 *                                  greater than 12.
	 */
	public void setPlayerPosition(int playerPosition) throws IllegalArgumentException {
		if (playerPosition >= 1 && playerPosition <= 12) {
			this.playerPosition = playerPosition;
		} else {
			throw new IllegalArgumentException(
					"Invalid playerPosition provided. Must be greater than or equal to 1 and less than or equal to 12.");
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
	public List<Square> getPlayerElements() {
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
	public void addPlayerElement(Square element) {
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
	 * A method that returns the fundsFrozen status of a Player object.
	 * 
	 * @return the fundsFrozen
	 */
	public boolean isFundsFrozen() {
		return fundsFrozen;
	}

	/**
	 * A method that sets the fundsFrozen status of a Player object.
	 * 
	 * @param fundsFrozen - the fundsFrozen to set
	 */
	public void setFundsFrozen(boolean fundsFrozen) {
		this.fundsFrozen = fundsFrozen;
	}

	/**
	 * A method that displays the funds balance of a Player object.
	 */
	public void displayPlayerFunds() {
		System.out.printf("\n%s has %d dollars remaining.\n", this.playerName, this.playerFunds);
	}

	/**
	 * A method that displays the elements owned by a Player object.
	 */
	public void displayElementsOwned() {
		// checks if the player owns any elements
		if (playerElements.size() == 0) {
			System.out.printf("\n%s does not own any elements yet.", this.playerName);
		} else {
			// loops through the playerElements list and prints details of each Element to
			// screen
			for (int loop = 0; loop < playerElements.size(); loop++) {
				// storing details of Elements in variables
				String squareName = ((Element) playerElements.get(loop)).getSquareName();
				String systemType = ((Element) playerElements.get(loop)).getSystemType();
				int developmentLevel = ((Element) playerElements.get(loop)).getDevelopmentLevel();
				// empty String variable to hold details of development level that will print to
				// screen
				String developmentLevelString;

				// checking if developmentLevel is 0, if so then "Undeveloped" will print to
				// screen
				if (developmentLevel == 0) {
					developmentLevelString = "Undeveloped";
				} else if (developmentLevel == 3) {
					// if developmentLevel is 3, the Level and Major Dev Status will print to screen
					developmentLevelString = "Level " + developmentLevel + ": Major Development Status Complete";
				} else {
					// if developmentLevel is 1 or 2, the Level will print to screen
					developmentLevelString = "Level " + developmentLevel;
				}
				// print to screen details about Element owned
				System.out.printf("%d: %s - %s - %s\n", loop + 1, squareName, systemType, developmentLevelString);
			}
		}
	}

	/**
	 * A method that displays the status of a Player object, including funds balance
	 * and details of Elements owned.
	 */
	public void displayStatus() {
		System.out.println("\n\n|*****| Current Player Status |*****|\n");
		System.out.printf("Player Name: %s\n", this.playerName);
		System.out.printf("Player ID: %d\n", this.playerID);
		System.out.printf("Player Funds: %d dollars\n", this.playerFunds);
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