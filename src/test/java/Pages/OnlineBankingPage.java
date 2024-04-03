package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OnlineBankingPage {
    private final WebDriver driver;
    public OnlineBankingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "span6")
    public WebElement obPageTitle;

    @FindBy(id = "account_summary_link")
    public WebElement accSummButton;

    @FindBy(id = "account_activity_link")
    public WebElement accActButton;

    @FindBy(id = "transfer_funds_link")
    public WebElement transFundsButton;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsButton;

    @FindBy(id = "money_map_link")
    public WebElement moneyMapButton;

    @FindBy(id = "online_statements_link")
    public WebElement onlineStatButton;





    //-------------------

    public void assertObPageTitle() {
        if(obPageTitle.getText().contains("Online Banking")) {
            obPageTitle.isDisplayed();
        }
    }

    public void clickOnAccountSummaryButton() {
        accSummButton.click();
    }

    public void clickOnAccountActivityButton() {
        accActButton.click();
    }

    public void clickOnTransferFundsButton() {
        transFundsButton.click();
    }

    public void clickOnPayBillsButton() {
        payBillsButton.click();
    }

    public void clickOnMyMoneyMapButton() {
        moneyMapButton.click();
    }

    public void clickOnOnlineStatementsButton() {
        onlineStatButton.click();
    }

}
