/**
 * 
 */
package qub.group8.artemislite;

import java.util.List;

/**
 * This class contains many of the text prompts, menus and messages that will be
 * displayed on screen during the ArtemisLite game. These messages are contained
 * within static methods that can be called directly without instantiating this
 * class.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class MessageCentre {

	/**
	 * Static method which displays the Opening Credits of the game, which is the
	 * first thing that Players will see when they run the game in the IDE.
	 */
	public static void displayOpeningCredits() {

		System.out.println("Dear Cadet / Cadets,\n\nYou have been selected to enroll in the ArtemisLite "
				+ "Lunar Exploration Program to\nhelp NASA develop and secure "
				+ "critical systems as part of our mission to land the\nfirst "
				+ "person of colour and the first woman on the surface of the Moon.\n");

		System.out.println("Your mission, should you choose to accept it, is to work to develop four "
				+ "Systems\nto ensure that the ArtemisLite program is ready for take off.\n"
				+ "\nThe four Systems are:\n");

		System.out.println("\t* Command and Control");
		System.out.println("\t* Space Launch System Rocket");
		System.out.println("\t* Launch Complex");
		System.out.println("\t* Astronaut Training Program");

		System.out.println("\nDo you want to enroll?");
	}

	/**
	 * Static method which displays the Start Menu of the game, which gives Players
	 * the options to play the game, view the rules of the game or quit the game.
	 */
	public static void displayStartMenu() {

		System.out.println("\n\n|*****| Start Menu |*****|");

		System.out.println("\nEnter a number between 1 and 3 to indicate your response.\n");

		System.out.println("1. Play Game.\n2. Display Game Rules.\n3. Quit.");
	}

	/**
	 * Static method which displays the rules of the game.
	 */
	public static void displayRules() {

		System.out.println("\n\n|*****| The ArtemisLite Mission |*****|\n");

		System.out.println("Your mission is to work to develop four Systems to ensure that "
				+ "the ArtemisLite\nprogram is ready for take off.\n\nThe four Systems are:\n");

		System.out.println("\t* Command and Control");
		System.out.println("\t* Space Launch System Rocket");
		System.out.println("\t* Launch Complex");
		System.out.println("\t* Astronaut Training Program");

		System.out.println("\nEach Element within each System will require three rounds "
				+ "of development to\nachieve Major Development status.\n");

		System.out.println("Please note: Once you have been registered to our program with Payroll, "
				+ "you must\ncomplete the mission. If you should choose to leave our mission, "
				+ "the mission will\nhave failed and we will unfortunately have no choice but retire all "
				+ "employees\nworking on the program. Therefore, you must be 100% committed to the "
				+ "program\nto ensure success.\n");

		System.out.println("In order to ensure that our staff are working at peak performance, we offer "
				+ "Unpaid\nLeave. When you are taking Unpaid Leave, you will not be able to partake in any work \n"
				+ "activities or developments - you will not be paid for this time.\n");

		System.out.println("We recognise that the Artemis Lite mission is demanding of all who work within\n"
				+ "our team, and to reward you for your commitment, we offer a yearly bonus in the \n"
				+ "form of Commitment Coins, which payroll will add to your account with each pass \n"
				+ "of the Payroll square."
				+ "\n\nNote: you do not need to do anything in order to gain access to your yearly bonus -\n"
				+ "just keep up the commitment!\r\n");

		System.out.println("Once all Systems are go, we will be able to fulfill our goal and the mission "
				+ "will\nbe accomplished. We hope you join us by signing up to be a part of our team to\n"
				+ "work together for this worth while endeavor.\n");

		System.out.println("Good luck," + "\nNASA\n\n");

		System.out.println("|*****| Employment Contract Terms and Conditions |*****|\n");

		System.out.println("\t* Your team must consist of between 1 - 4 Cadets."
				+ "\n\t  Cadet names may represent organisations or individuals.\n");

		System.out.println("\t* Each Cadet must take their turn independently to throw 2 dice before moving to "
				+ "\n\t  a new Square on the virtual game board.\n");

		System.out.println("\t* Each Cadet will begin their mission with 1000 Commitment Coins which"
				+ "\n\t  can be spent to take ownership of Elements and spent to develop Elements.\n");

		System.out.println("\t* After moving to a new Square, an explanation of the opportunities and obligations "
				+ "\n\t  will be displayed on screen and the Cadet will then have the opportunity to"
				+ "\n\t  indicate their choice of action before completing their turn.\n");

		System.out.println("\t* If a Cadet lands on a Square that no other Cadet has previously occupied, they "
				+ "\n\t  can choose to 'take charge' of that Square by purchasing it with Commitment Coins,"
				+ "\n\t  or they can offer it to another Cadet to purchase at the same cost.\n");

		System.out.println("\t* Cadets will be informed of all changes to their Commitment Coin balance,"
				+ "\n\t  and can access their Commitment Coin balance during their turn.\n");

		System.out.println("\t* When a Cadet passes or lands on the Payroll Square, they will gain a pay bonus of "
				+ "\n\t  250 Commitment Coins, a token of thanks for their commitment to the Artemis Lite Mission.\n");

		System.out.println("\t* When a Cadet lands on the 'Unpaid Leave' Square, they will take a break from "
				+ "\n\t  gameplay and will be unable to develop any Systems until they next roll the dice.\n");

		System.out.println("\t* The four Systems are:\n");

		System.out.println("\t\t* Command and Control - 3x Elements");

		System.out.println("\t\t* Space Launch System Rocket - 2x Elements (most expensive System)");

		System.out.println("\t\t* Launch Complex - 3x Elements");

		System.out.println("\t\t* Astronaut Training Program - 2x Elements (least expensive System)\n");

		System.out.println("\t* Before each Cadet can develop an Element of a System, they must have taken charge "
				+ "\n\t  of all of the Elements within that System.\n");

		System.out.println("\t* A Cadet can develop multiple Elements during a single turn.\n");

		System.out.println("\t* When a Cadet lands on an Element which they do not own, the person who is in "
				+ "\n\t  charge of that Element makes a choice whether to demand Commitment Coins from "
				+ "\n\t  the Cadet, or decline acceptance of Commitment Coins.\n");

		System.out.println("\t* If a Cadet runs out of resources, the game ends for the whole team"
				+ "\n\t  and the state of gameplay will display to screen.\n");

		System.out.println("\t* If a Cadet chooses to quit the game, the game ends for the whole team"
				+ "\n\t  and the state of gameplay will display to screen.\n");

		System.out.println("\t* When all Systems are fully developed through team effort, the successful outcome "
				+ "\n\t  of the mission is displayed to screen, along with the final state of gameplay.\n");

		System.out.println("|*****| End of Game Rules |*****|");
	}

	/**
	 * Static method which displays a message asking the Player to confirm that they
	 * want to end the game.
	 * 
	 * This message is displayed if the Player wants to quit the game from the Start
	 * Menu.
	 */
	public static void displayQuitFromStartMenuConfirmationMessage() {

		System.out.println("\n\n|*****| Quit Game |*****|");

		System.out.println("\nYou have selected to quit the game. Are you sure you want to quit?");
	}

	/**
	 * Static method which displays a menu asking the Player to choose to quit the
	 * game or return to the Start Menu.
	 */
	public static void displayQuitFromStartMenuConfirmationMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Quit Game." + "\n2. Cancel and return to Start Menu.");
	}

	/**
	 * Static method which displays a message if the game is quit from the Start
	 * Menu of the game.
	 */
	public static void displayQuitFromStartMenuMessage() {

		System.out.println("\n\n|*****| Game Over |*****|");

		System.out.println("\nYou have chosen not to enrol. Please reconsider in the future.\n\nGoodbye!");
	}

	/**
	 * Static method which displays a message asking the Player to confirm that they
	 * want to end the game.
	 * 
	 * This message is displayed if the Player wants to quit the game during the
	 * main game play of the game.
	 */
	public static void displayQuitFromGamePlayConfirmationMessage() {

		System.out.println("\n\n|*****| Quit Game |*****|");

		System.out.println("\nIf you decide to quit your job as a Cadet and withdraw from employment in NASA's "
				+ "\nArtemisLite programme, then our mission as a team will have failed and we will"
				+ "\ncease all employment contracts with the ArtemisLite team.\n"
				+ "\nThe future of the ArtemisLite project is in your hands, are you sure you wish to quit?");
	}

	/**
	 * Static method which displays a menu asking the Player to choose to quit the
	 * game or return to the game play.
	 */
	public static void displayQuitFromGamePlayConfirmationMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Quit Game." + "\n2. Cancel and return to mission.");
	}

	/**
	 * Static method which displays a message explaining that the number of Players
	 * needs to be provided.
	 */
	public static void displayPlayerEnrolmentMessage() {

		System.out.println("\n\n|*****| Welcome to ArtemisLite |*****|");

		System.out.println("\nThank you for enrolling in the ArtemisLite program!\n"
				+ "\nBefore we begin, we need to know how many Cadets will be on your team."
				+ "\nYour team must contain at least 1 Cadet and no more than 4 Cadets.\n");
	}

	/**
	 * Static method which displays a message asking for the number of Players that
	 * will be playing the game.
	 */
	public static void displayNumOfPlayersRequiredMessage() {
		System.out.println(
				"Please enter a number between 1 and 4 below to indicate how many Cadets will\nbe on your team.");
	}

	/**
	 * Static method which displays a message showing how many Players will be
	 * playing the game.
	 * 
	 * @param numOfPlayers - int variable which is used to display how many Players
	 *                     have been enrolled in the game - if there is more than 1
	 *                     Player then the plural of Cadet (Cadets) is used in the
	 *                     displayed message.
	 */
	public static void displayNumOfPlayersEnrolledMessage(int numOfPlayers) {

		System.out.println("\n\n|*****| Create Your Team |*****|");

		if (numOfPlayers == 1) {
			System.out.printf("\nYou have chosen to enrol %d Cadet in your team.\n\n", numOfPlayers);
		} else {
			System.out.printf("\nYou have chosen to enrol %d Cadets in your team.\n\n", numOfPlayers);
		}
	}

	/**
	 * Static method which displays a message asking for the names of each Player
	 * that will be playing the game.
	 * 
	 * @param numOfPlayers - int variable which is used to determine how many
	 *                     Players are playing - if there is more than 1 Player then
	 *                     the plural of name (names) is used in the displayed
	 *                     message.
	 */
	public static void displayPlayerNameRequiredMessage(int numOfPlayers) {

		if (numOfPlayers == 1) {
			System.out.printf("Please enter the name of the Cadet in your team.\n");
		} else {
			System.out.printf("Please enter the names of each Cadet in your team.\n");
		}
	}

	/**
	 * Static method which displays a message explaining that each Player must roll
	 * 2 dice to determine what order each Player will play in.
	 */
	public static void displayDeterminePlayerOrderMessage() {

		System.out.println("\n\n|*****| Determining Playing Order |*****|");

		System.out.println("\nTo determine which order each Cadet will play in and who goes first, "
				+ "each Cadet\nmust roll 2 dice. The Cadet with the highest roll will go first.\n");
	}

	/**
	 * Static method which displays a message showing the order that each Player
	 * will play in.
	 * 
	 * @param playerList - ArrayList of Player objects playing the game, which is
	 *                   used to display the names of each Player, as well as the
	 *                   highest roll score of the Player that will play first. If
	 *                   there is only 1 Player, a message is displayed explaining
	 *                   that the playing order does not need to be determined.
	 */
	public static void displayPlayerOrderMessage(List<Player> playerList) {

		if (playerList.size() == 1) {
			System.out.printf(
					"\n%s is the only Cadet enrolled in this mission. "
							+ "Therefore, the playing order\ndoes not need to be determined.\n",
					playerList.get(0).getPlayerName());
		} else if (playerList.size() == 2) {
			System.out.printf("%s rolled %d, so %s will go 1st.\n\n%s will go 2nd.\n",
					playerList.get(0).getPlayerName(), playerList.get(0).getFirstRollScore(),
					playerList.get(0).getPlayerName(), playerList.get(1).getPlayerName());
		} else if (playerList.size() == 3) {
			System.out.printf("%s rolled %d, so %s will go 1st.\n\n%s will go 2nd and %s will go 3rd.\n",
					playerList.get(0).getPlayerName(), playerList.get(0).getFirstRollScore(),
					playerList.get(0).getPlayerName(), playerList.get(1).getPlayerName(),
					playerList.get(2).getPlayerName());
		} else {
			System.out.printf(
					"%s rolled %d, so %s will go 1st.\n\n%s will go 2nd, %s will go 3rd and %s will go 4th.\n",
					playerList.get(0).getPlayerName(), playerList.get(0).getFirstRollScore(),
					playerList.get(0).getPlayerName(), playerList.get(1).getPlayerName(),
					playerList.get(2).getPlayerName(), playerList.get(3).getPlayerName());
		}
	}

	/**
	 * Static method which displays a menu showing the choices that each Player has
	 * during their turn.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player taking their turn.
	 */
	public static void displayPlayerTurnMenu(String playerName) {

		System.out.println("\n\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, it is your turn. What do you want to do?\n\n", playerName);

		System.out.println("1. Roll the Dice.");
		System.out.println("2. Develop an Element.");
		System.out.println("3. Gift an Element.");
		System.out.println("4. Display Your Status.");
		System.out.println("5. Display Game Rules.");
		System.out.println("6. Finish Turn.");
		System.out.println("7. Quit Game.");
	}

	/**
	 * Static method which displays a menu showing the choices that a solo Player
	 * has when playing.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player taking their turn.
	 */
	public static void displayPlayerTurnMenuSoloGamePlay(String playerName) {

		System.out.println("\n\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, what do you want to do now?\n\n", playerName);

		System.out.println("1. Roll the Dice.");
		System.out.println("2. Develop an Element.");
		System.out.println("4. Display Your Status.");
		System.out.println("5. Display Game Rules.");
		System.out.println("7. Quit Game.");
	}

	/**
	 * Static method which displays a menu showing the choices that each Player has
	 * during their turn when they are on the UnpaidLeave Square.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player taking their turn.
	 */
	public static void displayPlayerTurnMenuUnpaidLeave(String playerName) {

		System.out.println("\n\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, You shouldn't be working! What would you like to do?\n\n", playerName);
		System.out.println("4. Display Your Status.");
		System.out.println("5. Display Game Rules.");
		System.out.println("6. Finish Turn.");
		System.out.println("7. Quit Game.");
	}

	/**
	 * Static method which displays a menu showing the choices that a solo Player
	 * has when playing and when they are on the UnpaidLeave Square.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player taking their turn.
	 */
	public static void displayPlayerTurnMenuSoloGamePlayUnpaidLeave(String playerName) {

		System.out.println("\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, what do you want to do now?\n\n", playerName);

		System.out.println("1. Roll the Dice.");
		System.out.println("4. Display Your Status.");
		System.out.println("5. Display Game Rules.");
		System.out.println("7. Quit Game.");
	}

	/**
	 * Static method which displays a message showing the Player what they have
	 * rolled and what Square number they have landed on.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player taking their turn.
	 * @param numRolled  - int variable which will be used to represent the number
	 *                   the Player rolled with the dice.
	 * @param squareNum  int variable which will be used to represent the Square
	 *                   number that the Player has moved to.
	 */
	public static void displayPlayerRollDiceMessage(String playerName, int numRolled, int squareNum) {

		System.out.println("\n\n|*****| Role the Dice |*****|");

		if (numRolled == 8) {
			System.out.printf("\n%s has rolled an %d and has landed on Square %d.\n", playerName, numRolled, squareNum);
		} else {
			System.out.printf("\n%s has rolled a %d and has landed on Square %d.\n", playerName, numRolled, squareNum);
		}
	}

	/**
	 * Static method which displays a message explaining that the Player has landed
	 * on the Payroll Square and has collected a bonus.
	 * 
	 * @param playerName  - String variable which will be used to represent the name
	 *                    of the Player taking their turn.
	 * @param bonusAmount - int variable which will be used to represent the bonus
	 *                    amount that the Player receives.
	 */
	public static void displayLandOnPayrollMessage(String playerName, int bonusAmount) {

		System.out.println("\n\n|*****| Landed on Payroll |*****|");

		System.out.printf(
				"\n%s has landed on the Payroll Square.\n%s has collected their yearly bonus of "
						+ "%d Commitment Coins to support the completion of the mission.\n",
				playerName, playerName, bonusAmount);
	}

	/**
	 * Static method which displays a message explaining that the Player has passed
	 * the Payroll Square and has collected a bonus.
	 * 
	 * @param playerName  - String variable which will be used to represent the name
	 *                    of the Player taking their turn.
	 * @param bonusAmount - int variable which will be used to represent the bonus
	 *                    amount that the Player receives.
	 */
	public static void displayPassPayrollMessage(String playerName, int bonusAmount) {

		System.out.println("\n\n|*****| Passed Payroll |*****|");

		System.out.printf(
				"\n%s has passed the Payroll Square. %s has collected their yearly bonus of %d "
						+ "Commitment\nCoins to support the completion of the mission.\n",
				playerName, playerName, bonusAmount);
	}

	/**
	 * Static method which displays a message explaining that the Player has just
	 * ended their turn.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player that has ended their turn.
	 */
	public static void displayTurnEndedMessage(String playerName) {
		System.out.printf("\n%s has ended their turn.\n", playerName);
	}

	/**
	 * Static method which displays a message if the game is quit during the game
	 * play.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player that has quit.
	 */
	public static void displayQuitFromGamePlayMessage(String playerName) {

		System.out.println("\n\n|*****| Game Over |*****|");

		System.out.printf("\nCadet %s has decided to withdraw from the ArtemisLite project. All work on this "
				+ "\nproject has now ceased due to labour constraints, while the target of landing the first "
				+ "\nperson of colour and the first woman on the surface of the Moon by 2024 has been pushed "
				+ "\nback by several years. Senior NASA officials are expected to be summoned in front of "
				+ "\nCongress in the coming weeks to explain the failings of this project.\n", playerName);

		System.out.println("\nGame Over!");
	}

	/**
	 * Static method which displays a message if a Player goes bankrupt during the
	 * game play. If a Player goes bankrupt the game will end.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player that has went bankrupt.
	 */
	public static void displayPlayerBankruptMessage(String playerName) {

		System.out.println("\n\n|*****| Game Over |*****|");

		System.out.printf("\nCadet %s has become bankrupt. All work on the ArtemisLite project "
				+ "\nhas now ceased due to unforeseen constraints, while the target of landing the first person of "
				+ "colour \nand the first woman on the surface of the Moon by 2024 has been pushed back by several "
				+ "years. \nSenior NASA officials are expected to be summoned in front of Congress in the coming "
				+ "weeks \nto explain the failings of this project.\n", playerName);

		System.out.println("\nGame Over!");
	}

	/**
	 * Static method that displays a message explaining that the Player has already
	 * rolled the dice during their turn.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player taking their turn.
	 */
	public static void displayPlayerAlreadyRolledMessage(String playerName) {
		System.out.printf("\n%s has already rolled the Dice during this turn. Please select another option.\n",
				playerName);
	}

	/**
	 * Static method that displays a message explaining that the Element that has
	 * been landed on is available for purchase and asks the Player if they want to
	 * purchase it.
	 * 
	 * @param element - The Element object that a Player has landed on.
	 */
	public static void displayPurchaseElementMessage(Element element) {
		System.out.println("\n\n|*****| Element Available for Purchase |*****|");

		System.out.printf("\nThis Element is unoccupied. Do you want to purchase it for %d Commitment Coins?\n",
				element.getPurchaseCost());
	}

	/**
	 * Static method which displays the menu options shown to Players when they land
	 * on an unoccupied Element.
	 */
	public static void displayPurchaseElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Purchase Element.\n2. Decline Element.");
	}

	/**
	 * Static method which displays a message explaining that a Player has purchased
	 * an Element.
	 * 
	 * @param playerName  - String variable which will be used to represent the name
	 *                    of the Player that has purchased the Element.
	 * @param elementName - String variable which will be used to represent the name
	 *                    of the Element that has been purchased.
	 */
	public static void displayElementPurchasedMessage(String playerName, String elementName) {
		System.out.println("\n\n|*****| Purchase Complete |*****|");

		System.out.printf("\n%s has purchased the %s.\n", playerName, elementName);
	}

	/**
	 * Static method which displays a message explaining that a Player has declined
	 * the purchase of an Element.
	 * 
	 * @param playerName  - String variable which will be used to represent the name
	 *                    of the Player that has declined the purchase of the
	 *                    Element.
	 * @param elementName - String variable which will be used to represent the name
	 *                    of the Element that has been declined.
	 */
	public static void displayElementDeclinedMessage(String playerName, String elementName) {
		System.out.println("\n\n|*****| Purchase Declined |*****|");

		System.out.printf("\n%s has declined to purchase the %s.\n", playerName, elementName);
	}

	/**
	 * Static method which displays a message asking a Player if they want to offer
	 * the option to purchase an Element to another Player.
	 */
	public static void displayOfferElementMessage() {
		System.out.println("\n\n|*****| Offer Element to Another Player |*****|");

		System.out.println("\nDo you want to offer another player the chance to purchase this Element?");
	}

	/**
	 * Static method which displays a menu regarding offering the option to purchase
	 * an Element to another Player.
	 */
	public static void displayOfferElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Offer Element to Another Player." + "\n2. Decline to Offer Element.");
	}

	/**
	 * Static method which displays a message explaining that a Player has declined
	 * to offer the option to purchase an Element to another Player.
	 */
	public static void displayDeclineOfferElementMessage() {
		System.out.println("\n\n|*****| Declined Offer |*****|");

		System.out.println("\nYou have declined to offer this Element to another player.");
	}

	/**
	 * Static method which displays a list of Players that are currently playing the
	 * game. The Player that is currently taking their turn is not shown in the
	 * list.
	 * 
	 * @param playerList    - List of Player objects that are playing the game.
	 * @param currentPlayer - String variable which will be used to represent the
	 *                      name of the Player that is currently taking their turn.
	 */
	public static void displayPlayerNamesMenu(List<Player> playerList, String currentPlayer) {

		System.out.println(
				"\nEnter a number from the list below to select the player you want to offer this Element to.\n");

		/* Loops through each Player object in playerList. */
		for (Player player : playerList) {

			/*
			 * If the name of the current Player matches the name of a Player in playerList,
			 * it is not printed to screen.
			 */
			if (player.getPlayerName().equals(currentPlayer)) {
				continue;

				/*
				 * The name and playerID of the Player object is printed to screen.
				 */
			} else {
				System.out.printf("%d: %s\n", player.getPlayerID(), player.getPlayerName());
			}
		}
	}

	/**
	 * Static method that displays the Elements that a Player owns to screen.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player that will have their Elements displayed.
	 */
	public static void displayElementsOwnedMessage(String playerName) {
		System.out.printf("\n%s owns the following Elements:\n\n", playerName);
	}

	/**
	 * Static method that displays a message asking the Player to select which
	 * Element they want to develop.
	 * 
	 * @param numOfElementsOwned - int variable that represents that number of
	 *                           Elements that the Player owns. This is used to
	 *                           display the range of numbers that the Player can
	 *                           enter to select an Element (i.e. between 1 and 3
	 *                           etc.).
	 */
	public static void displaySelectElementToDevelopMessage(int numOfElementsOwned) {
		if (numOfElementsOwned > 1) {
			System.out.printf("\nEnter a number between 1 and %s to indicate which Element to wish to develop.\n",
					numOfElementsOwned);
		}
	}

	/**
	 * Static method that displays a message asking the Player to confirm that they
	 * want to develop an Element.
	 * 
	 * @param elementName     - String variable which will be used to represent the
	 *                        name of the Element that will be developed.
	 * @param developmentCost - int variable which will be used to represent the
	 *                        development cost of the Element.
	 */
	public static void displayDevelopElementMessage(String elementName, int developmentCost) {

		System.out.println("\n\n|*****| Development Available |*****|");

		System.out.printf("\nDo you want to develop the %s for %d Commitment Coins?\n", elementName, developmentCost);
	}

	/**
	 * Static method which displays the menu options shown to Players when they wish
	 * to develop an Element they own.
	 */
	public static void displayDevelopElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Develop Element.\n2. Cancel Development.");
	}

	/**
	 * Static method which displays a message when a Player tries to develop an
	 * Element when they don't own the full System.
	 * 
	 * @param systemType - String variable which represents the System Type of the
	 *                   Element.
	 */
	public static void displayDevelopElementUnavailableMessage(String systemType) {

		System.out.println("\n\n|*****| Full System Not Owned |*****|");

		System.out.printf("\nYou can not develop this Element until you own all of the related Elements "
				+ "from the %s System.\n", systemType);
	}

	/**
	 * Static method which displays a message if a Player selects to develop an
	 * Element but does not own any Elements.
	 * 
	 * @param playerName - String variable which will be used to represent the name
	 *                   of the Player that is attempting to develop and Element but
	 *                   does not own any.
	 */
	public static void displayNoElementsOwnedMessage(String playerName) {

		System.out.println("\n\n|*****| No Elements to Develop |*****|");

		System.out.printf("\n%s does not own any Elements.\n", playerName);
	}

	/**
	 * Static method which displays a message when an Element has been developed.
	 * 
	 * @param developmentLevel        - int variable which will be used to represent
	 *                                the new development level of an Element.
	 * @param developmentLevelMessage - String variable which will be used to
	 *                                represent the development message that is
	 *                                displayed by each Element when they are
	 *                                developed.
	 */
	public static void displayDevelopmentCompleteMessage(int developmentLevel, String developmentLevelMessage) {

		/*
		 * If the new development level is equal to 3, the Element has reached Major
		 * Development Status.
		 */
		if (developmentLevel == 3) {
			System.out.printf("\n|*****| Development Level %d Complete - Major Development Status Achieved |*****|\n\n",
					developmentLevel);

			/* Otherwise, the standard development message of each Element is displayed. */
		} else {
			System.out.printf("\n|*****| Development Level %d Complete |*****|\n\n", developmentLevel);
		}
		System.out.println(developmentLevelMessage);
	}

	/**
	 * Static method that displays a message if a Player has decided to cancel
	 * developing an Element.
	 * 
	 * @param elementName - String variable which will be used to represent the name
	 *                    of the Element that has had it's development cancelled.
	 */
	public static void displayDevelopmentCancelledMessage(String elementName) {
		System.out.printf("\nDevelopment of the %s cancelled.\n", elementName);
	}

	/**
	 * Static method that displays a message asking the Player to select which
	 * Element they want to gift to another Player.
	 * 
	 * @param numOfElementsOwned - int variable that represents that number of
	 *                           Elements that the Player owns. This is used to
	 *                           display the range of numbers that the Player can
	 *                           enter to select an Element (i.e. between 1 and 3
	 *                           etc.).
	 */
	public static void displaySelectElementToGiftMessage(int numOfElementsOwned) {

		if (numOfElementsOwned > 1) {
			System.out.printf("\nEnter a number between 1 and %s to indicate which Element to wish to gift to "
					+ "\nanother player.\n", numOfElementsOwned);
		}
	}

	/**
	 * Static method which displays the menu options shown to Players when they wish
	 * to gift an Element to another Player.
	 */
	public static void displayGiftElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Gift Element.\n2. Cancel Gift.");
	}

	/**
	 * Static method that asks the Player to confirm if they want to gift the
	 * Element to another Player.
	 * 
	 * @param elementName - String variable which will be used to represent the name
	 *                    of the Element that is being gifted.
	 */
	public static void displayConfirmGiftElementMessage(String elementName) {
		System.out.printf("\nDo you want to gift the %s to another player?\n", elementName);
	}

	/**
	 * Static method which displays the menu options shown to Players when they have
	 * chosen another Player to gift an Element to.
	 */
	public static void displayConfirmGiftElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Confirm Gifting of Element.\n2. Cancel Gifting of Element.");
	}

	/**
	 * Static method that displays a message if a Player has cancelled gifting an
	 * Element to another Player.
	 * 
	 * @param elementName - String variable which will be used to represent the name
	 *                    of the Element that is no longer being gifted.
	 */
	public static void displayElementGiftCancelled(String elementName) {
		System.out.printf("\nGifting of the %s cancelled.\n", elementName);
	}

	/**
	 * Static method that displays a message explaining that a Player has gifted an
	 * Element to another Player.
	 * 
	 * @param currentPlayerName   - String variable which will be used to represent
	 *                            the name of the Player that has gifted the
	 *                            Element.
	 * @param elementName         - String variable which will be used to represent
	 *                            the name of the Element that has been gifted.
	 * @param receivingPlayerName - String variable which will be used to represent
	 *                            the name of the Player that has received the
	 *                            Element.
	 */
	public static void displayElementGiftedMessage(String currentPlayerName, String elementName,
			String receivingPlayerName) {

		System.out.println("\n\n|*****| Element Gifted to Another Player |*****|");

		System.out.printf("\n%s has gifted the %s to %s.\n", currentPlayerName, elementName, receivingPlayerName);
	}

	/**
	 * Static method which displays a message explaining that a Player may have to
	 * pay tax for landing on an Element that is owned by another Player.
	 * 
	 * A message is displayed asking the owner of the Element if they want to charge
	 * the other Player tax.
	 * 
	 * @param currentPlayer - String variable which will be used to represent the
	 *                      name of the Player that has landed on an Element owned
	 *                      by another Player.
	 * @param elementOwner  - String variable which will be used to represent the
	 *                      name of the Player that owns the Element that another
	 *                      Player has landed on.
	 */
	public static void displayPayTaxMessage(String currentPlayer, String elementOwner) {

		System.out.println("\n\n|*****| Potential Tax Charge |*****|");

		System.out.printf("\nThis Element is owned by %s. You may have to pay tax for landing on this Element.\n",
				elementOwner);

		System.out.printf("\n%s, do you want to charge %s tax for landing on this Element?\n\n", elementOwner,
				currentPlayer);
	}

	/**
	 * Static method that displays a list of menu options when the owner of an
	 * Element is asked if they want to charge another Player tax.
	 */
	public static void displayPayTaxMenu() {
		System.out.println("1. Charge Tax.\n2. Waive Tax Charge.");
	}

	/**
	 * Static method that displays a message whenever a Player has been charged tax
	 * for landing on an Element that is owned by another Player.
	 * 
	 * @param taxAmount - int variable that will be used to represent the amount of
	 *                  tax that has been charged.
	 */
	public static void displayTaxNoticeMessage(int taxAmount) {

		System.out.println();
		System.out.println("=======================");
		System.out.println("=                     =");
		System.out.println("=  Tax Charge Notice  =");
		System.out.println("=                     =");
		System.out.printf("= %d Commitment Coins =\n", taxAmount);
		System.out.println("=      deducted       =");
		System.out.println("=  from your balance  =");
		System.out.println("=                     =");
		System.out.println("=======================");

	}

	/**
	 * Static method that displays a message whenever an Element owner has declined
	 * to charge another Player tax for landing on their Element.
	 * 
	 * @param elementOwner - String variable which will be used to represent the
	 *                     name of the Player that owns the Element that another
	 *                     Player has landed on.
	 */
	public static void displayTaxWaivedMessage(String elementOwner) {

		System.out.println("\n\n|*****| Tax Charge Waived |*****|");

		System.out.printf("\n%s has waived the tax charge.\n", elementOwner);
	}

	/**
	 * Static method that displays graphics and messages to screen whenever the game
	 * has successfully been completed.
	 */
	public static void displayMissionAccomplishedMessage() {

		System.out.println("\n\n|*****| Mission Successfully Completed |*****|\n");

		/* Adds a delay of 1 second. */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}

		System.out.println("\n\n\t          __________\n" + "\t         |NASA  NEWS|\n" + "\t         |*** ======|\n"
				+ "\t         |=== ======|\n" + "\t         |=== == ***|\n" + "\t         |[*] ======|\n"
				+ "\t         |=== ===/##|\n" + "\t         |__________|\n");

		String[] artemisLiteHeadlines = {
				"\n_______________________________________________\n\nIn 2022,\nThe team behind the ArtemisLite "
						+ "Mission have \nsuccessfully completed the development phase of \nthe program."
						+ "\n_______________________________________________",
				"\n\n________________________________________________\n\nIn 2023, \nFinal tests of the ArtemisLite "
						+ "Systems \nare underway as ArtemisLite plans to launch \nearly next year!"
						+ "\n________________________________________________",
				"\n\n________________________________________________\n\nIn 2024, \nExcitement builds as Launch "
						+ "of ArtemisLite is \nscheduled for May 1st 2024!"
						+ "\n________________________________________________",
				"\n\n________________________________________________\n\nMAY 2024 \nFINALLY, LAUNCH DAY IS HERE! "
						+ "\nGoodluck Cadets! America is behind you!"
						+ "\n________________________________________________" };

		/*
		 * String Array to hold messages that will displayed to screen at different
		 * intervals.
		 */
		String[] missionAccomplished = { "\nCongratulations Team Artemis",
				"You have successfully completed the development phase of the program.", "",
				"Your team has successfully developed the four core systems of Command and Control,"
						+ "\nSpace Launch System, SpaceCraft and the Training Program.",
				"Development has been to a high quality standard and we are now ready to launch!\n", "",
				"READY TO LAUNCH IN T MINUS 20 SECONDS", "", "'Launch Control, testing testing...'", "",
				"'Prop 1, Vehicle Fuel Tank press Open...'", "", "'Open!'", "", "'Fuel Umbilical Purge to Open!'", "",
				"'Open!'", "", "'Mission Director! Is the Artemis spacecraft ready?'", "", "'Spacecraft is go!", "",
				"'16 SECONDS'", "", "'Prop 1, is pressure ready?'", "", "'Tanks to Relief!'", "",
				"'SSC, updates please!'", "", "'Hydraulic External Power On!'", "",
				"'Range Control Officer.... RCO.....RCO, Updates NOW!'", "", "'YES! Range, you're go for Launch'", "",
				"'Roger'", "", "'10'", "", "'9'", "", "'8'", "", "'7'", "", "'6'", "", "'5'", "", "'4'", "", "'3'", "",
				"'2'", "", "'1'", "", "'LIFT OFF!'", "", "", "Launch was successful...", "",
				"Images coming through now...", "", };

		/*
		 * Messages from the artemisLiteHeadlines String array are displayed to screen
		 * at 0.5 second intervals.
		 */
		for (int loop = 0; loop < artemisLiteHeadlines.length; loop++) {
			System.out.println(artemisLiteHeadlines[loop]);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n\n\n\n*****| CONGRATULATIONS TEAM ARTEMISLITE |*****|\n\n");

		/*
		 * Messages from the missionAccomplished String array are displayed to screen at
		 * 0.5 second intervals.
		 */
		for (int loop = 0; loop < missionAccomplished.length; loop++) {
			System.out.println(missionAccomplished[loop]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/* Adds a delay of 1 second. */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}

		/* Displays to screen an image of 2 Astronauts - Created by Megan Dallat. */
		System.out.println("                                         <>______________________\r\n"
				+ "       .-\"\"\"-.            .-\"\"\"-.       ||-._`-._ :| |: _.-'_.-|\r\n"
				+ "      /= ___  \\          /= ___  \\      ||   `-._`:| |:`_.-'   |\r\n"
				+ "     |-//~~~\\\\ |        |- /~~~\\  |     ||-------`-' '-'-------|\r\n"
				+ "     |=( '.' ) |        |=( '.' ) |     ||------_.-. .-._------|\r\n"
				+ "     \\//\\_=_/\\\\/        \\__\\_=_/__/     ||  _.-'_.:| |:._`-._  |\r\n"
				+ "      {_______}          {_______}      ||-'_.-'  :| |:  `-._`-|\r\n"
				+ "    /` *       `'--._  /` *       `'--._||~~~~~~~~~~~~~~~~~~~~~~\r\n"
				+ "   /= .    [N] .      /= .    [N] .     { >\r\n" + "  /  /|ooo     |`'--'/  /|ooo     |`'--'|| \r\n"
				+ " (   )\\_______/     (   )\\_______/      ||        THE\r\n"
				+ "  \\``\\/       \\      \\``\\/       \\      ||    ARTEMISLITE\r\n"
				+ "   `-| ==    \\_|      `-| ==    \\_|     ||      MISSION\r\n"
				+ "     /         |        /         |     ||        WAS\r\n"
				+ "    |=   >\\  __/       |=   >\\  __/     ||     SUCCESSFUL!\r\n"
				+ "    \\   \\ |- --|       \\   \\ |- --|     ||    WE  DID  IT!\r\n"
				+ "     \\ __| \\___/        \\ __| \\___/     ||\r\n"
				+ "     _{__} _{__}        _{__} _{__}     ||\r\n" + "    (    )(    )       (    )(    )     ||\r\n"
				+ "^^~  `\"\"\"  `\"\"\" ~^^^^^~ `\"\"\"  `\"\"\"  ~^^^~^^~~~^^^~^^^~^^^~^^~^   \n"
				+ "________________________________________________________________________");
	}

	/**
	 * Static method that displays a summary and outcome of the game whenever the
	 * game has ended.
	 * 
	 * @param playerList - List of Player objects that are playing the game.
	 */
	public static void displayGamePlayResultsToScreen(List<Player> playerList, boolean quitGame, boolean playerBankrupt,
			boolean allElementsDeveloped) {

		/*
		 * If all Systems have been fully developed and the game has completed
		 * successfully, the displayMissionAccomplishedMessage is displayed to screen.
		 */
		if (allElementsDeveloped) {
			displayMissionAccomplishedMessage();
		}

		/* Adds a delay of 3 seconds. */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}

		System.out.println("\n\n|*****| Game Play Summary |*****|\n");

		/*
		 * Loops through each Player object in the playerList of the ArtemisLite class.
		 */
		for (Player player : playerList) {

			System.out.printf("\n|*****| Cadet %d |*****|\n", player.getPlayerID());

			/* Displays details of the Player if they owned no Elements. */
			if (player.getPlayerElements().size() == 0) {
				System.out.println("\nCadet " + player.getPlayerName() + " owned no Elements and had "
						+ player.getPlayerFunds() + " Commitment Coins remaining.\n");
			} else {

				/* Displays details of the Player if they owned any Elements. */
				System.out.println("\nCadet " + player.getPlayerName() + " owned " + player.getPlayerElements().size()
						+ " Elements and had " + player.getPlayerFunds() + " Commitment Coins remaining.");
				System.out.println("The work of Cadet " + player.getPlayerName()
						+ " included the below Element ownership and subsequent developments:\n\n");

				/* Loops through each Element owned by the Player. */
				for (Element element : player.getPlayerElements()) {

					/* int variable to store the amount of investment in each Element. */
					int costs = 0;

					/* Calculates the amount of investment in each Element. */
					if (element.getDevelopmentLevel() == 0) {
						costs = element.getPurchaseCost();
					} else if (element.getDevelopmentLevel() == 1) {
						costs = element.getPurchaseCost() + element.getDevelopmentCost();
					} else if (element.getDevelopmentLevel() == 2) {
						costs = element.getPurchaseCost() + (element.getDevelopmentCost() * 2);
					} else if (element.getDevelopmentLevel() == 3) {
						costs = element.getPurchaseCost() + (element.getDevelopmentCost() * 3);
					}

					/* Displays details to screen about each Element owned. */
					System.out.print("Element:\t\t\t\t" + element.getSquareName() + "\nSystem:\t\t\t\t\t"
							+ element.getSystemType() + "\nDevelopment Level:\t\t\t" + element.getDevelopmentLevel()
							+ "\nTotal Commitment Coins Invested:\t" + costs);
					System.out.println("\n");
				}
			}
		}

		/* Displays the reason for the game ending. */
		System.out.println("\n|*****| Reason for Game Ending |*****|\n");

		if (quitGame) {
			System.out.println("A Cadet decided to quit during the game play.");
		}

		if (playerBankrupt) {
			System.out.println("A Cadet went bankrupt during the game play.");
		}

		if (allElementsDeveloped) {
			System.out.println("All Systems were fully developed to Major Development Status.");

		}

		System.out.println("\n\n|*****| End of Game Play Summary |*****|");

	}
}
