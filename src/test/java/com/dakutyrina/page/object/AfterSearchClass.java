package com.dakutyrina.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AfterSearchClass extends PreSearchClass {

    List<WebElement> searchList;

    public AfterSearchClass(WebDriver driver) {
        super(driver);
        searchList = driver.findElements(By.id("search"));
    }

    public List<WebElement> getSearchResult() {
        return searchList;
    }


}
