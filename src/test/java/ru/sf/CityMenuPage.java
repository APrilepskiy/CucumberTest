package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public record CityMenuPage(WebDriver webDriver) {

    private static final String ENTER_BUTTON_XPATH = "//*[@id=\"header\"]/div[1]/div/div/div[3]/div/div/button/div/span";
    private final static String ACTIVE_CITY_SPAN_XPATH = "//*[@id=\"header\"]/div[1]/div/div/div[1]/div[2]/div/div/a/span";
    private static final String LOGIN_FIELD_XPATH = "//*[@id=\"popup-component\"]/div/div/div/div[4]/div[1]/div[2]/input";
    private static final String PASS_FIELD_XPATH = "//*[@id=\"popup-component\"]/div/div/div/div[4]/div[2]/input";
    private static final String CAB_FIELD_XPATH = "//*[@id=\"popup-component\"]/div/div/div/div[6]/div[2]/button";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"popup-component\"]/div/div/div/div[7]";

    public String getCurrentActiveCity() {
        return webDriver.findElement(By.xpath(ACTIVE_CITY_SPAN_XPATH)).getText();
    }

    public void enterButton () {
        final var enterButton = webDriver.findElement(By.xpath(ENTER_BUTTON_XPATH));
        enterButton.click();
    }

    public void enterLoginCab (String login) {
        final var enterLoginButton = webDriver.findElement(By.xpath(LOGIN_FIELD_XPATH));
        enterLoginButton.sendKeys(login, Keys.ENTER);
    }

    public void enterPassCab (String password) {
        final var enterLoginButton = webDriver.findElement(By.xpath(PASS_FIELD_XPATH));
        enterLoginButton.sendKeys(password, Keys.ENTER);
        final var enterCabButton = webDriver.findElement(By.xpath(CAB_FIELD_XPATH));
        enterCabButton.click();
    }

    public String getUserNotFoundMessage() {
        return webDriver.findElement(By.xpath(ERROR_MESSAGE_XPATH)).getText();
    }

}
