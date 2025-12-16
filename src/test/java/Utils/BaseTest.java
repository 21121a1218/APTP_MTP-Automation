package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setup() {
        if (driver.get() == null) {   // prevents multiple browsers
            WebDriver drv = new ChromeDriver();
            drv.manage().window().maximize();
            driver.set(drv);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openUrl(String url) {
        getDriver().get(url);
    }

    public static void tearDown() {
        if (driver.get() != null) {
            getDriver().quit();
           driver.remove();
        }
    }
}
