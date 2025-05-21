package test.java.com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/example/GoogleSearch.feature",
    glue = "test.java.com.example"
)
public class RunCucumberTest {
}
