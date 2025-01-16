package tests;

import methods.DataBaseHelper;
import methods.UsersCookie;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Registration_step_1_Page;
import properties.ConfigurationManager;

import java.sql.ResultSet;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DatabaseTest extends UsersCookie {
    private String phone = ConfigurationManager.configuration().phoneNumber();


    public void fetchUserIDFromDatabase() {
        new MainPage().clickGetMoneyBTN();
        $(byText("Пройти стандартную регистрацию")).click();
        new Registration_step_1_Page()
                .writePhone(phone);

        String cookieSid = getCookieSid();

        String query = "SELECT id FROM users where sess_id LIKE ?";
        try {

            ResultSet resultSet = DataBaseHelper.executeQueryWithParameter(query, "%" + cookieSid + "%");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                System.out.println("user_ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}