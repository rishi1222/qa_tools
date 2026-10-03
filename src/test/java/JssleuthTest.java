import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by kaporis on 19/02/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber", "json:target/cucumber-reports/cucumber.json"}
)
public class JssleuthTest {

}


