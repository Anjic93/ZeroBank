package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    HomePage homePage;
    LogInPage logInPage;
    OnlineBankingPage onlineBankingPage;
    TransferFundsPage transferFundsPage;

    @BeforeMethod
    public void pageSetUp(){

        WebDriver driver = new ChromeDriver();
        driverThreadLocal.set(driver);
        driver = driverThreadLocal.get();
        driver.get("http://zero.webappsecurity.com/index.html");
        driver.manage().window().maximize();

        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        onlineBankingPage = new OnlineBankingPage(driver);
        transferFundsPage = new TransferFundsPage(driver);

        String validUsername = "username";
        String validPassword = "password";


        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(validPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        driver.navigate().back();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
        Assert.assertTrue(homePage.usernameIcon.isDisplayed());

        homePage.clickOnOnlineBankingButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
        onlineBankingPage.assertObPageTitle();

        onlineBankingPage.clickOnTransferFundsButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/transfer-funds.html");
        Assert.assertTrue(transferFundsPage.transferTitle.isDisplayed());
    }
    WebDriver driver = new ChromeDriver();
    @Test(priority = 10)
    public void userCanSuccessfullyTransferMoney() {
        transferFundsPage.chooseRandomFromAccountOption();
        transferFundsPage.isSameFromAssertion();

        transferFundsPage.chooseRandomToAccountOption();
        transferFundsPage.isSameToAssertion();

        transferFundsPage.insertDesiredAmount("500");
        transferFundsPage.insertDescription("/");
        transferFundsPage.clickOnContinueButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/transfer-funds-verify.html");


        transferFundsPage.clickOnSubmitButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/transfer-funds-confirm.html");
        Assert.assertTrue(transferFundsPage.successMessage.isDisplayed());
    }


}
