/**
 * 
 */
package artemislitev9;

/**
 * This class represents a Dice or object that can be "rolled" or "thrown" to
 * achieve a random number in the ArtemisLite game.
 * 
 * Random numbers are generated between 1 and a specified upper limit
 * (numOfSides), inclusive.
 * 
 * @author Adam Vaughan
 * @author Megan Dallat
 * @author Lauren McCann
 * @author Claire McDermott
 */
public class Dice {

	/**
	 * int variable which will represent the number of sides of a Dice object, which
	 * will represent the upper limit of the random number that will be generated.
	 */
	private int numOfSides;

	/**
	 * Default constructor for Dice class - Takes no arguments.
	 */
	public Dice() {

	}

	/**
	 * Constructor with arguments for the Dice class - creates a Dice object with a
	 * specified number of sides defined by the numOfSides argument.
	 * 
	 * @param numOfSides - int that represents the number of sides of this Dice
	 *                   object.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  numOfSides is set to a value of less than 0.
	 */
	public Dice(int numOfSides) throws IllegalArgumentException {
		this.setNumOfSides(numOfSides);
	}

	/**
	 * A method that simulates the "roll" or "throw" of a Dice object and returns a
	 * random number.
	 * 
	 * @param numOfDice - int that represents the number of Dice that are being
	 *                  "rolled" or "thrown". Must be greater than 0.
	 * 
	 * @return - int that represents the random number achieved from "rolling" or
	 *         "throwing" the Dice.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if the
	 *                                  numOfDice is set to a value of 0 or less.
	 */
	public int roll(int numOfDice) throws IllegalArgumentException {

		/*
		 * int variable to store total score from "throwing" or "rolling" the Dice.
		 * Initially set to 0.
		 */
		int total = 0;

		/*
		 * If statement checks if numOfDice is greater than or equal to 1. If it is, it
		 * can proceed.
		 */
		if (numOfDice >= 1) {

			/*
			 * The value of numOfDice indicates how many Dice are being "thrown" or
			 * "rolled". After each iteration, a random number is generated and added to the
			 * total variable.
			 * 
			 */
			for (int loop = 0; loop < numOfDice; loop++) {
				total += (int) (Math.random() * numOfSides) + 1;
			}
		} else {

			/*
			 * IllegalArgumentException is thrown if this method is passed a number that is
			 * less than 1.
			 */
			throw new IllegalArgumentException("Invalid numOfDice provided. Must be greater than or equal to 1.");
		}

		/* returns the combined total of "throwing" or "rolling" the Dice. */
		return total;
	}

	/**
	 * A method that returns the number of sides of a Dice object.
	 * 
	 * @return the numOfSides
	 */
	public int getNumOfSides() {
		return numOfSides;
	}

	/**
	 * A method that sets the number of sides for a Dice object.
	 * 
	 * @param numOfSides - int that represents the number of sides of a Dice object.
	 *                   Must be greater than or equal to 1.
	 * 
	 * @throws IllegalArgumentException - IllegalArgumentException is thrown if
	 *                                  numOfSides is set to a value of 0 or less.
	 */
	public void setNumOfSides(int numOfSides) throws IllegalArgumentException {

		/*
		 * If statement checks if numOfSides is greater than or equal to 1. If it is,
		 * this.numOfSides can be set.
		 */
		if (numOfSides >= 1) {
			this.numOfSides = numOfSides;
		} else {

			/*
			 * IllegalArgumentException is thrown if this method is passed a number that is
			 * less than 1.
			 */
			throw new IllegalArgumentException("Invalid numOfSides provided. Must be greater than or equal to 1.");
		}
	}
}
