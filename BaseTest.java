package common;

import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import home.HomePage;

public class BaseTest extends Variables {
    protected WebDriver driver = null;
    protected LoginPage loginPage;
    protected HomePage homePage;

    // Global test data excel file
    public static final String testDataExcelFileName = "LoginData.xlsx";

    @BeforeClass
    public void writeTestBeginLog() {
        System.setProperty("webdriver.chrome.driver", "/Users/Can/IdeaProjects/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("no-sandbox");
        options.addArguments("keep-alive-for-test");
        options.addArguments("dns-prefetch-disable");
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability(ACCEPT_SSL_CERTS, true);
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        this.driver = new ChromeDriver(options);
        this.loginPage = this.navigateToLoginPage();
    }
    protected LoginPage navigateToLoginPage() {
        this.navigateTo(LOGIN_PAGE);
        return PageFactory.initElements(this.getDriver(), LoginPage.class);
    }

    protected HomePage navigateToHomePage() {
        this.navigateTo(HOME_PAGE);
        return PageFactory.initElements(this.getDriver(), HomePage.class);
    }

    private void navigateTo(String url) {
        this.getDriver().navigate().to(url);
    }

    private WebDriver getDriver() {
        return this.driver;
    }
}
