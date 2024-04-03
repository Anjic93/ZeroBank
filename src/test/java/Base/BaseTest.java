package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected  static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    /*public HomePage homePage;
    public LogInPage logInPage;
    public OnlineBankingPage onlineBankingPage;
    public FeedbackPage feedbackPage;
    public AccountSummaryPage accountSummaryPage;
    public AccountActivityPage accountActivityPage;
    public TransferFundsPage transferFundsPage;

     */



    @AfterMethod
    public void tearDown() {
        driverThreadLocal.get().quit();
    }

}
