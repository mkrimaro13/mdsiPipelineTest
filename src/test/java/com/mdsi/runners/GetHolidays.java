package com.mdsi.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.mdsi.stepdefinitions",//paquete que contiene las clases de stepdefinitions
        features = "src/test/resources/com.mdsi.features/get_holidays.feature",//paquete que define donde está el feature
        snippets = CucumberOptions.SnippetType.CAMELCASE//define que los steps y los nombres asociados con camelcase
)

public class GetHolidays {
}