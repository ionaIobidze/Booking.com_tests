package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.FlightsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class FlightsSteps {
    FlightsPage flightsPage = new FlightsPage();

    @Step("Validate flights page is displayed")
    public void validateFlightsPage(){
        flightsPage.title.shouldBe(visible);
    }
}
