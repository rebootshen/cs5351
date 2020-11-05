package cs.test_automation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import cs.test_automation.base.BaseWeb;

import com.eliasnogueira.page.cityu.RequirementPage;
import com.eliasnogueira.page.cityu.TpgAdmissionPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CityU07Test extends BaseWeb {
    @Test(description = "T7 General Entrance Requirements4")
    public void ger4() {

        TpgAdmissionPage tpgAdmissionPage = new TpgAdmissionPage();
        tpgAdmissionPage.clickMenu("Entrance Requirements");
        RequirementPage requirementPage = new RequirementPage();

        assertThat(requirementPage.getGer().getText()).isEqualTo("General Entrance Requirements");
    }
}
