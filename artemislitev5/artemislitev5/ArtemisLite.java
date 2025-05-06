/**
 * 
 */
package artemislitev5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class ArtemisLite {

	/**
	 * ArrayList to hold Player objects for players that are playing the game.
	 */
	private List<Player> playerList;

	/**
	 * ArrayListList to hold Square objects that will represent the squares and
	 * elements of the virtual game board.
	 */
	private List<Square> board;

	/**
	 * To be used to create an instance of the Dice class.
	 */
	Dice dice;

	/**
	 * int variable which will store the number of players that will be playing each
	 * instance of the game.
	 */
	int numOfPlayers;

	/**
	 * Method that begins an iteration of the game
	 */
	public void playGame(Scanner scanner) {
		// Initialising the instance variable playerList, which will hold instances of
		// the Player class which relate to each player currently playing the game
		playerList = new ArrayList<Player>();

		// creating an instance of the Dice class, creating a Dice object that has 6
		// sides
		try {
			dice = new Dice(6);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// calls the initialiseBoard method of the ArtemisLite class
		// this method creates a virtual game board containing Square objects
		board = initialiseBoard();

		// String variable to capture the name of each player
		String playerName;

		// Static method of MessageCentre class which displays a message explaining that
		// the game needs to know how many players will be playing - must be between 1
		// and 4 inclusive
		MessageCentre.displayPlayerEnrolmentMessage();

		// do-while loop which contains running if the user does not enter a number
		// between 1 and 4 inclusive
		do {
			try {
				// Static method of MessageCentre class which displays a message asking the user
				// how many players will be playing the game - must be between 1 and 4 inclusive
				MessageCentre.displayNumOfPlayersRequiredMessage();

				// Assigning the user's entry to the numOfPlayers variable
				numOfPlayers = scanner.nextInt();

				// if statement which checks if the number provided was less than 1 or greater
				// than 4
				if (numOfPlayers < 1 || numOfPlayers > 4) {
					System.out.println("\nA valid number was not entered.\n");
				}
				// catches Exceptions if a non-number value was entered by the user
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.\n");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
				// catches Exceptions if any other problems occur
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
			// While the number that the user enters is not between 1 and 4, the do while
			// loop enters another iteration
		} while (numOfPlayers < 1 || numOfPlayers > 4);

		// Static method of MessageCentre class which displays a message showing how
		// many players will be playing the game
		MessageCentre.displayNumOfPlayersEnrolledMessage(numOfPlayers);

		// Static method of MessageCentre class which displays a message asking the user
		// to enter the names of each player that will be playing the game
		MessageCentre.displayPlayerNameRequiredMessage(numOfPlayers);

		// clears out the return character of Scanner class
		scanner.nextLine();

		// boolean variable which will be used to assess if a valid name has been
		// entered
		boolean validName;

		// for loop which will ask the user to enter the name of each player, using the
		// value of numOfPlayers for the number of iterations
		// initial loop value begins at 1, so that playerNum loop value can be used to
		// set the playerID attribute of the Player class
		for (int playerNum = 1; playerNum <= numOfPlayers; playerNum++) {
			// do-while loop which will run while validName is false
			do {
				// validName initially set as true
				validName = true;

				// message asking for the user to enter the player name
				System.out.printf("\nPlayer %d Name:\n", playerNum);
				playerName = scanner.nextLine();

				// if statement checks if a blank entry has been provided
				if (playerName.isEmpty()) {
					System.out.println("The player name can not be blank. Please enter a name to continue.");
					// validName is then set as false, meaning the do-while loop will iterate again
					validName = false;
				} else {
					// for loop which iterates through the playerList and compares the recently
					// entered name with the playerName attribute of each Player object
					for (Player player : playerList) {
						// if the playerName is the same as the playerName attribute of a Player object,
						// a message is displayed
						if (playerName.equalsIgnoreCase(player.getPlayerName())) {
							System.out.println("\nThis name has already been used. Please enter another name.");
							// validName is then set as false, meaning the do-while loop will iterate again
							validName = false;
							break;
						}
					}
				}
			} while (!validName);
			// playerList instance variable is populated with new Player objects
			playerList.add(new Player(playerName, playerNum, 1000));
		}

		if (playerList.size() == 1) {
			// Static method of MessageCentre class which displays a message showing the
			// playing order for each player - if only 1 player has been enrolled, this
			// message
			// will display that the playing order does not need to be determined
			MessageCentre.displayPlayerOrderMessage(playerList);
		} else {
			// Static method of MessageCentre class which displays a message explaining that
			// the playing order for each player will be determined by each player rolling 2
			// dice and the highest scorer will go first
			MessageCentre.displayDeterminePlayerOrderMessage();

			// Calling the determinePlayOrder method of this class to sort the playerList to
			// determine the playing order
			determinePlayOrder(playerList, dice);

			// Static method of MessageCentre class which displays a message showing the
			// playing order for each player
			MessageCentre.displayPlayerOrderMessage(playerList);
		}

		System.out.println("\nLet's play!");

		turnManager(playerList, dice, scanner);

	}

	public void turnManager(List<Player> playerList, Dice dice, Scanner scanner) {
		// int variable to store the user's input from an instance of a Scanner class
		// Originally initialised to 0
		int userOption = 0;

		// int variable that will be used to check which player's turn it is
		int playerTurn = 0;

		// String variable that will be used to contain the name of a player that is
		// currently taking their turn
		String playerName = "";

		// int variable that will be used to hold the number that each player rolls
		// using a dice
		int numRolled = 0;

		// int variable that will be used to hold each player's current position on the
		// virtual game board
		int currentPosition = 0;

		// int variable that will be used to hold each player's new position on the
		// virtual game board
		int newPosition = 0;

		// boolean variable that will be used to assess if a player has rolled the dice
		// during their turn
		boolean hasRolled = false;

		// boolean variable that will be used to check if any player has decided to quit
		// during the game
		boolean quitGame = false;

		// boolean variable that will be used to check if any player has gone bankrupt
		boolean playerBankrupt = false;

		// String variable that will be used to contain the name of a player that has
		// gone bankrupt
		String whoIsBankrupt = "";

		// Do while loop that will run until the value of quitGame or playerBankrupt
		// becomes true
		do {
			// Try catch block that catches any non-numeric entries from the user
			try {
				// get the current player from playerList
				Player player = playerList.get(playerTurn);

				// String variable which retrieves the name of the current player from
				// playerList based on the value of playerTurn
				playerName = player.getPlayerName();

				// checking that if the player has just landed on unpaid leave, if so a
				// different restricted menu is displayed to screen as it is frustrating for
				// users to see options which do not apply to them.
				currentPosition = playerList.get(playerTurn).getPlayerPosition();

				if ((playerList.size() == 1) && (currentPosition == 7)) {
					MessageCentre.displayPlayerTurnMenuSoloGamePlayUnpaidLeave(playerName);
				} else if ((hasRolled == true) && (currentPosition == 7)) {
					MessageCentre.displayPlayerTurnMenuUnpaidLeave(playerName);
				} else if (playerList.size() == 1) {
					MessageCentre.displayPlayerTurnMenuSoloGamePlay(playerName);
					player.setFundsFrozen(false);
				} else {
					// Static method of MessageCentre class which displays a message showing which
					// player's turn it is and the options they can choose during their turn
					MessageCentre.displayPlayerTurnMenu(playerName);
				}

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// If 1 is entered by the user, the player will roll the dice
				case 1:
					// checks if the player has already rolled the dice during this turn
					if (hasRolled == false) {
						// rolling 2 dice
						numRolled = dice.roll(2);

						// creating the player's new position on the board using the newPlayerPositon
						// method of ArtemisLite class
						newPosition = newPlayerPosition(numRolled, currentPosition);

						// updating the playerPosition variable of the Player object
						playerList.get(playerTurn).setPlayerPosition(newPosition);

						// Static method of MessageCentre class which displays a message showing what
						// the player rolled with the dice and what square of the board they landed on
						MessageCentre.displayPlayerRollDiceMessage(playerName, numRolled, newPosition);

						// if the player lands on square 1 or passes square 1 they
						// collect new funds
						if (newPosition == 1) {
							player.setPlayerFunds(player.getPlayerFunds() + 100);
						} else if (newPosition < currentPosition) {
							player.setPlayerFunds(player.getPlayerFunds() + 100);
							// Static method of MessageCentre class which displays a message telling
							// the player they have passed the Payroll square and collected funds
							MessageCentre.displayPassPayrollMessage(playerName, 100);
							player.displayPlayerFunds();
						}

						// elementOptions method of ArtemisLite class is called which displays and
						// manages the options the player can choose when they land on a Square
						elementOptions(player, playerList, newPosition, board, scanner);

						if (player.getPlayerFunds() == 0) {
							playerBankrupt = true;
							whoIsBankrupt = player.getPlayerName();
						}

						// set hasRolled to true
						if (playerList.size() > 1) {
							hasRolled = true;
						}
						break;
					} else if ((playerList.size() > 1) && (newPosition == 7)) {
						System.out.println("\nA valid number was not entered.");
						break;
					} else {
						// inform the player they have already rolled the dice during this turn
						System.out.printf("\n%s has already rolled the dice during this turn. Please select "
								+ "another option.\n", playerName);
						break;
					}
					// If 2 is entered by the user, the player can select an element to develop
				case 2:
					if (player.isFundsFrozen() == false) {
						developElement(player, board, scanner);

						if (player.getPlayerFunds() == 0) {
							playerBankrupt = true;
							whoIsBankrupt = player.getPlayerName();
						}
					} else {
						// inform the player they can not develop an Element when on the UnpaidLeave
						// square
						System.out.println("\nA valid number was not entered.");
					}
					break;
				// If 3 is entered by the user, an overview of their current status will be
				// displayed
				case 3:
					player.displayStatus();
					break;
				// If 4 is entered by the user, the rules of the game will be displayed
				case 4:
					MessageCentre.displayRules();
					break;
				// If 5 is entered by the user, the player will skip their turn
				case 5:
					if (playerList.size() == 1) {
						System.out.println("\nA valid number was not entered.");
						break;
					} else {
						playerTurn++;
						hasRolled = false;
						player.setFundsFrozen(false);
						break;
					}
					// If 6 is entered by the user, the game will quit
				case 6:
					// calls the quitArtemisInGame method of the ArtemisLite class
					// if quitArtemisInGame returns false, quitGame will be false
					// if quitArtemisInGame returns true, quitGame will be true
					if (!quitArtemisInGame(scanner)) {
						quitGame = false;
						System.out.println("\nWe are glad you have chosen to stay with NASA and complete the "
								+ "ArtemisLite mission!");
					} else {
						quitGame = true;
					}
					break;
				// A message is displayed to the user if they enter that isn't
				// between 1 and 6
				default:
					System.out.println("\nA valid number was not entered.");
				}
				// If the user enters something that is not a number, it is caught as an
				// InputMismatchException
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
			// if statement checks if playerTurn is equal to the size of playerList, which
			// would mean the last player in the list has taken their turn. It then reverts
			// back to 0 so the first player in the list can take their next turn.
			// A check is also made to check if only 1 player is playing. If so, playerTurn
			// will always be 0
			if (playerTurn == playerList.size() || playerList.size() == 1) {
				playerTurn = 0;
			}

			// for loop checks each player in playerList, if it finds that at least one
			// player has gone bankrupt then the value of playerBankrupt will be changed to
			// true
			// for (Player player : playerList) {
			// if (player.isBankrupt() == true) {
			// playerBankrupt = true;
			// whoIsBankrupt = player.getPlayerName();
			// }
			// }
			// while condition checks if quitGame and playerBankrupt remain false
		} while ((quitGame == false) && (playerBankrupt == false));

		// if quitGame equals true, a message is displayed showing who quit the game
		if (quitGame == true) {
			MessageCentre.displayQuitFromGamePlayMessage(playerName);
			System.out.println("\nGame Over!");
			// if playerBankrupt equals true, a message is displayed showing who went
			// bankrupt
		} else if (playerBankrupt == true) {
			MessageCentre.displayPlayerBankruptMessage(whoIsBankrupt);
			System.out.println("\nGame Over!");
		}
	}

	public boolean quitArtemisInGame(Scanner scanner) {

		// boolean variable to assess if the player confirms they want to quit
		// originally initialised to false
		boolean confirmQuitGame = false;

		// int variable to store the user's input from an instance of a Scanner class
		// originally initialised to 0
		int userOption = 0;

		// Static method of MessageCentre class to display a message asking the player
		// to confirm that they want to quit the game
		MessageCentre.displayQuitFromGamePlayConfirmationMessage();

		// Do while loop that will run until the user enters the number 1 or 2
		do {
			// Try catch block that catches any non-numeric entries from the user
			try {
				// Static method of MessageCentre class to display the confirm quit menu
				MessageCentre.displayQuitFromGamePlayConfirmationMenu();

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// If 1 is entered by the user, confirmQuitGame is true
				case 1:
					confirmQuitGame = true;
					break;
				// If 2 is entered by the user, confirmQuitGame is false
				case 2:
					confirmQuitGame = false;
					break;
				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 2
				default:
					System.out.println("\nA valid number was not entered.");
				}
				// If the user enters something that is not a number, it is caught as an
				// InputMismatchException
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
			// Do while loop that will run until the user enters the number 1 or 2
		} while (userOption != 1 && userOption != 2);
		// value of confirmQuitGame is returned
		return confirmQuitGame;
	}

	/**
	 * Method that displays the options, obligations or details of what happens when
	 * a player lands on a Square on the virtual game board.
	 * 
	 * @param player         - Player object that represents each player taking part
	 *                       in the game
	 * @param playerPosition - position on the virtual game board of the current
	 *                       player
	 * @param board          - ArrayList of Square objects which represents the
	 *                       virtual game board
	 */
	public void elementOptions(Player player, List<Player> playerList, int playerPosition, List<Square> board,
			Scanner scanner) {

		// display the details of the square that the player landed on
		board.get(playerPosition - 1).displaySquareDetails();

		// if player has landed on square 1, they collect funds
		if (playerPosition == 1) {
			// Static method of MessageCentre class which displays a message telling
			// the player they have landed on the Payroll square and collected funds
			MessageCentre.displayLandOnPayrollMessage(player.getPlayerName(), 100);
			player.displayPlayerFunds();
			// if player has landed on square 7, they can do nothing
		} else if (playerPosition == 7) {
			player.setFundsFrozen(true);
		} else {

			// get the current owner of the square
			String squareOwner = ((Element) board.get(playerPosition - 1)).getElementOwner();

			// if there is no owner, the player is offered this square to purchase
			if (squareOwner.equals("Unoccupied")) {
				System.out.printf("\nThis element is unoccupied. Do you want to purchase it for %d dollars?\n",
						((Element) board.get(playerPosition - 1)).getPurchaseCost());
				purchaseElement(player, playerList, board, playerPosition, scanner);
				// if they already own it, they have the choice to develop it
			} else if (squareOwner == player.getPlayerName()) {
				System.out.println("\nYou already own this element.");
				developElementWhenOnOwnedElemet(player, ((Element) board.get(playerPosition - 1)).getSquarePositionID(),
						board, scanner);
				// if the square is owned by another player, they may have to pay tax for
				// landing on it
			} else {
				payTax(player, squareOwner, playerList, scanner);
			}
		}
	}

	/**
	 * Method that displays and manages the purchase options when a player lands on
	 * a Square on the virtual game board. The player is given the choice to either
	 * purchase the element on the Square or offer another player the chance to
	 * purchase it.
	 * 
	 * @param player
	 * @param board
	 * @param playerPosition
	 */
	public void purchaseElement(Player player, List<Player> playerList, List<Square> board, int playerPosition,
			Scanner scanner) {

		// int variable to store the user's input from an instance of a Scanner class
		// Initially initialised to 0
		int userOption = 0;

		// Do while loop that will run until the player enters 1 or 2
		do {
			try {
				// Static method of MessageCentre class which displays a menu asking the player
				// to purchase or decline purchasing the element
				MessageCentre.displayPurchaseElementMenu();

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// if 1 is entered by the player, they will purchase the element, provided they
				// have enough resources to purchase it
				case 1:
					// if statement checks if the player has enough funds to purchase the element
					if (((Element) board.get(playerPosition - 1)).getPurchaseCost() > player.getPlayerFunds()) {
						System.out.println("Insufficient funds to purchase this element.");
						// if they have enough funds, the element is purchased
					} else {
						// playerName is set as the elementOwner of the Element
						((Element) board.get(playerPosition - 1)).setElementOwner(player.getPlayerName());
						// Element is added to the playerElements ArrayList of Player object
						player.addPlayerElement(board.get(playerPosition - 1));

						// player funds are updated after purchase
						player.setPlayerFunds(
								player.getPlayerFunds() - ((Element) board.get(playerPosition - 1)).getPurchaseCost());
					}

					// display message showing the player's name and what they purchased
					System.out.printf("\n%s has purchased the %s.\n", player.getPlayerName(),
							((Element) board.get(playerPosition - 1)).getSquareName());

					// display player's updated funds
					player.displayPlayerFunds();
					break;
				// if 2 is entered by the player, they will decline the element
				case 2:
					System.out.println("\nDo you want to offer another player the chance to purchase this Element?");
					offerElement(playerList, player, board, scanner);
					break;

				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 2 inclusive
				default:
					System.out.println("\nA valid number was not entered.");
				}
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
		} while (userOption != 1 && userOption != 2);
	}

	public void offerElement(List<Player> playerList, Player currentPlayer, List<Square> board, Scanner scanner) {

		// int variable to store the user's input from an instance of a Scanner class
		// Initially initialised to 0
		int userOption = 0;

		// Do while loop that will run until the player enters 1 or 2
		do {
			try {
				// Static method of MessageCentre class which displays a menu asking the player
				// if they want to offer the option to purchase the Element to another player
				MessageCentre.displayOfferElementMenu();

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// if 1 is entered by the player, they will offer the option to purchase the
				// Element
				// to another player
				case 1:
					acceptElementOffer(playerList, currentPlayer, board, scanner);
					break;
				// if 2 is entered by the player, they will not offer the Element to another
				// player
				case 2:
					System.out.println("\nYou have declined to offer this Element to another player.");
					break;
				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 2 inclusive
				default:
					System.out.println("\nA valid number was not entered.");
				}
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
		} while (userOption != 1 && userOption != 2);
	}

	public void acceptElementOffer(List<Player> playerList, Player currentPlayer, List<Square> board, Scanner scanner) {

		// int variable to store the user's input from an instance of a Scanner class
		// Initially initialised to 0
		int userOption = 0;

		boolean validEntry = false;

		// Do while loop that will run until the player enters 1, 2, 3 or 4
		do {
			try {
				// Static method of MessageCentre class which displays a list of the other
				// players playing the game
				MessageCentre.displayPlayerNamesMenu(playerList, currentPlayer.getPlayerName());

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// if 1 is entered by the player, they will offer the option to purchase the
				// Element to the first player displayed
				case 1:

					if (playerList.indexOf(currentPlayer) + 1 == 1) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						Player player = playerList.get(userOption - 1);

						purchaseElementOffer(player, board, currentPlayer.getPlayerPosition(), scanner);
						validEntry = true;
					}

					break;
				// if 2 is entered by the player, they will offer the option to purchase the
				// Element to the second player displayed
				case 2:

					if (playerList.indexOf(currentPlayer) + 1 == 2) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {

						Player player = playerList.get(userOption - 1);

						purchaseElementOffer(player, board, currentPlayer.getPlayerPosition(), scanner);
						validEntry = true;
					}

					break;

				// if 3 is entered by the player, they will offer the option to purchase the
				// Element to the third player displayed
				case 3:

					if (playerList.indexOf(currentPlayer) + 1 == 3) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {
						Player player = playerList.get(userOption - 1);

						purchaseElementOffer(player, board, currentPlayer.getPlayerPosition(), scanner);
						validEntry = true;
					}

					break;

				// if 4 is entered by the player, they will offer the option to purchase the
				// Element to the fourth player displayed
				case 4:

					if (playerList.indexOf(currentPlayer) + 1 == 4) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else if (playerList.size() < 4) {
						System.out.println("\nA valid number was not entered.");
						validEntry = false;
					} else {
						Player player = playerList.get(userOption - 1);

						purchaseElementOffer(player, board, currentPlayer.getPlayerPosition(), scanner);
						validEntry = true;
					}

					break;

				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 4 inclusive
				default:
					System.out.println("\nA valid number was not entered.");
				}
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
		} while (validEntry == false);
	}

	public void purchaseElementOffer(Player player, List<Square> board, int playerPosition, Scanner scanner) {

		// int variable to store the user's input from an instance of a Scanner class
		// Initially initialised to 0
		int userOption = 0;

		// Do while loop that will run until the player enters 1 or 2
		do {
			try {
				// Static method of MessageCentre class which displays a menu asking the player
				// to purchase or decline purchasing the element
				MessageCentre.displayPurchaseElementMenu();

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// if 1 is entered by the player, they will purchase the element, provided they
				// have enough resources to purchase it
				case 1:
					// if statement checks if the player has enough funds to purchase the element
					if (((Element) board.get(playerPosition - 1)).getPurchaseCost() > player.getPlayerFunds()) {
						System.out.println("Insufficient funds to purchase this element.");
						// if they have enough funds, the element is purchased
					} else {
						// playerName is set as the elementOwner of the Element
						((Element) board.get(playerPosition - 1)).setElementOwner(player.getPlayerName());
						// Element is added to the playerElements ArrayList of Player object
						player.addPlayerElement(board.get(playerPosition - 1));

						// player funds are updated after purchase
						player.setPlayerFunds(
								player.getPlayerFunds() - ((Element) board.get(playerPosition - 1)).getPurchaseCost());
					}

					// display message showing the player's name and what they purchased
					System.out.printf("\n%s has purchased the %s.\n", player.getPlayerName(),
							((Element) board.get(playerPosition - 1)).getSquareName());

					// display player's updated funds
					player.displayPlayerFunds();
					break;
				// if 2 is entered by the player, they will decline the element
				case 2:
					System.out.println("\nNot purchased");
					break;

				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 2 inclusive
				default:
					System.out.println("\nA valid number was not entered.");
				}
			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
		} while (userOption != 1 && userOption != 2);
	}

	/**
	 * 
	 * @param player
	 * @param board
	 */
	public void developElement(Player player, List<Square> board, Scanner scanner) {

		// int variables to store the user's input from an instance of a Scanner class
		// Initially initialised to 0
		int userOption1 = 0;
		int userOption2 = 0;

		if (player.getPlayerElements().size() == 0) {
			System.out.printf("\n%s does not own any Elements.\n", player.getPlayerName());
		} else {
			do {
				try {
					// displays the names of the elements that are owned by the current player
					System.out.println("\n\n|*****| Develop an Element |*****|");
					System.out.printf("\n%s owns the following Elements:\n\n", player.getPlayerName());
					player.displayElementsOwned();

					if (player.getPlayerElements().size() == 1) {
						userOption1 = 1;
					} else {
						// displays a message asking the player to select the Element they want to
						// develop
						MessageCentre.displaySelectElementToDevelopMessage(player.getPlayerElements().size());

						// Assigning the user's entry to the userOption1 variable
						userOption1 = scanner.nextInt();
					}

					// displays a message if the player does not enter a valid number
					if (userOption1 < 1 || userOption1 > player.getPlayerElements().size()) {
						System.out.println("\nA valid number was not entered.");
					}
				} catch (InputMismatchException inputMismatchException) {
					// A message is displayed telling the user to enter a number
					System.out.println("\nA valid number was not entered.");
					// scanner.nextLine() is called to clear out the return character
					scanner.nextLine();

					// General exceptions or errors are caught as a general Exception
				} catch (Exception exception) {
					// A message is displayed telling the user something went wrong
					System.out.println("Something went wrong. Try again.");
					// scanner.nextLine() is called to clear out the return character
					scanner.nextLine();
				}
				// do while loop continues to run until the player enters a valid number to
				// select an Element to develop
			} while (userOption1 < 1 || userOption1 > player.getPlayerElements().size());

			// Do while loop that will run until the player enters 1 or 2
			do {
				try {
					// display messages asking the player if they wish to develop the selected
					// Element
					System.out.printf("\nDo you want to develop the %s for %d dollars?\n",
							((Element) player.getPlayerElements().get(userOption1 - 1)).getSquareName(),
							((Element) player.getPlayerElements().get(userOption1 - 1)).getDevelopmentCost());
					MessageCentre.displayDevelopElementMenu();

					// Assigning the user's entry to the userOption2 variable
					userOption2 = scanner.nextInt();

					// Passing the userOption variable into a switch statement to determine which
					// option they have chosen
					switch (userOption2) {

					// if 1 is entered by the player, they will develop the element, provided they
					// have enough resources to develop it
					case 1:
						// if statement checks if the player has enough funds to purchase the element
						if (((Element) player.getPlayerElements().get(userOption1 - 1)).getDevelopmentCost() > player
								.getPlayerFunds()) {
							System.out.println("Insufficient funds to develop this element.");
							// if they have enough funds, the element is developed
						} else {
							

							
							if (!checkFullSystemOwned(player, ((Element) player.getPlayerElements().get(userOption1 - 1)).getSystemType())) {
								System.out.println("Full system not owned");
								break;
							}
							
							
							// update the development level of the selected Element

							int currentDevelopmentLevel = ((Element) player.getPlayerElements().get(userOption1 - 1))
									.getDevelopmentLevel();

							if (currentDevelopmentLevel < 3) {
								((Element) player.getPlayerElements().get(userOption1 - 1))
										.setDevelopmentLevel(currentDevelopmentLevel + 1);

								// player funds are updated after purchase
								player.setPlayerFunds(player.getPlayerFunds()
										- ((Element) player.getPlayerElements().get(userOption1 - 1))
												.getDevelopmentCost());

								if (((Element) player.getPlayerElements().get(userOption1 - 1))
										.getDevelopmentLevel() == 1) {
									// display a message showing the Element that was developed and it's new level
									MessageCentre.displayDevelopmentCompleteMessage(
											((Element) player.getPlayerElements().get(userOption1 - 1))
													.getDevelopmentLevel(),
											((Element) player.getPlayerElements().get(userOption1 - 1))
													.getDevelopmentLevel1Message());
								} else if (((Element) player.getPlayerElements().get(userOption1 - 1))
										.getDevelopmentLevel() == 2) {
									// display a message showing the Element that was developed and it's new level
									MessageCentre.displayDevelopmentCompleteMessage(
											((Element) player.getPlayerElements().get(userOption1 - 1))
													.getDevelopmentLevel(),
											((Element) player.getPlayerElements().get(userOption1 - 1))
													.getDevelopmentLevel2Message());
								} else if (((Element) player.getPlayerElements().get(userOption1 - 1))
										.getDevelopmentLevel() == 3) {
									// display a message showing the Element that was developed and it's new level
									MessageCentre.displayDevelopmentCompleteMessage(
											((Element) player.getPlayerElements().get(userOption1 - 1))
													.getDevelopmentLevel(),
											((Element) player.getPlayerElements().get(userOption1 - 1))
													.getDevelopmentLevel3Message());
								}

								// display player's updated funds
								player.displayPlayerFunds();
							} else {
								System.out.println("\nMajor Development Status has already been reached. This "
										+ "Element can't be developed any further");
							}
						}
						break;
					case 2:
						// display development cancelled message
						System.out.printf("\nDevelopment of the %s cancelled.\n",
								((Element) player.getPlayerElements().get(userOption1 - 1)).getSquareName());
						break;

					// A message is displayed to the user if they enter and number that isn't
					// between 1 and 2 inclusive
					default:
						System.out.println("\nA valid number was not entered.");
					}

				} catch (InputMismatchException inputMismatchException) {
					// A message is displayed telling the user to enter a number
					System.out.println("\nA valid number was not entered.");
					// scanner.nextLine() is called to clear out the return character
					scanner.nextLine();

					// General exceptions or errors are caught as a general Exception
				} catch (Exception exception) {
					// A message is displayed telling the user something went wrong
					System.out.println("Something went wrong. Try again.");
					// scanner.nextLine() is called to clear out the return character
					scanner.nextLine();
				}
			} while (userOption2 != 1 && userOption2 != 2);
		}
	}

	public void developElementWhenOnOwnedElemet(Player player, int squarePositionID, List<Square> board,
			Scanner scanner) {

		// int variable to store the user's input from an instance of a Scanner class
		// Initially initialised to 0
		int userOption = 0;

		int elementID = 0;

		for (Square square : player.getPlayerElements()) {
			if (square.getSquarePositionID() == squarePositionID) {
				elementID = player.getPlayerElements().indexOf(square);
			}
		}

		// Do while loop that will run until the player enters 1 or 2
		do {
			try {

				// display messages asking the player if they wish to develop the selected
				// Element
				System.out.printf("\nDo you want to develop the %s for %d dollars?\n",
						((Element) player.getPlayerElements().get(elementID)).getSquareName(),
						((Element) player.getPlayerElements().get(elementID)).getDevelopmentCost());
				MessageCentre.displayDevelopElementMenu();

				// Assigning the user's entry to the userOption2 variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// if 1 is entered by the player, they will develop the element, provided they
				// have enough resources to develop it
				case 1:					
					// if statement checks if the player has enough funds to purchase the element
					if (((Element) player.getPlayerElements().get(elementID)).getDevelopmentCost() > player
							.getPlayerFunds()) {
						System.out.println("Insufficient funds to develop this element.");
						// if they have enough funds, the element is developed
					} else {
						// update the development level of the selected Element

						int currentDevelopmentLevel = ((Element) player.getPlayerElements().get(elementID))
								.getDevelopmentLevel();

						if (currentDevelopmentLevel < 3) {
							((Element) player.getPlayerElements().get(elementID))
									.setDevelopmentLevel(currentDevelopmentLevel + 1);

							// player funds are updated after purchase
							player.setPlayerFunds(player.getPlayerFunds()
									- ((Element) player.getPlayerElements().get(elementID)).getDevelopmentCost());

							if (((Element) player.getPlayerElements().get(elementID)).getDevelopmentLevel() == 1) {
								// display a message showing the Element that was developed and it's new level
								MessageCentre.displayDevelopmentCompleteMessage(
										((Element) player.getPlayerElements().get(elementID)).getDevelopmentLevel(),
										((Element) player.getPlayerElements().get(elementID))
												.getDevelopmentLevel1Message());
							} else if (((Element) player.getPlayerElements().get(elementID))
									.getDevelopmentLevel() == 2) {
								// display a message showing the Element that was developed and it's new level
								MessageCentre.displayDevelopmentCompleteMessage(
										((Element) player.getPlayerElements().get(elementID)).getDevelopmentLevel(),
										((Element) player.getPlayerElements().get(elementID))
												.getDevelopmentLevel2Message());
							} else if (((Element) player.getPlayerElements().get(elementID))
									.getDevelopmentLevel() == 3) {
								// display a message showing the Element that was developed and it's new level
								MessageCentre.displayDevelopmentCompleteMessage(
										((Element) player.getPlayerElements().get(elementID)).getDevelopmentLevel(),
										((Element) player.getPlayerElements().get(elementID))
												.getDevelopmentLevel3Message());
							}

							// display player's updated funds
							player.displayPlayerFunds();
						} else {
							System.out.println("\nMajor Development Status has already been reached. This "
									+ "Element can't be developed any further");
						}
					}
					break;
				case 2:
					// display development cancelled message
					System.out.printf("\nDevelopment of the %s cancelled.\n",
							((Element) player.getPlayerElements().get(elementID)).getSquareName());
					break;

				// A message is displayed to the user if they enter and number that isn't
				// between 1 and 2 inclusive
				default:
					System.out.println("\nA valid number was not entered.");
				}

			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}
		} while (userOption != 1 && userOption != 2);
	}
	
	
	

	public boolean checkFullSystemOwned(Player player, String systemType) {
		
		boolean fullSystemOwned = false;
		
		int commandAndControlTotal = 0;
		int launchComplexTotal = 0;
		int spaceCraftTotal = 0;
		int trainingProgramTotal = 0;
		
		for (Square square : player.getPlayerElements()) {
			
			if (((Element) square).getSystemType().equals(SystemType.COMMAND_AND_CONTROL.getSystemName())) {
				commandAndControlTotal++;
			} else if (((Element) square).getSystemType().equals(SystemType.LAUNCH_COMPLEX.getSystemName())) {
				launchComplexTotal++;
			} else if (((Element) square).getSystemType().equals(SystemType.SPACECRAFT.getSystemName())) {
				spaceCraftTotal++;
			} else if (((Element) square).getSystemType().equals(SystemType.TRAINING_PROGRAM.getSystemName())) {
				trainingProgramTotal++;
			}
		}
		
		if (systemType.equals(SystemType.COMMAND_AND_CONTROL.getSystemName()) && commandAndControlTotal == 3) {
			fullSystemOwned = true;
		} else if (systemType.equals(SystemType.LAUNCH_COMPLEX.getSystemName()) && launchComplexTotal == 3) {
			fullSystemOwned = true;
		} else if (systemType.equals(SystemType.SPACECRAFT.getSystemName()) && spaceCraftTotal == 2) {
			fullSystemOwned = true;
		} else if (systemType.equals(SystemType.TRAINING_PROGRAM.getSystemName()) && trainingProgramTotal == 2) {
			fullSystemOwned = true;
		}		

		return fullSystemOwned;
	}

	/**
	 * Method that creates and returns an ArrayList of Square / Element objects.
	 * This will represent the virtual game board of the ArtemisLite game.
	 * 
	 * @return ArrayList of Square / Element objects
	 */
	public ArrayList<Square> initialiseBoard() {

		// creates a new ArrayList to store Square objects
		ArrayList<Square> board = new ArrayList<Square>();

		// surrounding the elements within a try..catch as they throw exceptions when
		// values set are invalid.
		try {

			// creates the starting Square of the virtual game board, which is a Payroll
			// object
			// players will collect funds when they land on or pass this square
			Payroll square1 = new Payroll(SquareName.PAYROLL,
					"You will receive 100 dollars every time you land on or pass this square.", 1, 100);

			// creating the 2nd Square of the virtual game board, which is an Element
			// The Element represents the Crawler-Transporter, which is part of a 3 Element
			// system
			Element square2 = new Element(SquareName.CRAWLER_TRANSPORTER,
					"This will transport your Mobile Launcher Platform and Spacecraft to the Launch Pad.", 2,
					SystemType.LAUNCH_COMPLEX, false, null, 100, 0, 100,
					"Crawler-Transporter has been developed to Level 1. \nMobile Launcher Platforms and Spacecraft "
							+ "can now be transported to the launch pad for launching.",
					"Crawler-Transporter has been developed to Level 2. \nImprovements to the Motor Control Center, "
							+ "engines and ventilation systems have been provided.",
					"Crawler-Transporter has been fully developed to Level 3 (Super Crawler). \nLifting capacity "
							+ "has been increased from 5,400 to 8,200 tonnes to support the new Space Launch System rocket.",
					20);

			// creating the 3rd Square of the virtual game board, which is an Element
			// The Element represents the Mobile Launcher Platform, which is part of a 3
			// Element system
			Element square3 = new Element(SquareName.MOBILE_LAUNCHER_PLATFORM,
					"Your Spacecraft will sit atop of this platform and will be launched from it.", 3,
					SystemType.LAUNCH_COMPLEX, false, null, 100, 0, 100,
					"Mobile Launcher Platform has been developed to Level 1. \nThis platform can support the launch "
							+ "of 1960s / 1970s era Saturn V rockets.",
					"Mobile Launcher Platform has been developed to Level 2.\nThis platform can now support the "
							+ "launch of 1980s / 1990s era Space Shuttle.",
					"Mobile Launcher Platform has been fully developed to Level 3.\nThis platform can now support "
							+ "the launch of the new Space Launch System rocket.",
					20);

			// creating the 4th Square of the virtual game board, which is an Element
			// The Element represents the Launch Pad, which is part of a 3 Element system
			Element square4 = new Element(SquareName.LAUNCH_PAD,
					"Your Crawler-Transporter will transport your Mobile Launcher Platform and Spacecraft"
							+ "\nto this piece\nof ground at John F. Kennedy Space Center for launch.",
					4, SystemType.LAUNCH_COMPLEX, false, null, 100, 0, 100,
					"Launch Pad has been developed to Level 1.\nThis Launch Pad can now support the launch of 1960s / "
							+ "1970s era Saturn V rockets.",
					"Launch Pad has been developed to Level 2.\nThis Launch Pad can now support the launch of 1980s / "
							+ "1990s era Space Shuttles.",
					"Launch Pad has been fully developed to Level 3.\nThis Launch Pad can now support the launch of "
							+ "the new Space Launch System rocket.",
					20);

			// creating the 5th Square of the virtual game board, which is an Element
			// The Element represents the Neutral Buoyancy Laboratory Training, which is
			// part of a 2 Element system
			// Least expensive system
			Element square5 = new Element(SquareName.NEUTRAL_BUOYANCY_LABORATORY_TRAINING,
					"Astronauts will conduct training here in preperation for the zero-gravity conditions "
							+ "experienced in space.",
					5, SystemType.TRAINING_PROGRAM, false, null, 100, 0, 100,
					"Neutral Buoyancy Laboratory Training developed to Level 1.\nAstronaut training can take place "
							+ "when a suitable diving tank has been developed.",
					"Neutral Buoyancy Laboratory Training developed to Level 2.\nAstronauts can now train in a diving "
							+ "tank to simulate a microgravity environment.",
					"Neutral Buoyancy Laboratory Training fully developed to Level 3.\nAstronauts can now perform "
							+ "training specific to the Artemis missions.",
					20);

			// creating the 6th Square of the virtual game board, which is an Element
			// The Element represents the Orion Spacecraft Simulator Training which is part
			// of a 2 Element system
			// Least expensive system
			Element square6 = new Element(SquareName.ORION_SPACECRAFT_SIMULATOR_TRAINING,
					"Astronauts will learn how to operate the Orion Multi-Purpose Crew Vehicle (Orion MPCV) by"
							+ "\ntraining in a realistic simulator.",
					6, SystemType.TRAINING_PROGRAM, false, null, 100, 0, 100,
					"Orion Spacecraft Simulator Training developed to Level 1.\nDesign plans have been completed "
							+ "for the development of the Orion Spacecraft Simulator.",
					"Orion Spacecraft Simulator Training developed to Level 2.\nThe exterior of the simulator has "
							+ "been developed and delivered to Johnson Space Center.",
					"Orion Spacecraft Simulator Training fully developed to Level 3.\nThe interior of the simulator "
							+ "has been outfitted with Orion’s display and control system and crew seats and is ready "
							+ "for\nastronaut training.",
					20);

			// creating the 7th Square of the virtual game board, which is an UnpaidLeave
			// object
			// square
			// nothing happens when a player lands on this Square, and they can not make any
			// game choices
			UnpaidLeave square7 = new UnpaidLeave(SquareName.UNPAID_LEAVE,
					"No work activity will be conducted when present on this square.", 7);

			// creating the 8th Square of the virtual game board, which is an Element
			// The Element represents the Spaceport Command and Control System, which is
			// part of a 3 Element system
			Element square8 = new Element(SquareName.SPACEPORT_COMMAND_AND_CONTROL_SYSTEM,
					"This is the state of the art software system that will support the entire Artemis mission.", 8,
					SystemType.COMMAND_AND_CONTROL, false, null, 100, 0, 100,
					"Spaceport Command and Control System (SCCS) developed to Level 1. \nThe SCCS has passed the "
							+ "Preliminary Design Review.",
					"Spaceport Command and Control System (SCCS) developed to Level 2.\nThe SCCS has passed System "
							+ "and Implementation testing.",
					"Spaceport Command and Control System (SCCS) fully developed to Level 3.\nThe SCCS has been "
							+ "implemented and is now fully operational.",
					20);

			// creating the 9th Square of the virtual game board, which is an Element
			// The Element represents the Mission Control Center, which is part of a 3
			// Element system
			Element square9 = new Element(SquareName.MISSION_CONTROL_CENTRE,
					"All aspects of the Artemis mission will be coordinated from here.", 9,
					SystemType.COMMAND_AND_CONTROL, false, null, 100, 0, 100,
					"Mission Control Center (MCC) developed to Level 1.\nThe MCC can now support launches of 1960s "
							+ "/ 1970s era Saturn V rockets.",
					"Mission Control Center (MCC) developed to Level 2.\nThe MCC can now support launches of 1980s / "
							+ "1990s era Space Shuttles.",
					"Mission Control Center (MCC) fully developed to Level 3.\nThe MCC can now support launches of "
							+ "the new Space Launch System rocket and Artemis missions.",
					20);

			// creating the 10th Square of the virtual game board, which is an Element
			// The Element represents the Space Communications and Navigation, which is part
			// of a 3 Element system
			Element square10 = new Element(SquareName.SPACE_COMMUNICATIONS_AND_NAVIGATION,
					"This network will facilitate communications throughout the Artemis mission.", 10,
					SystemType.COMMAND_AND_CONTROL, false, null, 100, 0, 100,
					"Space Communications and Navigation developed to Level 1.\nThe Near Space Network has been "
							+ "developed, allowing communications with Artemis during launch as well as navigation\n"
							+ "services throughout the mission to be achieved.",
					"Space Communications and Navigation developed to Level 2.\nThe Tracking and Data Relay "
							+ "Satellites have been developed, allowing communications with Artemis during "
							+ "low-Earth orbit\nto be achieved.",
					"Space Communications and Navigation fully developed to Level 3.\nThe Deep Space Network "
							+ "has been developed, allowing communications with Artemis en route to and in orbit around "
							+ "the Moon to be achieved.",
					20);

			// creating the 11th Square of the virtual game board, which is an Element
			// The Element represents the Orion Multi-Purpose Crew Vehicle, which is part of
			// a 2 Element system
			// Most expensive system
			Element square11 = new Element(SquareName.ORION_MULTIPURPOSE_CREW_VEHICLE,
					"This is the exploration vehicle that will carry the crew to space and to the moon.", 11,
					SystemType.SPACECRAFT, false, null, 100, 0, 100,
					"Orion Multi-Purpose Crew Vehicle (MPCV) developed to Level 1.\nThe Orion MPCV has successfully "
							+ "passed the Preliminary Design Review.",
					"Orion Multi-Purpose Crew Vehicle (MPCV) developed to Level 2.\nThe Orion MPCV has successfully "
							+ "passed Flight and Abort testing.",
					"Orion Multi-Purpose Crew Vehicle (MPCV) fully developed to Level 3.\nThe Orion MPCV has been "
							+ "fully assembled in preparation for launch.",
					20);

			// creating the 12th Square of the virtual game board, which is an Element
			// The Element represents the Space Launch System, which is part of a 2 Element
			// system
			// Most expensive system
			Element square12 = new Element(SquareName.SPACE_LAUNCH_SYSTEM,
					"This is the launch vehicle that will launch the Orion Orion Multi-Purpose Crew Vehicle"
							+ "\n(Orion MPCV) into space.",
					12, SystemType.SPACECRAFT, false, null, 100, 0, 100,
					"Space Launch System developed to Level 1.\nThe Space Launch System has successfully passed the "
							+ "Preliminary Design Review.",
					"Space Launch System developed to Level 2.\nThe Space Launch System Core Stage has successfully "
							+ "passed the Static Firing test program.",
					"Space Launch System fully developed to Level 3. The Space Launch System has been fully assembled "
							+ "in preparation for launch.",
					20);

			// adding all Square / Element objects to the board ArrayList
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		// returns the created virtual game board of Square / Element objects
		return board;
	}

	public int newPlayerPosition(int numRolled, int playerPosition) {

		if (playerPosition + numRolled > 12) {
			return (playerPosition - 12) + numRolled;
		} else {
			return playerPosition + numRolled;
		}
	}

	/**
	 * Method that will roll 2 dice at the beginning of the game for each player,
	 * assign the score they achieved to each Player object within the game and sort
	 * the ArrayList of Player objects by the score they achieved in descending
	 * order
	 * 
	 * @param playerList - ArrayList of Player objects within the game
	 * @param dice       - An instance of the Dice class
	 */
	public void determinePlayOrder(List<Player> playerList, Dice dice) {

		if (playerList.size() > 1) {
			// int variable to hold the score that is achieved by rolling 2 dice
			int playerRoll = 0;

			// looping through each Player object within the playerList that has been passed
			// as an argument, rolling 2
			// dice and assigning the score achieved to the firstRollScore variable of each
			// Player object
			for (Player player : playerList) {
				try {
					// 2 is passed as an argument to the roll method of the dice object, indicating
					// that
					// 2 dice will be rolled
					playerRoll = dice.roll(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// assigning the score to the firstRollScore of each Player object
				player.setFirstRollScore(playerRoll);
			}
			// sorting the playerList based on the value of firstRollScore for each Player
			// object
			Collections.sort(playerList);

			int newID = 1;

			for (Player player : playerList) {
				player.setPlayerID(newID);
				newID++;
			}
		}
	}

	/**
	 * 
	 * @param currentPlayer
	 * @param squareOwner
	 * @param playerList
	 * @param scanner
	 */
	public void payTax(Player currentPlayer, String squareOwner, List<Player> playerList, Scanner scanner) {

		// Static method of MessageCentre class which displays a message explaining that
		// the player may have to pay tax for landing on an Element they do not own
		MessageCentre.displayPayTaxMessage(currentPlayer.getPlayerName(), squareOwner);

		// Static method of MessageCentre class which displays a menu asking the Element
		// owner if they want to charge the player tax for landing on their Element
		MessageCentre.displayPayTaxMenu();

		// int variable to store the user's input from an instance of a Scanner class
		// Originally initialised to 0
		int userOption = 0;

		// Do while loop that will run until the player enters 1 or 2
		do {
			try {
				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// if 1 is entered by the player, the player will pay tax to the element owner
				case 1:
					// int variable to hold the current player's funds balance
					int currentPlayerFunds = currentPlayer.getPlayerFunds();

					// update the current player's funds by passing their current
					// balance amount to the setPlayerFunds method of the player
					// class and subtracting the tax amount
					currentPlayer.setPlayerFunds(currentPlayerFunds - 50);

					// loop through all players in playerList
					for (Player player : playerList) {

						// if getPlayerName matches the squareOwner, the funds
						// for the squareOwner get updated with the tax amount
						if (player.getPlayerName().equals(squareOwner)) {

							// int variable to hold the squareOwner's funds balance
							int elementOwnerFunds = player.getPlayerFunds();

							// update the squareOwner's funds by passing their current
							// balance amount to the setPlayerFunds method of the player
							// class and adding the tax amount
							player.setPlayerFunds(elementOwnerFunds + 50);

							// display message explaining that tax has been charged
							MessageCentre.displayTaxNoticeMessage();

							// display the squareOwner's new funds balance
							player.displayPlayerFunds();
						}
					}

					// display the currentPlayer's new funds balance
					currentPlayer.displayPlayerFunds();
					break;
				// if 2 is entered by the player, the player does not have to pay tax
				case 2:
					System.out.printf("\n%s has waived the tax charge.\n", squareOwner);
					break;
				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 2 inclusive
				default:
					System.out.println("\nA valid number was not entered.");
				}

			} catch (InputMismatchException inputMismatchException) {
				// A message is displayed telling the user to enter a number
				System.out.println("\nA valid number was not entered.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();

				// General exceptions or errors are caught as a general Exception
			} catch (Exception exception) {
				// A message is displayed telling the user something went wrong
				System.out.println("Something went wrong. Try again.");
				// scanner.nextLine() is called to clear out the return character
				scanner.nextLine();
			}

		} while (userOption != 1 && userOption != 2);

	}

}
