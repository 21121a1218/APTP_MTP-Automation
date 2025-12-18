package Utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final boolean IS_CI =
            System.getenv("GITHUB_ACTIONS") != null;

    public static void setup() {
        if (driver.get() == null) {   // prevents multiple browsers

            ChromeOptions options = new ChromeOptions();

            if (IS_CI) {
                // ---- CI / GitHub Actions REQUIRED OPTIONS ----
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--force-device-scale-factor=1");
                options.addArguments("--disable-notifications");
            }
            // ------------------------------------------------

            WebDriver drv = new ChromeDriver(options);

            if (!IS_CI) {
                drv.manage().window().maximize(); // keep local behavior
            }

            drv.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            drv.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

            driver.set(drv);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openUrl(String url) {
        getDriver().get(url);
        waitForPageStable();
        disableAnimationsIfCI();
    }

    private static void waitForPageStable() {
        if (IS_CI) {
            new WebDriverWait(getDriver(), Duration.ofSeconds(30))
                .until(d ->
                    ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
                );
        }
    }

    private static void disableAnimationsIfCI() {
        if (IS_CI) {
            ((JavascriptExecutor) getDriver()).executeScript(
                "var css='*{animation:none!important;transition:none!important;}';" +
                "var style=document.createElement('style');" +
                "style.appendChild(document.createTextNode(css));" +
                "document.head.appendChild(style);"
            );
        }
    }

    public static void tearDown() {
        if (driver.get() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
