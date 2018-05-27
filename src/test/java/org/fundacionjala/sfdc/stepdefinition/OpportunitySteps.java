package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.pageobjects.opportunities.OpportInputs;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFONewModifyPage;

import java.util.Map;

/**
 * OpportunitySteps.
 */
public class OpportunitySteps {
    private SFONewModifyPage modifyPage;

    /**
     * OpportunitySteps.
     *
     * @param modifyPage  modifyPage menu.
     */
    public OpportunitySteps(final SFONewModifyPage modifyPage) {
        this.modifyPage = modifyPage;

    }

    /**
     * @param values iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can create a new opportunity fill the fields and press the save button$")
    public void iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton(final Map<OpportInputs, String> values) {
        values.keySet().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

}
