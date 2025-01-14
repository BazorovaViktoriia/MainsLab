package pages;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {
    TextInput tel = new TextInput($(byXpath("/html/body/div[4]/div/div[2]/div[2]/form/div/div[1]/input[1]")));
    TextInput password = new TextInput($(byXpath("/html/body/div[4]/div/div[2]/div[2]/form/div/div[1]/input[2]")));
    Button entryBtn = new Button($(byText("Войти")));

    @Step("Вводим номер телефона")
    public LoginPage writeTel(String telephone) {
        sleep(2000);
        tel.sendKeys(telephone);
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage writePassword(String pass) {
        sleep(2000);
        password.sendKeys(pass);
        return this;
    }

    @Step("Нажимаем кнопку 'Войти' ")
    public void clickBTN() {
        entryBtn.click();
    }
}