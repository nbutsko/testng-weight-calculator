package test;

import org.testng.annotations.Test;
import page.WeightCalculatorHomePage;

import static org.testng.Assert.assertEquals;

public class WeightCalculatorTest extends AbstractTest {

    @Test(dataProvider = "heightWithValidValuesForExcessBodyWeight", dataProviderClass = DataProviderClass.class)
    public void testInputHeightWithValidValuesForExcessBodyWeight(String validHeight) {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", validHeight, "100", "М");
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_EXCESS_WEIGHT);
    }

    @Test
    public void testInputHeightWithValidValuesForLackBodyWeight() {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "300", "100", "М");
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_LACK_WEIGHT);
    }

    @Test(dataProvider = "heightWithInvalidValues", dataProviderClass = DataProviderClass.class)
    public void testInputHeightWithInvalidValues(String invalidHeight) {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", invalidHeight, "100", "М");
        assertEquals(weightCalculatorHomePage.getErrorInputMessageAfterSubmit(), WeightCalculatorHomePage.ERROR_MESSAGE_OF_HEIGHT_INPUT);
    }

    @Test
    public void testInputWeightWithValidValuesForLackBodyWeight() {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "150", "3", "М");
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_LACK_WEIGHT);
    }

    @Test
    public void testInputWeightWithValidValuesForSlightExcessBodyWeight() {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "150", "60", "М");
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_SLIGHT_EXCESS_WEIGHT);
    }

    @Test
    public void testInputWeightWithValidValuesForExcessBodyWeight() {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "150", "500", "М");
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_EXCESS_WEIGHT);
    }

    @Test(dataProvider = "weightWithInvalidValues", dataProviderClass = DataProviderClass.class)
    public void testInputWeightWithInvalidValues(String invalidWeight) {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "150", invalidWeight, "М");
        assertEquals(weightCalculatorHomePage.getErrorInputMessageAfterSubmit(), WeightCalculatorHomePage.ERROR_MESSAGE_OF_WEIGHT_INPUT);
    }

    @Test(dataProvider = "nameWithValidValues", dataProviderClass = DataProviderClass.class)
    public void testInputNameWithValidValues(String validName) {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit(validName, "150", "60", "М");
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_SLIGHT_EXCESS_WEIGHT);
    }

    @Test(dataProvider = "nameWithInvalidValues", dataProviderClass = DataProviderClass.class)
    public void testInputNameWithInvalidValues(String invalidName) {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit(invalidName, "150", "60", "М");
        assertEquals(weightCalculatorHomePage.getErrorInputMessageAfterSubmit(), WeightCalculatorHomePage.ERROR_MESSAGE_OF_NAME_INPUT);
    }

    @Test(dataProvider = "genderWithInvalidValues", dataProviderClass = DataProviderClass.class)
    public void testButtonGenderWithValidValues(String validGender) {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "150", "60", validGender);
        assertEquals(weightCalculatorHomePage.getWeightMessageAfterSubmit(), WeightCalculatorHomePage.MESSAGE_OF_SLIGHT_EXCESS_WEIGHT);
    }

    @Test
    public void testButtonGenderWithoutSelecting() {
        weightCalculatorHomePage.openPage()
                .fillFormAndSubmit("Name", "150", "500", "");
        assertEquals(weightCalculatorHomePage.getErrorInputMessageAfterSubmit(), WeightCalculatorHomePage.ERROR_MESSAGE_OF_GENDER_SELECT);
    }

}
