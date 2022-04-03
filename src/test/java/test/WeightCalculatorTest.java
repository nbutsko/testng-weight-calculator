package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.WeightCalculatorHomePage;

public class WeightCalculatorTest {
    private final String URL = "https://svyatoslav.biz/testlab/wt/";

    private static WebDriver driver;

    @BeforeAll
    public static void browserSetup() {
        driver = new ChromeDriver();
    }

    @ParameterizedTest
    @ValueSource(strings = {"50", "300", "150"})
    public void testInputHeightWithValidValues(String validHeight) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String actualMessage = weightCalculatorHomePage.typeName("Name")
                .typeHeight(validHeight)
                .typeWeight("100")
                .selectGender("М")
                .clickSubmitButton()
                .getWeightMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains("масс"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"49", "301", "0", "-10", "1000000", "a", "A", "-", "a*1A"})
    public void testInputHeightWithInvalidValues(String invalidHeight) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String expectedMessage = "Рост должен быть в диапазоне 50-300 см.";
        String actualMessage = weightCalculatorHomePage.typeName("Name")
                .typeHeight(invalidHeight)
                .typeWeight("100")
                .selectGender("М")
                .clickSubmitButton()
                .getErrorInputMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "500", "60"})
    public void testInputWeightWithValidValues(String validWeight) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String actualMessage = weightCalculatorHomePage.typeName("Name")
                .typeHeight("150")
                .typeWeight(validWeight)
                .selectGender("М")
                .clickSubmitButton()
                .getWeightMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains("масс"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "501", "0", "-10", "1000000", "a", "A", "-", "a*1A"})
    public void testInputWeightWithInvalidValues(String invalidWeight) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String expectedMessage = "Вес должен быть в диапазоне 3-500 кг.";
        String actualMessage = weightCalculatorHomePage.typeName("Name")
                .typeHeight("150")
                .typeWeight(invalidWeight)
                .selectGender("М")
                .clickSubmitButton()
                .getErrorInputMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Name", "A"})
    public void testInputNameWithValidValues(String validName) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String actualMessage = weightCalculatorHomePage.typeName(validName)
                .typeHeight("150")
                .typeWeight("60")
                .selectGender("М")
                .clickSubmitButton()
                .getWeightMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains("масс"));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "0"})
    public void testInputNameWithInvalidValues(String invalidName) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String expectedMessage = "Не указано имя.";
        String actualMessage = weightCalculatorHomePage.typeName(invalidName)
                .typeHeight("150")
                .typeWeight("60")
                .selectGender("М")
                .clickSubmitButton()
                .getErrorInputMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @EmptySource
    public void testInputNameWithEmptySource(String emptyName) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String expectedMessage = "Не указано имя.";
        String actualMessage = weightCalculatorHomePage.typeName(emptyName)
                .typeHeight("150")
                .typeWeight("60")
                .selectGender("М")
                .clickSubmitButton()
                .getErrorInputMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @ValueSource(strings = {"М", "Ж"})
    public void testButtonGenderWithValidValues(String validGender) {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String actualMessage = weightCalculatorHomePage.typeName("Name")
                .typeHeight("150")
                .typeWeight("60")
                .selectGender(validGender)
                .clickSubmitButton()
                .getWeightMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains("масс"));
    }

    @Test
    public void testButtonGenderWithoutSelecting() {
        driver.get(URL);
        WeightCalculatorHomePage weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
        String expectedMessage = "Не указан пол.";
        String actualMessage = weightCalculatorHomePage.typeName("Name")
                .typeHeight("150")
                .typeWeight("60")
                .clickSubmitButton()
                .getErrorInputMessageAfterSubmit();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterAll
    public static void browserTearDown() {
        driver.quit();
        driver = null;
    }


}
