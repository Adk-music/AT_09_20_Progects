package com.dakutyrina.page.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankPage {

    @FindBy(how = How.XPATH, xpath ="//tbody/tr[2]/td[2]/div/span")
    private WebElement currencyBuy;

    @FindBy(how = How.XPATH, xpath ="//tbody/tr[2]/td[4]/div/span")
    private WebElement currencySell;


    public WebElement getCurrencyBuy() {
        return currencyBuy;
    }

    public WebElement getCurrencySell() {
        return currencySell;
    }
}
