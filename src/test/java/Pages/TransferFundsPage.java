package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;


public class TransferFundsPage {
    private final WebDriver driver;
    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "board-header")
    public WebElement transferTitle;

    @FindBy(id = "tf_fromAccountId")
    public WebElement fromAccDropMenu;

    @FindBy(id = "tf_toAccountId")
    public WebElement toAccDropMenu;

    @FindBy(id = "tf_amount")
    public WebElement amountField;

    @FindBy(id = "tf_description")
    public WebElement descrField;

    @FindBy(id = "btn_submit")
    public WebElement continueButton;

    @FindBy(css = ".btn.btn-primary")
    public WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    public WebElement successMessage;

    @FindBy(className = "span3")
    public WebElement transAmount;


    //----------------


    public void chooseRandomFromAccountOption() {

        List<WebElement> fromAccOption = fromAccDropMenu.findElements(By.tagName("option"));

            Random r = new Random();
            int value1 = r.nextInt(fromAccOption.size());
            fromAccOption.get(value1).click();
    }


    public boolean isSameFromAssertion() {
        String fromAccDropTitle = fromAccDropMenu.getText();
        Select selectedOption1 = new Select(fromAccDropMenu);
        String selOpt1 = selectedOption1.getFirstSelectedOption().getText();

        return fromAccDropTitle.equalsIgnoreCase(selOpt1);
    }


    public void chooseRandomToAccountOption() {

            List<WebElement> toAccOption = toAccDropMenu.findElements(By.tagName("option"));

            Random rn = new Random();
            int value2 = rn.nextInt(toAccOption.size());
            toAccOption.get(value2).click();
        }



    public boolean isSameToAssertion() {
        String toAccDropTitle = toAccDropMenu.getText();
        Select selectedOption2 = new Select(toAccDropMenu);
        String selOpt2 = selectedOption2.getFirstSelectedOption().getText();

        return toAccDropTitle.equalsIgnoreCase(selOpt2);
    }

    public void insertDesiredAmount(String amount) {
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public void insertDescription(String descr) {
        descrField.clear();
        descrField.sendKeys(descr);
    }

    public void clickOnContinueButton() {
        continueButton.click();

    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

}
