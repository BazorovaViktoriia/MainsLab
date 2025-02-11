package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class PersonalAddressPage {

    private final SelenideElement deliveryDate = $(byId("deliveryDate"));
    private final SelenideElement deliveryDateAgree = $(byText("15"));

    private final SelenideElement checkCourier = $(byText("Курьер"));
    private final SelenideElement checkByYourself = $(byText("Самовывоз"));
    private final SelenideElement checkByPost = $(byText("Почтовая служба"));

    private final SelenideElement acceptPersonalData = $(byId("agreement"));

    private final SelenideElement sendBtn = $(byText("Отправить"));
    private final SelenideElement agreeBtn = $(byText("Ок"));
    private final SelenideElement cancelBtn = $(byText("Отмена"));

    @Step("Ставим курсор в поле выбора даты")
    public PersonalAddressPage dateClick() {
        deliveryDate.click();
        return this;
    }

    @Step("Выбираем нужную дату")
    public PersonalAddressPage checkDate() {
        deliveryDateAgree.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Выбираем отправку заказа курьером")
    public PersonalAddressPage clickCheckCourier() {
        checkCourier.click();
        return this;
    }

    @Step("Выбираем самовывоз")
    public PersonalAddressPage clickCheckByYourself() {
        checkByYourself.click();
        return this;
    }

    @Step("Выбираем отправку почтой")
    public PersonalAddressPage clickCheckByPost() {
        checkByPost.click();
        return this;
    }

    @Step("Отжимаем чек бокс с согласием на обработку ПД")
    public PersonalAddressPage setAgreement() {
        acceptPersonalData.click();
        return this;
    }

    @Step("Нажимаем кнопку отправки данных")
    public PersonalAddressPage sendPersonalInfo() {
        sendBtn.click();
        return this;
    }

    @Step("Нажимаем кнопку Продолжить")
    public void clickAgreeBtn() {
        agreeBtn.click();
    }

    @Step("Нажимаем кнопку Отмена")
    public void clickCancelBtn() {
        cancelBtn.click();
    }
}