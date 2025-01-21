package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class Registration_step_4_Page {

    private final SelenideElement region = $(By.name("pregion"));
    private final SelenideElement city = $(By.name("pcity"));
    private final SelenideElement street = $(By.name("pstreet"));
    private final SelenideElement building = $(By.name("pbuilding"));
    private final SelenideElement apartment = $(By.name("papartment"));

    private final SelenideElement nextBTN = $(byXpath("/html/body/div[4]/div[1]/section/div[2]/div[3]/div/div[2]/button"));

    public Registration_step_4_Page writeAddress(String address) {
        $(byId("address")).setValue(address).pressEnter(); // "addressField" замените на ваш локатор
        return this;
    }

    public Registration_step_4_Page writeRegion(String str) {
        region.sendKeys(str);
        return this;
    }

    public Registration_step_4_Page writeCity(String str) {
        city.sendKeys(str);
        return this;
    }

    public Registration_step_4_Page writeStreet(String str) {
        street.sendKeys(str);
        return this;
    }

    public Registration_step_4_Page writeBuilding(String str) {
        building.sendKeys(str);
        return this;
    }

    public Registration_step_4_Page writeApartment(String str) {
        apartment.sendKeys(str);
        return this;
    }


    public Registration_step_4_Page clickButton() {
        nextBTN.click();
        return this;
    }
}
