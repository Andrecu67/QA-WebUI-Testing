package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LeftSection;
import pages.LoginSection;
import pages.MainPage;
import pages.MenuSection;
import session.Session;

public class LoginTodoistTest {
    MenuSection menuSection = new MenuSection();
    LoginSection loginSection = new LoginSection();
    LeftSection leftSection = new LeftSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/es");
    }

    @Test
    public void LoginTesting() {
        menuSection.loginButtonTodoist.click();
        loginSection.emailTodoistTextBox.setText("andreacuevas1@upb.edu");
        loginSection.pwdTodoistTextBox.setText("A12b34c56");
        loginSection.loginTodoistButton.click();

        Assertions.assertTrue(leftSection.userNameButton.isControlDisplayed(),"ERROR, no se pudo iniciar la sesión");
    }
}
