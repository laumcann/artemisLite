/**
 * 
 */
package artemislitev5;

/**
 * Scanner class imported to handle the user's keyboard entries.
 */
import java.util.Scanner;

/**
 * InputMismatchException class imported to handle invalid user entries using a Scanner object.
 */
import java.util.InputMismatchException;

/**
 * This class contains the main Game Engine that controls the flow of the
 * ArtemisLite game. This class contains a static method (initialiseArtemis)
 * with a do-while loop that will continuously run until the user selects to
 * exit out of the entire application in the IDE.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class GameController {

	/**
	 * A static method that controls the flow of the ArtemisLite game.
	 * 
	 * Contains a do-while loop that will continuously run until the user enters the
	 * number 3, which will cause the loop to end and the entire application to end.
	 * 
	 * If the user enters the number 1, the playGame method of the ArtemisLite class
	 * is executed and the main game play begins.
	 * 
	 * @param scanner - Scanner object which will handle the user's keyboard
	 *                entries.
	 */
	public static void initialiseArtemis(Scanner scanner) {

		// boolean variable to assess if the game has been quit at the Start menu
		// originally initialised to false
		boolean quitGame = false;

		// int variable to store the user's input from an instance of a Scanner class
		// originally initialised to 0
		int userOption = 0;

		// Static method of MessageCentre class to display the opening credits for the
		// game
		MessageCentre.displayOpeningCredits();

		// Do while loop that will run until the user enters the number 3 to end the
		// game
		do {
			// Try catch block that catches any non-numeric entries from the user
			try {
				// Static method of MessageCentre class to display the start menu of the game
				MessageCentre.displayStartMenu();

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// If 1 is entered by the user, the game will be begin
				case 1:
					// creates a new instance of the ArtemisLite class
					ArtemisLite newGame = new ArtemisLite();
					// executes the playGame method of the ArtemisLite class
					newGame.playGame(scanner);
					break;
				// If 2 is entered by the user, the rules of the game will be displayed
				case 2:
					// Static method of MessageCentre class to display the rules of the game
					MessageCentre.displayRules();
					break;
				// If 3 is entered by the user, the game will quit
				case 3:
					// calls the static quitArtemis method of the GameController class
					// if quitArtemis returns false, quitGame will be false
					// if quitArtemis returns true, quitGame will be true
					if (!quitArtemis(scanner)) {
						quitGame = false;
					} else {
						quitGame = true;
					}
					break;
				// A message is displayed to the user if they enter a number that isn't
				// between 1 and 3
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
			// While quitGame is false, the do while loop enters another iteration
		} while (!quitGame);
		scanner.close();
		// Application ends
		System.exit(0);
	}

	/**
	 * A static method that will determine if the user wants to quit the game from
	 * within the Start Menu.
	 * 
	 * Contains a do-while loop that will continuously run until the user enters the
	 * number 1 or 2, which will cause the loop to end and the method to return a
	 * boolean value.
	 * 
	 * If the user enters the number 1, the method will return true. If the user
	 * enters the number 2, the method will return false.
	 * 
	 * @param scanner - Scanner object which will handle the user's keyboard
	 *                entries.
	 */
	public static boolean quitArtemis(Scanner scanner) {

		// boolean variable to assess if the player confirms they want to quit
		// originally initialised to false
		boolean confirmQuitGame = false;

		// int variable to store the user's input from an instance of a Scanner class
		// originally initialised to 0
		int userOption = 0;

		// Static method of MessageCentre class to display a message asking the player
		// to confirm that they want to quit the game
		MessageCentre.displayQuitFromStartMenuConfirmationMessage();

		// Do while loop that will run until the user enters the number 1 or 2
		do {
			// Try catch block that catches any non-numeric entries from the user
			try {
				// Static method of MessageCentre class to display the confirm quit menu
				MessageCentre.displayQuitFromStartMenuConfirmationMenu();

				// Assigning the user's entry to the userOption variable
				userOption = scanner.nextInt();

				// Passing the userOption variable into a switch statement to determine which
				// option they have chosen
				switch (userOption) {

				// If 1 is entered by the user, confirmQuitGame is true
				case 1:
					// Static method of MessageCentre class to display a message that the game has
					// been ended
					MessageCentre.displayQuitFromStartMenuMessage();
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
}
