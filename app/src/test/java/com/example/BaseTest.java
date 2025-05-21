package test.java.com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Clase base para todas las pruebas.
 *  - Inicializa y cierra el WebDriver.
 *  - Soporta modo headless mediante -Dheadless=true.
 *  - Configura un timeout implícito de 10 s.
 *
 * Ejecuta tus tests extendiendo esta clase:
 *   class GoogleTest extends BaseTest { ... }
 */
public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        // 1. Configura y descarga el driver adecuado
        WebDriverManager.chromedriver().setup();

        // 2. Opciones de navegador (headless opcional)
        ChromeOptions options = new ChromeOptions();
        if (Boolean.getBoolean("headless")) {
            // --headless=new es la bandera recomendada desde Chrome 109
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");

        // 3. Instancia del driver
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
