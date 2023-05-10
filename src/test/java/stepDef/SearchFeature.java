package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFeature extends env_target {
    @Given("User is on homepage")
    public void userIsOnHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(shopeeLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("section-banner-hotword--no-skin"))
        );
    }

    @When("User search kaos polos")
    public void userSearchKaosPolos() {
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/header/div[1]/nav/ul/a[3]"));
    }

    @And("User click search button")
    public void userClickSearchButton() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("yup5K8"))
        );
        driver.findElement(By.className("yup5K8")).sendKeys("standard_user");
        driver.findElement(By.className("pDzPRp")).sendKeys("pw123");
    }

    @Then("result kaos polos appear")
    public void resultKaosPolosAppear() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div/div[2]/div[1]"))
        );
        driver.quit();
    }
}
