package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Registration_step_2_Page {

    private final SelenideElement surname = $(By.id("field_surname"));
    private final SelenideElement name = $(By.id("field_name"));
    private final SelenideElement patronymic = $(By.id("field_patronymic"));
    private final SelenideElement birthday = $(By.name("birthday"));
    private final SelenideElement birthPlace = $(By.name("birth_place"));
    private final SelenideElement nextBTN = $(byText("Продолжить"));

    public Registration_step_2_Page writeBirthday(String birthdayStr) {
        birthday.sendKeys(birthdayStr);
        return this;
    }

    public Registration_step_2_Page writeBirthPlace(String birthPlaceStr) {
        birthPlace.sendKeys(birthPlaceStr);
        return this;
    }

    public Registration_step_2_Page writeSurname(String surnameStr) {
        surname.sendKeys(surnameStr);
        return this;
    }

    public Registration_step_2_Page writeName(String nameStr) {
        name.sendKeys(nameStr);
        return this;
    }

    public Registration_step_2_Page writePatronymic(String patronymicStr) {
        patronymic.sendKeys(patronymicStr);
        return this;
    }

    public void clickEntryButton() {
        nextBTN.click();
    }
}
