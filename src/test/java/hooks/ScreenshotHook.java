package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ScreenshotHook {

    @After
    public void addScreenshotAfterScenario(Scenario scenario) {
        /*try {
            WebDriver driver = BaseTest.getDriver();

            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        scenario.getName()
                );
            }
        } catch (Exception e) {
            // do nothing – screenshot failure should not fail scenario
            e.printStackTrace();
        }*/
    }
}
