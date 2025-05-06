/**
 * 
 */
package artemislitev9;

/**
 * This Enum represents the names of Systems that will be used to define the
 * systemType attributes of Element objects in the the ArtemisLite virtual game
 * board.
 * 
 * These System names represent some of the real life components of the NASA
 * Artemis mission.
 * 
 * Each System in the ArtemisLite virtual game board will consist of either 2 or
 * 3 Element objects.
 * 
 * Each System in this Enum has a corresponding String attribute attached to it.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public enum SystemType {

	/**
	 * Enum variables which will be used to define the systemType attributes of
	 * Element objects.
	 */
	COMMAND_AND_CONTROL("Command and Control"), SPACECRAFT("Spacecraft"), LAUNCH_COMPLEX("Launch Complex"),
	TRAINING_PROGRAM("Training Program");

	/**
	 * String variable which will hold a String representation of a SystemType Enum.
	 */
	private String systemName;

	/**
	 * Constructor with arguments for the SystemType Enum - Assigns a String
	 * variable to a SystemType Enum.
	 * 
	 * @param systemName
	 */
	private SystemType(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * A method that returns the systemName of a SystemType Enum.
	 * 
	 * @return systemName
	 */
	public String getSystemName() {
		return systemName;
	}
}
