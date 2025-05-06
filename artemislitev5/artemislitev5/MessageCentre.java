/**
 * 
 */
package artemislitev5;

import java.util.List;

/**
 * @author Adam Vaughan This class contains many of the text prompts, menus and
 *         messages that will be displayed to players during the ArtemisLite
 *         game. These messages are contained within static methods that can be
 *         called directly without instantiating this class.
 */
public class MessageCentre {

	/**
	 * Static method which displays the Opening Credits of the game, which is the
	 * first thing that players will see when they run the game in the IDE.
	 */
	public static void displayOpeningCredits() {

		System.out.println("Dear Cadet / Cadets,\n\nYou have been selected to enroll in the ArtemisLite "
				+ "Lunar Exploration Program to help NASA develop and secure critical\nsystems as part "
				+ "of our mission to land the first person of colour and the first woman on the "
				+ "surface of the Moon.\n");

		System.out.println("Your mission, should you choose to accept it, is to work to develop four "
				+ "systems to ensure that the ArtemisLite program\nis ready for take off. The four systems are:\n");

		System.out.println("\t• Command and Control");
		System.out.println("\t• Space Launch System Rocket");
		System.out.println("\t• Launch Complex");
		System.out.println("\t• Astronaut Training Program");

		System.out.println("\nDo you want to enroll?");
	}

	/**
	 * Static method which displays the Start Menu of the game, which gives players
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

		System.out.println("Your mission is to work to develop four Systems to ensure that the ArtemisLite "
				+ "program is ready for take off.\nThe four Systems are:\n");

		System.out.println("\t• Command and Control");
		System.out.println("\t• Space Launch System Rocket");
		System.out.println("\t• Launch Complex");
		System.out.println("\t• Astronaut Training Program\n");

		System.out.println("Each Element within each System will require three rounds of development to achieve "
				+ "Major Development status.\n");

		System.out.println("Please note: Once you have been registered to our program with Payroll, you must complete "
				+ "the mission. If you\nshould choose to leave our mission, the mission will have failed and we "
				+ "will unfortunately have to retire all\nof the employees working on the program. Therefore, "
				+ "you must be 100% dedicated to the program to ensure success.\n");

		System.out.println("In order to ensure that our staff are working at peak performance, we offer Unpaid Leave. "
				+ "When you are taking Unpaid\nLeave, we advise that you do not partake in any work activities or "
				+ "developments - you will not be paid for this time.\n");

		System.out.println("We also offer a desirable yearly bonus scheme, which Payroll will add to your account "
				+ "with each passing year - you\ndo not need to do anything in order to gain access to your yearly "
				+ "bonus - just keep up the good work!\n");

		System.out.println("Working on the common goal of fully developing each Element of all four Systems will "
				+ "result in the completion of our\nmission and we can finally take off. We will support you "
				+ "through every move by providing you with all of the relevant\ninformation you need to "
				+ "make the best decisions in your work.\n");

		System.out.println("Good luck Cadet!\nNASA\n\n");

		System.out.println("|*****| Employment Contract Terms and Conditions |*****|\n");

		System.out.println("\t• Your team must consist of between 1 - 4 Cadets. Cadet names may represent "
				+ "organisations or individuals.\n");

		System.out.println("\t• Each Cadet must take their turn independently to throw 2 dice before moving to "
				+ "a new Square on the virtual\n\tgame board.\n");

		System.out.println("\t• After moving to a new Square, an explanation of the opportunities and obligations "
				+ "will be displayed on screen\n\tand the player will then have the opportunity to indicate their "
				+ "choice of action before completing their turn.\n");

		System.out.println("\t• If a player lands on a Square that no other player has previously occupied, they "
				+ "can choose to ‘take charge’ of \n\tthat Square by purchasing it, or they can offer it to another "
				+ "player to purchase at the usual cost.\n");

		System.out.println("\t• Cadets will be informed of all changes to their resources, and can access their "
				+ "resource balance during their turn.\n");

		System.out.println(
				"\t• When a Cadet passes or lands on the Payroll square, they will gain a pay bonus of " + "$00\n");

		System.out.println("\t• When a player lands on the 'Unpaid Leave' square, they will take a break from "
				+ "gameplay and will be unable to\n\tdevelop any systems.\n");

		System.out.println("\t• The four systems are:\n");

		System.out.println("\t\t• Command and Control - 3x Elements");

		System.out.println("\t\t• Space Launch System Rocket - 2x Elements (most expensive System)");

		System.out.println("\t\t• Launch Complex - 3x Elements");

		System.out.println("\t\t• Astronaut Training Program - 2x Elements (least expensive System)\n");

		System.out.println("\t• Before each player can develop an Element of a System, they must have taken charge "
				+ "of all of the elements\n\twithin that System.\n");

		System.out.println("\t• A player can develop multiple Elements during a single turn.\n");

		System.out.println("\t• When a player lands on an Element which they do not own, the person who is in "
				+ "charge of that element makes\n\ta choice whether to demand resources from the player, or "
				+ "decline acceptance of resources.\n");

		System.out.println("\t• If a player runs out of resources, the game ends for all players and the state "
				+ "of gameplay will display to screen.\n");

		System.out.println("\t• If a player chooses to quit the game, the game ends for all players and the state "
				+ "of gameplay will display to screen.\n");

		System.out.println("\t• When all Systems are fully developed through team effort, the successful outcome "
				+ "of the mission is displayed to\n\tscreen, along with the final state of gameplay.\n");

		System.out.println("|*****| End of Game Rules |*****|");
	}

	public static void displayQuitFromStartMenuConfirmationMessage() {

		System.out.println("\n\n|*****| Quit Game |*****|");

		System.out.println("\nYou have selected to quit the game. Are you sure you want to quit?");
	}

	public static void displayQuitFromStartMenuConfirmationMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Quit Game.\n2. Cancel and return to Start Menu.");
	}

	/**
	 * Static method which displays a message if the game is quit from the start
	 * menu of the game.
	 */
	public static void displayQuitFromStartMenuMessage() {

		System.out.println("\n\n|*****| Game Over |*****|");

		System.out.println("\nYou have chosen not to enrol. Please reconsider in the future.\n\nGoodbye!");
	}

