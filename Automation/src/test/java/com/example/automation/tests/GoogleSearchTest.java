/*
 * GoogleSearchTest.java
 * Prueba JUnit 5: verifica que el primer resultado de Google contenga "selenium.dev".
 * Autor: ChristianJaimes
 */
package com.example.automation.tests;

import com.example.automation.pages.GoogleSearchPage;
import com.example.automation.support.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest extends BaseTest {

    @Test
    void primerResultadoContieneSeleniumDev() {
        GoogleSearchPage google = new GoogleSearchPage(driver);
        google.open();
        google.search("selenium");
        String firstUrl = google.getFirstResultUrl();
        assertTrue(firstUrl.contains("selenium.dev"),
                "El primer resultado debe contener 'selenium.dev', pero fue: " + firstUrl);
    }
}
