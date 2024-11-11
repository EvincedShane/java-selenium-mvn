
// import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.junit.jupiter.api.Assertions;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Evinced-specific imports
import com.evinced.EvincedSDK;
import com.evinced.EvincedWebDriver;
import com.evinced.dto.configuration.EvincedConfiguration;
import com.evinced.dto.results.Report;
import com.evinced.EvincedReporter;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class EvincedTest {
    ChromeDriver driver;
    EvincedWebDriver evincedDriver;

    @BeforeEach
    public void setupAll() {
        EvincedConfiguration config = new EvincedConfiguration();
        config.setEnableScreenshots(true);
        Map<String, Boolean> toggles = new HashMap<String, Boolean>() {
            {
                put("WAIT_FOR_ANIMATIONS", true);

            }
        };
        config.setExperimentalFlags(toggles);
        evincedDriver = new EvincedWebDriver(new ChromeDriver(), config);
        EvincedSDK.setCredentials(System.getenv("EVINCED_SERVICE_ID"), System.getenv("EVINCED_API_KEY"));

        evincedDriver.evStart();
    }

    @AfterEach
    public void teardownDrivers() {
        Report report = evincedDriver.evStop();
        EvincedReporter.evSaveFile("test-result", report, EvincedReporter.FileFormat.HTML);

        evincedDriver.quit();
    }

    @Test
    public void evAnalyzeSaveReport() throws Exception {
        // EvincedWebDriver evincedDriver = new EvincedWebDriver(driver);
        // EvincedSDK.setCredentials(System.getenv("EVINCED_SERVICE_ID"),
        // System.getenv("EVINCED_API_KEY"));

        // Navigate to the site under test
        evincedDriver.get("");

        WebElement p = evincedDriver.findElement(By.id(""));
        p.click();

        WebElement userName = evincedDriver.findElement((By.id("")));
        userName.click();
        userName.sendKeys("");

        WebElement password = evincedDriver.findElement((By.id("")));
        password.click();
        password.sendKeys("");

        WebElement loginButton = evincedDriver.findElement((By.id("")));
        loginButton.click();

        Thread.sleep(3000);

        WebElement courseButton = evincedDriver.findElement(By.xpath(
                ""));
        courseButton.click();

        Thread.sleep(7000);

        WebElement continueCourse = evincedDriver
                .findElement(By.xpath(""));
        continueCourse.click();

        Thread.sleep(10000);

        // Run analysis and get the accessibility report
        // Report report = evincedDriver.evAnalyze();
        // System.out.println("evAnalyze found issues: " + report);

        // EvincedReporter.evSaveFile("htmlReport", report,
        // EvincedReporter.FileFormat.HTML);

        // Assert that there are no accessibility issues
        // assertTrue(report.getIssues().size() != 0);
    }

}
