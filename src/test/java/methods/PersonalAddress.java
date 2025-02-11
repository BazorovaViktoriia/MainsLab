package methods;

import base.TestBase;
import pages.PersonalAddressPage;

public class PersonalAddress extends TestBase {
    public void writePersonalAddress() {
        new PersonalAddressPage()
                .dateClick()
                .checkDate()
                .clickCheckCourier()
                .setAgreement()
                .sendPersonalInfo()
                .clickAgreeBtn();
    }
}
