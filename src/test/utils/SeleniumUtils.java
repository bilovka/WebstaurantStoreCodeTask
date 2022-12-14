package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class SeleniumUtils {
    public WebDriver driver;
    public String configFilePath = "src/test/utils/config.properties";

    @BeforeTest
    public void getPageFactory() {
        //initializing WebDriver with the browser we put in .properties
        initializeDriver(ConfigReader.readProperty(configFilePath, "browser"));
        //starting the browser with the url we put in .properties
        driver.get(ConfigReader.readProperty(configFilePath, "url"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void initializeDriver(String browser) {
        //creating and initialize local WebDriver
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            //here we could write cases for other browsers
            default:
                System.out.println("This program is intended to execute only in Chrome");
        }
        //maximizing the window
        driver.manage().window().maximize();
        //adding global wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
