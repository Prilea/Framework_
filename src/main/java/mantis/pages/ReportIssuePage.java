package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ReportIssuePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "input[name=summary]")
    private WebElement summary;
    @FindBy (css = "textarea[name=description]")
    private WebElement description;
    @FindBy (xpath = "//*[@value='Submit Issue']")
    private WebElement submitIssue;


    public void createIssue (String summaryString, String descriptionString) {
       summary.sendKeys(summaryString);
       description.sendKeys(descriptionString);
    }

    public void createIssueButton() {
        submitIssue.click();
    }

}
