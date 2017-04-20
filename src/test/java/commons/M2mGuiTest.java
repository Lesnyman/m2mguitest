package commons; /**
 * Created by Lesnyman on 2017-04-20.
 */

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class M2mGuiTest {
    public final String pathToGecko = System.getProperty("user.dir") + "/dependencies/geckodriver.exe";
    public final String pathToChrome = System.getProperty("user.dir") + "/dependencies/chromedriver.exe";
    public Logger logger = Logger.getLogger(M2mGuiTest.class);
    public WebDriver driver;

    public M2mGuiTest() {
        System.setProperty("webdriver.gecko.driver", pathToGecko);
        System.setProperty("webdriver.chrome.driver", pathToChrome);

        driver = new ChromeDriver();
    }

    @After
    public void closeAll() {
        driver.quit();
    }

    static File junitReport;
    static BufferedWriter junitWriter;

    @BeforeClass
    public static void setUp() throws IOException {

        String junitReportFile = System.getProperty("user.dir")
                + "/target/junitReportFile.html";
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date = new Date();
        junitReport = new File(junitReportFile);
        junitWriter = new BufferedWriter(new FileWriter(junitReport, true));
        junitWriter.write("<html><body>");
        junitWriter.write("<h1>Test Execution Summary - " + dateFormat.format(date)
                + "</h1>");

    }

    @AfterClass
    public static void tearDown() throws IOException {

        junitWriter.write("</body></html>");
        junitWriter.close();

    }

    @Rule
    public TestRule watchman = new TestWatcher() {

        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            try {
                junitWriter.write(description.getDisplayName() + " "
                        + "success!");
                junitWriter.write("<br/>");
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                junitWriter.write(description.getDisplayName() + " "
                        + e.getClass().getSimpleName());
                junitWriter.write("<br/>");
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    };
}
