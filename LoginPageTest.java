package login;

import common.BaseTest;
import home.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtil;
//import utils.ExcelDataProvider;
//import utils.ExcelUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPageTest extends BaseTest {

    private String sTestCaseName;
    private int iTestCaseRow;

    //@DataProvider(name = "FetchData");
    public static Object[][] credentials() {

        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

    }

    @BeforeTest
    public void setupTestData() throws Exception {
        //set test data excel and sheet
        System.out.println("''''''''''''Setup Test Level Data''''''''''''");
        //ExcelUtils.setExcelFile("/Users/Can/IdeaProjects/foursquaretest/src/test/java/resources/", "LoginData.xlsx");
        ExcelUtil.setExcelFileSheet("Sheet1");
    }

    @Test(priority = 1)
    public void loginTest() throws Exception {
        int i = 0;
        try{
            Object[][] x = FetchData();
            //System.out.println(x.length);

            while(i < x.length){
                // INVALID LOGIN
                if(x[i][2].equals("0")){
                    this.loginPage.login(x[i][0].toString(),x[i][1].toString());
                    i++;
                    Assert.assertEquals(loginPage.getErrorMessage().isDisplayed(), true);
                }
                // VALID LOGIN
                if(x[i][2].equals("1")){
                    this.loginPage.login(x[i][0].toString(),x[i][1].toString());
                    this.homePage = PageFactory.initElements(this.driver, HomePage.class);
                    Assert.assertEquals(homePage.getUserPath().isDisplayed(), true);
                    this.homePage.logout();
                    i++;
                }

            }
        }
        catch (Exception e){
            throw e;
        }

    }

    @Test(priority = 2, enabled = false)
    public void loginWithValidCredentials() throws InterruptedException {
        this.loginPage.login("dgncnrn@gmail.com","123456");
    }

    @Test(priority = 1, enabled = false)
    public void loginWithInvalidUsername() throws Exception {
        Object[][] x = FetchData();

        //this.loginPage.login(ExcelUtil.getCellData(1,1), ExcelUtil.getCellData(1, 2));
    }

    @Test(priority = 1, enabled = false)
    public void loginWithInvalidPassword() throws InterruptedException {
        this.loginPage.login("dgncnrn@gmail.com","1234");
    }

    @AfterTest
    public void closeDriver() {
        this.driver.close();
    }

    @DataProvider

    public Object[][] FetchData() throws Exception{

        sTestCaseName = this.toString();

        sTestCaseName = ExcelUtil.getTestCaseName(this.toString());

        iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,0);

        Object[][] testObjArray = ExcelUtil.getTableArray("/Users/Can/IdeaProjects/foursquaretest/src/test/java/resources/LoginData.xlsx","Sheet1");

        System.out.println(Arrays.deepToString(testObjArray));
        return (testObjArray);

    }
}
