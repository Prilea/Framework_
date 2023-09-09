package mantis.pages;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;
    @FindBy (css = "#buglist > tbody > tr:nth-child(1) > td:nth-child(4) > a")
    private WebElement createdIssueLink;
    public String createdIdText() {
        return createdIssueLink.getText();
    }

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }
    public int countIssues() {
        return issues.size();
    }
    public void openCreatedIssue() {

        createdIssueLink.click();
    }
    public void checkIdAndSummary() {
        String idText = createdIssueLink.getText();
    }

    @FindBy (css = "input[value=Delete]")
    private WebElement deleteButton;
    public void delete() {
        deleteButton.click();
    }
    @FindBy (xpath = "//input[@value='Delete Issues']")
    private WebElement deleteIssueButton;
    public void deleteIssue() {
        deleteIssueButton.click();
    }

    @FindBy (xpath = "//td[@class='column-summary']")
    private WebElement columnSummaryGetText;
    public String columnSummaryText() {
        return columnSummaryGetText.getText();
    }

    @FindBy (css = "td.bug-summary")
    private WebElement getSummaryAndIdText;
    public String summaryIdText() {
        return getSummaryAndIdText.getText();
    }

    @FindBy (css = "td.bug-id")
    private WebElement idValue;
    public String idValueText() {
        return idValue.getText();
    }
    @FindBy (css = "input[name=\"bug_id\"]")
    private WebElement search;
    public void searchFieldType(String currentId) {
        search.sendKeys(currentId);
        search.sendKeys(Keys.ENTER);
    }

}
