package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeightCalculatorHomePage {
    private static final String INPUT_NAME_XPATH = "//input[@name='name']";
    private static final String INPUT_HEIGHT_XPATH = "//input[@name='height']";
    private static final String INPUT_WEIGHT_XPATH = "//input[@name='weight']";
    private static final String RADIOBUTTON_MALE_GENDER_XPATH = "//input[@name='gender'][1]";
    private static final String RADIOBUTTON_FEMALE_GENDER_XPATH = "//input[@name='gender'][2]";
    private static final String BUTTON_SUBMIT_XPATH = "//input[@value='Рассчитать']";

    private static final String WEIGHT_MESSAGE_FIELD_XPATH = "//td[text()='menu']/following-sibling::td";
    private static final String ERROR_INPUT_MESSAGE_FIELD_XPATH = "//td[text()='menu']/following-sibling::td//b";

    private WebDriver driver;

    @FindBy(xpath = INPUT_NAME_XPATH)
    WebElement inputName;

    @FindBy(xpath = INPUT_HEIGHT_XPATH)
    WebElement inputHeight;

    @FindBy(xpath = INPUT_WEIGHT_XPATH)
    WebElement inputWeight;

    @FindBy(xpath = RADIOBUTTON_MALE_GENDER_XPATH)
    WebElement radiobuttonMaleGender;

    @FindBy(xpath = RADIOBUTTON_FEMALE_GENDER_XPATH)
    WebElement radiobuttonFemaleGender;

    @FindBy(xpath = BUTTON_SUBMIT_XPATH)
    WebElement buttonSubmit;

    @FindBy(xpath = WEIGHT_MESSAGE_FIELD_XPATH)
    WebElement weightMessageAfterSubmit;

    @FindBy(xpath = ERROR_INPUT_MESSAGE_FIELD_XPATH)
    WebElement errorInputMessageAfterSubmit;

    public WeightCalculatorHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WeightCalculatorHomePage typeName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public WeightCalculatorHomePage typeHeight(String height) {
        inputHeight.sendKeys(height);
        return this;
    }

    public WeightCalculatorHomePage typeWeight(String weight) {
        inputWeight.sendKeys(weight);
        return this;
    }

    public WeightCalculatorHomePage selectGender(String gender) {
        if (gender.equals("М")) {
            radiobuttonMaleGender.click();
        } else if (gender.equals("Ж")) {
            radiobuttonFemaleGender.click();
        }
        return this;
    }

    public WeightCalculatorHomePage clickSubmitButton() {
        buttonSubmit.click();
        return this;
    }

    public String getWeightMessageAfterSubmit() {
        return weightMessageAfterSubmit.getText();
    }

    public String getErrorInputMessageAfterSubmit() {
        return errorInputMessageAfterSubmit.getText();
    }

}
