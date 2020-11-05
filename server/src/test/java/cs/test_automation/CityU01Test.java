package cs.test_automation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import cs.test_automation.base.BaseWeb;

import com.eliasnogueira.page.cityu.RequirementPage;
import com.eliasnogueira.page.cityu.TpgAdmissionPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CityU01Test extends BaseWeb {

    @Test(description = "Tpg1")
    public void tpg() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.getTpg();

        assertThat(tpgAdmissionPage.getTpg().getText()).isEqualTo("Taught Postgraduate Programmes");
    }

    @Test(description = "Tpg1 menu")
    public void tpgMenu() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        List<WebElement> tpgMenus = tpgAdmissionPage.getTpgMenus();

        assertThat(tpgMenus.get(0).getText()).isEqualTo("Introduction");
    }
}
