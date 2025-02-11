package methods;

import base.TestBase;
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
}
