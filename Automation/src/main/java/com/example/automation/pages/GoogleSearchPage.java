/*
 * GoogleSearchPage.java
 * Page Object Model para la página de búsqueda de Google.
 * Autor: ChristianJaimes
 */
package com.example.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private final WebDriver driver;
    private final By searchBox = By.name("q");
    private final By results = By.cssSelector("div#search a");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.google.com/");
    }

    public void search(String query) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(query);
        box.sendKeys(Keys.RETURN);
    }

    public String getFirstResultUrl() {
        return driver.findElements(results)
                .stream()
                .findFirst()
                .map(e -> e.getAttribute("href"))
                .orElse("");
    }
}
