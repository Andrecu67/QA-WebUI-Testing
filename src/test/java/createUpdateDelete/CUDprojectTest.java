package createUpdateDelete;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CUDprojectTest {

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

    @Test
    public void  verifyCreateUpdateDeleteProject() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();

        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upbapi1@upbapi.com");

        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");

        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

    //CREATE PROJECT
        String nameProject = "testWEB";
        //click add new project
        chrome.findElement(By.xpath("//td[text()='Add New Project']")).click();

        //nombre del proyecto
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);

        //añadir
        chrome.findElement(By.id("NewProjNameButton")).click();

        //veficar
        Thread.sleep(2000);
        String actualResult= chrome.findElement(By.id("CurrentProjectTitle")).getText();
        String expectedResult = nameProject;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR, no se pudo crear el projecto");

        Thread.sleep(2000);

    //UPDATE PROJECT
        String newNameProject = "WEBtestActual";

        //click en mi projecto
        chrome.findElement(By.xpath("//li[last()]//td[text()='"+nameProject+"']")).click();

        // click options
        chrome.findElement(By.xpath("//div[@style=\"display: block;\"]/img[@title='Options']")).click();

        // click edit
        chrome.findElement(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']")).click();

        //fill new name project
        chrome.findElement(By.xpath("//td/div/input[@id=\"ItemEditTextbox\"]")).clear();
        chrome.findElement(By.xpath("//td/div/input[@id=\"ItemEditTextbox\"]")).sendKeys(newNameProject);

        // click save
        chrome.findElement(By.xpath("//td/div/img[@id=\"ItemEditSubmit\"]")).click();

        // verificamos
        Assertions.assertTrue(chrome.findElement(By.xpath("//li[last()]//td[text()='"+newNameProject+"']")).isDisplayed(),
                "ERROR, el nombre no fue actualizado");
        Thread.sleep(2000);

    //DELETE PROJECT
        //click en mi projecto
        chrome.findElement(By.xpath("//li[last()]//td[text()='"+newNameProject+"']")).click();

        // click options
        chrome.findElement(By.xpath("//div[@style=\"display: block;\"]/img[@title='Options']")).click();

        // click delete
        chrome.findElement(By.id("ProjShareMenuDel")).click();

        //>>>>> ALERT <<<<
        chrome.switchTo().alert().accept();
        Thread.sleep(2000);

        //Verificacion
        Assertions.assertTrue(chrome.findElements(By.xpath("//li[last()]//td[text()='"+newNameProject+"']")).size() <= 0,
                "ERROR, el project no fue eliminado");
        Thread.sleep(2000);
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

}
