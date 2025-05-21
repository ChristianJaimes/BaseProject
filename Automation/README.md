# automation-java

Proyecto base de automatización web con Java 23, Gradle 8.10, Selenium 4, JUnit 5 y Cucumber.

**Autor:** ChristianJaimes

## Requisitos

- JDK 23 instalado ([descargar](https://jdk.java.net/23/))
- Git
- Chrome/Firefox instalado (para pruebas locales)

## Instalación

```bash
git clone https://github.com/tuusuario/automation-java.git
cd automation-java
./gradlew build
```

## Ejecución de pruebas

- **JUnit 5:**
  ```bash
  ./gradlew test
  ```
- **Cucumber:**
  ```bash
  ./gradlew test --tests "*RunCucumberTest"
  ```

## Modo headless

Agrega el flag `-Dheadless=true` para ejecutar sin interfaz gráfica:
```bash
./gradlew test -Dheadless=true
```

## Ver dependencias

```bash
./gradlew printDeps
```

## Integración continua

El flujo de trabajo de GitHub Actions ejecuta las pruebas automáticamente en cada push.

---
