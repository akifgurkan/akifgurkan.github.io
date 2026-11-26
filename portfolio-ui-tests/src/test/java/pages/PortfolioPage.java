package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class PortfolioPage {

    private final WebDriverWait wait;

    // Sayfa elementlerini ve bekleme nesnesini başlatır.
    public PortfolioPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        wait = new WebDriverWait(
                Driver.getDriver(), Duration.ofSeconds(10));
    }

    // Profil isminin bulunduğu elementi bulur.
    @FindBy(tagName = "h1")
    private WebElement profileName;

    // Profil fotoğrafını bulur.
    @FindBy(className = "profile-image")
    private WebElement profileImage;

    // Türkçe ve İngilizce dil değiştirme butonlarını bulur.
    @FindBy(xpath = "//button[@lang='tr']")
    private WebElement turkishButton;

    @FindBy(xpath = "//button[@lang='en']")
    private WebElement englishButton;

    // "About" menü öğesini bulur.
    @FindBy(xpath = "//div[@id='navLinks']//a[@href='#about']")
    private WebElement aboutMenu;

    // Tema değiştirme butonunu bulur.
    @FindBy(id = "themeToggle")
    private WebElement themeToggleButton;

    // Sayfanın tema bilgisini taşır.
    @FindBy(tagName = "html")
    private WebElement pageRoot;

    // İletişim formu alanlarını bulur.
    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;


    // Sayfanın başlığını döndürür.
    public String getPageTitle() {
        return Driver.getDriver().getTitle();
    }

    // Profil isminin görünmesini bekler ve metnini döndürür.
    public String getProfileName() {
        return wait.until(
                        ExpectedConditions.visibilityOf(profileName))
                .getText();
    }

    // Profil fotoğrafının görünürlüğünü kontrol eder.
    public boolean isProfileImageDisplayed() {
        return wait.until(driver -> profileImage.isDisplayed());
    }

    // Profil fotoğrafının başarıyla yüklendiğini doğrular.
    public boolean isProfileImageLoaded() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        return Boolean.TRUE.equals(js.executeScript(
                "return arguments[0].complete && arguments[0].naturalWidth > 0;",
                profileImage));
    }

    // Dil değiştirme işlemleri.
    public void switchToTurkish() {
        turkishButton.click();
    }

    public void switchToEnglish() {
        englishButton.click();
    }

    // Menü metninin değişmesini bekler.
    public String waitForAboutMenuText(String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(
                aboutMenu, expectedText));

        return aboutMenu.getText();
    }

    public void toggleTheme() {
        themeToggleButton.click();
    }

    public String getTheme() {
        String theme = pageRoot.getDomAttribute("data-theme");
        return theme == null ? "light" : theme;
    }

    // Tema değişiminin tamamlanmasını bekler.
    public String waitForTheme(String expectedTheme) {
        wait.until(driver -> expectedTheme.equals(getTheme()));
        return getTheme();
    }

    // İsim alanının geçersizliğini kontrol eder.
    public boolean isNameInvalid() {
        return !nameInput.getDomProperty("validationMessage").isEmpty();
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // E-posta alanının geçersizliğini kontrol eder.
    public boolean isEmailInvalid() {
        return !emailInput.getDomProperty("validationMessage").isEmpty();
    }

}