/**
 * Created by Lesnyman on 2017-04-20.
 */
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.*;

public class M2mGuiTest {
    public final String pathToGecko = System.getProperty("user.dir") + "/dependencies/geckodriver.exe";
    public Logger logger = Logger.getLogger(M2mGuiTest.class);
    public WebDriver driver;
    public M2mGuiTest(){
        System.setProperty("webdriver.gecko.driver", pathToGecko);
        driver = new FirefoxDriver();
    }
}
