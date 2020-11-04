package com.eliasnogueira.page.cityu;

import java.util.List;

import com.eliasnogueira.driver.DriverManager;
import com.eliasnogueira.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TpgAdmissionPage extends AbstractPageObject {

    @FindBy(xpath = "//*[@id='myCarousel-34']/div/div/div/div/div[2]")
    private WebElement tpg;

    @FindBy(xpath = "//*[@id='block-menu2-taught-postgraduate']/ul/li")
    private List<WebElement> tpgMenus;

    @Step
    public void clickMenu(String menu) {
        WebDriver driver = DriverManager.getDriver();
        tpgMenus.stream().filter(p -> p.getText().equals(menu)).findAny().get().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }

    public WebElement getTpg() {
        return tpg;
    }

    public List<WebElement> getTpgMenus() {
        return tpgMenus;
    }
}
