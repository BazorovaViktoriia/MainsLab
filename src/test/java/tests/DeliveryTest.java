package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import methods.PersonalAddress;
import methods.PersonalInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PersonalAddressPage;
import pages.PersonalInfoPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Test
public class DeliveryTest extends PersonalInfo {

    @Owner("Базорова Виктория")
    @Description("Проверка ввода персональных данных на сайте")
    @Test
    public void sendPersonInfoTest() {
        new PersonalInfo().writePersonalInfo();

        Assert.assertTrue($(byText("Способ доставки:")).exists(),
                "Не произошел переход на страницу ввода адреса и времени доставки");

    }

    @Owner("Базорова Виктория")
    @Description("Проверка ввода персональных данных и данных для доставки на сайте")
    @Test
    public void checkDeliveryTest() {
        new PersonalInfo().writePersonalInfo();
        new PersonalAddress().writePersonalAddress();

        Assert.assertTrue($(byText("Ваша информация по доставке")).exists(),
                "Отсутсвует информация о доставке одежды");

    }

    @Owner("Базорова Виктория")
    @Description("Проверка возвращения на страницу ввода перс данных после ввода даты доставки")
    @Test
    public void checkPrevBtnTest() {
        new PersonalInfo().writePersonalInfo();
        new PersonalAddress().fillDateDelivery();
        new PersonalAddressPage().clickPrevPage();

        Assert.assertTrue($(byText("Доставка одежды")).exists(),
                "Не произошло возвращение на первую страницу");

    }

    @Description("Проверка валидации поля 'Имя'")
    @Test(dataProvider = "nameData")
    public void testNameValidation(String clientName, boolean expected) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.writeName(clientName);

        boolean actual = personalInfoPage.isValidName();

        Assert.assertEquals(actual, expected, "Ошибка в имени: имя " + clientName + " не прошло валидацию");
    }

    @Description("Проверка валидации поля 'Телефон'")
    @Test(dataProvider = "telData")
    public void testTelephoneValidation(String clientTel, boolean expected) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.writeTel(clientTel);

        boolean actual = personalInfoPage.isValidTel();

        Assert.assertEquals(actual, expected, "Ошибка в формате телефонного номера: введено " + clientTel);
    }
}