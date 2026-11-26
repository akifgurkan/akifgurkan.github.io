package utilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Driver {

    private static WebDriver driver;

    // Tarayıcıyı configuration ayarlarına göre başlatır.
    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigReader.getProperty("browser");
            boolean headless = Boolean.parseBoolean(
                    ConfigReader.getProperty("headless"));

            switch (browser.toLowerCase()) {

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) {
                        chromeOptions.addArguments("--headless");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("-headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (headless) {
                        edgeOptions.addArguments("--headless");
                    }
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Desteklenmeyen tarayıcı: " + browser);
            }

            // Tarayıcı pencere boyutunu ayarlar.
            driver.manage().window().setSize(
                    new Dimension(1440, 900));

            // Test ortamı bilgilerini kaydeder.
            writeEnvironment(headless);
        }

        return driver;
    }

    // Tarayıcıyı kapatır ve Driver nesnesini temizler.
    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Test ortamı bilgilerini Allure raporu için kaydeder.
    private static void writeEnvironment(boolean headless) {

        Capabilities capabilities =
                ((HasCapabilities) driver).getCapabilities();

        Properties environment = new Properties();

        environment.setProperty("Browser",
                capabilities.getBrowserName());

        environment.setProperty("Browser Version",
                capabilities.getBrowserVersion());

        environment.setProperty("Java Version",
                System.getProperty("java.version"));

        environment.setProperty("Operating System",
                System.getProperty("os.name"));

        environment.setProperty("Base URL",
                ConfigReader.getProperty("baseUrl"));

        environment.setProperty("Headless",
                String.valueOf(headless));

        Path directory = Path.of("target", "allure-results");

        try {
            Files.createDirectories(directory);

            try (var output = Files.newOutputStream(
                    directory.resolve("environment.properties"))) {

                environment.store(output, null);
            }

        } catch (IOException e) {
            System.err.println(
                    "Ortam bilgileri kaydedilemedi: " + e.getMessage());
        }
    }

    private Driver() {
    }
}