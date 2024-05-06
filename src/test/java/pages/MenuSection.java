package pages;

import controls.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button settingButton = new Button(By.xpath("//a[text()='Settings']"));

    public Button loginButtonTodoist = new Button(By.xpath("//li/a[@href=\"https://app.todoist.com/auth/login\"]"));
}
