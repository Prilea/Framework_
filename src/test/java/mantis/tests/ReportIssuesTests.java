package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ReportIssuesTests extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void createIssues() throws InterruptedException {

        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        String currentUserName = mantisSite.getMainPage().getUserName();
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(currentUserName).isEqualTo("admin");

        mantisSite.getMainPage().goToReportIssuePage();
        Thread.sleep(3000);
        mantisSite.getReportIssuePage().createIssue("Summary", "Description");
        mantisSite.getReportIssuePage().createIssueButton();

        mantisSite.getMainPage().goToViewIssuesPage();


        mantisSite.getViewIssuesPage().openCreatedIssue();
        String currentId = mantisSite.getViewIssuesPage().idValueText();

        softAssert.assertThat(mantisSite.getViewIssuesPage().summaryIdText()).isEqualTo("mantisSite.getReportIssuePage().idValueText():" + "mantisSite.getReportIssuePage().summaryValueText()");
        Thread.sleep(3000);
        mantisSite.getViewIssuesPage().delete();
        Thread.sleep(3000);
        mantisSite.getViewIssuesPage().deleteIssue();
        Thread.sleep(3000);

        mantisSite.getViewIssuesPage().searchFieldType();
        softAssert.assertThat(mantisSite.getMainPage().errorNumber()).isEqualTo("APPLICATION ERROR #1100");
        softAssert.assertThat(mantisSite.getMainPage().errorText()).isEqualTo("Issue " + currentId + " not found.");





    }
}
