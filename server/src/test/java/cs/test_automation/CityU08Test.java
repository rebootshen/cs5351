package cs.test_automation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import cs.test_automation.base.BaseWeb;

import com.eliasnogueira.page.cityu.RequirementPage;
import com.eliasnogueira.page.cityu.TpgAdmissionPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CityU08Test extends BaseWeb {
    @Test(description = "T8 General Entrance Requirements08")
    public void ger8() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.clickMenu("Entrance Requirements");
        RequirementPage requirementPage = new RequirementPage();

        assertThat(requirementPage.getGer().getText()).isEqualTo("General Entrance Requirements");
    }
}
