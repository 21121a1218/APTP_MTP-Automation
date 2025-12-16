package StepDefnitions;

import org.testng.Assert;

import Pages.CreditPage;
import Pages.LoginPage;
import Pages.SearchPage;
import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class SearchSteps extends BaseTest {
	private static boolean searchfeatureInitialized = false;
    private LoginPage loginPage;
    private SearchPage searchPage;

    @Before("@search")
    public void beforeScenario() {
        if (!searchfeatureInitialized) {
            setup(); // thread-local idempotent driver creation
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());

            // perform login once
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            searchfeatureInitialized = true;
            System.out.println("SearchSteps: logged in for feature");
        } else {
            // reuse existing browser/session
            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());
            System.out.println("SearchSteps: reusing browser session");
        }
    }    
    @Given("I have login to the System")
    public void i_have_login_to_th_E_system() {
        System.out.println("Already logged in for the test session.");
    }

    @When("I search {string} in the search bar")
    public void i_search_in_the_search_bar(String input) throws InterruptedException {
        // The SearchPage.search method should handle entering text (and not pressing Enter)
        searchPage.search(input);
    }

    @When("I press ENTER key")
    public void i_press_enter_key() {
        // The SearchPage.clicksearch method should actually perform the Enter/click action
        searchPage.clicksearch();
    }

    @Then("the first tire sku should be {string}")
    public void the_first_tire_sku_should_be(String expectedSku) throws InterruptedException {
    	Thread.sleep(3000);
        String actualFirstSku = searchPage.plpproductname();
        Assert.assertNotNull(actualFirstSku, "First product name/SKU was null");
        Assert.assertTrue(
            actualFirstSku.contains(expectedSku),
            String.format("Expected SKU '%s' to be contained in actual '%s'", expectedSku, actualFirstSku)
        );
    }

    @Then("the first tire name should contain {string}")
    public void the_first_tire_name_should_contain(String expectedText) throws InterruptedException {
        String actualFirstName = searchPage.plpproductname();
        Assert.assertNotNull(actualFirstName, "First product name was null");
        Assert.assertTrue(
            actualFirstName.contains(expectedText),
            String.format("Expected product name to contain '%s' but got '%s'", expectedText, actualFirstName)
        );
    }

    @Then("results should be displayed")
    public void results_should_be_displayed() {
        Assert.assertTrue(searchPage.resultsExist(), "Expected results to be displayed but none found");
    }

    @When("I click grid view button")
    public void i_click_gridview() {
        searchPage.gridView();
    }

    @Then("the search results should be in grid view")
    public void the_search_results_should_be_in_grid_view() throws InterruptedException {
        Assert.assertTrue(searchPage.gridviewenabled(), "Expected grid view to be enabled");
        Thread.sleep(2000);
        tearDown();
    }
}
