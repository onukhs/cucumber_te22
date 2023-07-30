package hellocucumber;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    private static WebDriver driver;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();

        System.out.println("INFO: Browser is setup");
    }

    @After
    public static void tearDown() {
        driver.close();
        driver.quit();

        System.out.println("INFO: Browser is shut down");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
