package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PortfolioPage;

public class PortfolioSmokeTest extends BaseTest {

    @Feature("Sayfa Açılışı")
    @Description("Sayfa başlığı ve profil ismi doğrulanır.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "Portföy sayfasının açılması")
    public void portfolioPageShouldOpen() {

        PortfolioPage portfolioPage = new PortfolioPage();

        Allure.step("Sayfa başlığını doğrula", () -> {
            Assert.assertEquals(
                    portfolioPage.getPageTitle(),
                    "Akif Gürkan | QA Engineer Portfolio",
                    "Sayfa başlığı hatalı!"
            );
        });

        Allure.step("Profil ismini doğrula", () -> {
            Assert.assertEquals(
                    portfolioPage.getProfileName(),
                    "Akif Gürkan",
                    "Profil ismi hatalı!"
            );
        });
    }

    @Feature("Profil")
    @Description("Profil fotoğrafının görünürlüğü ve yüklenmesi doğrulanır.")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Profil fotoğrafının kontrolü")
    public void profileImageShouldBeDisplayed() {

        PortfolioPage portfolioPage = new PortfolioPage();

        Allure.step("Profil fotoğrafının görünürlüğünü doğrula", () -> {
            Assert.assertTrue(
                    portfolioPage.isProfileImageDisplayed(),
                    "Profil fotoğrafı görünmüyor!"
            );
        });

        Allure.step("Profil fotoğrafının yüklendiğini doğrula", () -> {
            Assert.assertTrue(
                    portfolioPage.isProfileImageLoaded(),
                    "Profil fotoğrafı yüklenemedi!"
            );
        });
    }

    @Feature("Dil Seçimi")
    @Description("Türkçe ve İngilizce dil geçişleri doğrulanır.")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Dil değiştirme kontrolü")
    public void languageShouldChange() {

        PortfolioPage portfolioPage = new PortfolioPage();

        Allure.step("İngilizce dilini seç ve doğrula", () -> {
            portfolioPage.switchToEnglish();

            Assert.assertEquals(
                    portfolioPage.waitForAboutMenuText("About"),
                    "About",
                    "English menu text is incorrect!"
            );
        });

        Allure.step("Türkçe dilini seç ve doğrula", () -> {
            portfolioPage.switchToTurkish();

            Assert.assertEquals(
                    portfolioPage.waitForAboutMenuText("Hakkımda"),
                    "Hakkımda",
                    "Turkish menu text is incorrect!"
            );
        });

        Allure.step("İngilizce diline geri dön ve doğrula", () -> {
            portfolioPage.switchToEnglish();

            Assert.assertEquals(
                    portfolioPage.waitForAboutMenuText("About"),
                    "About",
                    "Language did not switch back to English!"
            );
        });
    }

    @Feature("Tema Seçimi")
    @Description("Açık ve koyu tema geçişleri doğrulanır.")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Tema değiştirme kontrolü")
    public void themeShouldChange() {

        PortfolioPage portfolioPage = new PortfolioPage();

        String initialTheme = portfolioPage.getTheme();

        Allure.step("Başlangıç temasını doğrula", () -> {
            Assert.assertTrue(
                    "light".equals(initialTheme) || "dark".equals(initialTheme),
                    "Invalid initial theme!"
            );
        });

        String expectedTheme = initialTheme.equals("light")
                ? "dark" : "light";

        Allure.step("Temayı değiştir ve doğrula", () -> {
            portfolioPage.toggleTheme();

            Assert.assertEquals(
                    portfolioPage.waitForTheme(expectedTheme),
                    expectedTheme,
                    "Theme did not change!"
            );
        });

        Allure.step("Başlangıç temasına geri dön ve doğrula", () -> {
            portfolioPage.toggleTheme();

            Assert.assertEquals(
                    portfolioPage.waitForTheme(initialTheme),
                    initialTheme,
                    "Initial theme was not restored!"
            );
        });
    }

    @Feature("İletişim Formu")
    @Description("Boş isim alanı ve e-posta formatı doğrulanır.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "İletişim formu alan kontrolleri")
    public void contactFormShouldValidateInputs() {

        PortfolioPage portfolioPage = new PortfolioPage();

        Allure.step("Boş isim alanının geçersiz olduğunu doğrula", () -> {
            Assert.assertTrue(
                    portfolioPage.isNameInvalid(),
                    "Empty name must be invalid!"
            );
        });

        Allure.step("Geçersiz e-posta formatını doğrula", () -> {
            portfolioPage.enterEmail("invalidemail");

            Assert.assertTrue(
                    portfolioPage.isEmailInvalid(),
                    "Invalid email format was accepted!"
            );
        });

        Allure.step("Geçerli e-posta formatını doğrula", () -> {
            portfolioPage.enterEmail("qa@example.com");

            Assert.assertFalse(
                    portfolioPage.isEmailInvalid(),
                    "Valid email format was rejected!"
            );
        });
    }
}