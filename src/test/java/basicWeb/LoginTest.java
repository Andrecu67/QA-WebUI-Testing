package basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        chrome.get("https://todo.ly/");
    }

    //upbapi1@upbapi.com - 12345
    //login-->//img[@src="/Images/design/pagelogin.png"]
    //email-->id="ctl00_MainContent_LoginControl1_TextBoxEmail"
    //password-->id="ctl00_MainContent_LoginControl1_TextBoxPassword"
    //login-->id="ctl00_MainContent_LoginControl1_ButtonLogin"

    // para verificar el login exitoso:
    //logout-->//a[text()='Logout']
    @Test
    public void  verifyLoginTest() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();

        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upbapi1@upbapi.com");

        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");

        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // verificarlo si existe el control del logout
        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size()==1),
                "ERROR, no se pudo ingresar a la sesion");

    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }
}
