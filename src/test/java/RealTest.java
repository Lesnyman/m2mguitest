import commons.M2mGuiTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Lesnyman on 2017-04-20.
 */
public class RealTest extends M2mGuiTest {
    public RealTest(){
        super();
    }

    @Test
    public void PierwszyTest(){
        driver.navigate().to("http://google.com");
        logger.warn("PierwszyTest");
        assertTrue(1 < 2);
    }

    @Test
    public void DrugiTest(){
        logger.warn("DrugiTest");
        assertTrue(2 > 1);

    }

    @Test
    public void TrzeciTest(){
        logger.warn("TrzeciTest");
        assertTrue(1 < 2);
    }

}
