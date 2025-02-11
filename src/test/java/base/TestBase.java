package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import properties.ConfigurationManager;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import static com.codeborne.selenide.Selenide.open;

@Listeners(FailedWatcher.class)
public class TestBase {

    @BeforeMethod
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        //addListener("AllureSelenide", new AllureSelenide());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browser = "Chrome";
        Configuration.browserCapabilities = options;
        Configuration.holdBrowserOpen = true;
        open(ConfigurationManager.configuration().url());
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}