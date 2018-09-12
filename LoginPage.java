package login;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "#loginFormButton > div")
    private WebElement signinButton;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(css = "#loginForm > div > div.errorMsg > p > strong")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) throws InterruptedException {
        this.driver.get("https://foursquare.com/login");
        this.username.click();
        this.username.sendKeys(username);
        Thread.sleep(2000);
        this.password.sendKeys(password);
        Thread.sleep(2000);
        this.signinButton.click();
    }

}
