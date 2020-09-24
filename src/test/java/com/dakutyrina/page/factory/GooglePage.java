package com.dakutyrina.page.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GooglePage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath ="//div/div[2]/input")
    WebElement searchField;

    @FindAll(@FindBy(how = How.ID, id = "rso"))
    WebElement searchResult;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void somethingToSearch(String key){
        searchField.click();
        searchField.sendKeys(key);
        searchField.submit();
    }

    public WebElement getSearchResult() {
        return searchResult;
    }



}



