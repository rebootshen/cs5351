package com.eliasnogueira.page.cityu;

import com.eliasnogueira.page.AbstractPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequirementPage extends AbstractPageObject {

    @FindBy(xpath = "//*[@id='page_content-267']/div/div[1]/div/div/h1")
    private WebElement ger;


    public WebElement getGer() {
        return ger;
    }
}
