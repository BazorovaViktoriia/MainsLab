package methods;

import base.TestBase;
import pages.Payout;

import static com.codeborne.selenide.Selenide.Wait;

public class AddBankDetails extends TestBase {
    public void addBankAccount() {
        new Authorized().login();
        Wait().until(webDriver -> webDriver.getCurrentUrl().equals("https://shigapova.microklad.ru/user/payout"));
        new Payout().scrollDown(50).clickAddAccountBtn();
    }

    public void addCard() {
        new Authorized().login();
        Wait().until(webDriver -> webDriver.getCurrentUrl().equals("https://shigapova.microklad.ru/user/payout"));
        new Payout().scrollDown(50).clickAddNewCard();
    }
}
