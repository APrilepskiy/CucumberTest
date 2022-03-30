package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record ChooseCityPage(WebDriver webDriver) {

    private static final String SEARCH_FIELD_XPATH = "//*[@id=\"popup-component\"]/div/div/div[2]/ul/li[4]/a";

    public void go(String url) {
        webDriver.get(url);
    }

    public void searchCity(String city) {
        final var searchInput = webDriver.findElement(By.xpath(SEARCH_FIELD_XPATH));
        searchInput.click();
    }
}