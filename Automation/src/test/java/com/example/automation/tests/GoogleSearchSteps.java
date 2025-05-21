/*
 * GoogleSearchSteps.java
 * Definición de pasos Cucumber para búsqueda en Google.
 * Autor: ChristianJaimes
 */
package com.example.automation.tests;

import com.example.automation.pages.GoogleSearchPage;
import com.example.automation.support.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchSteps extends BaseTest {
    private GoogleSearchPage google;
    private String firstUrl;

    @Before
    public void setUpScenario() {
        super.setUp();
        google = new GoogleSearchPage(driver);
    }

    @After
    public void tearDownScenario() {
        super.tearDown();
    }

    @Given("abro Google")
    public void abro_google() {
        google.open();
    }

    @When("busco {string}")
    public void busco(String query) {
        google.search(query);
    }

    @Then("el primer resultado contiene {string}")
    public void el_primer_resultado_contiene(String texto) {
        firstUrl = google.getFirstResultUrl();
        assertTrue(firstUrl.contains(texto),
                "El primer resultado debe contener '" + texto + "', pero fue: " + firstUrl);
    }
}
