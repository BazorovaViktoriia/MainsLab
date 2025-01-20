package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import methods.Registration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Test
public class RegistrationTest extends Registration {

    @Owner("Базорова Виктория")
    @Description("Проверка регистрации на сайте, моб версия анкета-заявка")
    @Test
    public void regPersonTest() throws InterruptedException {
        new Registration().regPerson();

        Assert.assertTrue($(byText("Бонус за рекомендацию")).exists(), "Не произошел вход в ЛК");
    }

    @Owner("Базорова Виктория")
    @Description("Проверка, что телефон не улетит в Краткую анкету без согласия Клиента на обработку ПД")
    @Test
    public void fastRegPersonTest() {
        new Registration().fastRegPerson();

        Assert.assertFalse($(byClassName("btn btn-outline-secondary")).isDisplayed(),
                "Кнопка отправки телефона активна, хотя не должна быть.");

    }

    @Owner("Базорова Виктория")
    @Description("Проверка появления сообщения о попытке зарегистрироваться по краткой анкете при наличии ЛК")
    @Test
    public void repeatFastRegPersonTest() {
        new Registration().repeatFastRegPerson();

        Assert.assertTrue($(byId("anketaTelefonRequestInfo")).exists(),
                "Отсутствует сообщение, что у Клиента уже есть ЛК");

    }

    @Owner("Базорова Виктория")
    @Description("Проверка минимальной суммы займа")
    @Test
    public void checkMinZaimTest() {
        new MainPage().checkMinZaimValue();
        Assert.assertTrue($(byText("5 000 ₽")).exists(), "Не отразилась мин сумма займа в 5 тысяч рублей");
    }

    @Owner("Базорова Виктория")
    @Description("Проверка максимальной суммы займа")
    @Test
    public void checkMaxZaimTest() {
        new MainPage().checkMaxZaim();
        Assert.assertTrue($(byText("48 000 ₽")).exists(), "Не отразилась максимальная сумма займа в 48 тысяч рублей");
    }
}