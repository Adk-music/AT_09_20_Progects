package com.dakutyrina.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PreSearchClass {

    WebElement searchField;


    public PreSearchClass(WebDriver driver) {
        this.searchField = driver.findElement(By.xpath("//div/div[2]/input"));
    }

    public void somethingToSearch(String key){
        searchField.click();
        searchField.sendKeys(key);
        searchField.submit();
    }

}
