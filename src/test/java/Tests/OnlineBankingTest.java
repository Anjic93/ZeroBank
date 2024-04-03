package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlineBankingTest extends BaseTest {

    HomePage homePage;
    LogInPage logInPage;
    OnlineBankingPage onlineBankingPage;
    AccountSummaryPage accountSummaryPage;
    AccountActivityPage accountActivityPage;
    TransferFundsPage transferFundsPage;

    @BeforeMethod
    public void pageSetUp() {
        WebDriver driver = new ChromeDriver();
        driverThreadLocal.set(driver);
        driver = driverThreadLocal.get();
    driver.get("http://zero.webappsecurity.com/index.html");
    driver.manage().window().maximize();



    logInPage = new LogInPage(driver);
    homePage = new HomePage(driver);
    onlineBankingPage = new OnlineBankingPage(driver);
    accountSummaryPage = new AccountSummaryPage(driver);
    accountActivityPage = new AccountActivityPage(driver);
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
    }


    WebDriver driver = new ChromeDriver();

    @Test(priority = 10)
    public void userCanProceedToOnlineBankingPage() {

        homePage.clickOnOnlineBankingButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
        onlineBankingPage.assertObPageTitle();
    }

    @Test(priority = 20)
    public void userCanProceedToAccountSummaryPage() {

        homePage.clickOnOnlineBankingButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
        onlineBankingPage.assertObPageTitle();

        onlineBankingPage.clickOnAccountSummaryButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/account-summary.html");
        accountSummaryPage.accountAssertion();
    }

    @Test(priority = 30)
    public void userCanProceedToAccountActivityPage() {

        homePage.clickOnOnlineBankingButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
        onlineBankingPage.assertObPageTitle();

        onlineBankingPage.clickOnAccountActivityButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/account-activity.html");
        Assert.assertTrue(accountActivityPage.transactionsTitle.isDisplayed());
    }

    @Test(priority = 40)
    public void userCanProceedToTransferFundsPage() {

        homePage.clickOnOnlineBankingButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
        onlineBankingPage.assertObPageTitle();

        onlineBankingPage.clickOnTransferFundsButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/transfer-funds.html");
        Assert.assertTrue(transferFundsPage.transferTitle.isDisplayed());
    }


}
