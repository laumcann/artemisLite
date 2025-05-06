/**
 * 
 */
package artemislitev5;

/**
 * This class represents the Unpaid Leave Square on the ArtemisLite virtual game
 * board. It is an extension of the Square class.
 * 
 * Players will not be able to conduct any purchases or developments when they
 * are on this Square.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class UnpaidLeave extends Square {

	/**
	 * Default constructor for UnpaidLeave class - Takes no arguments.
	 */
	public UnpaidLeave() {

	}

	/**
	 * Constructor with arguments for the UnpaidLeave class - Creates a UnpaidLeave
	 * object to be used as the seventh Square on the ArtemisLite virtual game
	 * board.
	 * 
	 * @param squareName        - Enum that represents the name of this UnpaidLeave
	 *                          object.
	 * @param squareDescription - String that represents a description of this
	 *                          UnpaidLeave object.
	 * @param squarePositionID  - int that represents the position on the virtual
	 *                          game board of this UnpaidLeave object.
	 */
	public UnpaidLeave(SquareName squareName, String squareDescription, int squarePositionID) {
		super(squareName, squareDescription, squarePositionID);
	}
}
