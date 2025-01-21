package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class Registration_step_3_fast {
    private SelenideElement firstPhoto = $(By.xpath("//*[@id=\"photos\"]/div[2]/div[1]/form/div/input"));
    private SelenideElement secondPhoto = $(By.xpath("//*[@id=\"photos\"]/div[2]/div[3]/form/div/input"));
    private final SelenideElement nextBTN = $(byText("Продолжить"));
    private final SelenideElement bankAccount = $(byId("sbp"));
    private final SelenideElement bankName = $(byClassName("select2-search__field"));

    SelenideElement slider = $("#sum_slider");  // Локатор слайдера
    int salaryValue = 20000;

    @Attachment
    public Registration_step_3_fast uploadFirstPhoto() {
        firstPhoto.uploadFile(new File("C:/Users/Виктория Базарова/Desktop/для теста.jpg")); // Загрузка файла
        return this;
    }

    @Attachment
    public Registration_step_3_fast uploadSecondPhoto() {
        secondPhoto.uploadFile(new File("C:/Users/Виктория Базарова/Desktop/для теста.jpg")); // Загрузка файла
        return this;

    }
    //метод для передвижения слайдера с суммой дохода
    public Registration_step_3_fast moveSliderWithKeys() {
        int currentValue = Integer.parseInt(slider.getValue());

        int step = Integer.parseInt(slider.getAttribute("step"));
        int steps = (salaryValue - currentValue) / step;

        for (int i = 0; i < Math.abs(steps); i++) {
            slider.sendKeys(steps > 0 ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT);
        }

        return this;
    }

    public Registration_step_3_fast clickBankAccount() {
        bankAccount.click();
        return this;
    }

    public Registration_step_3_fast addBankAccount(String str) throws InterruptedException {
        bankName.sendKeys(str);

        $((byText("Банк Венец")))
                .should(exist).click();
        sleep(5000);
        $((byText("Добавить"))).click(); // красная кнопка Добавить
        sleep(5000);

        $((byText("Счет СБП в Банк Венец")))
               .should(exist).click();

        return this;
    }

    public void clickButton() {
        nextBTN.click();
    }
}