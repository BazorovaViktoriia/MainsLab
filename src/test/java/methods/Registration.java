package methods;

import base.TestBase;
import io.qameta.allure.Description;
import pages.*;
import properties.ConfigurationManager;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class Registration extends TestBase {
    private String mail = ConfigurationManager.configuration().e_mail();
    private String phone = ConfigurationManager.configuration().phoneNumber();
    private String surname = ConfigurationManager.configuration().surname();
    private String name = ConfigurationManager.configuration().name();
    private String patronymic = ConfigurationManager.configuration().patronymic();
    private String birthday = ConfigurationManager.configuration().birthday();
    private String birthplace = ConfigurationManager.configuration().birthPlace();
    private String passportSeria = ConfigurationManager.configuration().passportSeria();
    private String passportNumber = ConfigurationManager.configuration().passportNumber();
    private String passportCode = ConfigurationManager.configuration().passportCode();
    private String passportDate = ConfigurationManager.configuration().passportDate();
    private String address = ConfigurationManager.configuration().address();
    private String bank = ConfigurationManager.configuration().bank();
    private String code = ConfigurationManager.configuration().code();
    private String tel = ConfigurationManager.configuration().telephone();


    public void regPerson() throws InterruptedException {
        new MainPage().clickGetMoneyBTN();
        $(byText("Пройти стандартную регистрацию")).click();
        new Registration_step_1_Page()
                .writePhone(phone)
                .writeEmail(mail)
                .clickEntryButton();
        sleep(1000);
        new Registration_step_2_Page()
                .writeSurname(surname)
                .writeName(name)
                .writePatronymic(patronymic)
                .writeBirthday(birthday)
                .writeBirthPlace(birthplace)
                .clickEntryButton();
        sleep(1000);
        new Registration_step_3_Page()
                .writePassportSeries(passportSeria)
                .writePassportNumber(passportNumber)
                .writepassportCode(passportCode)
                .writepassportDate(passportDate)
                .writePassportGive()
                .clickButton();
        sleep(1000);
        new Registration_step_4_Page()
                .writeAddress(address)
                .clickButton()
                .clickButton();

        new Registration_step_3_fast()
                .uploadFirstPhoto()
                .uploadSecondPhoto()
                .moveSliderWithKeys()
                .clickBankAccount()
                .addBankAccount(bank)
                .clickButton();

        new Registration_step_4_sbp_Page()
                .getAgreement()
                .getSms()
                .puttSmsCode(code)
                .getCredit();
    }


    public void fastRegPerson() {
        new MainPage().setTelephoneNumber(phone)
                .setAgreement();
    }

    public void repeatFastRegPerson() {
        new MainPage().setTelephoneNumber(tel)
                .clickSendTelBTN();
    }

    public void checkMinData() {

    }

    public void checkMaxData() {

    }
}
