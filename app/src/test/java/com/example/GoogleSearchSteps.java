package test.java.com.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class GoogleSearchSteps {
    private WebDriver driver;
    private GoogleSearchPage googlePage;

    @Before
    public void setUp() {
        BaseTest base = new BaseTest() {};
        base.setUp();
        this.driver = base.driver;
        this.googlePage = new GoogleSearchPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Given("que abro Google")
    public void que_abro_google() {
        googlePage.open();
    }

    @When("busco {string}")
    public void busco(String query) {
        googlePage.search(query);
    }

    @Then("veo resultados relacionados")
    public void veo_resultados_relacionados() {
        assertTrue("No se muestran resultados", googlePage.resultsAreDisplayed());
    }
}
