/**
 * 
 */
package qub.group8.artemislite;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Adam Vaughan Megan Dallat Lauren McCann Claire McDermott
 *
 */
class ElementTest {

	/* Arranging test variables. */
	Element element;
	SquareName squareName;
	String squareDescription, elementOwner, developmentLevel1Message, developmentLevel2Message,
			developmentLevel3Message;
	SystemType systemType1, systemType2, systemType3;
	boolean isOwned;
	int purchaseCostValidLow, purchaseCostValidHigh, purchaseCostInvalid, developmentLevelValidLow,
			developmentLevelValidMid, developmentLevelValidHigh, developmentLevelInvalidLow,
			developmentLevelInvalidHigh, developmentCostValidLow, developmentCostValidHigh, developmentCostInvalid;

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUpBeforeClass() throws Exception {

		squareName = SquareName.CRAWLER_TRANSPORTER;
		squareDescription = "Test Description";
		elementOwner = "Test Owner";
		systemType1 = SystemType.SPACECRAFT;
		systemType2 = SystemType.COMMAND_AND_CONTROL;
		systemType3 = SystemType.COMMAND_AND_CONTROL;
		isOwned = true;
		purchaseCostValidLow = 0;
		purchaseCostValidHigh = 300;
		purchaseCostInvalid = -100;
		developmentLevelValidLow = 1;
		developmentLevelValidMid = 2;
		developmentLevelValidHigh = 3;
		developmentLevelInvalidLow = -1;
		developmentLevelInvalidHigh = 4;
		developmentCostValidLow = 0;
		developmentCostValidHigh = 100;
		developmentCostInvalid = -50;
		developmentLevel1Message = "Developed Level 1";
		developmentLevel2Message = "Developed Level 2";
		developmentLevel3Message = "Developed Level 3";

		element = new Element(squareName, squareDescription, systemType1, elementOwner, purchaseCostValidHigh,
				developmentCostValidHigh, developmentLevel1Message, developmentLevel2Message, developmentLevel3Message);
	}

	/**
	 * Testing the constructor of the Element class with valid values.
	 */
	@Test
	void testConstructorArgsValid() {

		assertEquals(squareName.getSquareName(), element.getSquareName());
		assertEquals(squareDescription, element.getSquareDescription());
		assertEquals(systemType1.getSystemName(), element.getSystemType());
		assertEquals(elementOwner, element.getElementOwner());
		assertEquals(purchaseCostValidHigh, element.getPurchaseCost());
		assertEquals(developmentCostValidHigh, element.getDevelopmentCost());
		assertEquals(developmentLevel1Message, element.getDevelopmentLevel1Message());
		assertEquals(developmentLevel2Message, element.getDevelopmentLevel2Message());
		assertEquals(developmentLevel3Message, element.getDevelopmentLevel3Message());
	}

	/**
	 * Testing the constructor of the Element class with invalid values.
	 */
	@Test
	void testConstructorArgsInvalid() {

		IllegalArgumentException exceptionPurchaseCost = assertThrows(IllegalArgumentException.class, () -> {
			element = new Element(squareName, squareDescription, systemType1, elementOwner, purchaseCostInvalid,
					developmentCostValidHigh, developmentLevel1Message, developmentLevel2Message,
					developmentLevel3Message);
		});

		assertEquals("Invalid purchaseCost provided. Must be 0 or greater.", exceptionPurchaseCost.getMessage());

		IllegalArgumentException exceptionDevelopmentCost = assertThrows(IllegalArgumentException.class, () -> {
			element = new Element(squareName, squareDescription, systemType1, elementOwner, purchaseCostValidHigh,
					developmentCostInvalid, developmentLevel1Message, developmentLevel2Message,
					developmentLevel3Message);
		});

		assertEquals("Invalid developmentCost provided. Must be 0 or greater.", exceptionDevelopmentCost.getMessage());
	}

	/**
	 * Testing the getSquareName method of the Element class.
	 */
	@Test
	void testGetSquareName() {

		assertEquals(squareName.getSquareName(), element.getSquareName());
	}

	/**
	 * Testing the getSquareDescription method of the Element class.
	 */
	@Test
	void testGetSquareDescription() {

		assertEquals(squareDescription, element.getSquareDescription());
	}

	/**
	 * Testing the getSystemType method of the Element class.
	 */
	@Test
	void testGetSystemType() {

		assertEquals(systemType1.getSystemName(), element.getSystemType());
	}

	/**
	 * Testing the isElementOwned method of the Element class.
	 */
	@Test
	void testIsElementOwned() {

		assertEquals(false, element.isElementOwned());
	}

	/**
	 * Testing the setElementOwned method of the Element class.
	 */
	@Test
	void testSetElementOwned() {

		element.setElementOwned(isOwned);
		assertEquals(isOwned, element.isElementOwned());
	}

	/**
	 * Testing the get and setElementOwner methods of the Element class.
	 */
	@Test
	void testGetSetElementOwner() {

		element.setElementOwner(elementOwner);
		assertEquals(elementOwner, element.getElementOwner());

		element.setElementOwner(null);
		assertEquals("Unoccupied", element.getElementOwner());

		element.setElementOwner("");
		assertEquals("Unoccupied", element.getElementOwner());
	}

