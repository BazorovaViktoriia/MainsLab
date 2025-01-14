package tests;

import com.codeborne.selenide.WebDriverRunner;
import methods.Authorized;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizedTest extends Authorized {

    @Test
    public void authorized() {

        new Authorized().login();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(),
                "https://shigapova.microklad.ru/user/payout",
                "URL не соответствует ожидаемому");
    }
}