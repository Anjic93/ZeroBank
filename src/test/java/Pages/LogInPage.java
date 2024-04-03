package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogInPage {

    private final WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login")
    public WebElement usernameLoginField;

    @FindBy(id = "user_password")
    public WebElement passwordField;

    @FindBy(id = "user_remember_me")
    public WebElement keepCheckbox;

    @FindBy(name = "submit")
    public WebElement signInButton;

    @FindBy(id = "login_form")
    public List<WebElement> loginForm;


    //-----------------

    public void inputUsername(String userName) {
        usernameLoginField.clear();
        usernameLoginField.sendKeys(userName);
    }

    public void inputPassword(String passWord) {
        passwordField.clear();
        passwordField.sendKeys(passWord);
    }

    public void checkKeepMeSignedInCheckbox() {
        keepCheckbox.click();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void checkErrorMessage() {
        for(int i=0; i<loginForm.size(); i++) {
            if(loginForm.get(i).getText().contains("Login and/or password are wrong")) {
                loginForm.get(i).isDisplayed();
            }
        }
    }

}
