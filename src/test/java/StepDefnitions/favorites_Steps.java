package StepDefnitions;

import Pages.LoginPage;
import Pages.SearchPage;
import Pages.favoritespage;
import Utils.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class favorites_Steps extends BaseTest{
	private static boolean searchfeatureInitialized = false;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private favoritespage favPage;

    @Before("@favorites")
    public void beforeScenario() {
        if (!searchfeatureInitialized) {
            setup(); // thread-local idempotent driver creation
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());
            favPage = new favoritespage(getDriver());

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

@Given("I have login tO the sYstem")
public void i_have_login_t_o_the_s_ystem() {
	System.out.println("Already logged in for the test session.");
}

@When("I search {string} tire in the sEarch bar")
public void i_search_70r13_tire_in_the_search_bar(String tire) throws InterruptedException {
	searchPage.search(tire);
	searchPage.clicksearch();
}
@When("I add the first tire of search result to my favourites")
public void i_add_the_first_tire_of_search_result_to_my_favourites() {
	favPage.faviconclick1();   
}

@When("I go to favourites page")
public void i_go_to_favourites_page() {
	favPage.redirectfavorites();
}

@Then("I should see {string} sku code tire on the favourites page")
public void i_should_see_70r13_sku_code_tire_on_the_favourites_page(String tire) {
	favPage.verify(tire);  
	tearDown();
}

}
