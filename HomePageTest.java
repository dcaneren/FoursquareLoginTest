package home;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import common.BaseTest;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void loginWithValidCredentials() throws InterruptedException {
        this.loginPage.login("dgncnrn@gmail.com","asdf");
        this.homePage = PageFactory.initElements(this.driver, HomePage.class); //this.driver.getCurrentUrl();
    }

    @Test
    public void logout() throws InterruptedException {
        homePage.logout();
    }
}
