package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import properties.ConfigurationManager;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Listeners(FailedWatcher.class)
public class TestBase {

    @BeforeMethod
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        //addListener("AllureSelenide", new AllureSelenide());

        ChromeOptions options = new ChromeOptions();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

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