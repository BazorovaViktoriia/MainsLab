package methods;

import base.TestBase;
import org.testng.annotations.DataProvider;
import pages.PersonalInfoPage;
import properties.ConfigurationManager;

public class PersonalInfo extends TestBase {
    private String name = ConfigurationManager.configuration().name();
    private String phone = ConfigurationManager.configuration().telephone();
    private String address = ConfigurationManager.configuration().address();


    public void writePersonalInfo() {
        new PersonalInfoPage()
                .writeName(name)
                .writeTel(phone)
                .writeAddress(address)
                .clickSaveBTN()
                .clickNextPage();
    }

    @DataProvider(name = "nameData")
    public Object[][] provideNames() {
        return new Object[][]{
                {"Иван", true},
                {"Jane", true},
                {"", false},
                {" ", false},
                {"@%;?", false},
                {"A", false},
                {"ПрвоеркаНаВводДлинногоИмени", false}
        };
    }

    @DataProvider(name = "telData")
    public Object[][] provideTel() {
        return new Object[][]{
                {"89198889911", true},
                {"+79198889911", true},
                {"", false},
                {" ", false},
                {"@%;?", false},
                {"A", false},
                {"33333333333333333333333333333333", false}
        };
    }
}