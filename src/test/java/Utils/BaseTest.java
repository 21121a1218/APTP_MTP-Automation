package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setup() {
        if (driver.get() == null) {   // prevents multiple browsers

            ChromeOptions options = new ChromeOptions();

            // ---- CI / GitHub Actions REQUIRED OPTIONS ----
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            // ------------------------------------------------

            WebDriver drv = new ChromeDriver(options);
            drv.manage().window().maximize(); // kept as-is
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