	/**
	 * Testing the get and setDevelopmentCost methods of the Element class with valid values.
	 */
	@Test
	void testGetSetDevelopmentCostValid() {

		element.setDevelopmentCost(developmentCostValidLow);
		assertEquals(developmentCostValidLow, element.getDevelopmentCost());

		element.setDevelopmentCost(developmentCostValidHigh);
		assertEquals(developmentCostValidHigh, element.getDevelopmentCost());
	}

	/**
	 * Testing the get and setDevelopmentCost methods of the Element class with invalid values.
	 */
	@Test
	void testGetSetDevelopmentCostInvalid() {

		IllegalArgumentException exceptionDevelopmentCost = assertThrows(IllegalArgumentException.class, () -> {
			element.setDevelopmentCost(developmentCostInvalid);
		});

		assertEquals("Invalid developmentCost provided. Must be 0 or greater.", exceptionDevelopmentCost.getMessage());
	}

	/**
	 * Testing the get and setDevelopmentLevel methods of the Element class with valid values.
	 */
	@Test
	void testGetSetDevelopmentLevelValid() {

		/* Tests that development level is automatically set to 0. */
		assertEquals(0, element.getDevelopmentLevel());

		element.setDevelopmentLevel(developmentLevelValidLow);
		assertEquals(developmentLevelValidLow, element.getDevelopmentLevel());

		element.setDevelopmentLevel(developmentLevelValidMid);
		assertEquals(developmentLevelValidMid, element.getDevelopmentLevel());

		element.setDevelopmentLevel(developmentLevelValidHigh);
		assertEquals(developmentLevelValidHigh, element.getDevelopmentLevel());
	}

	/**
	 * Testing the get and setDevelopmentLevel methods of the Element class with invalid values.
	 */
	@Test
	void testGetSetDevelopmentLevelInvalid() {

		IllegalArgumentException exceptionDevelopmentLevelLow = assertThrows(IllegalArgumentException.class, () -> {
			element.setDevelopmentLevel(developmentLevelInvalidLow);
		});

		assertEquals("Invalid developmentLevel provided. Must be 0 or greater and less than or equal to 3.",
				exceptionDevelopmentLevelLow.getMessage());

		IllegalArgumentException exceptionDevelopmentLevelHigh = assertThrows(IllegalArgumentException.class, () -> {
			element.setDevelopmentLevel(developmentLevelInvalidHigh);
		});

		assertEquals("Invalid developmentLevel provided. Must be 0 or greater and less than or equal to 3.",
				exceptionDevelopmentLevelHigh.getMessage());
	}

	/**
	 * Testing the get and setPurchaseCost methods of the Element class with valid values.
	 */
	@Test
	void testGetSetPurchaseCostValid() {

		element.setPurchaseCost(purchaseCostValidLow);
		assertEquals(purchaseCostValidLow, element.getPurchaseCost());

		element.setPurchaseCost(purchaseCostValidHigh);
		assertEquals(purchaseCostValidHigh, element.getPurchaseCost());
	}

	/**
	 * Testing the get and setPurchaseCost methods of the Element class with invalid values.
	 */
	@Test
	void testGetSetPurchaseCostInValid() {

		IllegalArgumentException exceptionPurchaseCost = assertThrows(IllegalArgumentException.class, () -> {
			element.setPurchaseCost(purchaseCostInvalid);
		});

		assertEquals("Invalid purchaseCost provided. Must be 0 or greater.", exceptionPurchaseCost.getMessage());
	}

	/**
	 * Testing the getDevelopmentLevel methods of the Element class.
	 */
	@Test
	void testGetDevelopmentLevelMessage() {

		assertEquals(developmentLevel1Message, element.getDevelopmentLevel1Message());
		assertEquals(developmentLevel2Message, element.getDevelopmentLevel2Message());
		assertEquals(developmentLevel3Message, element.getDevelopmentLevel3Message());
	}

	/**
	 * Testing the getSquarePositionID method of the Element class.
	 */
	@Test
	void testGetSquarePositionID() {

		assertEquals(squareName.getSquarePositionID(), element.getSquarePositionID());
	}

	/**
	 * Testing the compareTo method of the Element class.
	 */
	@Test
	void testCompareTo() {

		Element element1 = new Element(squareName, squareDescription, systemType1, elementOwner, purchaseCostValidHigh,
				developmentCostValidHigh, developmentLevel1Message, developmentLevel2Message, developmentLevel3Message);
		Element element2 = new Element(squareName, squareDescription, systemType2, elementOwner, purchaseCostValidHigh,
				developmentCostValidHigh, developmentLevel1Message, developmentLevel2Message, developmentLevel3Message);
		Element element3 = new Element(squareName, squareDescription, systemType3, elementOwner, purchaseCostValidHigh,
				developmentCostValidHigh, developmentLevel1Message, developmentLevel2Message, developmentLevel3Message);

		int greater = element1.compareTo(element2);
		assertTrue(greater > 0);

		int lesser = element2.compareTo(element1);
		assertTrue(lesser < 0);

		int equal = element2.compareTo(element3);
		assertTrue(equal == 0);
	}
}
