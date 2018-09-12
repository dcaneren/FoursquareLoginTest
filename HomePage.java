package home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

    public WebElement getUserPath() {
        return userPath;
    }

    @FindBy(css = "a[class='userPathLink']")
    private WebElement userPath;

    @FindBy(id = "logoutLink")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    Actions builder = new Actions(driver);

    public void logout() throws InterruptedException {
        this.builder.moveToElement(userPath).perform();
        Thread.sleep(4000);
        this.logoutButton.click();
    }



}
