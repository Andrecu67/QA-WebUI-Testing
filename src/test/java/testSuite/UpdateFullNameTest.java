package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Name;
import java.util.Date;

public class UpdateFullNameTest extends TestBase{
    @Test
    public void changingFullNameTesting() throws InterruptedException {
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("upbapi1@upbapi.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();

        String name = "Andrea";
        menuSection.settingButton.click();
        profileDialog.fullNameTextBox.clearSetText(name);
        //profileDialog.fullNameTextBox.setText(name);
        profileDialog.okButton.click();

        menuSection.settingButton.click();
        Thread.sleep(1000);
        Assertions.assertEquals(name, profileDialog.fullNameTextBox.getTextProperty("value"),
                "ERROR! El nombre no fue actulizado");

    }

}
