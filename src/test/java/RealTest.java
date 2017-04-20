import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Lesnyman on 2017-04-20.
 */
public class RealTest extends M2mGuiTest{
    public RealTest(){
        super();
    }

    @Test
    public void PierwszyTest(){
        driver.navigate().to("http://google.com");
        logger.warn("Warning zalogowany");
        logger.error("Error");
        logger.info("cokolwiek");
        driver.close();
    }

}
