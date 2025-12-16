package StepDefnitions;

import org.testng.Assert;

import Pages.LoginPage;
import Pages.SearchPage;
import Utils.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Inventory_InfoSteps extends BaseTest{
	private static boolean inventoryfeatureInitialized = false;
    private LoginPage loginPage;
    private SearchPage searchPage;
	
	@Before("@inventory")
    public void beforeScenario() {
        if (!inventoryfeatureInitialized) {
            setup(); // thread-local idempotent driver creation
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());

            // perform login once
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            inventoryfeatureInitialized = true;
            System.out.println("SearchSteps: logged in for feature");
        } else {
            // reuse existing browser/session
            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());
            System.out.println("SearchSteps: reusing browser session");
        }
    } 
	
	
	@Given("I havE login to the sysTEm")
	public void i_hav_e_login_to_the_sys_t_em() {
		System.out.println("Already logged in for the test session.");
	}

	@When("I search {string} tire in the Search bar")
	public void i_search_tire_in_the_search_bar(String tire) throws InterruptedException {
		searchPage.search(tire);
	}

	@When("I press ENTER kEy to search")
	public void i_press_enter_k_ey_to_search() {
		searchPage.clicksearch();
	}

	@Then("I should see the inventory information of tires either Stock Available or No Stock")
	public void i_should_see_the_inventory_information_of_tires_either_stock_available_or_no_stock() {	
		Assert.assertTrue(searchPage.stockinfo(), "No Info");
		tearDown();
	}

}
