package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeightCalculatorHomePage extends AbstractPage {
    private final String URL = "https://svyatoslav.biz/testlab/wt/";

    private final String INPUT_NAME_XPATH = "//input[@name='name']";
    private final String INPUT_HEIGHT_XPATH = "//input[@name='height']";
    private final String INPUT_WEIGHT_XPATH = "//input[@name='weight']";
    private final String RADIOBUTTON_MALE_GENDER_XPATH = "//input[@name='gender'][1]";
    private final String RADIOBUTTON_FEMALE_GENDER_XPATH = "//input[@name='gender'][2]";
    private final String BUTTON_SUBMIT_XPATH = "//input[@value='Рассчитать']";

    private final String WEIGHT_MESSAGE_FIELD_XPATH = "//td[text()='menu']/following-sibling::td";
    private final String ERROR_INPUT_MESSAGE_FIELD_XPATH = "//td[text()='menu']/following-sibling::td//b";

    public static final String MESSAGE_OF_EXCESS_WEIGHT = "Значительный избыток массы тела, тучность";
    public static final String MESSAGE_OF_LACK_WEIGHT = "Слишком малая масса тела";
    public static final String MESSAGE_OF_SLIGHT_EXCESS_WEIGHT = "Незначительный избыток массы тела";

    public static final String ERROR_MESSAGE_OF_NAME_INPUT = "Не указано имя.";
    public static final String ERROR_MESSAGE_OF_HEIGHT_INPUT = "Рост должен быть в диапазоне 50-300 см.";
    public static final String ERROR_MESSAGE_OF_WEIGHT_INPUT = "Вес должен быть в диапазоне 3-500 кг.";
    public static final String ERROR_MESSAGE_OF_GENDER_SELECT = "Не указан пол.";

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
        super(driver);
    }

    public WeightCalculatorHomePage openPage() {
        driver.get(URL);
        return this;
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

    public WeightCalculatorHomePage fillFormAndSubmit(String name, String height, String weight, String gender) {
        typeName(name);
        typeHeight(height);
        typeWeight(weight);
        selectGender(gender);
        clickSubmitButton();
        return this;
    }

    public String getWeightMessageAfterSubmit() {
        return weightMessageAfterSubmit.getText();
    }

    public String getErrorInputMessageAfterSubmit() {
        return errorInputMessageAfterSubmit.getText();
    }

}
