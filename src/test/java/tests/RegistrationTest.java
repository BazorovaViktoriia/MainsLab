package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import methods.Registration;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
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
}