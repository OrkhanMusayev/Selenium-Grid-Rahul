package SeleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Remotetest {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        // DesiredCapabilities
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        URL url = new URL("http://localhost:4445/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, dc);
        // code above is basically set up RemoteWebDriver (accept 2 parameter(IP and object))
        driver.get("http://www.google.com");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("google"));
        driver.close();
        driver.quit();

    }
}
