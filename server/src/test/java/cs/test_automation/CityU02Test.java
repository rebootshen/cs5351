package cs.test_automation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import cs.test_automation.base.BaseWeb;

import com.eliasnogueira.page.cityu.RequirementPage;
import com.eliasnogueira.page.cityu.TpgAdmissionPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CityU02Test extends BaseWeb {
    @Test(description = "Tpg2")
    public void tpg2() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.getTpg();
        tpgAdmissionPage.getTpgMenus();

        assertThat(tpgAdmissionPage.getTpg().getText()).isEqualTo("Taught Postgraduate Programmes");
    }

    @Test(description = "Tpg2 menu")
    public void tpgMenu2() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        List<WebElement> tpgMenus = tpgAdmissionPage.getTpgMenus();

        assertThat(tpgMenus.get(0).getText()).isEqualTo("Introduction");
    }

}
