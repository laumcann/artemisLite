/**
 * 
 */
package qub.group8.artemislite;

/**
 * Scanner class imported to handle the user's keyboard entries.
 */
import java.util.Scanner;

/**
 * This class contains the main method that runs the application for the
 * ArtemisLite game.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class Main {

	/**
	 * main method that begins the application.
	 * 
	 * This method creates a Scanner object that will be used throughout the game to
	 * handle the user's keyboard entries.
	 * 
	 * It calls the static initialiseArtemis method of the GameController class to
	 * begin the game, and passes the Scanner object to this method as an argument.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Creates a new Scanner object. A single instance of this Scanner is used
		 * throughout the entire application.
		 */
		Scanner scanner = new Scanner(System.in);

		/* Calls the static initialiseArtemis method of the GameController class. */
		GameController.initialiseArtemis(scanner);

		/* Closes the Scanner object, if it hasn't previously been closed. */
		scanner.close();
	}
}
