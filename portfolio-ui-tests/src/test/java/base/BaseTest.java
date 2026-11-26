package base;

import io.qameta.allure.Allure;
import io.qameta.allure.AttachmentOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ByteArrayInputStream;

public class BaseTest {

    private WebDriver driver;

    // Her test öncesinde tarayıcıyı ve web sitesini açar.
    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    // Başarısız testte ekran görüntüsü alır ve tarayıcıyı kapatır.
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE
                    && driver instanceof TakesScreenshot) {

                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                Allure.attachment(
                        "Hata anı ekran görüntüsü",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        AttachmentOptions.withFileExtension(".png")
                );
            }
        } catch (RuntimeException e) {
            System.err.println("Ekran görüntüsü alınamadı: " + e.getMessage());
        } finally {
            driver = null;
            Driver.closeDriver();
        }
    }
}