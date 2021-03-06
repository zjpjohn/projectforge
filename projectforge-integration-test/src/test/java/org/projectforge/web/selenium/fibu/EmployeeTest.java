package org.projectforge.web.selenium.fibu;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.InvalidSelectorException;
import org.projectforge.web.selenium.Const;
import org.projectforge.web.selenium.login.SeleniumLoginPage;
import org.projectforge.web.selenium.SeleniumSuiteTestBase;
import org.projectforge.web.selenium.TestPageBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest extends SeleniumSuiteTestBase
{

  @BeforeMethod
  public void createAdminEmployee() {

    new SeleniumLoginPage()
        .callPage()
        .loginAsAdmin();
    boolean caughtException = false;
    SeleniumEmployeeListPage seleniumEmployeeListPage = new SeleniumEmployeeListPage();

    try {
      seleniumEmployeeListPage
          .callPage()
          .clickRowWhereColumnLike("Administrator");
    } catch (Exception e) {
      caughtException = true;
    }

    if (caughtException == true) {
      seleniumEmployeeListPage
          .addEntry()
          .callPage()
          .setKost1("3.000.00.00")
          .setStatus(SeleniumEmployeeEditPage.status_FEST_ANGESTELLTER)
          .setAssociatedUsername(Const.ADMIN_USERNAME)
          .setGender(SeleniumEmployeeEditPage.gender_MALE)
          .setStaffNumber("1234")
          .setPayeTaxNumber("abc")
          .clickCreateOrUpdate();
    }

    new SeleniumLoginPage().logout();

  }

  @Test
  public void testRequiredBankingDetails()
  {
    new SeleniumLoginPage()
        .callPage()
        .loginAsAdmin();

    SeleniumEmployeeListPage seleniumEmployeeListPage = new SeleniumEmployeeListPage();

    try {
      seleniumEmployeeListPage
          .callPage()
          .clickRowWhereColumnLike("Administrator");
    } catch (InvalidSelectorException e) {
      // if this happens nothing has to be done
    }

    String currentUrl = TestPageBase.getDriver().getCurrentUrl();
    assertTrue(currentUrl.contains("employeeEdit"));
    String employeeId = currentUrl.split("id=")[1];

    new SeleniumEmployeeEditPage(Integer.parseInt(employeeId))
        .callPage()

        .setAssociatedUsername("admin")
        .setKost1("3.000.00.00")
        .setStatus(SeleniumEmployeeEditPage.status_FEST_ANGESTELLTER)
        .setGender(SeleniumEmployeeEditPage.gender_NOT_KNOWN)

        // wrong input, we should stay on this page
        .setAccountHolder("Konto Vollmacht")
        .setIban("")
        .clickCreateOrUpdate()
        .assertWeAreOnThisPage()

        // wrong input, we should stay on this page
        .setAccountHolder("")
        .setIban("dfgdfgdfgdfgdf")
        .clickCreateOrUpdate()
        .assertWeAreOnThisPage()

        // correct input, we should go to list page
        .setAccountHolder("fgdfgdfgdfgdfg")
        .setIban("hmhvngfdfgdfg")
        .clickCreateOrUpdate();

    seleniumEmployeeListPage.assertWeAreOnThisPage();
  }

  @Test
  public void testStaffNumber()
  {
    new SeleniumLoginPage()
        .callPage()
        .loginAsAdmin();

    new SeleniumEmployeeListPage()
        .callPage()
        .clickRowWhereColumnLike("Administrator");

    String currentUrl = TestPageBase.getDriver().getCurrentUrl();
    assertTrue(currentUrl.contains("employeeEdit"));
    String employeeId = currentUrl.split("id=")[1];

    new SeleniumEmployeeEditPage(Integer.parseInt(employeeId))
        .callPage()

        // wrong input, we should stay on this page
        .setStaffNumber("asd 123")
        .clickCreateOrUpdate()
        .assertWeAreOnThisPage()

        // wrong input, we should stay on this page
        .setStaffNumber("asd.123")
        .clickCreateOrUpdate()
        .assertWeAreOnThisPage()

        // wrong input, we should stay on this page
        .setStaffNumber("asd-123")
        .clickCreateOrUpdate()
        .assertWeAreOnThisPage()

        // correct input, we should go to list page
        .setStaffNumber("asd123")
        .clickCreateOrUpdate();

    new SeleniumEmployeeListPage().assertWeAreOnThisPage();

  }

}
