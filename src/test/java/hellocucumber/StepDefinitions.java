package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static hellocucumber.Hooks.getDriver;

public class StepDefinitions {

    private final WebDriver driver = getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");

        System.out.println("STEP 1 - I am on the login page");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        System.out.println("STEP 2 - I enter username and password");

    }

    @When("I enter locked username")
    public void i_enter_locked_out_username(){
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @When("I enter valid password")
    public void i_enter_valid_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("error message should be shown")
    public void error_message_shown(){
        driver.findElement(By.xpath("//*[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]"));

        System.out.println("----Error is shown");
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        driver.findElement(By.id("login-button")).click();

        System.out.println("STEP 3  - The login button is clicked");
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        driver.findElement(By.id("shopping_cart_container"));

        System.out.println("STEP 4 - I am logged into the system");
    }
}
