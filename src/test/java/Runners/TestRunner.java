package Runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/Features/accountsummarypage.feature",
                /*"src/test/resources/Features/cartpage.feature",
                "src/test/resources/Features/creditpage.feature",
                "src/test/resources/Features/favorites.feature",
                "src/test/resources/Features/featuresandbenfits.feature",
                "src/test/resources/Features/inventory_visibility.feature",
                "src/test/resources/Features/invoices.feature",
                "src/test/resources/Features/login.feature",
                "src/test/resources/Features/logout.feature",
                "src/test/resources/Features/orderhistorypage.feature",
                "src/test/resources/Features/PaymentHistory.feature",
                "src/test/resources/Features/PLPOrder.feature",
                "src/test/resources/Features/Resendotp.feature",
                "src/test/resources/Features/Search.feature"*/
        },
        glue = {
                "StepDefnitions",
                "hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests { 
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
