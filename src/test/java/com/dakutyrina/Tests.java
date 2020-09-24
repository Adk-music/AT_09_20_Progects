package com.dakutyrina;

import com.dakutyrina.page.factory.BankPage;
import com.dakutyrina.page.factory.GooglePage;
import com.dakutyrina.page.object.AfterSearchClass;
import com.dakutyrina.page.object.PreSearchClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public class Tests extends BeforeTests {

    @Test
    public void searchSomeDataPO(){
        driver.get("https://www.google.ru/");
        PreSearchClass preSearchClass = new PreSearchClass(driver);
        preSearchClass.somethingToSearch("Гладиолус");
        AfterSearchClass afterSearchClass = new AfterSearchClass(driver);
        Assertions.assertTrue(
                afterSearchClass.getSearchResult().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")),
                "Данные не найдены"
        );

    }

    @Test
    public void searchSomeDataPF(){
        driver.get("https://www.google.ru/");
        GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);
        googlePage.somethingToSearch("Гладиолус");
        Assertions.assertTrue(googlePage.getSearchResult().getText().contains("Шпажник — Википедия"));

    }


    @Test
    public void searchBankPF(){
        driver.get("https://www.google.ru/");
        GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);
        googlePage.somethingToSearch("Открытие");
        WebElement searchResult = googlePage.getSearchResult();
        List<WebElement> searchResultList = searchResult.findElements(By.className("g"));
        Optional<WebElement> linkToBank = searchResultList.stream()
                .map(webElement -> webElement.findElement(By.tagName("a")))
                .filter(linkWebElement -> linkWebElement.getAttribute("href").equals("https://www.open.ru/"))
                .findFirst();

        Assertions.assertTrue(linkToBank.isPresent());
        String bankUrl = linkToBank.get().getAttribute("href");
        driver.get(bankUrl);

        BankPage bankPage = PageFactory.initElements(driver, BankPage.class);

        BigDecimal usdBuy = new BigDecimal(bankPage.getCurrencyBuy().getText().replace(",", "."));
        BigDecimal usdSell = new BigDecimal(bankPage.getCurrencySell().getText().replace(",", "."));

        Assertions.assertFalse(usdSell.compareTo(usdBuy) < 0);
    }



}
