package com.eliasnogueira.test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import com.eliasnogueira.BaseWeb;

import com.eliasnogueira.page.cityu.RequirementPage;
import com.eliasnogueira.page.cityu.TpgAdmissionPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CityUTest extends BaseWeb {

    @Test(description = "Tpg")
    public void tpg() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.getTpg();
        tpgAdmissionPage.getTpgMenus();

        assertThat(tpgAdmissionPage.getTpg().getText()).isEqualTo("Taught Postgraduate Programmes");
    }

    @Test(description = "Tpg menu")
    public void tpgMenu() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        List<WebElement> tpgMenus = tpgAdmissionPage.getTpgMenus();

        assertThat(tpgMenus.get(0).getText()).isEqualTo("Introduction");
    }

    @Test(description = "General Entrance Requirements")
    public void ger() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.clickMenu("Entrance Requirements");
        RequirementPage requirementPage = new RequirementPage();

        assertThat(requirementPage.getGer().getText()).isEqualTo("General Entrance Requirements");
    }

    @Test(description = "Tpg2")
    public void tpg2() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.getTpg();
        tpgAdmissionPage.getTpgMenus();

        assertThat(tpgAdmissionPage.getTpg().getText()).isEqualTo("Taught Postgraduate Programmes");
    }

    @Test(description = "Tpg menu2")
    public void tpgMenu2() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        List<WebElement> tpgMenus = tpgAdmissionPage.getTpgMenus();

        assertThat(tpgMenus.get(0).getText()).isEqualTo("Introduction");
    }

    @Test(description = "General Entrance Requirements2")
    public void ger2() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.clickMenu("Entrance Requirements");
        RequirementPage requirementPage = new RequirementPage();

        assertThat(requirementPage.getGer().getText()).isEqualTo("General Entrance Requirements");
    }

    @Test(description = "Tpg3")
    public void tpg3() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.getTpg();
        tpgAdmissionPage.getTpgMenus();

        assertThat(tpgAdmissionPage.getTpg().getText()).isEqualTo("Taught Postgraduate Programmes");
    }

    @Test(description = "Tpg menu3")
    public void tpgMenu3() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        List<WebElement> tpgMenus = tpgAdmissionPage.getTpgMenus();

        assertThat(tpgMenus.get(0).getText()).isEqualTo("Introduction");
    }

    @Test(description = "General Entrance Requirements3")
    public void ger3() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.clickMenu("Entrance Requirements");
        RequirementPage requirementPage = new RequirementPage();

        assertThat(requirementPage.getGer().getText()).isEqualTo("General Entrance Requirements");
    }

    @Test(description = "General Entrance Requirements4")
    public void ger4() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.clickMenu("Entrance Requirements");
        RequirementPage requirementPage = new RequirementPage();

        assertThat(requirementPage.getGer().getText()).isEqualTo("General Entrance Requirements");
    }
}
