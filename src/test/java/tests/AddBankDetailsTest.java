package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import methods.AddBankDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Test
public class AddBankDetailsTest extends AddBankDetails {

    @Owner("Базорова Виктория")
    @Description("Проверка добавления другой банковской карты из ЛК Клиента для перевода займа на неё")
    @Test(priority = 1)
    public void addBankAccountTest() {
        addBankAccount();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(),
                "https://shigapova.microklad.ru/user/addtinkoffsbp",
                "нет перехода на страницу Добавления счета");
    }

    @Owner("Базорова Виктория")
    @Description("Проверка добавления счета СБП из ЛК Клиента")
    @Test(priority = 2)
    public void addBankCardTest() {
        addCard();
        Assert.assertTrue($(byText("Добавить карту")).isDisplayed(),"Не найдена строка для ввода номера банковской карты");

    }
}