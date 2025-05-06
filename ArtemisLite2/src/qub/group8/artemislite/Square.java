/**
 * 
 */
package qub.group8.artemislite;

/**
 * This abstract class represents the basics of Square objects that will exist
 * in the ArtemisLite virtual game board.
 * 
 * This class will act as a superclass for the detailed implementations of
 * Element, Payroll and UnpaidLeave objects in the virtual game board.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public abstract class Square {

	/**
	 * Enum variable which will hold the name of a Square object
	 */
	private SquareName squareName;

	/**
	 * String variable which will hold a description of a Square object
	 */
	private String squareDescription;

	/**
	 * Constructor with arguments for the Square class.
	 * 
	 * @param squareName        - Enum that represents the name of this Square
	 *                          object.
	 * @param squareDescription - String that represents a description of this
	 *                          Square object.
	 * @param squarePositionID  - int that represents the position on the virtual
	 *                          game board of this Square object.
	 */
	public Square(SquareName squareName, String squareDescription) {
		this.squareName = squareName;
		this.squareDescription = squareDescription;
	}

	/**
	 * A method that returns the squareName of a Square object.
	 * 
	 * The getSquareName method of the provided squareName Enum is called to return
	 * a String value representing the name of the Square.
	 * 
	 * @return the squareName
	 */
	public String getSquareName() {
		return squareName.getSquareName();
	}

	/**
	 * A method that returns the squareDescription of a Square object.
	 * 
	 * @return the squareDescription
	 */
	public String getSquareDescription() {
		return squareDescription;
	}

	/**
	 * A method that returns the squarePositionID (i.e. Square number on the virtual
	 * game board) of a Square object.
	 * 
	 * @return the squarePositionID
	 */
	public int getSquarePositionID() {
		return squareName.getSquarePositionID();
	}

	/**
	 * A method that will display the details of a Square object
	 */
	public void displaySquareDetails() {
		System.out.println("\n\n|*****| Square Details |*****|\n");
		System.out.println("Square Name: " + this.getSquareName());
		System.out.println("Square ID: " + this.getSquarePositionID());
		System.out.println("Square Description: " + this.getSquareDescription());
	}
}