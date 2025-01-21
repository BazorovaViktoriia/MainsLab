package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class Registration_step_3_Page {

    private final SelenideElement passportSeries = $(By.name("passport_s"));
    private final SelenideElement passportNumber = $(By.name("passport_n"));
    private final SelenideElement passportCode = $(By.name("passport_code"));
    private final SelenideElement passportDate = $(By.name("passport_date"));
    private final SelenideElement nextBTN = $(byText("Продолжить"));


    public Registration_step_3_Page writePassportSeries(String passportSeriesStr) {
        passportSeries.sendKeys(passportSeriesStr);
        return this;
    }

    public Registration_step_3_Page writePassportNumber(String passportNumberStr) {
        passportNumber.sendKeys(passportNumberStr);
        return this;
    }

    public Registration_step_3_Page writepassportCode(String passportCodeStr) {
        passportCode.sendKeys(passportCodeStr);
        return this;
    }

    public Registration_step_3_Page writepassportDate(String passportDateStr) {
        passportDate.sendKeys(passportDateStr);
        passportDate.sendKeys(Keys.TAB);
        return this;
    }

    public Registration_step_3_Page writePassportGive() throws InterruptedException {

        sleep(5000);
        $((byText("ТП № 25 ОУФМС РОССИИ ПО САНКТ-ПЕТЕРБУРГУ И ЛЕНИНГРАДСКОЙ ОБЛ. В КИРОВСКОМ РАЙОНЕ Г. САНКТ-ПЕТЕРБУРГА")))
                .should(exist).click();

        return this;
    }

    public void clickButton() {
        nextBTN.click();
    }
}
