package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInfoPage {
    private final SelenideElement name = $(byId("name"));
    private final SelenideElement tel = $(byId("phone"));
    private final SelenideElement address = $(byId("address"));
    private final SelenideElement saveBtn = $(byText("Сохранить"));
    private final SelenideElement secondPageBtn = $(byText("2"));


    @Step("Вводим имя Клиента")
    public PersonalInfoPage writeName(String clientName) {
        name.sendKeys(clientName);
        return this;
    }

    @Step("Вводим номер телефона Клиента")
    public PersonalInfoPage writeTel(String clientTelephone) {
        tel.sendKeys(clientTelephone);
        return this;
    }

    @Step("Вводим адрес Клиента")
    public PersonalInfoPage writeAddress(String clientAddress) {
        address.sendKeys(clientAddress);
        return this;
    }

    @Step("Нажимаем кнопку 'Сохранить' ")
    public PersonalInfoPage clickSaveBTN() {
        saveBtn.click();
        return this;
    }

    @Step("Перходим на следующую страницу")
    public void clickNextPage() {
        secondPageBtn.click();
    }


    public boolean isValidName() {
        return !name.getAttribute("class").contains("error");
    }

    public boolean isValidTel() {
        return !tel.getAttribute("class").contains("error");
    }


}
