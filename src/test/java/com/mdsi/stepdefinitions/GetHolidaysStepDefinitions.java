package com.mdsi.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import com.mdsi.tasks.ExecutionGetHolidays;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GetHolidaysStepDefinitions {

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("{string} stablish the base url {string} of the service")
    public void stablishBaseUrl(String agentName, String baseUrl) {
        theActorCalled(agentName).whoCan(CallAnApi.at(baseUrl));
    }

    @When("consult the endpoint {string} by year {string}")
    public void consultEndpointByYear(String endpoint, String year) {
        theActorInTheSpotlight().attemptsTo(ExecutionGetHolidays.getInformation(endpoint, year));
    }

    @Then("verify the status code might be {int}")
    public void verifyStatusCode(Integer status) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status)));
    }

}
