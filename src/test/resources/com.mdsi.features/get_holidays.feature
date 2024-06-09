Feature: Api Rest Automation
  I as an apprentice
  Need to automate the requests on a Api
  To learn how to interact with services

  Scenario: Get the holidays on a year
    Given "Generic Agent" stablish the base url "https://demoapimdsi.azurewebsites.net/" of the service
    When consult the endpoint "/festivos/obtener/" by year "2024"
    Then verify the status code might be 200