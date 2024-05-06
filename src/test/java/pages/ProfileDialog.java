package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class ProfileDialog {

    public TextBox fullNameTextBox = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//span[text()='Ok']"));
}
