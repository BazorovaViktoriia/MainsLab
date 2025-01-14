package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Payout {
    private WebElement addSBPAccount = $(byText("Добавить счет СБП"));
    private WebElement addNewCard = $(byText("Добавить другую карту"));


    @Step("Пролистываем страницу до появления кнопки 'Добавить счет' ")
    public Payout scrollDown(int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", pixels);
        return this;
    }

    @Step("Нажимаем кнопку 'Добавить СБП счет' ")
    public Payout clickAddAccountBtn() {
        addSBPAccount.click();
        return this;
    }

    @Step("Нажимаем кнопку 'Добавить другую карту' ")
    public Payout clickAddNewCard() {
        addNewCard.click();
        return this;
    }
}