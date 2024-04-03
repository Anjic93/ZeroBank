package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "signin_button")
    public WebElement signInButton;

    @FindBy(className = "icon-user")
    public WebElement usernameIcon;

    @FindBy(className = "icon-user")
    public WebElement usernameButton;

    @FindBy(id = "logout_link")
    public WebElement logoutButton;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingButton;

    @FindBy(id = "feedback")
    public WebElement feedbackButton;




    //-------------------------------

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickOnUsernameButton() {
        usernameButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }


    public void clickOnOnlineBankingButton() {
        onlineBankingButton.click();
    }

    public void clickOnFeedbackButton() {
        feedbackButton.click();
    }
}


