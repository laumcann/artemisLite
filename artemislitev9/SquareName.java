/**
 * 
 */
package artemislitev9;

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
	MISSION_CONTROL_CENTRE("Mission Control Center"),
	SPACE_COMMUNICATIONS_AND_NAVIGATION("Space Communications and Navigation"),
	SPACEPORT_COMMAND_AND_CONTROL_SYSTEM("Spaceport Command and Control System"),
	ORION_MULTIPURPOSE_CREW_VEHICLE("Orion Multi-Purpose Crew Vehicle"), SPACE_LAUNCH_SYSTEM("Space Launch System"),
	UNPAID_LEAVE("Unpaid Leave"), CRAWLER_TRANSPORTER("Crawler-Transporter"),
	MOBILE_LAUNCHER_PLATFORM("Mobile Launcher Platform"), LAUNCH_PAD("Launch Pad"),
	NEUTRAL_BUOYANCY_LABORATORY_TRAINING("Neutral Buoyancy Laboratory Training"),
	ORION_SPACECRAFT_SIMULATOR_TRAINING("Orion Spacecraft Simulator Training"), PAYROLL("Payroll");

	/**
	 * String variable which will hold a String representation of a SquareName Enum.
	 */
	private String nameOfSquare;

	/**
	 * Constructor with arguments for the SquareName Enum - Assigns a String
	 * variable to a SquareName Enum.
	 * 
	 * @param nameOfSquare
	 */
	private SquareName(String nameOfSquare) {
		this.nameOfSquare = nameOfSquare;
	}

	/**
	 * A method that returns the nameOfSquare of a SquareName Enum.
	 * 
	 * @return nameOfSquare
	 */
	public String getSquareName() {
		return nameOfSquare;
	}
}
