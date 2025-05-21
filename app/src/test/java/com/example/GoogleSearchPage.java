package test.java.com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object Model para la búsqueda de Google.
 */
public class GoogleSearchPage {
    private WebDriver driver;
    private By searchBox = By.name("q");
    private By results = By.id("search");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search(String query) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(query);
        box.sendKeys(Keys.RETURN);
    }

    public boolean resultsAreDisplayed() {
        // Google puede mostrar un iframe de consentimiento en la UE, lo ignoramos para pruebas básicas
        try {
            driver.switchTo().defaultContent();
        } catch (Exception ignored) {}
        return driver.findElements(results).size() > 0;
    }
}
