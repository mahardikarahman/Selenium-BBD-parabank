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

public class Location extends env_target {
    @Given("User on homepage")
    public void userOnHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(parabankLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[5]/a"))
        );
    }

    @When("User click location button")
    public void userClickLocationButton() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[5]/a")).click();
    }

    @Then("User will be allocate to menu location")
    public void userWillBeAllocateToMenuLocation() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div[2]/div/div/div/div/div/h1"))
        );
        driver.quit();
    }
}
