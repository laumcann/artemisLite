/**
 * 
 */
package qub.group8.artemislite;

/**
 * This class represents the Payroll Square on the ArtemisLite virtual game
 * board. It is an extension of the Square class and contains all the attributes
 * and methods relating to a Payroll object.
 * 
 * Players will collect additional funds whenever they pass this Square or land
 * on it.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class Payroll extends Square {

	/**
	 * int variable which will hold the yearly bonus amount of a Payroll object.
	 * 
	 * Must be a value greater than or equal to 0.
	 */
	int yearlyBonus;

	/**
	 * Constructor with arguments for the Payroll class - Creates a Payroll object
	 * to be used as the first Square on the ArtemisLite virtual game board.
	 * 
	 * @param squareName        - Enum that represents the name of this Payroll
	 *                          object.
	 * @param squareDescription - String that represents a description of this
	 *                          Payroll object.
	 * @param squarePositionID  - int that represents the position on the virtual
	 *                          game board of this Payroll object.
	 * @param yearlyBonus       - int that represents the yearlyBonus amount of this
	 *                          Payroll object.
	 */
	public Payroll(SquareName squareName, String squareDescription, int yearlyBonus) throws IllegalArgumentException {
		super(squareName, squareDescription);
		this.setYearlyBonus(yearlyBonus);
	}

	/**
	 * A method that returns the yearlyBonus of a Payroll object.
	 * 
	 * @return the yearlyBonus
	 */
	public int getYearlyBonus() {
		return yearlyBonus;
	}

	/**
	 * Sets the value of the yearlyBonus which is collected with each pass of the
	 * Payroll Square on the virtual game board.
	 * 
	 * @param yearlyBonus - must be greater than or equal to 0.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  yearlyBonus is set to a value of less than
	 *                                  0.
	 */
	public void setYearlyBonus(int yearlyBonus) throws IllegalArgumentException {
		if (yearlyBonus >= 0) {
			this.yearlyBonus = yearlyBonus;
		} else {
			throw new IllegalArgumentException("Invalid yearlyBonus provided. Must be 0 or greater.");
		}
	}
}
