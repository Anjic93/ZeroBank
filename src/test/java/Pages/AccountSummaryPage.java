package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    private final WebDriver driver;

    public AccountSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "board-header")
    public List<WebElement> accountName;



    //----------------


    public void accountAssertion() {
        for(int i=0; i<accountName.size(); i++) {
            if(accountName.get(i).getText().contains("Cash Accounts")
                    || accountName.get(i).getText().contains("Investment Accounts")
                    || accountName.get(i).getText().contains("Credit Accounts")
                    || accountName.get(i).getText().contains("Loan Accounts")
            )
                accountName.get(i).isDisplayed();
        }
    }
}
