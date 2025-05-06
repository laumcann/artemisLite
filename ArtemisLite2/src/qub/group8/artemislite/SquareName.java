/**
 * 
 */
package qub.group8.artemislite;

/**
 * This Enum represents the names of Elements that will be used to define the
 * squareName attributes of Element objects in the the ArtemisLite virtual game
 * board.
 * 
 * These Element names represent some of the real life components of the NASA
 * Artemis mission.
 * 
 * Each Element name in this Enum has a corresponding String attribute attached
 * to it.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public enum SquareName {

	/**
	 * Enum variables which will be used to define the squareName attributes of
	 * Element objects.
	 */
	MISSION_CONTROL_CENTRE("Mission Control Center", 9),
	SPACE_COMMUNICATIONS_AND_NAVIGATION("Space Communications and Navigation", 10),
	SPACEPORT_COMMAND_AND_CONTROL_SYSTEM("Spaceport Command and Control System", 8),
	ORION_MULTIPURPOSE_CREW_VEHICLE("Orion Multi-Purpose Crew Vehicle", 11),
	SPACE_LAUNCH_SYSTEM("Space Launch System", 12), UNPAID_LEAVE("Unpaid Leave", 7),
	CRAWLER_TRANSPORTER("Crawler-Transporter", 2), MOBILE_LAUNCHER_PLATFORM("Mobile Launcher Platform", 3),
	LAUNCH_PAD("Launch Pad", 4), NEUTRAL_BUOYANCY_LABORATORY_TRAINING("Neutral Buoyancy Laboratory Training", 5),
	ORION_SPACECRAFT_SIMULATOR_TRAINING("Orion Spacecraft Simulator Training", 6), PAYROLL("Payroll", 1);

	/**
	 * String variable which will hold a String representation of a SquareName Enum.
	 */
	private String nameOfSquare;

	/**
	 * int variable which will hold the square position ID (position on the virtual
	 * game board) for each SquareName Enum.
	 */
	private int squarePositionID;

	/**
	 * Constructor with arguments for the SquareName Enum - Assigns a String
	 * variable to a SquareName Enum.
	 * 
	 * @param nameOfSquare
	 */
	private SquareName(String nameOfSquare, int squarePositionID) {
		this.nameOfSquare = nameOfSquare;
		this.squarePositionID = squarePositionID;
	}

	/**
	 * A method that returns the nameOfSquare of a SquareName Enum.
	 * 
	 * @return nameOfSquare
	 */
	public String getSquareName() {
		return nameOfSquare;
	}

	/**
	 * A method that returns the squarePositionID of a SquareName Enum.
	 * 
	 * @return squarePositionID
	 */
	public int getSquarePositionID() {
		return squarePositionID;
	}
}
