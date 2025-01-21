package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class RegistrationStepOne
 * Includes person's info - passport, contact, address
 */
public class Registration_step_1_Page {

    private final SelenideElement phone = $(By.name("mobile_phone"));
    private final SelenideElement email = $(By.name("email"));

    private final SelenideElement address = $(By.id("address"));

    private final SelenideElement nextBTN = $(byText("Продолжить"));

    public Registration_step_1_Page writePhone(String phoneStr) {
        phone.sendKeys(phoneStr);
        return this;
    }

    public Registration_step_1_Page writeEmail(String emailStr) {
        email.sendKeys(emailStr);
        return this;
    }

    public Registration_step_1_Page writeaddress(String addressStr) {
        address.sendKeys(addressStr);
        return this;
    }

    public void clickEntryButton() {
        nextBTN.click();
    }
}