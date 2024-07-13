package ge.tbcitacademy.steps;


import ge.tbcitacademy.pages.CarRentalsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class CarRentalsSteps {
    CarRentalsPage carRentalsPage = new CarRentalsPage();

    @Step("Validate rentals page is displayed")
    public void validateRentalsPage(){
        carRentalsPage.rentalText.shouldBe(visible);
    }
}
