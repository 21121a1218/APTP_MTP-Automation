package StepDefnitions;

import org.testng.Assert;

import Pages.Featuresandbenfitspage;
import Pages.LoginPage;
import Pages.SearchPage;
import Utils.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class featuresandbenfitsSteps extends BaseTest{

    private static boolean benfitsfeatureInitialized = false;

    private SearchPage searchPage;
    private LoginPage loginPage;
    private  Featuresandbenfitspage benfitsPage;
   

    @Before("@features")
    public void beforeScenario() {
        
        // Run only once per feature file
        if (!benfitsfeatureInitialized) {

            setup();  // open browser ONCE
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());
            benfitsPage  = new Featuresandbenfitspage(getDriver());

            // Login once per feature
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            benfitsfeatureInitialized = true;
            System.out.println("Login done once for this feature.");
        }
        else {
            // Already logged in and browser exists
            loginPage = new LoginPage(getDriver());
            searchPage = new SearchPage(getDriver());
            benfitsPage  = new Featuresandbenfitspage(getDriver());
            System.out.println("Reusing existing browser session.");
        }
    }

    // ------------------ STEPS ----------------------

    @Given("I hAVe login to the systeM")
    public void i_have_login_to_th_e_system() {
        System.out.println("Already logged in.");
    }
    @When("I searCh {string} tire in the search bar")
    public void i_sear_ch_tire_in_the_search_bar(String tire) throws InterruptedException {
    	searchPage.search(tire);
    	searchPage.clicksearch();
    }

    @When("I click the first tire of search result")
    public void i_click_the_first_tire_of_search_result() {
        searchPage.clickontire();
    }

    @When("I click Features & Benefits button")
    public void i_click_features_benefits_button() throws InterruptedException {
    	Thread.sleep(2000);
    	benfitsPage.featureopen();
    }

    @Then("I should see tires features and benefits contents on the page")
    public void i_should_see_tires_features_and_benefits_contents_on_the_page() {
        Assert.assertTrue(benfitsPage.verifyfeatures(), "No Features Displayed");
        tearDown();
    }


}
