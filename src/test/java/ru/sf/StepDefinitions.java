package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final ChooseCityPage chooseCityPage;
    public static final CityMenuPage cityMenuPage;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\Education\\Testing\\CucumberTask\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseCityPage = new ChooseCityPage(webDriver);
        cityMenuPage = new CityMenuPage(webDriver);
    }

    @Given("url of restaurant {string}")
    public void urlOfRestaurantHttpsDodopizzaRu(String url) {
        chooseCityPage.go(url);
    }

    @Then("chose city {string}")
    public void choseCityDomodedovo(String city) {
        chooseCityPage.searchCity(city);
    }

    @And("assert that chosen city is {string}")
    public void assertThatChosenCityIsDomodedovo(String expectedCity) {
        final var currentActiveCity = cityMenuPage.getCurrentActiveCity();
        assertEquals(expectedCity, currentActiveCity);
    }

    @Then("chose element enter")
    public void choseElementEnter() {
        cityMenuPage.enterButton();
    }

    @Then("enter login {string}")
    public void enterLogin(String login) {
        cityMenuPage.enterLoginCab(login);
    }

    @Then("enter password {string}")
    public void enterPasswordTest(String password) {
        cityMenuPage.enterPassCab(password);
    }

    @And("assertThatUserGotMessageWrongPass {string}")
    public void assertthatusergotmessagewrongpass(String errorMessage) {
        final var cityNotFoundMessage = cityMenuPage.getUserNotFoundMessage();
        assertEquals(errorMessage, cityNotFoundMessage);
    }

}
