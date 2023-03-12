package base;

import Util.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties pro;

    public static WebDriverWait wait;
    public static Actions actions;

    public BaseTest() throws IOException {

        pro =new Properties();
        FileInputStream fis = new FileInputStream("F:\\Town_Team_Web\\src\\main\\java\\Config\\config.properties");
        pro.load(fis);
    }

    @Parameters({"browser"})
    @BeforeMethod(groups = {"E2E"})
    public void setUp(String browser){

        if (browser.equalsIgnoreCase("chrome")){
                    WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("edge")){
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox")){
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
        }
  /*      ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
*/

            driver.manage().window().maximize();
            driver.get(pro.getProperty("URL"));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            wait=new WebDriverWait(driver,20);
            actions = new Actions(driver);
    }

    @AfterMethod(groups = {"E2E"})
    public void tearDown() throws InterruptedException {
        driver.quit();
    }


}

