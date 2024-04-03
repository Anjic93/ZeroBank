package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeedbackTest extends BaseTest {

    LogInPage logInPage;
    HomePage homePage;
    FeedbackPage feedbackPage;

    @BeforeMethod
    public void pageSetUp() {
        WebDriver driver = new ChromeDriver();
        driverThreadLocal.set(driver);
        driver = driverThreadLocal.get();
        driver.get("http://zero.webappsecurity.com/index.html");
        driver.manage().window().maximize();

        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        feedbackPage = new FeedbackPage(driver);

    }

    WebDriver driver = new ChromeDriver();
    String validUsername = "username";
    String validPassword = "password";



    @Test(priority = 10)
    public void userCanProceedToFeedbackPage() {

        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(validPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        driver.navigate().back();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
        Assert.assertTrue(homePage.usernameIcon.isDisplayed());

       homePage.clickOnFeedbackButton();
      //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/feedback.html");
       feedbackPage.assertFeedbackTitle();
    }


}
