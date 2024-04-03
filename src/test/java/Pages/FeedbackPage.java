package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage {
    private final WebDriver driver;
    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "feedback-title")
    public WebElement feedbackPageTitle;



    //------------------

    public void assertFeedbackTitle() {
        feedbackPageTitle.isDisplayed();
    }
}
