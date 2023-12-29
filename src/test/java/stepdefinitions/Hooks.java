package hooks;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.TestBase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
public class Hooks extends TestBase {
@BeforeAll
public static void setUp(){
        launchBrowser(BrowserType.CHROME);
        navigateToBackEnd();
    }




    @AfterAll
    public static void tearDown(){
        teardown();
    }


}
