package com.mdsi.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecutionGetHolidays implements Task {

    private String endpoint;
    private String year;

    public ExecutionGetHolidays (String endpoint, String year){
        this.endpoint = endpoint;
        this.year = year;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint.concat(year)));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecutionGetHolidays getInformation (String endpoint, String year){
        return Tasks.instrumented(ExecutionGetHolidays.class, endpoint, year);
    }

}
