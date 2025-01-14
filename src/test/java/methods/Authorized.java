package methods;

import base.TestBase;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;
import properties.ConfigurationManager;

public class Authorized extends TestBase {
    private String tel = ConfigurationManager.configuration().telephone();
    private String password = ConfigurationManager.configuration().passwordLK();

    @Step("Начинаем процесс авторизации в ЛК")
    public void login() {
        new MainPage().scrollDown(60);
        new MainPage().login();

        new LoginPage()
                .writeTel(tel)
                .writePassword(password)
                .clickBTN();
    }
}