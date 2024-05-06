package pages;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class CenterSection {
    public Label projectNameLabel = new Label(By.id("CurrentProjectTitle"));
    public TextBox nameItemTextBox = new TextBox(By.id("NewItemContentInput"));
    public Button addButton = new Button(By.id("NewItemAddButton"));

    public TextBox nameUpdateTextBox = new TextBox(By.id("ItemEditTextbox"));

    public boolean verifyNameItem(String nameItem){
        Label nameItemCreated = new Label(By.xpath("//td/div[text()='"+nameItem+"']"));
        return nameItemCreated.isControlDisplayed();
    }
    public void clickItem(String nameItem){
        Label nameItemCreated = new Label(By.xpath("//td/div[text()='"+nameItem+"']"));
        nameItemCreated.click();
    }
}