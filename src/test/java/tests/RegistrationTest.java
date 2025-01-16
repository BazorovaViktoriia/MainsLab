package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import methods.Registration;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}