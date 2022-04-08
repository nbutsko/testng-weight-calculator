package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page.WeightCalculatorHomePage;

public class AbstractTest {

    static WebDriver driver;
    static WeightCalculatorHomePage weightCalculatorHomePage;

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        weightCalculatorHomePage = new WeightCalculatorHomePage(driver);
    }

    @AfterClass
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }


}
