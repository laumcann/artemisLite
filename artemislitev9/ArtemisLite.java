/**
 * 
 */
package artemislitev9;

/**
 * Scanner class imported to handle the user's keyboard entries.
 */
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

/**
 * This class contains many of the key methods and functionality of the
 * ArtemisLite game.
 * 
 * This class contains a playGame method, which controls and facilitates many of
 * the key aspects of the game, including a Player's ability to roll a Dice,
 * purchase and develop Elements and complete an iteration of the game play of
 * the game by calling other methods within this class and from other classes.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class ArtemisLite implements Serializable{

	/**
	 * Serializable long
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Unique Name / ID for the use of saving gameplay to file of unique name
	 */
	public static String fileName = String.valueOf(serialVersionUID);

	/**
	 * int constant variable which will represent the minimum number of players that
	 * can play the game.
	 */
	private static final int NUM_OF_PLAYERS_MIN = 1;

	/**
	 * int constant variable which will represent the maximum number of players that
	 * can play the game.
	 */
	private static final int NUM_OF_PLAYERS_MAX = 4;

	/**
	 * int constant variable which will represent the amount of funds that each
	 * Player will begin the game with.
	 */
	private static final int INITIAL_PLAYER_FUNDS = 1000;

	/**
	 * int constant variable which will represent the Payroll bonus that each Player
	 * will receive when passing or landing on the Payroll Square.
	 */
	private static final int PAYROLL_BONUS = 250;

	/**
	 * int constant variable which will represent the standard purchase cost of
	 * Elements on the virtual game board.
	 */
	private static final int STANDARD_PURCHASE_COST = 200;

	/**
	 * int constant variable which will represent the purchase cost of Elements
	 * within the least expensive System on the virtual game board.
	 */
	private static final int MIN_PURCHASE_COST = 100;

	/**
	 * int constant variable which will represent the purchase cost of Elements
	 * within the most expensive System on the virtual game board.
	 */
	private static final int MAX_PURCHASE_COST = 300;

	/**
	 * int constant variable which will represent the standard development cost of
	 * Elements on the virtual game board.
	 */
	private static final int STANDARD_DEVELOPMENT_COST = 100;

	/**
	 * int constant variable which will represent the development cost of Elements
	 * within the least expensive System on the virtual game board.
	 */
	private static final int MIN_DEVELOPMENT_COST = 50;

	/**
	 * int constant variable which will represent the development cost of Elements
	 * within the most expensive System on the virtual game board.
	 */
	private static final int MAX_DEVELOPMENT_COST = 150;

	/**
	 * int constant variable which will represent the number of Dice that are rolled
	 * within the game.
	 */
	private static final int NUM_OF_DICE_ROLLED = 2;

	/**
	 * List to hold Player objects that will represent players that are playing the
	 * game.
	 */
	public static List<Player> playerList;

	/**
	 * List to hold Square objects that will represent the Squares and Elements of
	 * the virtual game board.
	 */
	private static List<Square> board;

	/**
	 * Dice object that will represent a virtual Dice that can be "rolled" or
	 * "thrown" in the game.
	 */
	Dice dice;

	/**
	 * int variable which will represent the number of players that will be playing
	 * the game.
	 */
	int numOfPlayers;

	/**
	 * Method that begins an iteration of the game.
	 * 
	 * @param scanner - Scanner object to collect the user's keyboard entries.
	 */
	public void playGame(Scanner scanner) {

		/*
		 * Initialising the instance variable playerList, which will hold Player objects
		 * that represent each Player playing the game.
		 */
		playerList = new ArrayList<Player>();

		/* Creating a Dice object that has 6 sides. */
		dice = new Dice(6);

		/*
		 * Calling the initialiseBoard method of the ArtemisLite class. This method
		 * creates a virtual game board containing Square objects.
		 */
		board = initialiseBoard();

		/* String variable to capture the name of each Player. */
		String playerName;

		/*
		 * Static method of MessageCentre class which displays a message explaining that
		 * the game needs to know how many Players will be playing.
		 */
		MessageCentre.displayPlayerEnrolmentMessage();

		/*
		 * Do-while loop which continues running if the user does not enter a number
		 * between NUM_OF_PLAYERS_MIN and NUM_OF_PLAYERS_MAX inclusive.
		 */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a message asking the user
				 * how many Players will be playing the game - must be between
				 * NUM_OF_PLAYERS_MIN and NUM_OF_PLAYERS_MAX inclusive.
				 */
				MessageCentre.displayNumOfPlayersRequiredMessage();

				/* Assigning the user's entry to the numOfPlayers variable. */
				numOfPlayers = scanner.nextInt();

				/*
				 * If statement which checks if the number provided was less than
				 * NUM_OF_PLAYERS_MIN or greater than NUM_OF_PLAYERS_MAX.
				 */
				if (numOfPlayers < NUM_OF_PLAYERS_MIN || numOfPlayers > NUM_OF_PLAYERS_MAX) {
					System.out.println("\nA valid number was not entered.\n");
				}

				/* Catches Exceptions if a non-number value was entered by the user. */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the user to enter a number. */
				System.out.println("\nA valid number was not entered.\n");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* Catches Exceptions if any other problems occur. */
			} catch (Exception exception) {

				/* A message is displayed telling the user something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/*
			 * While the number that the user enters is not between NUM_OF_PLAYERS_MIN and
			 * NUM_OF_PLAYERS_MAX inclusive, the do while loop enters another iteration.
			 */
		} while (numOfPlayers < NUM_OF_PLAYERS_MIN || numOfPlayers > NUM_OF_PLAYERS_MAX);

		/*
		 * Static method of MessageCentre class which displays a message showing how
		 * many Players will be playing the game.
		 */
		MessageCentre.displayNumOfPlayersEnrolledMessage(numOfPlayers);

		/*
		 * Static method of MessageCentre class which displays a message asking the user
		 * to enter the names of each Player that will be playing the game.
		 */
		MessageCentre.displayPlayerNameRequiredMessage(numOfPlayers);

		/* Clears out the return character of the Scanner class. */
		scanner.nextLine();

		/*
		 * boolean variable which will be used to assess if a valid name has been
		 * entered.
		 */
		boolean validName;

		/*
		 * For loop which will ask the user to enter the name of each Player, using the
		 * value of numOfPlayers for the number of iterations. The initial loop value
		 * begins at 1, so the playerNum loop value can be used to set the playerID
		 * attribute of the Player class.
		 */
		for (int playerNum = 1; playerNum <= numOfPlayers; playerNum++) {

			/* Do-while loop which will run while validName becomes false. */
			do {

				/* validName initially set as true. */
				validName = true;

				/* Message asking for the user to enter the Player's name. */
				System.out.printf("\nPlayer %d Name:\n", playerNum);
				playerName = scanner.nextLine();

				/* If statement checks if a blank entry has been provided. */
				if (playerName.isEmpty()) {
					System.out.println("The Player name can not be blank. Please enter a name to continue.");

					/*
					 * validName is then set as false, meaning the do-while loop will iterate again.
					 */
					validName = false;
				} else {

					/*
					 * For loop which iterates through the playerList and compares the recently
					 * entered name with the playerName attribute of each Player object in the List.
					 */
					for (Player player : playerList) {

						/*
						 * If the playerName is the same as the playerName attribute of a Player object,
						 * an error message is displayed.
						 */
						if (playerName.equalsIgnoreCase(player.getPlayerName())) {
							System.out.println("\nThis name has already been used. Please enter another name.");

							/*
							 * validName is then set as false, meaning the do-while loop will iterate again.
							 */
							validName = false;
							break;
						}
					}
				}
			} while (!validName);

			/*
			 * If a valid name has been provided, a new Player object is created and added
			 * to the playerList.
			 */
			playerList.add(new Player(playerName, playerNum, INITIAL_PLAYER_FUNDS));
		}

		/*
		 * If statement checks how many Players will be playing - if it is greater than
		 * 1, the playing order will be determined by each Player rolling the Dice.
		 */
		if (playerList.size() == 1) {

			/*
			 * Static method of MessageCentre class which displays a message explaining that
			 * the playing order does not need to be determined.
			 */
			MessageCentre.displayPlayerOrderMessage(playerList);
		} else {

			/*
			 * Static method of MessageCentre class which displays a message explaining that
			 * the playing order for each Player will be determined by each Player rolling
			 * the Dice and the highest scorer will go first
			 */
			MessageCentre.displayDeterminePlayerOrderMessage();

			/*
			 * Calling the determinePlayOrder method of the ArtemisLite class to determine
			 * the playing order.
			 */
			determinePlayOrder(playerList, dice);

			/*
			 * Static method of MessageCentre class which displays a message showing the
			 * playing order for each Player.
			 */
			MessageCentre.displayPlayerOrderMessage(playerList);
		}
		System.out.println("\nLet's play!");

		/*
		 * turnManager method of the ArtemisLite class is called, which will begin the
		 * main game play of the game.
		 */
		turnManager(playerList, dice, scanner);
	}

	/**
	 * Method that will roll Dice objects at the beginning of the game for each
	 * Player and will assign the score they achieved to the relevant Player object
	 * within the game.
	 * 
	 * The List of Player objects is then sorted by the score they achieved in
	 * descending order.
	 * 
	 * @param playerList - List of Player objects that are playing the game.
	 * @param dice       - Dice object that can be "rolled" or "thrown".
	 */
	public void determinePlayOrder(List<Player> playerList, Dice dice) {

		if (playerList.size() > 1) {

			/* int variable to hold the score that is achieved by rolling the Dice. */
			int playerRoll = 0;

			/*
			 * Looping through each Player object within the playerList, rolling the Dice
			 * and assigning the score achieved to the firstRollScore variable of each
			 * Player object.
			 */
			for (Player player : playerList) {

				/*
				 * Value of NUM_OF_DICE_ROLLED is passed as an argument to the roll method of
				 * the Dice object, indicating how many Dice will be rolled.
				 */
				playerRoll = dice.roll(NUM_OF_DICE_ROLLED);

				/* Assigning playerRoll score to the firstRollScore of each Player object. */
				player.setFirstRollScore(playerRoll);
			}

			/*
			 * Sorting the playerList based on the value of firstRollScore for each Player
			 * object.
			 */
			Collections.sort(playerList);

			/*
			 * int variable to represent the new ID of each Player object in sorted order.
			 */
			int newID = 1;

			/* Updating the playerID of each Player object. */
			for (Player player : playerList) {
				player.setPlayerID(newID);
				newID++;
			}
		}
	}

	/**
	 * Method that contains and controls the main functionality of the ArtemisLite
	 * game. This method contains a do-while loop which will constantly iterate
	 * until a Player decides to quit the game or a Player goes bankrupt.
	 * 
	 * @param playerList - List of Player objects that are playing the game.
	 * @param dice       - Dice object that can be "rolled" or "thrown".
	 * @param scanner    - Scanner object to collect the user's keyboard entries.
	 */
	public void turnManager(List<Player> playerList, Dice dice, Scanner scanner) {

		/*
		 * int variable to store the current Player's input from an instance of the
		 * Scanner class. Initially set as 0.
		 */
		int userOption = 0;

		/*
		 * int variable that will be used to check which Player's turn it is. Initially
		 * set as 0.
		 */
		int playerTurn = 0;

		/*
		 * String variable that will be used to contain the name of the Player that is
		 * currently taking their turn.
		 */
		String playerName = "";

		/*
		 * int variable that will be used to hold the number that each Player rolls with
		 * the Dice. Initially set as 0.
		 */
		int numRolled = 0;

		/*
		 * int variable that will be used to hold each Player's current position on the
		 * virtual game board. Initially set as 0.
		 */
		int currentPosition = 0;

		/*
		 * int variable that will be used to hold each Player's new position on the
		 * virtual game board. Initially set as 0.
		 */
		int newPosition = 0;

		/*
		 * boolean variable that will be used to assess if the current Player has rolled
		 * the Dice during their turn. Initially set as false.
		 */
		boolean hasRolled = false;

		/*
		 * boolean variable that will be used to check if any Player has decided to quit
		 * during the game. Initially set as false.
		 */
		boolean quitGame = false;

		/*
		 * boolean variable that will be used to check if any Player has gone bankrupt.
		 * Initially set as false.
		 */
		boolean playerBankrupt = false;

		/*
		 * String variable that will be used to contain the name of the Player that has
		 * gone bankrupt.
		 */
		String whoIsBankrupt = "";

		/*
		 * int variable that represents the amount of additional funds that each Player
		 * receives when they pass the starting Square on the virtual game board.
		 */
		int payrollAmount = ((Payroll) board.get(0)).getYearlyBonus();
		
		
		//Ensures state of game is saved to file every minute.
		do {
			StateOfPlay sop = new StateOfPlay(playerList, board);
			PrintDataToScreen printData = new PrintDataToScreen();
			printData.setSop(sop);
			
			Thread t = new Thread(printData);
			t.start();
			
			try {
				Thread.sleep(600000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((quitGame == false) && (playerBankrupt == false));
		
		/*
		 * Do-while loop that will run until the value of quitGame or playerBankrupt
		 * becomes true.
		 */
		do {

			/* Try-catch block that catches any non-numeric entries from the user. */
			try {

				/* Gets the current Player from the playerList. */
				Player currentPlayer = playerList.get(playerTurn);

				/*
				 * Gets the name of the current Player from the playerList.
				 */
				playerName = currentPlayer.getPlayerName();

				/* Gets the current Player's position on the board. */
				currentPosition = currentPlayer.getPlayerPosition();

				/*
				 * If the current Player has landed on the Payroll or UnpaidLeave Squares,
				 * different menus from the static MessageCentre class are displayed to screen,
				 * as some options will not be available to choose whenever present on these
				 * Squares.
				 */

				/*
				 * Checking if only 1 Player is playing and they are on the UnpaidLeave Square.
				 * If so, the Finish Turn and Develop Element options are not shown
				 */
				if ((playerList.size() == 1) && (currentPosition == 7)) {
					MessageCentre.displayPlayerTurnMenuSoloGamePlayUnpaidLeave(playerName);

					/*
					 * If more than 1 Player is playing, checking if the Player has just rolled and
					 * has landed on the Unpaid Leave Square. If so, the Develop Element option is
					 * not shown.
					 */
				} else if ((hasRolled == true) && (currentPosition == 7)) {
					MessageCentre.displayPlayerTurnMenuUnpaidLeave(playerName);

					/*
					 * Checking if only 1 Player is playing. If so, the Finish Turn option is not
					 * shown.
					 */
				} else if (playerList.size() == 1) {
					MessageCentre.displayPlayerTurnMenuSoloGamePlay(playerName);

					/* The full menu options are shown. */
				} else {
					MessageCentre.displayPlayerTurnMenu(playerName);
				}

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/* If 1 is entered by the current Player, they will roll the Dice. */
				case 1:

					/* Checks if the current Player has already rolled the Dice during this turn. */
					if (hasRolled == false) {

						/* Rolling the Dice and assigning total to numRolled. */
						numRolled = dice.roll(NUM_OF_DICE_ROLLED);

						/*
						 * Calculating the current Player's new position on the board using the
						 * newPlayerPositon method of the ArtemisLite class.
						 */
						newPosition = newPlayerPosition(numRolled, currentPosition);

						/* Updating the playerPosition of the current Player. */
						currentPlayer.setPlayerPosition(newPosition);

						/*
						 * Static method of MessageCentre class which displays a message showing what
						 * the current Player rolled with the Dice and what Square of the board they
						 * landed on.
						 */
						MessageCentre.displayPlayerRollDiceMessage(playerName, numRolled, newPosition);

						/*
						 * If the current Player lands on the Payroll Square or passes it they collect a
						 * bonus.
						 */
						if (newPosition == 1) {
							currentPlayer.setPlayerFunds(currentPlayer.getPlayerFunds() + payrollAmount);
						} else if (newPosition < currentPosition) {
							currentPlayer.setPlayerFunds(currentPlayer.getPlayerFunds() + payrollAmount);

							/*
							 * Static method of MessageCentre class which displays a message telling the
							 * current Player they have passed the Payroll square and collected funds.
							 */
							MessageCentre.displayPassPayrollMessage(playerName, payrollAmount);

							/* Displaying the current Player's updated funds balance. */
							currentPlayer.displayPlayerFunds();
						}

						/*
						 * elementOptions method of ArtemisLite class is called which displays and
						 * manages the options the current Player can choose when they land on an
						 * Element.
						 */
						elementOptions(currentPlayer, playerList, board, scanner);

						/* If the current Player has 0 funds, playerBankrupt becomes true. */
						if (currentPlayer.getPlayerFunds() == 0) {
							playerBankrupt = true;
							whoIsBankrupt = currentPlayer.getPlayerName();
						}

						/* Sets hasRolled to true if more than 1 Player is playing. */
						if (playerList.size() > 1) {
							hasRolled = true;
						}
						break;

						/*
						 * Checking if more that 1 Player is playing and they are on the UnpaidLeave
						 * Square. If so, the Take Turn menu option is unavailable for them.
						 */
					} else if ((playerList.size() > 1) && (newPosition == 7)) {
						System.out.println("\nA valid number was not entered.");
						break;
					} else {

						/*
						 * Static method of MessageCentre class which displays a message telling the
						 * current Player they have already rolled the Dice during this turn.
						 */
						MessageCentre.displayPlayerAlreadyRolledMessage(playerName);
						break;
					}

					/*
					 * If 2 is entered by the current Player, they can select an Element to develop.
					 */
				case 2:

					/* Checking if the current Player is on the UnpaidLeave Square. */
					if (currentPlayer.getPlayerPosition() != 7) {

						/*
						 * developElement method of the ArtemisLite class is called, which gives the
						 * current Player options to develop an Element.
						 */
						developElement(currentPlayer, board, scanner);

						/*
						 * Checks if the current Player has 0 funds remaining. If so, playerBankrupt
						 * becomes true.
						 */
						if (currentPlayer.getPlayerFunds() == 0) {
							playerBankrupt = true;
							whoIsBankrupt = currentPlayer.getPlayerName();
						}
					} else {

						/*
						 * The Develop Element menu option is not available when a Player is on the
						 * UnpaidLeave square.
						 */
						System.out.println("\nA valid number was not entered.");
					}
					break;

				/*
				 * If 3 is entered by the current Player, they can gift an Element to another
				 * Player, unless they are a solo player.
				 */
				case 3:

					/*
					 * Checks if only 1 Player is playing. If so, this option is not available to
					 * them.
					 */
					if (playerList.size() == 1) {
						System.out.println("\nA valid number was not entered.");
						break;
						/* Checking if the current Player is on the UnpaidLeave Square. */
					} else if (currentPlayer.getPlayerPosition() != 7) {

						/*
						 * giftElement method of the ArtemisLite class is called, which gives the
						 * current Player options to gift an Element to another Player.
						 */
						giftElement(currentPlayer, playerList, board, scanner);
					} else {

						/*
						 * The Gift Element menu option is not available when a Player is on the
						 * UnpaidLeave square.
						 */
						System.out.println("\nA valid number was not entered.");
					}
					break;

				/*
				 * If 4 is entered by the current Player, an overview of their current status
				 * will be displayed.
				 */
				case 4:

					/* Calls the displayStatus method of the Player class. */
					currentPlayer.displayStatus();
					break;

				/*
				 * If 5 is entered by the current Player, the rules of the game will be
				 * displayed.
				 */
				case 5:

					/* Static method of MessageCentre class which displays the rules of the game. */
					MessageCentre.displayRules();
					break;

				/* If 6 is entered by the current Player, they will skip their turn. */
				case 6:

					/*
					 * Checks if only 1 Player is playing. If so, this option is not available to
					 * them.
					 */
					if (playerList.size() == 1) {
						System.out.println("\nA valid number was not entered.");
						break;
					} else {

						/*
						 * Increments playTurn value and sets hasRolled to false so the next Player can
						 * take their turn.
						 */
						playerTurn++;
						hasRolled = false;

						/*
						 * Static method of MessageCentre class which displays a message saying that the
						 * current Player has ended their turn.
						 */
						MessageCentre.displayTurnEndedMessage(playerName);
						break;
					}

					/* If 7 is entered by the current Player, the game will quit. */
				case 7:

					/*
					 * Calls the quitArtemisInGame method of the ArtemisLite class. If
					 * quitArtemisInGame returns false, quitGame will become false. If
					 * quitArtemisInGame returns true, quitGame will become true.
					 */
					if (!quitArtemisInGame(scanner)) {
						quitGame = false;
						System.out.println("\nWe are glad you have chosen to stay with NASA and complete the "
								+ "ArtemisLite mission!");
					} else {
						quitGame = true;
					}
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 7.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the current Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the current Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/*
			 * If statement checks if playerTurn is equal to the size of playerList, which
			 * would mean the last Player in the list has taken their turn. It then reverts
			 * back to 0 so the first Player in the list can take their next turn. A check
			 * is also made to check if only 1 player is playing. If so, playerTurn will
			 * always be 0.
			 */
			if (playerTurn == playerList.size() || playerList.size() == 1) {
				playerTurn = 0;
			}

			/* While condition checks if quitGame and playerBankrupt remain false. */
		} while ((quitGame == false) && (playerBankrupt == false));

		/* If quitGame equals true, a message is displayed showing who quit the game. */
		if (quitGame == true) {
			MessageCentre.displayQuitFromGamePlayMessage(playerName);

			/*
			 * If playerBankrupt equals true, a message is displayed showing who went
			 * bankrupt.
			 */
		} else if (playerBankrupt == true) {
			MessageCentre.displayPlayerBankruptMessage(whoIsBankrupt);
		}
	}

	/**
	 * Method that updates a Player's position on the virtual game board.
	 * 
	 * @param numRolled             - The number that the current Player has rolled
	 *                              with a Dice object.
	 * @param currentPlayerPosition - The position on the virtual game board of the
	 *                              current Player.
	 * 
	 * @return - The updated position of the current Player on the virtual game
	 *         board.
	 */
	public int newPlayerPosition(int numRolled, int currentPlayerPosition) {

		/*
		 * Checks if numRolled plus the current Player's position is greater than 12. If
		 * so, the Player will have passed the starting Square on the board, and 12 is
		 * subtracted from the current Player's position to account for this.
		 */
		if (currentPlayerPosition + numRolled > 12) {
			return (currentPlayerPosition - 12) + numRolled;
		} else {
			return currentPlayerPosition + numRolled;
		}
	}

	/**
	 * Method that asks the Player to confirm if they wish to quit the game while in
	 * the middle of the game play.
	 * 
	 * @param scanner - Scanner object to collect the user's keyboard entries.
	 * @return - Returns true if the Player confirms they want to quit, returns
	 *         false if they do not wish to quit.
	 */
	public boolean quitArtemisInGame(Scanner scanner) {

		/*
		 * boolean variable to assess if the Player confirms they want to quit.
		 * Initially set to false.
		 */
		boolean confirmQuitGame = false;

		/*
		 * int variable to store the user's input from an instance of the Scanner class.
		 * Initially set to 0.
		 */
		int userOption = 0;

		/*
		 * Static method of MessageCentre class that displays a message asking the
		 * current Player to confirm that they want to quit the game.
		 */
		MessageCentre.displayQuitFromGamePlayConfirmationMessage();

		/*
		 * Do-while loop that will run until the current Player enters the number 1 or
		 * 2.
		 */
		do {

			/* Try-catch block that catches any non-numeric entries. */
			try {

				/* Static method of MessageCentre class that displays a quit menu. */
				MessageCentre.displayQuitFromGamePlayConfirmationMenu();

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/* If 1 is entered by the current Player, confirmQuitGame becomes true. */
				case 1:
					confirmQuitGame = true;
					// show current state of gameplay to screen.
					MessageCentre.printGamePlayResultsToScreen();

					break;

				/* If 2 is entered by the current Player, confirmQuitGame becomes false. */
				case 2:
					confirmQuitGame = false;
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 2.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the current Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the current Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the current Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/*
			 * Do-while loop that will run until the current Player enters the number 1 or
			 * 2.
			 */
		} while (userOption != 1 && userOption != 2);

		/* Value of confirmQuitGame is returned. */
		return confirmQuitGame;
	}

	/**
	 * Method that displays the options, obligations or details of what happens when
	 * a Player lands on a Square on the virtual game board.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void elementOptions(Player currentPlayer, List<Player> playerList, List<Square> board, Scanner scanner) {

		/* Getting the current Player's position on the virtual game board. */
		int currentPlayerPosition = currentPlayer.getPlayerPosition();

		/* Getting the current Player's name. */
		String currentPlayerName = currentPlayer.getPlayerName();

		/* Getting the current Square that the Player is on. */
		Square currentSquare = board.get(currentPlayerPosition - 1);

		/* Displays the details of the Square that the current Player is on. */
		currentSquare.displaySquareDetails();

		/*
		 * If the current Player has landed on the Payroll Square, they collect a bonus.
		 */
		if (currentPlayerPosition == 1) {

			/*
			 * int variable that represents the amount of additional funds that each Player
			 * receives when they pass the starting Square on the virtual game board.
			 */
			int payrollAmount = ((Payroll) board.get(0)).getYearlyBonus();

			/*
			 * Static method of MessageCentre class which displays a message telling the
			 * current Player they have landed on the Payroll square and collected a bonus.
			 */
			MessageCentre.displayLandOnPayrollMessage(currentPlayerName, payrollAmount);

			/* Displays the current Player's new balance. */
			currentPlayer.displayPlayerFunds();
		} else {

			/* Checks if the current Player is not on the UnpaidLeave Square. */
			if (currentPlayerPosition != 7) {

				/* Gets the Element the current Player is on. */
				Element element = ((Element) currentSquare);

				/* Gets the current owner of the Element. */
				String elementOwner = element.getElementOwner();

				/*
				 * If there is no owner, the current Player is offered this Element to purchase.
				 */
				if (elementOwner.equals("Unoccupied")) {

					/*
					 * Static method of MessageCentre class which displays a message asking the
					 * current Player if they want to purchase the Element.
					 */
					MessageCentre.displayPurchaseElementMessage(element);

					/* purchaseElement method of ArtemisLite class is called. */
					purchaseElement(currentPlayer, playerList, board, element, scanner);

					/* If they already own it, they have the choice to develop it. */
				} else if (elementOwner == currentPlayerName) {
					System.out.println("\nYou already own this element.");

					/*
					 * Checks if the currentPlayer owns all Elements within that System. If they
					 * don't, the option to develop the Element will not be displayed.
					 */
					if (!checkFullSystemOwned(currentPlayer, element.getSystemType())) {
						System.out.println("\nThis Element can not be developed until you own all Elements "
								+ "from it's System.");
					} else {

						/* developElementWhenOnOwnedElement of ArtemisLite class is called. */
						developElementWhenOnOwnedElement(currentPlayer, currentSquare.getSquarePositionID(), board,
								scanner);
					}

					/*
					 * If the Square is owned by another Player, they may have to pay tax for
					 * landing on it.
					 */
				} else {

					/* payTax method of ArtemisLite class is called. */
					payTax(currentPlayer, elementOwner, playerList, element, scanner);
				}
			}
		}
	}

	/**
	 * Method that displays and manages the purchase options when a Player lands on
	 * a Square on the virtual game board.
	 * 
	 * The Player is given the choice to either purchase the Element on the Square
	 * or offer another Player the chance to purchase it.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param element       - The Element object that the current Player is
	 *                      positioned on.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 * 
	 */
	public void purchaseElement(Player currentPlayer, List<Player> playerList, List<Square> board, Element element,
			Scanner scanner) {

		/*
		 * int variable to store the Player's input from an instance of the Scanner
		 * class. Initially set to 0.
		 */
		int userOption = 0;

		/* Getting the purchase cost of the Element. */
		int elementCost = element.getPurchaseCost();

		/* Getting the current Player's name. */
		String currentPlayerName = currentPlayer.getPlayerName();

		/* Getting the current Player's current funds balance. */
		int playerFunds = currentPlayer.getPlayerFunds();

		/* Do-while loop that will run until the current Player enters 1 or 2. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a menu asking the current
				 * Player to purchase or decline purchasing the Element.
				 */
				MessageCentre.displayPurchaseElementMenu();

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * if 1 is entered by the current Player, they will purchase the Element,
				 * provided they have enough resources to purchase it.
				 */
				case 1:

					/*
					 * If statement checks if the current Player has enough funds to purchase the
					 * Element.
					 */
					if (elementCost > playerFunds) {
						System.out.println("Insufficient funds of Commitment Coins to purchase this Element.");

						/* If they have enough funds, the Element is purchased. */
					} else {

						/* currentPlayerName is set as the elementOwner of the Element. */
						element.setElementOwner(currentPlayerName);

						/* Element is added to the playerElements ArrayList of the current Player. */
						currentPlayer.addPlayerElement(element);

						/* current Player's funds are updated after purchase. */
						currentPlayer.setPlayerFunds(currentPlayer.getPlayerFunds() - elementCost);

						/*
						 * Static method of MessageCentre class which displays a message showing what
						 * Element the current Player has purchased.
						 */
						MessageCentre.displayElementPurchasedMessage(currentPlayerName, element.getSquareName());

						/* Displays the current Player's updated funds balance. */
						currentPlayer.displayPlayerFunds();
					}
					break;

				/* If 2 is entered by the current Player, they will decline the Element. */
				case 2:

					/*
					 * If there is only 1 Player playing, they can not offer the Element to another
					 * Player. Therefore, the current Player will return to the options menu.
					 */
					if (playerList.size() == 1) {
						break;
					} else {

						/*
						 * Static method of MessageCentre class which displays a message asking the
						 * current Player if they want to offer another Player the option to purchase
						 * the Element.
						 */
						MessageCentre.displayOfferElementMessage();

						/* offerElement method of the ArtemisLite class is called. */
						offerElement(currentPlayer, playerList, board, element, scanner);
						break;
					}

					/*
					 * A message is displayed to the current Player if they enter a number that
					 * isn't between 1 and 2 inclusive.
					 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the current Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the current Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the current Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/*
			 * Do-while loop that will run until the current Player enters the number 1 or
			 * 2.
			 */
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * Method that displays an option for the current Player to offer another Player
	 * within the game the opportunity to purchase an Element.
	 * 
	 * The Player is given the choice to either offer another Player the chance to
	 * purchase the Element or decline offering the Element to another Player.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param element       - The Element object that the current Player is
	 *                      positioned on.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void offerElement(Player currentPlayer, List<Player> playerList, List<Square> board, Element element,
			Scanner scanner) {

		/*
		 * int variable to store the Player's input from an instance of the Scanner
		 * class. Initially set to 0.
		 */
		int userOption = 0;

		/* Do-while loop that will run until the current Player enters 1 or 2. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a menu asking the current
				 * Player if they want to offer the option to purchase the Element to another
				 * Player.
				 */
				MessageCentre.displayOfferElementMenu();

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the current Player, they will offer the option to purchase
				 * the Element to another Player.
				 */
				case 1:

					/* Calls the acceptElementOffer method of the ArtemisLite class. */
					offerElementSelectPlayer(playerList, currentPlayer, board, element, scanner);
					break;

				/*
				 * If 2 is entered by the current Player, they will not offer the Element to
				 * another Player.
				 */
				case 2:

					/*
					 * Static method of MessageCentre class which displays a message saying that the
					 * current Player has declined to offer the Element to another Player.
					 */
					MessageCentre.displayDeclineOfferElementMessage();
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 2 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the Player enters something that is not a number, it is caught as an
				 * InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the current Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the current Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}
			/* Do-while loop that will run until the current Player enters 1 or 2. */
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * Method that displays a list of other Players that are playing the game and
	 * allows the current Player to choose which other Player they want to offer an
	 * Element to.
	 * 
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param element       - The Element object that the current Player is
	 *                      positioned on.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void offerElementSelectPlayer(List<Player> playerList, Player currentPlayer, List<Square> board,
			Element element, Scanner scanner) {

		/*
		 * int variable to store the Player's input from an instance of the Scanner
		 * class. Initially set to 0.
		 */
		int userOption = 0;

		/*
		 * boolean variable which will be used to assess if the current Player has
		 * selected a valid Player to offer the Element to.
		 */
		boolean validEntry = false;

		Player offeredPlayer;

		/* Do-while loop that will run until the value of validEntry becomes true. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a list of the other
				 * Players playing the game. The current Player is excluded from this list.
				 */
				MessageCentre.displayPlayerNamesMenu(playerList, currentPlayer.getPlayerName());

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * if 1 is entered by the current Player, they will offer the option to purchase
				 * the Element to Player ID 1.
				 */
				case 1:

					/*
					 * If Player ID 1 is the current Player, this option will not be displayed and
					 * will not be available to choose.
					 */
					if (currentPlayer.getPlayerID() == 1) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* Player to offer to is the Player at index 0 of playerList. */
						offeredPlayer = playerList.get(0);

						/* Calling the purchaseElementOffer method of ArtemisLite class. */
						purchaseElementOffer(offeredPlayer, board, element, scanner);

						/* validEntry becomes true and the do-while loop ends. */
						validEntry = true;
					}
					break;

				/*
				 * If 2 is entered by the current Player, they will offer the option to purchase
				 * the Element to Player ID 2.
				 */
				case 2:

					/*
					 * If Player ID 2 is the current Player, this option will not be displayed and
					 * will not be available to choose.
					 */
					if (currentPlayer.getPlayerID() == 2) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* Player to offer to is the Player at index 1 of playerList. */
						offeredPlayer = playerList.get(1);

						/* Calling the purchaseElementOffer method of ArtemisLite class. */
						purchaseElementOffer(offeredPlayer, board, element, scanner);

						/* validEntry becomes true and the do-while loop ends. */
						validEntry = true;
					}
					break;

				/*
				 * If 3 is entered by the current Player, they will offer the option to purchase
				 * the Element to Player ID 3.
				 */
				case 3:

					/*
					 * If Player ID 3 is the current Player, this option will not be displayed and
					 * will not be available to choose.
					 */
					if (currentPlayer.getPlayerID() == 3) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;

						/*
						 * If less than 3 Players are playing, this option will not be displayed and
						 * will not be available to choose.
						 */
					} else if (playerList.size() < 3) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* Player to offer to is the Player at index 2 of playerList. */
						offeredPlayer = playerList.get(2);

						/* Calling the purchaseElementOffer method of ArtemisLite class. */
						purchaseElementOffer(offeredPlayer, board, element, scanner);

						/* validEntry becomes true and the do-while loop ends. */
						validEntry = true;
					}
					break;

				/*
				 * If 4 is entered by the current Player, they will offer the option to purchase
				 * the Element to Player ID 4.
				 */
				case 4:

					/*
					 * If Player ID 4 is the current Player, this option will not be displayed and
					 * will not be available to choose.
					 */
					if (currentPlayer.getPlayerID() == 4) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;

						/*
						 * If less than 4 Players are playing, this option will not be displayed and
						 * will not be available to choose.
						 */
					} else if (playerList.size() < 4) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* Player to offer to is the Player at index 2 of playerList. */
						offeredPlayer = playerList.get(3);

						/* Calling the purchaseElementOffer method of ArtemisLite class. */
						purchaseElementOffer(offeredPlayer, board, element, scanner);

						/* validEntry becomes true and the do-while loop ends. */
						validEntry = true;
					}
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 4 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the Player enters something that is not a number, it is caught as an
				 * InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the current Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the current Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/* Do-while loop that will run until the value of validEntry becomes true. */
		} while (!validEntry);
	}

	/**
	 * Method that allows a Player to purchase or decline purchasing an Element that
	 * has been offered to them by another Player.
	 * 
	 * @param offeredPlayer - Player object that represents the player that has been
	 *                      offered an Element to purchase.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param element       - The Element object that the current Player is
	 *                      positioned on.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void purchaseElementOffer(Player offeredPlayer, List<Square> board, Element element, Scanner scanner) {

		/*
		 * int variable to store the offered Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption = 0;

		/* Name of Element object that has been offered for purchase. */
		String elementName = element.getSquareName();

		/* Name of the Player that has been offered the Element. */
		String offeredPlayerName = offeredPlayer.getPlayerName();

		/* Available funds of the offered Player. */
		int offeredPlayerFunds = offeredPlayer.getPlayerFunds();

		/* Do-while loop that will run until the offered Player enters 1 or 2. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a menu asking the offered
				 * Player to purchase or decline purchasing the element.
				 */
				MessageCentre.displayPurchaseElementMenu();

				/* Assigning the offered Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the offered Player, they will purchase the element,
				 * provided they have enough resources to purchase it.
				 */
				case 1:

					/*
					 * if statement checks if the offered Player has enough funds to purchase the
					 * Element.
					 */
					if (element.getPurchaseCost() > offeredPlayerFunds) {
						System.out.println("Insufficient funds to purchase this element.");

						/* If they have enough funds, the element is purchased. */
					} else {

						/* offeredPlayerName is set as the elementOwner of the Element. */
						element.setElementOwner(offeredPlayerName);

						/* Element is added to the playerElements ArrayList of offeredPlayer object. */
						offeredPlayer.addPlayerElement(element);

						/* offered Player's funds are updated after purchase. */
						offeredPlayer.setPlayerFunds(offeredPlayerFunds - element.getPurchaseCost());

						/*
						 * Static method of MessageCentre class which displays a message showing what
						 * Element the offered Player has purchased.
						 */
						MessageCentre.displayElementPurchasedMessage(offeredPlayerName, elementName);

						/* Displays the offered Player's updated funds balance. */
						offeredPlayer.displayPlayerFunds();
					}
					break;

				/* If 2 is entered by the offered Player, they will decline the Element. */
				case 2:
					MessageCentre.displayElementDeclinedMessage(offeredPlayerName, elementName);
					break;

				/*
				 * A message is displayed to the offered Player if they enter a number that
				 * isn't between 1 and 2 inclusive.
				 * 
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the offered Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the offered Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the offered Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/* Do-while loop that will run until the offered Player enters 1 or 2. */
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * Method that allows a Player to gift an Element that they own to another
	 * Player.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void giftElement(Player currentPlayer, List<Player> playerList, List<Square> board, Scanner scanner) {

		/*
		 * int variables to store the current Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption1 = 0;
		int userOption2 = 0;

		/* Getting the name of the current Player. */
		String currentPlayerName = currentPlayer.getPlayerName();

		/* Getting the number of Elements that the current Player owns. */
		int totalElementsOwned = currentPlayer.getPlayerElements().size();

		/* Checks if the current Player owns any Elements. */
		if (totalElementsOwned == 0) {

			/* Message displayed if the current Player doesn't own any Elements. */
			System.out.printf("\n%s does not own any Elements.\n", currentPlayerName);
		} else {
			do {
				try {
					System.out.println("\n\n|*****| Gift an Element |*****|");

					/*
					 * Static method of MessageCentre class that displays the names of the Elements
					 * that are owned by the current Player.
					 */
					MessageCentre.displayElementsOwnedMessage(currentPlayerName);

					/* Calls the displayElementsOwned method of the Player class. */
					currentPlayer.displayElementsOwned();

					/*
					 * If the current Player only owns 1 Element, that will be the Element they are
					 * asked if they want to gift to another Player.
					 */
					if (totalElementsOwned == 1) {

						/*
						 * UserOption becomes 1 to represent the only Element the current Player owns.
						 */
						userOption1 = 1;
					} else {

						/*
						 * If the current Player owns more than 1 Element, a static method of the
						 * MessageCentre class displays a message asking the current Player to select
						 * the Element they want to gift to another player by entering a number.
						 */
						MessageCentre.displaySelectElementToGiftMessage(totalElementsOwned);

						/*
						 * Assigning the number entered by the current Player to the userOption1
						 * variable.
						 */
						userOption1 = scanner.nextInt();
					}

					/* Displays a message if the current Player does not enter a valid number. */
					if (userOption1 < 1 || userOption1 > totalElementsOwned) {
						System.out.println("\nA valid number was not entered.");
					}

					/*
					 * If the current Player enters something that is not a number, it is caught as
					 * an InputMismatchException.
					 */
				} catch (InputMismatchException inputMismatchException) {

					/* A message is displayed telling the user to enter a number. */
					System.out.println("\nA valid number was not entered.");

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();

					/* General exceptions or errors are caught as a general Exception. */
				} catch (Exception exception) {

					/* A message is displayed telling the user something went wrong. */
					System.out.println("Something went wrong. Try again.");
					exception.printStackTrace();

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();
				}

				/*
				 * Do-while loop continues to run until the current Player enters a valid number
				 * to select an Element to gift.
				 * 
				 */
			} while (userOption1 < 1 || userOption1 > totalElementsOwned);

			/* Gets the Element that will be gifted. */
			Element element = ((Element) currentPlayer.getPlayerElements().get(userOption1 - 1));

			/* Gets the name of the Element that will be gifted. */
			String elementName = element.getSquareName();

			/* Do-while loop that will run until the current Player enters 1 or 2. */
			do {
				try {

					/*
					 * Static method of MessageCentre class which displays a message asking the
					 * current Player if they wish to gift the selected Element.
					 */
					MessageCentre.displayConfirmGiftElementMessage(elementName);

					/*
					 * Static method of MessageCentre class which displays a menu asking the current
					 * Player to choose to gift the Element or cancel gifting the Element.
					 */
					MessageCentre.displayGiftElementMenu();

					/* Assigning the current Player's entry to the userOption2 variable. */
					userOption2 = scanner.nextInt();

					/*
					 * Passing the userOption2 variable into a switch statement to determine which
					 * option they have chosen.
					 */
					switch (userOption2) {

					/* If 1 is entered by the current Player, they will gift the Element. */
					case 1:

						/* SelectPlayerToGiftElement method of ArtemisLite class is called. */
						selectPlayerToGiftElement(currentPlayer, playerList, element, board, scanner);
						break;

					case 2:

						/*
						 * Static method of MessageCentre class which displays a message explaining that
						 * the gifting of the Element has been cancelled.
						 */
						MessageCentre.displayElementGiftCancelled(elementName);
						break;

					/*
					 * A message is displayed to the current Player if they enter a number that
					 * isn't between 1 and 2 inclusive.
					 */
					default:
						System.out.println("\nA valid number was not entered.");
					}

					/*
					 * If the current Player enters something that is not a number, it is caught as
					 * an InputMismatchException.
					 */
				} catch (InputMismatchException inputMismatchException) {

					/* A message is displayed telling the current Player to enter a number. */
					System.out.println("\nA valid number was not entered.");

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();

					/* General exceptions or errors are caught as a general Exception. */
				} catch (Exception exception) {

					/* A message is displayed telling the current Player something went wrong. */
					System.out.println("Something went wrong. Try again.");
					exception.printStackTrace();

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();
				}

				/* Do while loop that will run until the current Player enters 1 or 2. */
			} while (userOption2 != 1 && userOption2 != 2);
		}
	}

	/**
	 * Method that allows a Player to select another Player that they want to gift
	 * an Element to.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param element       - The Element that is being gifted to another Player.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void selectPlayerToGiftElement(Player currentPlayer, List<Player> playerList, Element element,
			List<Square> board, Scanner scanner) {

		/*
		 * int variable to store the current Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption = 0;

		/*
		 * boolean variable to check if the current Player has chosen a valid Player to
		 * gift the Element to.
		 */
		boolean validEntry = false;

		/* Getting the name of the current Player. */
		String currentPlayerName = currentPlayer.getPlayerName();

		/*
		 * Player object that will represent the Player that has been selected to
		 * receive the Element.
		 */
		Player receivingPlayer;

		/* Do-while loop that will run until validEntry becomes true. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a list of the other
				 * Players playing the game. The current Player is excluded from the displayed
				 * list.
				 */
				MessageCentre.displayPlayerNamesMenu(playerList, currentPlayerName);

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the current Player, they will offer the option to purchase
				 * the Element to the first player displayed.
				 */
				case 1:

					/*
					 * If the first Player in the list is the current Player, the option to choose
					 * number 1 is unavailable and an error message is displayed if this number is
					 * entered.
					 */
					if (playerList.indexOf(currentPlayer) + 1 == 1) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* userOption is passed to playerList to retrieve the Player object. */
						receivingPlayer = playerList.get(userOption - 1);

						/* confirmGift method of ArtemisLite class is called. */
						confirmGift(currentPlayer, receivingPlayer, element, scanner);

						/* validEntry becomes true and the do while loop will end. */
						validEntry = true;
					}
					break;

				/*
				 * If 2 is entered by the current Player, they will offer the option to purchase
				 * the Element to the second Player displayed.
				 */
				case 2:

					/*
					 * If the second Player in the list is the current Player, the option to choose
					 * number 2 is unavailable and an error message is displayed if this number is
					 * entered.
					 */
					if (playerList.indexOf(currentPlayer) + 1 == 2) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* userOption is passed to playerList to retrieve the Player object. */
						receivingPlayer = playerList.get(userOption - 1);

						/* confirmGift method of ArtemisLite class is called. */
						confirmGift(currentPlayer, receivingPlayer, element, scanner);

						/* validEntry becomes true and the do while loop will end. */
						validEntry = true;
					}
					break;

				/*
				 * If 3 is entered by the current Player, they will offer the option to purchase
				 * the Element to the third player displayed.
				 */
				case 3:

					/*
					 * If the third Player in the list is the current Player, the option to choose
					 * number 3 is unavailable and an error message is displayed if this number is
					 * entered.
					 */
					if (playerList.indexOf(currentPlayer) + 1 == 3) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* userOption is passed to playerList to retrieve the Player object. */
						receivingPlayer = playerList.get(userOption - 1);

						/* confirmGift method of ArtemisLite class is called. */
						confirmGift(currentPlayer, receivingPlayer, element, scanner);

						/* validEntry becomes true and the do while loop will end. */
						validEntry = true;
					}
					break;

				/*
				 * If 4 is entered by the current Player, they will offer the option to purchase
				 * the Element to the fourth player displayed.
				 */
				case 4:

					/*
					 * If the fourth Player in the list is the current Player, the option to choose
					 * number 4 is unavailable and an error message is displayed if this number is
					 * entered.
					 */
					if (playerList.indexOf(currentPlayer) + 1 == 4) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;

						/*
						 * If there are less than 4 Players playing, entering number 4 will display an
						 * error message.
						 */
					} else if (playerList.size() < 4) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						/* userOption is passed to playerList to retrieve the Player object. */
						receivingPlayer = playerList.get(userOption - 1);

						/* confirmGift method of ArtemisLite class is called. */
						confirmGift(currentPlayer, receivingPlayer, element, scanner);

						/* validEntry becomes true and the do while loop will end. */
						validEntry = true;
					}
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 4 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the current Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the user to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the user something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}
			/* Do-while loop that will run until validEntry becomes true. */
		} while (validEntry == false);
	}

	/**
	 * Method that asks a Player to confirm that they want to gift an Element to
	 * another Player.
	 * 
	 * @param currentPlayer   - Player object that represents the current player
	 *                        taking their turn.
	 * @param receivingPlayer - Player object that represents that player that will
	 *                        receive the Element from the current Player.
	 * @param element         - The Element that is being gifted to another Player.
	 * @param scanner         - Scanner object to collect the user's keyboard
	 *                        entries.
	 */
	public void confirmGift(Player currentPlayer, Player receivingPlayer, Element element, Scanner scanner) {

		/*
		 * int variable to store the current Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption = 0;

		/* Do-while loop that will run until the current Player enters 1 or 2. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a menu asking the current
				 * Player to confirm they want to gift the Element to the receiving Player.
				 */
				MessageCentre.displayConfirmGiftElementMenu();

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the current Player, they will gift the Element to the
				 * receiving Player.
				 */
				case 1:
					/*
					 * Checks that the current Player owns the Element and removes it from their
					 * list of owned Elements if so.
					 */
					if (currentPlayer.getPlayerElements().contains(element)) {
						currentPlayer.getPlayerElements().remove(element);
					}

					/* Assigns the name of the receiving Player as the Element's new owner. */
					element.setElementOwner(receivingPlayer.getPlayerName());

					/* adds Element object to the receiving Player's list of owned Elements. */
					receivingPlayer.addPlayerElement(element);
					break;

				/*
				 * If 2 is entered by the current Player, they will not gift the Element to the
				 * receiving Player.
				 */
				case 2:
					System.out.println("\nYou have declined to gift this Element to another Player.");
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 2 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the current Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the user to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the user something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/* Do while loop that will run until the current Player enters 1 or 2. */
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * Method that allows a Player to develop an Element that they own.
	 * 
	 * This method can be called when the Player is not currently positioned on the
	 * Element they want to develop.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param board         - ArrayList of Square objects which represents the
	 *                      virtual game board.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void developElement(Player currentPlayer, List<Square> board, Scanner scanner) {

		/*
		 * int variables to store the current Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption1 = 0;
		int userOption2 = 0;

		/* Getting the name of the current Player. */
		String currentPlayerName = currentPlayer.getPlayerName();

		/* Getting the number of Elements that the current Player owns. */
		int totalElementsOwned = currentPlayer.getPlayerElements().size();

		/* Checks if the current Player owns any Elements. */
		if (totalElementsOwned == 0) {

			/*
			 * Static method of MessageCentre class which displays a message saying the
			 * current Player does not own any Elements to develop.
			 */
			MessageCentre.displayNoElementsOwnedMessage(currentPlayerName);
		} else {
			do {
				try {
					System.out.println("\n\n|*****| Develop an Element |*****|");

					/*
					 * Static method of MessageCentre class that displays the names of the Elements
					 * that are owned by the current Player.
					 */
					MessageCentre.displayElementsOwnedMessage(currentPlayerName);

					/* Calls the displayElementsOwned method of the Player class. */
					currentPlayer.displayElementsOwned();

					/*
					 * If the current Player only owns 1 Element, that will be the Element they are
					 * asked if they want to develop.
					 */
					if (totalElementsOwned == 1) {

						/*
						 * userOption becomes 1 to represent the only Element the current Player owns.
						 */
						userOption1 = 1;
					} else {

						/*
						 * If the current Player owns more than 1 Element, a static method of the
						 * MessageCentre class displays a message asking the current Player to select
						 * the Element they want to develop.
						 */
						MessageCentre.displaySelectElementToDevelopMessage(totalElementsOwned);

						/* Assigning the current Player's entry to the userOption1 variable. */
						userOption1 = scanner.nextInt();
					}

					/* Displays a message if the current Player does not enter a valid number. */
					if (userOption1 < 1 || userOption1 > totalElementsOwned) {
						System.out.println("\nA valid number was not entered.");
					}

					/*
					 * If the current Player enters something that is not a number, it is caught as
					 * an InputMismatchException.
					 */
				} catch (InputMismatchException inputMismatchException) {

					/* A message is displayed telling the user to enter a number. */
					System.out.println("\nA valid number was not entered.");

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();

					/* General exceptions or errors are caught as a general Exception. */
				} catch (Exception exception) {

					/* A message is displayed telling the user something went wrong. */
					System.out.println("Something went wrong. Try again.");
					exception.printStackTrace();

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();
				}

				/*
				 * Do-while loop continues to run until the current Player enters a valid number
				 * to select an Element to develop.
				 */
			} while (userOption1 < 1 || userOption1 > totalElementsOwned);

			/* Gets the Element that will be developed. */
			Element element = ((Element) currentPlayer.getPlayerElements().get(userOption1 - 1));

			/* Gets the name of the Element that will be developed. */
			String elementName = element.getSquareName();

			/* Gets the development cost of the Element that will be developed. */
			int developmentCost = element.getDevelopmentCost();

			/* Do-while loop that will run until the current Player enters 1 or 2. */
			do {
				try {

					/*
					 * Static method of MessageCentre class which displays a message asking the
					 * current Player if they wish to develop the selected Element.
					 */
					MessageCentre.displayDevelopElementMessage(elementName, developmentCost);

					/*
					 * Static method of MessageCentre class which displays a menu asking the current
					 * Player to choose to develop the Element or cancel developing the Element.
					 */
					MessageCentre.displayDevelopElementMenu();

					/* Assigning the current Player's entry to the userOption2 variable. */
					userOption2 = scanner.nextInt();

					/*
					 * Passing the userOption2 variable into a switch statement to determine which
					 * option they have chosen.
					 */
					switch (userOption2) {

					/*
					 * If 1 is entered by the current Player, they will develop the Element,
					 * provided they have enough funds to develop it.
					 */
					case 1:

						/*
						 * If statement checks if the current Player has enough funds to develop the
						 * Element.
						 */
						if (developmentCost > currentPlayer.getPlayerFunds()) {
							System.out.println("Insufficient funds to develop this element.");

							/* If they have enough funds, the Element is developed. */
						} else {

							/*
							 * Checks if the current Player owns the full system that the Element belongs
							 * to. If they don't, they Element can't be developed.
							 */
							if (!checkFullSystemOwned(currentPlayer, element.getSystemType())) {
								System.out.println("Full system not owned");
								break;
							}

							/* Gets the development level of the selected Element. */
							int currentDevelopmentLevel = element.getDevelopmentLevel();

							/*
							 * If the current development level of the Element is less than 3, the Element
							 * can be developed.
							 */
							if (currentDevelopmentLevel < 3) {
								element.setDevelopmentLevel(currentDevelopmentLevel + 1);

								/* Current Player's funds are updated after development. */
								currentPlayer.setPlayerFunds(currentPlayer.getPlayerFunds() - developmentCost);

								if (element.getDevelopmentLevel() == 1) {

									/*
									 * Static method of MessageCentre class displays a message showing the Element
									 * that was developed and it's new development level.
									 */
									MessageCentre.displayDevelopmentCompleteMessage(element.getDevelopmentLevel(),
											element.getDevelopmentLevel1Message());
								} else if (element.getDevelopmentLevel() == 2) {

									/*
									 * Static method of MessageCentre class displays a message showing the Element
									 * that was developed and it's new development level.
									 */
									MessageCentre.displayDevelopmentCompleteMessage(element.getDevelopmentLevel(),
											element.getDevelopmentLevel2Message());
								} else if (element.getDevelopmentLevel() == 3) {

									/*
									 * Static method of MessageCentre class displays a message showing the Element
									 * that was developed and it's new development level.
									 */
									MessageCentre.displayDevelopmentCompleteMessage(element.getDevelopmentLevel(),
											element.getDevelopmentLevel3Message());
								}

								/*
								 * displayPlayerFunds method of Player class is called to display the current
								 * Players new funds balance.
								 */
								currentPlayer.displayPlayerFunds();
							} else {

								/*
								 * If the current development level of the Element is 3, the Element can not be
								 * developed any further.
								 * 
								 */
								System.out.println("\nMajor Development Status has already been reached. This "
										+ "Element can't be developed any further");
							}
						}
						break;

					/*
					 * If 2 is entered by the current Player, they will cancel developing the
					 * Element.
					 */
					case 2:

						/*
						 * Static method of MessageCentre class that displays a message. explaining that
						 * the development of the Element was cancelled.
						 */
						MessageCentre.displayDevelopmentCancelledMessage(elementName);
						break;

					/*
					 * A message is displayed to the current Player if they enter a number that
					 * isn't between 1 and 2 inclusive.
					 */
					default:
						System.out.println("\nA valid number was not entered.");
					}

					/*
					 * If the current Player enters something that is not a number, it is caught as
					 * an InputMismatchException.
					 */
				} catch (InputMismatchException inputMismatchException) {

					/* A message is displayed telling the user to enter a number. */
					System.out.println("\nA valid number was not entered.");

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();

					/* General exceptions or errors are caught as a general Exception. */
				} catch (Exception exception) {

					/* A message is displayed telling the user something went wrong. */
					System.out.println("Something went wrong. Try again.");
					exception.printStackTrace();

					/* scanner.nextLine() is called to clear out the return character. */
					scanner.nextLine();
				}

				/* Do-while loop that will run until the current Player enters 1 or 2. */
			} while (userOption2 != 1 && userOption2 != 2);
		}
	}

	/**
	 * Method that allows a Player to develop an Element that they own.
	 * 
	 * This method will be called when the Player is currently positioned on the
	 * Element they want to develop.
	 * 
	 * @param currentPlayer    - Player object that represents the current player
	 *                         taking their turn.
	 * @param squarePositionID - The numeric position of the Element on the virtual
	 *                         game board.
	 * @param board            - ArrayList of Square objects which represents the
	 *                         virtual game board.
	 * @param scanner          - Scanner object to collect the user's keyboard
	 *                         entries.
	 */
	public void developElementWhenOnOwnedElement(Player currentPlayer, int squarePositionID, List<Square> board,
			Scanner scanner) {

		/*
		 * int variable to store the current Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption = 0;

		/*
		 * int variable which will represent the index of the Element that the current
		 * Player is positioned on.
		 */
		int elementID = 0;

		/* Loops through each Element that the current Player owns. */
		for (Square square : currentPlayer.getPlayerElements()) {

			/*
			 * If squarePositionID matches one of the Elements, the elementID is set as
			 * squarePositionID.
			 */
			if (square.getSquarePositionID() == squarePositionID) {
				elementID = currentPlayer.getPlayerElements().indexOf(square);
			}
		}

		/* Gets the Element that will be developed. */
		Element element = ((Element) currentPlayer.getPlayerElements().get(elementID));

		/* Gets the name of the Element that will be developed. */
		String elementName = element.getSquareName();

		/* Gets the development cost of the Element that will be developed. */
		int developmentCost = element.getDevelopmentCost();

		/* Do-while loop that will run until the current Player enters 1 or 2. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a message asking the
				 * current Player if they wish to develop the selected Element.
				 */
				MessageCentre.displayDevelopElementMessage(elementName, developmentCost);

				/*
				 * Static method of MessageCentre class which displays a menu asking the current
				 * Player to choose to develop the Element or cancel developing the Element.
				 */
				MessageCentre.displayDevelopElementMenu();

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the current Player, they will develop the Element,
				 * provided they have enough funds to develop it.
				 */
				case 1:

					/*
					 * If statement checks if the player has enough funds to purchase the Element.
					 */
					if (developmentCost > currentPlayer.getPlayerFunds()) {
						System.out.println("Insufficient funds to develop this element.");

						/* If they have enough funds, the Element is developed. */
					} else {

						/*
						 * Checks if the current Player owns the full system that the Element belongs
						 * to. If they don't, they Element can't be developed.
						 */
						if (!checkFullSystemOwned(currentPlayer, element.getSystemType())) {
							System.out.println("Full system not owned");
							break;
						}

						/* Gets the development level of the selected Element. */
						int currentDevelopmentLevel = element.getDevelopmentLevel();

						/*
						 * If the current development level of the Element is less than 3, the Element
						 * can be developed.
						 */
						if (currentDevelopmentLevel < 3) {
							element.setDevelopmentLevel(currentDevelopmentLevel + 1);

							/* Current Player's funds are updated after purchase. */
							currentPlayer.setPlayerFunds(currentPlayer.getPlayerFunds() - developmentCost);

							if (element.getDevelopmentLevel() == 1) {

								/*
								 * Static method of MessageCentre class displays a message showing the Element
								 * that was developed and it's new development level.
								 */
								MessageCentre.displayDevelopmentCompleteMessage(element.getDevelopmentLevel(),
										element.getDevelopmentLevel1Message());
							} else if (element.getDevelopmentLevel() == 2) {

								/*
								 * Static method of MessageCentre class displays a message showing the Element
								 * that was developed and it's new development level.
								 */
								MessageCentre.displayDevelopmentCompleteMessage(element.getDevelopmentLevel(),
										element.getDevelopmentLevel2Message());
							} else if (element.getDevelopmentLevel() == 3) {

								/*
								 * Static method of MessageCentre class displays a message showing the Element
								 * that was developed and it's new development level.
								 */
								MessageCentre.displayDevelopmentCompleteMessage(element.getDevelopmentLevel(),
										element.getDevelopmentLevel3Message());
							}

							/*
							 * displayPlayerFunds method of Player class is called to display the current
							 * Players new funds balance.
							 */
							currentPlayer.displayPlayerFunds();
						} else {

							/*
							 * If the current development level of the Element is 3, the Element can not be
							 * developed any further.
							 */
							System.out.println("\nMajor Development Status has already been reached. This "
									+ "Element can't be developed any further");
						}
					}
					break;

				/*
				 * If 2 is entered by the current Player, they will cancel developing the
				 * Element.
				 */
				case 2:

					/*
					 * Static method of MessageCentre class that displays a message. explaining that
					 * the development of the Element was cancelled.
					 */
					MessageCentre.displayDevelopmentCancelledMessage(elementName);
					break;

				/*
				 * A message is displayed to the current Player if they enter a number that
				 * isn't between 1 and 2 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the current Player enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the current Player to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the current Player something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/* Do while loop that will run until the current Player enters 1 or 2. */
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * Method that will check if a Player owns a full system when the Player
	 * attempts to develop an Element.
	 * 
	 * A System must be fully owned by a Player before they can develop any of the
	 * Elements within the System.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param systemType    - Name of the System that contains the Element that the
	 *                      current Player is attempting to develop.
	 * 
	 * @return - Returns true if the full System is owned by the current Player and
	 *         false if the full System is not owned by the current Player.
	 */
	public boolean checkFullSystemOwned(Player currentPlayer, String systemType) {

		/* boolean value that will be returned by this method. */
		boolean fullSystemOwned = false;

		/*
		 * int variables which will be used to assess how many Elements are owned in
		 * each System.
		 */
		int commandAndControlTotal = 0;
		int launchComplexTotal = 0;
		int spaceCraftTotal = 0;
		int trainingProgramTotal = 0;

		/* Loops through each Element owned by the current Player. */
		for (Square square : currentPlayer.getPlayerElements()) {

			/* Finds the System of each Element. */
			String elementSystem = ((Element) square).getSystemType();

			/*
			 * Increments the total values for each System if the current Player owns an
			 * Element within that System.
			 */
			if (elementSystem.equals(SystemType.COMMAND_AND_CONTROL.getSystemName())) {
				commandAndControlTotal++;
			} else if (elementSystem.equals(SystemType.LAUNCH_COMPLEX.getSystemName())) {
				launchComplexTotal++;
			} else if (elementSystem.equals(SystemType.SPACECRAFT.getSystemName())) {
				spaceCraftTotal++;
			} else if (elementSystem.equals(SystemType.TRAINING_PROGRAM.getSystemName())) {
				trainingProgramTotal++;
			}
		}

		/*
		 * Checks if the provided systemType argument matches any of the Systems and
		 * total values for each System match the number of Elements within that System.
		 * fullSystemOwned is set to true if a match is found.
		 */
		if (systemType.equals(SystemType.COMMAND_AND_CONTROL.getSystemName()) && commandAndControlTotal == 3) {
			fullSystemOwned = true;
		} else if (systemType.equals(SystemType.LAUNCH_COMPLEX.getSystemName()) && launchComplexTotal == 3) {
			fullSystemOwned = true;
		} else if (systemType.equals(SystemType.SPACECRAFT.getSystemName()) && spaceCraftTotal == 2) {
			fullSystemOwned = true;
		} else if (systemType.equals(SystemType.TRAINING_PROGRAM.getSystemName()) && trainingProgramTotal == 2) {
			fullSystemOwned = true;
		}

		/* Value of fullSystemOwned is returned. */
		return fullSystemOwned;
	}

	/**
	 * Method that creates and returns an ArrayList of Square / Element objects.
	 * 
	 * Each individual Square / Element is created within this method and added to
	 * the ArrayList.
	 * 
	 * This will represent the virtual game board of the ArtemisLite game.
	 * 
	 * @return - ArrayList of Square / Element objects representing the virtual game
	 *         board.
	 */
	public ArrayList<Square> initialiseBoard() {

		/* Creates a new ArrayList to store Square objects. */
		ArrayList<Square> board = new ArrayList<Square>();

		/*
		 * String variables created to hold the descriptions of each Square / Element.
		 * Variables will be passed to the constructors of each Square / Element
		 */
		String square1Description = "You will receive " + PAYROLL_BONUS
				+ " Commitment Coins every time you land on or pass this square.";
		String square2Description = "This will transport your Mobile Launcher Platform and Spacecraft to the "
				+ "Launch Pad.";
		String square3Description = "Your Spacecraft will sit atop of this platform and will be launched from it.";
		String square4Description = "Your Crawler-Transporter will transport your Mobile Launcher Platform and "
				+ "Spacecraft\nto this piece\nof ground at John F. Kennedy Space Center for launch.";
		String square5Description = "Astronauts will conduct training here in preperation for the zero-gravity "
				+ "conditions experienced in space.";
		String square6Description = "Astronauts will learn how to operate the Orion Multi-Purpose Crew Vehicle "
				+ "(Orion MPCV) by\ntraining in a realistic simulator.";
		String square7Description = "No work activity will be conducted when present on this square.";
		String square8Description = "This is the state of the art software system that will support the entire "
				+ "Artemis mission.";
		String square9Description = "All aspects of the Artemis mission will be coordinated from here.";
		String square10Description = "This network will facilitate communications throughout the Artemis mission.";
		String square11Description = "This is the exploration vehicle that will carry the crew to space and to "
				+ "the moon.";
		String square12Description = "This is the launch vehicle that will launch the Orion Orion Multi-Purpose "
				+ "Crew Vehicle\n(Orion MPCV) into space.";

		/*
		 * String variables created to hold the development level messages of each
		 * Square / Element. Variables will be passed to the constructors of each Square
		 * / Element
		 */
		String square2DevLevel1Message = "Crawler-Transporter has been developed to Level 1.\nMobile Launcher "
				+ "Platforms and Spacecraft can now be transported to the launch pad for launching.";
		String square2DevLevel2Message = "Crawler-Transporter has been developed to Level 2.\nImprovements to "
				+ "the Motor Control Center, engines and ventilation systems have been provided.";
		String square2DevLevel3Message = "Crawler-Transporter has been fully developed to Level 3 (Super Crawler)."
				+ "\nLifting capacity has been increased from 5,400 to 8,200 tonnes to support the new Space "
				+ "Launch System rocket.";

		String square3DevLevel1Message = "Mobile Launcher Platform has been developed to Level 1.\nThis platform "
				+ "can support the launch of 1960s / 1970s era Saturn V rockets.";
		String square3DevLevel2Message = "Mobile Launcher Platform has been developed to Level 2.\nThis platform "
				+ "can now support the launch of 1980s / 1990s era Space Shuttles.";
		String square3DevLevel3Message = "Mobile Launcher Platform has been fully developed to Level 3.\nThis "
				+ "platform can now support the launch of the new Space Launch System rocket.";

		String square4DevLevel1Message = "Launch Pad has been developed to Level 1.\nThis Launch Pad can now "
				+ "support the launch of 1960s / 1970s era Saturn V rockets.";
		String square4DevLevel2Message = "Launch Pad has been developed to Level 2.\nThis Launch Pad can now "
				+ "support the launch of 1980s / 1990s era Space Shuttles.";
		String square4DevLevel3Message = "Launch Pad has been fully developed to Level 3.\nThis Launch Pad can "
				+ "now support the launch of the new Space Launch System rocket.";

		String square5DevLevel1Message = "Neutral Buoyancy Laboratory Training developed to Level 1.\nAstronaut "
				+ "training can take place when a suitable diving tank has been developed.";
		String square5DevLevel2Message = "Neutral Buoyancy Laboratory Training developed to Level 2.\nAstronauts "
				+ "can now train in a diving tank to simulate a microgravity environment.";
		String square5DevLevel3Message = "Neutral Buoyancy Laboratory Training fully developed to Level 3.\n"
				+ "Astronauts can now perform training specific to the Artemis missions.";

		String square6DevLevel1Message = "Orion Spacecraft Simulator Training developed to Level 1.\nDesign plans "
				+ "have been completed for the development of the Orion Spacecraft Simulator.";
		String square6DevLevel2Message = "Orion Spacecraft Simulator Training developed to Level 2.\nThe exterior "
				+ "of the simulator has been developed and delivered to Johnson Space Center.";
		String square6DevLevel3Message = "Orion Spacecraft Simulator Training fully developed to Level 3.\nThe "
				+ "interior of the simulator has been outfitted with Orion�s display and control system and crew "
				+ "seats and is ready for\nastronaut training.";

		String square8DevLevel1Message = "Spaceport Command and Control System (SCCS) developed to Level 1.\nThe "
				+ "SCCS has passed the Preliminary Design Review.";
		String square8DevLevel2Message = "Spaceport Command and Control System (SCCS) developed to Level 2.\nThe "
				+ "SCCS has passed System and Implementation testing.";
		String square8DevLevel3Message = "Spaceport Command and Control System (SCCS) fully developed to Level 3."
				+ "\nThe SCCS has been implemented and is now fully operational.";

		String square9DevLevel1Message = "Mission Control Center (MCC) developed to Level 1.\nThe MCC can now "
				+ "support launches of 1960s 1970s era Saturn V rockets.";
		String square9DevLevel2Message = "Mission Control Center (MCC) developed to Level 2.\nThe MCC can now "
				+ "support launches of 1980s 1990s era Space Shuttles.";
		String square9DevLevel3Message = "Mission Control Center (MCC) fully developed to Level 3.\nThe MCC can "
				+ "now support launches of the new Space Launch System rocket and Artemis missions.";

		String square10DevLevel1Message = "Space Communications and Navigation developed to Level 1.\nThe Near "
				+ "Space Network has been developed, allowing communications with Artemis during launch as well "
				+ "as navigation\nservices throughout the mission to be achieved.";
		String square10DevLevel2Message = "Space Communications and Navigation developed to Level 2.\nThe Tracking "
				+ "and Data Relay Satellites have been developed, allowing communications with Artemis during "
				+ "low-Earth orbit\nto be achieved.";
		String square10DevLevel3Message = "Space Communications and Navigation fully developed to Level 3.\nThe "
				+ "Deep Space Network has been developed, allowing communications with Artemis en route to and in "
				+ "orbit around the Moon to be achieved.";

		String square11DevLevel1Message = "Orion Multi-Purpose Crew Vehicle (MPCV) developed to Level 1.\nThe "
				+ "Orion MPCV has successfully passed the Preliminary Design Review.";
		String square11DevLevel2Message = "Orion Multi-Purpose Crew Vehicle (MPCV) developed to Level 2.\nThe "
				+ "Orion MPCV has successfully passed Flight and Abort testing.";
		String square11DevLevel3Message = "Orion Multi-Purpose Crew Vehicle (MPCV) fully developed to Level 3."
				+ "\nThe Orion MPCV has been fully assembled in preparation for launch.";

		String square12DevLevel1Message = "Space Launch System developed to Level 1.\nThe Space Launch System "
				+ "has successfully passed the Preliminary Design Review.";
		String square12DevLevel2Message = "Space Launch System developed to Level 2.\nThe Space Launch System "
				+ "Core Stage has successfully passed the Static Firing test program.";
		String square12DevLevel3Message = "Space Launch System fully developed to Level 3.\nThe Space Launch "
				+ "System has been fully assembled in preparation for launch.";

		/*
		 * Squares / Elements are created within a try-catch block to handle any
		 * Exceptions if invalid values are passed to the Square / Element constructors.
		 */
		try {

			/*
			 * Creates the starting Square of the virtual game board, which is a Payroll
			 * object. Players will collect funds when they land on or pass this square.
			 */
			Payroll square1 = new Payroll(SquareName.PAYROLL, square1Description, 1, PAYROLL_BONUS);

			/*
			 * Creating the 2nd Square of the virtual game board, which is an Element. This
			 * Element represents the Crawler-Transporter, which is part of a 3 Element
			 * system.
			 */
			Element square2 = new Element(SquareName.CRAWLER_TRANSPORTER, square2Description, 2,
					SystemType.LAUNCH_COMPLEX, false, null, STANDARD_PURCHASE_COST, 0, STANDARD_DEVELOPMENT_COST,
					square2DevLevel1Message, square2DevLevel2Message, square2DevLevel3Message);

			/*
			 * Creating the 3rd Square of the virtual game board, which is an Element. This
			 * Element represents the Mobile Launcher Platform, which is part of a 3 Element
			 * system.
			 */
			Element square3 = new Element(SquareName.MOBILE_LAUNCHER_PLATFORM, square3Description, 3,
					SystemType.LAUNCH_COMPLEX, false, null, STANDARD_PURCHASE_COST, 0, STANDARD_DEVELOPMENT_COST,
					square3DevLevel1Message, square3DevLevel2Message, square3DevLevel3Message);

			/*
			 * Creating the 4th Square of the virtual game board, which is an Element. This
			 * Element represents the Launch Pad, which is part of a 3 Element system.
			 */
			Element square4 = new Element(SquareName.LAUNCH_PAD, square4Description, 4, SystemType.LAUNCH_COMPLEX,
					false, null, STANDARD_PURCHASE_COST, 0, STANDARD_DEVELOPMENT_COST, square4DevLevel1Message,
					square4DevLevel2Message, square4DevLevel3Message);

			/*
			 * Creating the 5th Square of the virtual game board, which is an Element. This
			 * Element represents the Neutral Buoyancy Laboratory Training, which is part of
			 * a 2 Element system and is the least expensive system.
			 */
			Element square5 = new Element(SquareName.NEUTRAL_BUOYANCY_LABORATORY_TRAINING, square5Description, 5,
					SystemType.TRAINING_PROGRAM, false, null, MIN_PURCHASE_COST, 0, MIN_DEVELOPMENT_COST,
					square5DevLevel1Message, square5DevLevel2Message, square5DevLevel3Message);

			/*
			 * Creating the 6th Square of the virtual game board, which is an Element. This
			 * Element represents the Orion Spacecraft Simulator Training which is part of a
			 * 2 Element system and is the least expensive system.
			 */
			Element square6 = new Element(SquareName.ORION_SPACECRAFT_SIMULATOR_TRAINING, square6Description, 6,
					SystemType.TRAINING_PROGRAM, false, null, MIN_PURCHASE_COST, 0, MIN_DEVELOPMENT_COST,
					square6DevLevel1Message, square6DevLevel2Message, square6DevLevel3Message);

			/*
			 * Creating the 7th Square of the virtual game board, which is an UnpaidLeave
			 * Square. Nothing happens when a Player lands on this Square, and they can not
			 * make any purchases / developments.
			 */
			UnpaidLeave square7 = new UnpaidLeave(SquareName.UNPAID_LEAVE, square7Description, 7);

			/*
			 * Creating the 8th Square of the virtual game board, which is an Element. This
			 * Element represents the Spaceport Command and Control System, which is part of
			 * a 3 Element system.
			 */
			Element square8 = new Element(SquareName.SPACEPORT_COMMAND_AND_CONTROL_SYSTEM, square8Description, 8,
					SystemType.COMMAND_AND_CONTROL, false, null, STANDARD_PURCHASE_COST, 0, STANDARD_DEVELOPMENT_COST,
					square8DevLevel1Message, square8DevLevel2Message, square8DevLevel3Message);

			/*
			 * Creating the 9th Square of the virtual game board, which is an Element. This
			 * Element represents the Mission Control Center, which is part of a 3 Element
			 * system.
			 */
			Element square9 = new Element(SquareName.MISSION_CONTROL_CENTRE, square9Description, 9,
					SystemType.COMMAND_AND_CONTROL, false, null, STANDARD_PURCHASE_COST, 0, STANDARD_DEVELOPMENT_COST,
					square9DevLevel1Message, square9DevLevel2Message, square9DevLevel3Message);

			/*
			 * Creating the 10th Square of the virtual game board, which is an Element. This
			 * Element represents the Space Communications and Navigation, which is part of
			 * a 3 Element system.
			 */
			Element square10 = new Element(SquareName.SPACE_COMMUNICATIONS_AND_NAVIGATION, square10Description, 10,
					SystemType.COMMAND_AND_CONTROL, false, null, STANDARD_PURCHASE_COST, 0, STANDARD_DEVELOPMENT_COST,
					square10DevLevel1Message, square10DevLevel2Message, square10DevLevel3Message);

			/*
			 * Creating the 11th Square of the virtual game board, which is an Element. This
			 * Element represents the Orion Multi-Purpose Crew Vehicle, which is part of a 2
			 * Element system and is the most expensive system.
			 */
			Element square11 = new Element(SquareName.ORION_MULTIPURPOSE_CREW_VEHICLE, square11Description, 11,
					SystemType.SPACECRAFT, false, null, MAX_PURCHASE_COST, 0, MAX_DEVELOPMENT_COST,
					square11DevLevel1Message, square11DevLevel2Message, square11DevLevel3Message);

			/*
			 * Creating the 12th Square of the virtual game board, which is an Element. This
			 * Element represents the Space Launch System, which is part of a 2 Element
			 * system and is the most expensive system.
			 */
			Element square12 = new Element(SquareName.SPACE_LAUNCH_SYSTEM, square12Description, 12,
					SystemType.SPACECRAFT, false, null, MAX_PURCHASE_COST, 0, MAX_DEVELOPMENT_COST,
					square12DevLevel1Message, square12DevLevel2Message, square12DevLevel3Message);

			/* Adding all Square / Element objects to the board List. */
			board.add(square1);
			board.add(square2);
			board.add(square3);
			board.add(square4);
			board.add(square5);
			board.add(square6);
			board.add(square7);
			board.add(square8);
			board.add(square9);
			board.add(square10);
			board.add(square11);
			board.add(square12);

			/* Catching any Exceptions that occur when Squares / Elements are created. */
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(
					"An invalid value has been used when creating a Square or Element on the virtual game board.");
			illegalArgumentException.printStackTrace();
			/* Catching any general Exceptions if something goes wrong. */
		} catch (Exception exception) {
			System.out.println("Something went wrong. Try again.");
			exception.printStackTrace();
		}

		/* Returns the created virtual game board of Square / Element objects. */
		return board;
	}

	/**
	 * Method that asks the owner of an Element if they want to charge tax whenever
	 * another Player lands on an Element they own.
	 * 
	 * @param currentPlayer - Player object that represents the current player
	 *                      taking their turn.
	 * @param elementOwner  - The owner of an Element that the current Player has
	 *                      landed on.
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param element       - The Element object that the current Player is
	 *                      positioned on.
	 * @param scanner       - Scanner object to collect the user's keyboard entries.
	 */
	public void payTax(Player currentPlayer, String elementOwner, List<Player> playerList, Element element,
			Scanner scanner) {

		/*
		 * int variable to store the Element owner's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption = 0;

		/* String variable to store the name of the current Player. */
		String currentPlayerName = currentPlayer.getPlayerName();

		/*
		 * Static method of MessageCentre class which displays a message explaining that
		 * the current Player may have to pay tax for landing on an Element owned by
		 * another Player.
		 */
		MessageCentre.displayPayTaxMessage(currentPlayer.getPlayerName(), elementOwner);

		/*
		 * Static method of MessageCentre class which displays a menu asking the Element
		 * owner if they want to charge the current Player tax for landing on their
		 * Element.
		 */
		MessageCentre.displayPayTaxMenu();

		/* Do-while loop that will run until the Element owner enters 1 or 2. */
		do {
			try {

				/* Assigning the Element owner's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the Element owner, the current Player will pay tax to the
				 * Element owner.
				 */
				case 1:

					/* int variable to store the amount of tax that will be charged. */
					int taxAmount = 0;

					/*
					 * Calculating the amount of tax that will be charged (10% of purchase cost +
					 * completed development costs of Element).
					 */
					if (element.getDevelopmentLevel() == 0) {
						taxAmount = element.getPurchaseCost() / 10;
					} else if (element.getDevelopmentLevel() == 1) {
						taxAmount = (element.getPurchaseCost() + element.getDevelopmentCost()) / 10;
					} else if (element.getDevelopmentLevel() == 2) {
						taxAmount = (element.getPurchaseCost() + (element.getDevelopmentCost() * 2)) / 10;
					} else {
						taxAmount = (element.getPurchaseCost() + (element.getDevelopmentCost() * 3)) / 10;
					}

					/* int variable to hold the current Player's funds balance. */
					int currentPlayerFunds = currentPlayer.getPlayerFunds();

					/* Checking if the current Player has enough funds to pay the tax. */
					if (taxAmount > currentPlayerFunds) {
						System.out.printf(
								"%s does not have enough Commitment Coins to pay the full tax for this "
										+ "Element. They can only pay %d. Taxing them will cause them to go bankrupt"
										+ "and the mission will be over. Are you sure you want to charge them tax?",
								currentPlayerName, currentPlayerFunds);

						/* Calling the confirmPayTax method of the ArtemisLite class. */
						confirmPayTax(currentPlayer, elementOwner, playerList, currentPlayerFunds, taxAmount, scanner);

					} else if (taxAmount == currentPlayerFunds) {
						System.out.printf("Taxing %s will cause them to go bankrupt and the mission will be over. "
								+ "Are you sure you want to charge them tax?", currentPlayerName);

						/* Calling the confirmPayTax method of the ArtemisLite class. */
						confirmPayTax(currentPlayer, elementOwner, playerList, currentPlayerFunds, taxAmount, scanner);
					} else {

						/*
						 * Update the current Player's funds by passing their current balance amount to
						 * the setPlayerFunds method of the Player class and subtracting the tax amount.
						 */
						currentPlayer.setPlayerFunds(currentPlayerFunds - taxAmount);

						/* Loop through all Players in playerList. */
						for (Player player : playerList) {

							/*
							 * If getPlayerName matches elementOwner, the funds for elementOwner get updated
							 * with the tax amount.
							 */
							if (player.getPlayerName().equals(elementOwner)) {

								/* int variable to hold elementOwner's funds balance. */
								int elementOwnerFunds = player.getPlayerFunds();

								/*
								 * Update elementOwner's funds by passing their current balance amount to the
								 * setPlayerFunds method of the Player class and adding the tax amount.
								 */
								player.setPlayerFunds(elementOwnerFunds + taxAmount);

								/* Display message explaining that tax has been charged. */
								MessageCentre.displayTaxNoticeMessage(taxAmount);

								/* Display elementOwner's new funds balance. */
								player.displayPlayerFunds();
							}
						}

						/* Displays the current Player's new funds balance. */
						currentPlayer.displayPlayerFunds();
					}
					break;

				/*
				 * If 2 is entered by the Element owner, the current Player does not have to pay
				 * tax.
				 */
				case 2:

					/*
					 * Static method of MessageCentre class which displays a message explaining that
					 * the Element owner has declined to ask for tax to be paid.
					 */
					MessageCentre.displayTaxWaivedMessage(elementOwner);
					break;

				/*
				 * A message is displayed to the Element owner if they enter a number that isn't
				 * between 1 and 2 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the Element owner enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the Element owner to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the Element owner something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/* Do-while loop that will run until the Element owner enters 1 or 2. */
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * 
	 * @param currentPlayer      - Player object that represents the current player
	 *                           taking their turn.
	 * @param elementOwner       - The owner of an Element that the current Player
	 *                           has landed on.
	 * @param playerList         - List of Player objects that are playing the game.
	 * @param currentPlayerFunds
	 * @param taxAmount          - Amount of tax that the current Player will be
	 *                           charged for landing on an Element.
	 * @param scanner            - Scanner object to collect the user's keyboard
	 *                           entries.
	 */
	public void confirmPayTax(Player currentPlayer, String elementOwner, List<Player> playerList,
			int currentPlayerFunds, int taxAmount, Scanner scanner) {

		/*
		 * int variable to store the current Player's input from an instance of the
		 * Scanner class. Initially set to 0.
		 */
		int userOption = 0;

		/* Do-while loop that will run until the current Player enters 1 or 2. */
		do {
			try {

				/*
				 * Static method of MessageCentre class which displays a menu asking the current
				 * Player to confirm they want to charge tax.
				 */
				MessageCentre.displayPayTaxMenu();

				/* Assigning the current Player's entry to the userOption variable. */
				userOption = scanner.nextInt();

				/*
				 * Passing the userOption variable into a switch statement to determine which
				 * option they have chosen.
				 */
				switch (userOption) {

				/*
				 * If 1 is entered by the Element owner, the current Player will pay tax to the
				 * Element owner.
				 */
				case 1:

					/*
					 * Update the current Player's funds by setting it to 0, as this method is only
					 * called if the current Player doesn't have enough funds or has exactly the
					 * right amount of funds to pay the tax amount.
					 */
					currentPlayer.setPlayerFunds(0);

					/* Loop through all Players in playerList. */
					for (Player player : playerList) {

						/*
						 * If getPlayerName matches elementOwner, the funds for elementOwner get updated
						 * with the tax amount.
						 */
						if (player.getPlayerName().equals(elementOwner)) {

							/* int variable to hold elementOwner's funds balance. */
							int elementOwnerFunds = player.getPlayerFunds();

							/*
							 * Checks if the Element owner will receive the full amount of tax, or just the
							 * amount of funds that the current Player has.
							 */
							if (taxAmount > currentPlayerFunds) {

								/*
								 * Update elementOwner's funds by passing their current balance amount to the
								 * setPlayerFunds method of the Player class and adding the current Player's
								 * Funds.
								 */
								player.setPlayerFunds(elementOwnerFunds + currentPlayerFunds);
							} else {

								/*
								 * Update elementOwner's funds by passing their current balance amount to the
								 * setPlayerFunds method of the Player class and adding the tax amount.
								 */
								player.setPlayerFunds(elementOwnerFunds + taxAmount);
							}

							/* Display message explaining that tax has been charged. */
							MessageCentre.displayTaxNoticeMessage(taxAmount);

							/* Display elementOwner's new funds balance. */
							player.displayPlayerFunds();
						}
					}

					/* Displays the current Player's new funds balance. */
					currentPlayer.displayPlayerFunds();

					break;

				/*
				 * If 2 is entered by the Element owner, the current Player does not have to pay
				 * tax.
				 */
				case 2:

					/*
					 * Static method of MessageCentre class which displays a message explaining that
					 * the Element owner has declined to ask for tax to be paid.
					 */
					MessageCentre.displayTaxWaivedMessage(elementOwner);
					break;

				/*
				 * A message is displayed to the Element owner if they enter a number that isn't
				 * between 1 and 2 inclusive.
				 */
				default:
					System.out.println("\nA valid number was not entered.");
				}

				/*
				 * If the Element owner enters something that is not a number, it is caught as
				 * an InputMismatchException.
				 */
			} catch (InputMismatchException inputMismatchException) {

				/* A message is displayed telling the Element owner to enter a number. */
				System.out.println("\nA valid number was not entered.");

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();

				/* General exceptions or errors are caught as a general Exception. */
			} catch (Exception exception) {

				/* A message is displayed telling the Element owner something went wrong. */
				System.out.println("Something went wrong. Try again.");
				exception.printStackTrace();

				/* scanner.nextLine() is called to clear out the return character. */
				scanner.nextLine();
			}

			/* Do while loop that will run until the Element owner enters 1 or 2. */
		} while (userOption != 1 && userOption != 2);
	}
	


}