	/**
	 * Display message for when a player decides to quit on their gameplay turn.
	 */
	public static void displayQuitFromGamePlayConfirmationMessage() {

		System.out.println("\n\n|*****| Quit Game |*****|");

		System.out.println("\nIf you decide to quit your job as a Cadet and withdraw from employment in NASA's "
				+ "ArtemisLite programme,\nthen our mission as a team will have failed and we will cease "
				+ "all employment with the ArtemisLite team.\n"
				+ "The future of the ArtemisLite project is in your hands, are you sure you wish to quit?");
	}

	public static void displayQuitFromGamePlayConfirmationMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Quit Game.\n2. Cancel and return to mission.");
	}

	/**
	 * Static method which displays a message explaining that the number of players
	 * needs to be provided.
	 */
	public static void displayPlayerEnrolmentMessage() {

		System.out.println("\n\n|*****| Welcome to ArtemisLite |*****|");

		System.out.println("\nThank you for enrolling in the ArtemisLite program!\n\nBefore we begin, we need to know "
				+ "how many Cadets will be on your team. Your team must contain at least 1 Cadet and no more\n"
				+ "than 4 Cadets.\n");
	}

	/**
	 * Static method which displays a message asking for the number of players that
	 * will be playing the game.
	 */
	public static void displayNumOfPlayersRequiredMessage() {

		System.out.println(
				"Please enter a number between 1 and 4 below to indicate how many Cadets will be on " + "your team.");
	}

	/**
	 * Static method which displays a message showing how many players will be
	 * playing the game.
	 * 
	 * @param numOfPlayers - numOfPlayers variable from ArtemisLite class is passed
	 *                     as an argument and is used to display how many players
	 *                     have been enrolled in the game - if there are more than 1
	 *                     player then the plural of Cadet (Cadets) is used in the
	 *                     displayed message.
	 */
	public static void displayNumOfPlayersEnrolledMessage(int numOfPlayers) {

		if (numOfPlayers == 1) {
			System.out.printf("\nYou have chosen to enrol %d Cadet in your team.\n\n", numOfPlayers);
		} else {
			System.out.printf("\nYou have chosen to enrol %d Cadets in your team.\n\n", numOfPlayers);
		}
	}

	/**
	 * Static method which displays a message asking the user to enter the names of
	 * each player that will be playing the game.
	 * 
	 * @param numOfPlayers - numOfPlayers variable from ArtemisLite class is passed
	 *                     as an argument and is used to determine how many players
	 *                     are playing - if there are more than 1 player then the
	 *                     plural of name (names) is used in the displayed message.
	 */
	public static void displayPlayerNameRequiredMessage(int numOfPlayers) {

		if (numOfPlayers == 1) {
			System.out.printf("Please enter the name of the Cadet in your team.\n");
		} else {
			System.out.printf("Please enter the names of each Cadet in your team.\n");
		}
	}

	/**
	 * Static method which displays a message explaining that each player must roll
	 * 2 dice to determine what order each player will play in.
	 */
	public static void displayDeterminePlayerOrderMessage() {

		System.out.println("\n\n|*****| Determining Playing Order |*****|");

		System.out.println("\nTo determine which order each player will play in and who goes first, each player "
				+ "must roll 2 dice. The player with the\nhighest roll will go first.\n");
	}

	/**
	 * Static method which displays a message showing the order that each player
	 * will play in.
	 * 
	 * @param playerList - Method takes an ArrayList of Player objects as a
	 *                   parameter to be used to display the names of each player,
	 *                   as well as the highest roll score of the player that will
	 *                   play first. If there is only 1 player, a message is
	 *                   displayed explaining that the playing order does not need
	 *                   to be determined.
	 */
	public static void displayPlayerOrderMessage(List<Player> playerList) {

		if (playerList.size() == 1) {
			System.out.printf("\n%s is the only Cadet enrolled in this mission; therefore, the player order does "
					+ "not need to be determined.\n", playerList.get(0).getPlayerName());
		} else if (playerList.size() == 2) {
			System.out.printf("%s rolled %d and will go 1st. %s will go 2nd.\n", playerList.get(0).getPlayerName(),
					playerList.get(0).getFirstRollScore(), playerList.get(1).getPlayerName());
		} else if (playerList.size() == 3) {
			System.out.printf("%s rolled %d and will go 1st. %s will go 2nd and %s will go 3rd.\n",
					playerList.get(0).getPlayerName(), playerList.get(0).getFirstRollScore(),
					playerList.get(1).getPlayerName(), playerList.get(2).getPlayerName());
		} else {
			System.out.printf("%s rolled %d and will go 1st. %s will go 2nd, %s will go 3rd and %s will go 4th.\n",
					playerList.get(0).getPlayerName(), playerList.get(0).getFirstRollScore(),
					playerList.get(1).getPlayerName(), playerList.get(2).getPlayerName(),
					playerList.get(3).getPlayerName());
		}
	}

	/**
	 * Static method which displays a message showing the choices that each player
	 * has during their turn.
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player taking their turn.
	 */
	public static void displayPlayerTurnMenu(String playerName) {

		System.out.println("\n\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, it is your turn. What do you want to do?\n\n", playerName);

		System.out.println("1. Roll the dice.");
		System.out.println("2. Develop an element.");
		System.out.println("3. Display your status.");
		System.out.println("4. Display game rules.");
		System.out.println("5. Finish turn.");
		System.out.println("6. Quit game.");
	}

	/**
	 * Static method which displays a message showing the choices that a solo player
	 * has when playing
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player taking their turn.
	 */
	public static void displayPlayerTurnMenuSoloGamePlay(String playerName) {

		System.out.println("\n\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, what do you want to do now?\n\n", playerName);

		System.out.println("1. Roll the dice.");
		System.out.println("2. Develop an element.");
		System.out.println("3. Display your status.");
		System.out.println("4. Display game rules.");
		System.out.println("6. Quit game.");
	}

	/**
	 * Static method which displays a message showing the choices that each player
	 * has during their turn whilst on unpaid Leave
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player taking their turn.
	 */
	public static void displayPlayerTurnMenuUnpaidLeave(String playerName) {

		System.out.println("\n\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, You shouldn't be working! What would you like to do?\n\n", playerName);
		System.out.println("3. Display your status.");
		System.out.println("4. Display game rules.");
		System.out.println("5. Finish turn.");
		System.out.println("6. Quit game.");
	}

	/**
	 * Static method which displays a message showing the choices that a solo player
	 * has when playing and landed on the Unpaid Leave Square
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player taking their turn.
	 */
	public static void displayPlayerTurnMenuSoloGamePlayUnpaidLeave(String playerName) {

		System.out.println("\n|*****| Turn Menu |*****|");

		System.out.printf("\n%s, what do you want to do now?\n\n", playerName);

		System.out.println("1. Roll the dice.");
		System.out.println("3. Display your status.");
		System.out.println("4. Display game rules.");
		System.out.println("6. Quit game.");
	}

	/**
	 * Static method which displays a message showing the player what they have
	 * rolled and what square number they have landed on.
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player taking their turn.
	 * @param numRolled  - Method takes an int as a parameter, which will be used to
	 *                   represent the number the player rolled with the dice.
	 * @param squareNum  - - Method takes an int as a parameter, which will be used
	 *                   to represent the square number that the player has moved
	 *                   to.
	 */
	public static void displayPlayerRollDiceMessage(String playerName, int numRolled, int squareNum) {

		System.out.println("\n\n|*****| Role the Dice |*****|");

		System.out.printf("\n%s has rolled a %d and has landed on Square %d.\n", playerName, numRolled, squareNum);
	}

	public static void displayLandOnPayrollMessage(String playerName, int funds) {
		
		System.out.println("\n\n|*****| Landed on Payroll |*****|");

		System.out.printf("\n%s has landed on the Payroll Square. %s has collected their yearly bonus of %d "
				+ "dollars to support the completion\nof the mission.\n", playerName, playerName, funds);
	}

	public static void displayPassPayrollMessage(String playerName, int funds) {
		
		System.out.println("\n\n|*****| Passed Payroll |*****|");

		System.out.printf("\n%s has passed the Payroll Square. %s has collected their yearly bonus of %d "
				+ "dollars to support the completion\nof the mission.\n", playerName, playerName, funds);
	}

	/**
	 * Static method which displays a message if the game is quit during the game
	 * play.
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player who has quit.
	 */
	public static void displayQuitFromGamePlayMessage(String playerName) {

		System.out.printf("\nCadet %s has decided to withdraw from the ArtemisLite project. All work on this "
				+ "project has now ceased due to\nlabour constraints, while the target of landing the first "
				+ "person of colour and the first woman on the surface of\nthe Moon by 2024 has been pushed "
				+ "back by several years. Senior NASA officials are expected to be summoned in front\nof "
				+ "Congress in the coming weeks to explain the failings of this project.\n", playerName);
	}

	/**
	 * Static method which displays a message if a player goes bankrupt during the
	 * game play. If a player goes bankrupt the game will end.
	 * 
	 * @param playerName - Method takes a String as a parameter, which will be used
	 *                   to represent the name of the player who has gone bankrupt.
	 */
	public static void displayPlayerBankruptMessage(String playerName) {

		System.out.printf("\nCadet %s has become bankrupt. All work on the ArtemisLite project "
				+ "has now ceased due to funding constraints, while\nthe target of landing the first person of colour "
				+ "and the first woman on the surface of the Moon by 2024 has been\npushed back by several years. "
				+ "Senior NASA officials are expected to be summoned in front of Congress in the coming\nweeks "
				+ "to explain the failings of this project.\n", playerName);
	}

	/**
	 * Static method which displays the menu options shown to players when they land
	 * on an unoccupied element
	 */
	public static void displayPurchaseElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Purchase Element.\n2. Decline Element.");
	}

	public static void displayOfferElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Offer Element to Another Player.\n2. Decline to Offer Element.");
	}

	public static void displayPlayerNamesMenu(List<Player> playerList, String currentPlayer) {

		System.out.println(
				"\nEnter a number from the list below to select the player you want to offer this " + "Element to.\n");

		for (Player player : playerList) {

			if (player.getPlayerName().equals(currentPlayer)) {
				continue;
			} else {
				System.out.printf("%d: %s\n", playerList.indexOf(player) + 1, player.getPlayerName());
			}
		}
	}

	public static void displaySelectElementToDevelopMessage(int numOfElementsOwned) {

		if (numOfElementsOwned > 1) {
			System.out.printf("\nEnter a number between 1 and %s to indicate which Element to wish to develop.\n",
					numOfElementsOwned);
		}
	}

	/**
	 * Static method which displays the menu options shown to players when they wish
	 * to develop an Element they own
	 */
	public static void displayDevelopElementMenu() {

		System.out.println("\nEnter a number between 1 and 2 to indicate your response.\n");

		System.out.println("1. Develop Element.\n2. Cancel Development.");
	}

	public static void displayDevelopmentCompleteMessage(int developmentLevel, String developmentLevelMessage) {

		if (developmentLevel == 3) {
			System.out.printf("\n|*****| Development Level %d Complete - Major Development Status Achieved |*****|\n\n",
					developmentLevel);
		} else {
			System.out.printf("\n|*****| Development Level %d Complete |*****|\n\n", developmentLevel);
		}
		System.out.println(developmentLevelMessage);
	}

	public static void displayPayTaxMessage(String currentPlayer, String squareOwner) {

		System.out.printf("\nThis Element is owned by %s. You may have to pay tax for landing on this Element.\n",
				squareOwner);

		System.out.printf("\n%s, do you want to charge %s 50 dollars in tax for landing on this Element?\n\n",
				squareOwner, currentPlayer);
	}

	public static void displayPayTaxMenu() {

		System.out.println("1. Charge Tax.\n2. Waive Tax Charge.");
	}

	public static void displayTaxNoticeMessage() {

		System.out.println();
		System.out.println("=======================");
		System.out.println("=                     =");
		System.out.println("=  Tax Charge Notice  =");
		System.out.println("=                     =");
		System.out.println("= 50 dollars deducted =");
		System.out.println("=  from your balance  =");
		System.out.println("=                     =");
		System.out.println("=======================");

	}

	/**
	 * displays the message with 1 second delay between each string to screen.
	 * Incredible artwork by @author Megan Dallat
	 */
	public static void displayMissionAccomplishedMessage() {
		String[] missionAccomplished = { "\nCongratulations Team Artemis",
				"You have successfully completed the development phase of the program.", "",
				"Your team has developed our four core systems of Command and Control,\nSpace Launch System, SpaceCraft and the Training Program...",
				"to high quality standards and we are now ready to launch!", "",
				"READY TO LAUNCH IN T MINUS 20 SECONDS", "", "'Launch Control, testing testing..'", "",
				"'Prop 1, Vehicle Fuel Tank press Open..'\tOpen!'", "", "'Fuel Umbilical Purge to Open!'\'Open!'", "",
				"'Mission Director! Is Artemis spacecraft ready?'\t'Spacecraft is go!", "", "'16 SECONDS'", "",
				"'Prop 1, is pressure ready?'\t'Tanks to Relief!'", "",
				"'SSC, updates please!'\t'Hydraulic External Power On!'", "",
				"'Range Control Officer.... RCO.....RCO, Updates NOW!'", "", "'YES! Range, you're go for Launch'", "",
				"'Roger'", "", "'10'", "", "'9'", "", "'8'", "", "'7'", "", "'6'", "", "'5'", "", "'4'", "", "'3'", "",
				"'2'", "", "'1'", "", "'LIFT OFF!'", "", "", "Launch was successful...", "",
				"Images coming through now...", "",
				"                                         <>______________________\r\n"
						+ "       .-\"\"\"-.            .-\"\"\"-.       ||-._`-._ :| |: _.-'_.-|\r\n"
						+ "      /= ___  \\          /= ___  \\      ||   `-._`:| |:`_.-'   |\r\n"
						+ "     |-//~~~\\\\ |        |- /~~~\\  |     ||-------`-' '-'-------|\r\n"
						+ "     |=( '.' ) |        |=( '.' ) |     ||------_.-. .-._------|\r\n"
						+ "     \\//\\_=_/\\\\/        \\__\\_=_/__/     ||  _.-'_.:| |:._`-._  |\r\n"
						+ "      {_______}          {_______}      ||-'_.-'  :| |:  `-._`-|\r\n"
						+ "    /` *       `'--._  /` *       `'--._||~~~~~~~~~~~~~~~~~~~~~~\r\n"
						+ "   /= .    [N] .      /= .    [N] .     { >\r\n"
						+ "  /  /|ooo     |`'--'/  /|ooo     |`'--'|| \r\n"
						+ " (   )\\_______/     (   )\\_______/      ||        THE\r\n"
						+ "  \\``\\/       \\      \\``\\/       \\      ||    ARTEMISLITE\r\n"
						+ "   `-| ==    \\_|      `-| ==    \\_|     ||      MISSION\r\n"
						+ "     /         |        /         |     ||        WAS\r\n"
						+ "    |=   >\\  __/       |=   >\\  __/     ||     SUCCESSFUL!\r\n"
						+ "    \\   \\ |- --|       \\   \\ |- --|     ||    WE  DID  IT!\r\n"
						+ "     \\ __| \\___/        \\ __| \\___/     ||\r\n"
						+ "     _{__} _{__}        _{__} _{__}     ||\r\n"
						+ "    (    )(    )       (    )(    )     ||\r\n"
						+ "^^~  `\"\"\"  `\"\"\" ~^^^^^~ `\"\"\"  `\"\"\"  ~^^^~^^~~~^^^~^^^~^^^~^^~^   \n"
						+ "________________________________________________________________________" };

		for (int loop = 0; loop < missionAccomplished.length; loop++) {
			System.out.println(missionAccomplished[loop]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
