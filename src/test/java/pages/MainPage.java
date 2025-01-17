package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class MainPage
 * <p>
 * Главная страница microklad.ru
 * С этой страницы используются локаторы для авторизации в ЛК и прохождения
 * краткой регистрации, анкеты-заявки
 * Проверка минимального и максимального значения в калькуляторе
 *
 */
public class MainPage {

    private WebElement getMoneyBTN = $(By.xpath("/html/body/div[4]/div/section/div[2]/form/div/div[2]/button"));
    private WebElement loginLK = $(byText("Войти в личный кабинет"));
    private TextInput telInput = new TextInput($(byId("anketaTelefonValue")));
    private WebElement acceptPersonalData = $(byId("chS"));
    private WebElement sendTel = $(byClassName("btn btn-outline-secondary"));


    public void clickGetMoneyBTN() {
        getMoneyBTN.click();
    }

    @Step("Нажимаем кнопку для перехода в ЛК")
    public void login() {
        loginLK.click();
    }

    @Step("Пролистываем страницу до появления кнопки 'Войти в ЛК' ")
    public void scrollDown(int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    @Step("Вводим номер телефона")
    public MainPage setTelephoneNumber(String tel) {
        telInput.sendKeys(tel);
        return this;
    }

    @Step("Отжимаем чек бокс с согласием на обработку ПД")
    public MainPage setAgreement() {
        acceptPersonalData.click();
        return this;
    }

    @Step("Нажимаем кнопку для отправки номера телефона верификаторам")
    public void clickSendTelBTN() {
        sendTel.click();
    }

}