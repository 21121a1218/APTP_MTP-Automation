package StepDefnitions;

import org.testng.Assert;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.PLPOrderprocess;
import Pages.SearchPage;
import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends BaseTest {

    private SearchPage searchPage;
    private LoginPage loginPage;
    private PLPOrderprocess plp;
    private CartPage cartPage;
    
    private static boolean cartpagefeatureInitialized = false;
    @Before("@cart")
    public void beforeScenario() {
        
        // Run only once per feature file
        if (!cartpagefeatureInitialized) {

            setup();  // open browser ONCE
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            plp = new PLPOrderprocess(getDriver());
            searchPage =new SearchPage(getDriver());
            cartPage =new CartPage(getDriver());

            // Login once per feature
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            cartpagefeatureInitialized = true;
            System.out.println("Login done once for this feature.");
        }
        else {
            // Already logged in and browser exists
            loginPage = new LoginPage(getDriver());
            plp = new PLPOrderprocess(getDriver());
            searchPage =new SearchPage(getDriver());
            cartPage =new CartPage(getDriver());
            System.out.println("Reusing existing browser session.");
        }
    }
    @After("@cart")
    public void closingafterFeature() {
        System.out.println("Closing browser for ORDER feature...");
        BaseTest.tearDown();
        cartpagefeatureInitialized = false;
    }

    // ------------------ STEPS ----------------------

    @Given("I have login to the syStEm")
    public void i_have_login_to_th_e_system() {
        System.out.println("Already logged in.");
    }
    @When("I search {string} tire in the search bar")
    public void i_navigate_to_the_product_listing_page_plp(String tire) throws InterruptedException {
        plp.search(tire);
    }
    @And("I press ENTER key to search")
    public void i_press_enter_key_to_search()
    {
    	searchPage.clicksearch();
    }
    @And("I add the first tire of search result to the cart")
    public void i_add_the_first_tire_of_search_result_to_the_cart() throws InterruptedException
    {  
    	Thread.sleep(3000);
    	plp.addtocart();
    }
    @And("I go to cart page")
    public void i_go_toCart()
    {
    	plp.viewcartbutton();
    }
    @Then("I should see {string} sku code tire on the cart page")
    public void i_should_see_sku_code_on_the_cart(String expectedSku)
    {
    	String actualFirstSku = cartPage.cartpageValidation();
        Assert.assertTrue(
                actualFirstSku != null && actualFirstSku.contains(expectedSku),
                "Expected SKU: '" + expectedSku + "' but got: '" + actualFirstSku + "'"
        );	
        tearDown();
    }
    
}
