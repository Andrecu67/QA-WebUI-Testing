package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Date;


public class CreaProCUItemTest extends TestBase {


    @Test
    public void cProCUItemTesting() throws InterruptedException {

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("upbapi1@upbapi.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();

        String nameProject = new Date().getTime()+"UPB";
        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.setText(nameProject);
        leftSection.addButton.click();

        Thread.sleep(1000);
        Assertions.assertEquals(nameProject, centerSection.projectNameLabel.getText(),
                "ERROR! El project no fue creado");

        centerSection.nameItemTextBox.click();
        centerSection.nameItemTextBox.setText("UPBItem");
        centerSection.addButton.click();

        Assertions.assertTrue(centerSection.verifyNameItem("UPBItem"),"ERROR!! el item no fue creado");

        centerSection.clickItem("UPBItem");
        centerSection.nameUpdateTextBox.clearSetText("QAItem"+ Keys.ENTER);
        Thread.sleep(1000);

        Assertions.assertTrue(centerSection.verifyNameItem("QAItem"),"ERROR!! el item no fue creado");
    }


}