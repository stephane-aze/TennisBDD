import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        glue = {"com.esgi.bddtennis"},
        tags = {"~@wip"}
)
public class RunFeatureTest {

}