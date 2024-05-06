package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginSection {

    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
    public TextBox pwdTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
    public Button loginButton  = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));

    public TextBox emailTodoistTextBox = new TextBox(By.id("element-0"));
    public TextBox pwdTodoistTextBox = new TextBox(By.id("element-3"));
    public Button loginTodoistButton  = new Button(By.xpath("//button[@data-gtm-id =\"start-email-login\"]"));

}
