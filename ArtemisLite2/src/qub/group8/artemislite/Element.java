/**
 * 
 */
package qub.group8.artemislite;

/**
 * This class represents the Elements that will exist in the ArtemisLite virtual
 * game board. It is an extension of the Square class and contains all the
 * attributes and methods relating to an Element.
 * 
 * A Player can purchase or develop an Element and can charge other Players tax
 * for landing on an Element that they own.
 * 
 * This class uses the Enum SystemType to define its systemType attribute.
 * 
 * A Player can purchase 1 or more Elements that are not occupied as they
 * progress through the virtual game board.
 * 
 * This class implements the Comparable interface, which is used to compare
 * Element objects based on their systemType.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class Element extends Square implements Comparable<Element> {

	/**
	 * Enum variable which will hold the System type of an Element object.
	 */
	private SystemType systemType;

	/**
	 * boolean variable which will be used to assess if an Element object is owned
	 * by a Player.
	 */
	private boolean elementOwned;

	/**
	 * String variable which will hold the name of the Player that owns the Element
	 * object.
	 */
	private String elementOwner;

	/**
	 * int variable which will hold the purchase cost of an Element object.
	 * 
	 * Must be a value greater than or equal to 0.
	 */
	private int purchaseCost;

	/**
	 * int variable which will hold the current development level of an Element
	 * object.
	 * 
	 * Must be a value greater than or equal to 0 and less than or equal to 3.
	 */
	private int developmentLevel;

	/**
	 * int variable which will hold the development cost of an Element object.
	 * 
	 * Must be a value greater than or equal to 0.
	 */
	private int developmentCost;

	/**
	 * String variable which will hold the message that is display when an Element
	 * is developed to Level 1 status.
	 */
	private String developmentLevel1Message;

	/**
	 * String variable which will hold the message that is display when an Element
	 * is developed to Level 2 status.
	 */
	private String developmentLevel2Message;

	/**
	 * String variable which will hold the message that is display when an Element
	 * is developed to Level 3 status.
	 */
	private String developmentLevel3Message;

	/**
	 * Constructor with arguments for the Element class - Creates Element Objects to
	 * be used as Squares on the ArtemisLite virtual game board.
	 * 
	 * @param squareName               - Enum that represents the name of this
	 *                                 Element object.
	 * @param squareDescription        - String that represents a description of
	 *                                 this Element object.
	 * @param systemType               - Enum that represents the System type of
	 *                                 this Element object.
	 * @param elementOwner             - String that represents the name of the
	 *                                 Player that owns this Element.
	 * @param purchaseCost             - int that represents the purchase cost of
	 *                                 this Element.
	 * @param developmentCost          - int that represents the development costs
	 *                                 of this Element.
	 * @param developmentLevel1Message - String that represents a message that is
	 *                                 displayed when this Element is developed to
	 *                                 Level 1 status.
	 * @param developmentLevel2Message - String that represents a message that is
	 *                                 displayed when this Element is developed to
	 *                                 Level 2 status.
	 * @param developmentLevel3Message - String that represents a message that is
	 *                                 displayed when this Element is developed to
	 *                                 Level 3 status.
	 * @throws IllegalArgumentException - IllegalArgumentException thrown if
	 *                                  purchaseCost, taxCost or developmentCost
	 *                                  attributes are set to a value less than 0,
	 *                                  or if the developmentLevel is set to a value
	 *                                  less than 0 or greater than 3.
	 */
	public Element(SquareName squareName, String squareDescription, SystemType systemType, String elementOwner,
			int purchaseCost, int developmentCost, String developmentLevel1Message, String developmentLevel2Message,
			String developmentLevel3Message) throws IllegalArgumentException {

		super(squareName, squareDescription);
		this.systemType = systemType;
		this.elementOwned = false;
		this.setElementOwner(elementOwner);
		this.setDevelopmentCost(developmentCost);
		this.setDevelopmentLevel(0);
		this.setPurchaseCost(purchaseCost);
		this.developmentLevel1Message = developmentLevel1Message;
		this.developmentLevel2Message = developmentLevel2Message;
		this.developmentLevel3Message = developmentLevel3Message;
	}

	/**
	 * A method that returns the systemType of an Element object.
	 * 
	 * @return The getSystemName method of the provided systemType Enum is called to
	 *         return a String value representing the name of the System.
	 */
	public String getSystemType() {
		return systemType.getSystemName();
	}

	/**
	 * A method that returns the elementOwned status of an Element object.
	 * 
	 * @return elementOwned
	 */
	public boolean isElementOwned() {
		return elementOwned;
	}

	/**
	 * A method that sets the elementOwned status of an Element object.
	 * 
	 * @param elementOwned - elementOwned to set
	 */
	public void setElementOwned(boolean elementOwned) {
		this.elementOwned = elementOwned;
	}

	/**
	 * A method that returns the elementOwner of an Element object.
	 * 
	 * @return the elementOwner;
	 */
	public String getElementOwner() {
		return elementOwner;
	}

	/**
	 * A method that sets the elementOwner of an Element object. If elementOwner is
	 * set as null or an empty String, elementOwner gets set as Unoccupied
	 * 
	 * @param elementOwner - the elementOwner to set
	 */
	public void setElementOwner(String elementOwner) {
		if (elementOwner == null || elementOwner == "") {
			this.elementOwner = "Unoccupied";
		} else {
			this.elementOwner = elementOwner;
		}
	}

	/**
	 * A method that returns the purchaseCost of an Element object.
	 * 
	 * @return the purchaseCost
	 */
	public int getPurchaseCost() {
		return purchaseCost;
	}

	/**
	 * A method that sets the purchaseCost of an Element object.
	 * 
	 * @param purchaseCost - must be greater than or equal to 0.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  purchaseCost is set to a value of less than
	 *                                  0.
	 */
	public void setPurchaseCost(int purchaseCost) throws IllegalArgumentException {
		if (purchaseCost >= 0) {
			this.purchaseCost = purchaseCost;
		} else {
			throw new IllegalArgumentException("Invalid purchaseCost provided. Must be 0 or greater.");
		}
	}

	/**
	 * A method that returns the developmentLevel of an Element object.
	 * 
	 * @return the developmentLevel
	 */
	public int getDevelopmentLevel() {
		return developmentLevel;
	}

	/**
	 * A method that sets the developmentLevel of an Element object.
	 * 
	 * @param developmentLevel - must be between 0 and 3 inclusive.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  developmentLevel is set as less than 0 or
	 *                                  greater than 3.
	 */
	public void setDevelopmentLevel(int developmentLevel) throws IllegalArgumentException {
		if (developmentLevel >= 0 && developmentLevel <= 3) {
			this.developmentLevel = developmentLevel;
		} else {
			throw new IllegalArgumentException(
					"Invalid developmentLevel provided. Must be 0 or greater and less than or equal to 3.");
		}
	}

	/**
	 * A method that returns the developmentCost of an Element object.
	 * 
	 * @return the developmentCost
	 */
	public int getDevelopmentCost() {
		return developmentCost;
	}

	/**
	 * A method that sets the developmentCost of an Element object.
	 * 
	 * @param developmentCost - must be greater than or equal to 0.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  developmentCost is set to a value of less
	 *                                  than 0.
	 */
	public void setDevelopmentCost(int developmentCost) throws IllegalArgumentException {
		if (developmentCost >= 0) {
			this.developmentCost = developmentCost;
		} else {
			throw new IllegalArgumentException("Invalid developmentCost provided. Must be 0 or greater.");
		}
	}

	/**
	 * A method that returns the developmentLevel1Message of an Element object.
	 * 
	 * @return the developmentLevel1Message
	 */
	public String getDevelopmentLevel1Message() {
		return developmentLevel1Message;
	}

	/**
	 * A method that returns the developmentLevel2Message of an Element object.
	 * 
	 * @return the developmentLevel2Message
	 */
	public String getDevelopmentLevel2Message() {
		return developmentLevel2Message;
	}

	/**
	 * A method that returns the developmentLevel3Message of an Element object.
	 * 
	 * @return the developmentLevel3Message
	 */
	public String getDevelopmentLevel3Message() {
		return developmentLevel3Message;
	}

	/**
	 * A method that returns the tax cost of an Element object.
	 * 
	 * @return the amount if tax
	 */
	public int getTaxCost() {

		/*
		 * Calculating the amount of tax that will be charged (10% of purchase cost +
		 * completed development costs of Element). If the purchase cost is 0, 0 is
		 * returned.
		 */
		if (this.getDevelopmentLevel() == 0 && this.getPurchaseCost() != 0) {
			return this.getPurchaseCost() / 10;
		} else if (this.getDevelopmentLevel() == 1 && this.getPurchaseCost() != 0) {
			return (this.getPurchaseCost() + this.getDevelopmentCost()) / 10;
		} else if (this.getDevelopmentLevel() == 2 && this.getPurchaseCost() != 0) {
			return (this.getPurchaseCost() + (this.getDevelopmentCost() * 2)) / 10;
		} else if (this.getDevelopmentLevel() == 3 && this.getPurchaseCost() != 0) {
			return (this.getPurchaseCost() + (this.getDevelopmentCost() * 3)) / 10;
		} else {
			return 0;
		}
	}

	/**
	 * A method that will display the details of an Element object. Overrides
	 * displaySquareDetails method of superclass and also calls the superclass's
	 * displaySquareDetails method.
	 */
	@Override
	public void displaySquareDetails() {
		super.displaySquareDetails();
		System.out.println("System: " + this.getSystemType());
		System.out.println("Element Owner: " + this.getElementOwner());
		System.out.println("Purchase Cost: " + this.getPurchaseCost() + " Commitment Coins");
	}

	/**
	 * Method that will display the development details of an Element object. Calls
	 * the superclass's displaySquareDetails method. Will be displayed instead of
	 * the displaySquareDetails whenever a player lands on an Element they already
	 * own.
	 */
	public void displayDevelopmentDetails() {
		super.displaySquareDetails();
		System.out.println("System: " + this.getSystemType());
		System.out.println("Element Owner: " + this.getElementOwner());
		System.out.println("Development Level: " + this.getDevelopmentLevel());
		System.out.println("Development Cost: " + this.getDevelopmentCost());
	}

	/**
	 * A method that will compare the systemType of Element objects.
	 * 
	 * This method will be called when the displayElementsOwned of the Player class
	 * is called.
	 */
	@Override
	public int compareTo(Element otherElement) {
		return this.getSystemType().compareTo(otherElement.getSystemType());
	}
}
