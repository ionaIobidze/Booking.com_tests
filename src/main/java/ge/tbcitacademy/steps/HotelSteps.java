package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.HotelPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class HotelSteps {
    HotelPage hotelPage = new HotelPage();

    @Step("Get hotel name")
    public String getHotelName() {
        return hotelPage.hotelName.should(exist).getText();
    }

    @Step("Click the 'Reserve' button")
    public HotelSteps clickReserve() {
        hotelPage.reserveButton.shouldBe(visible).click();
        return this;
    }

    @Step("Click 'I'll reserve' button")
    public void clickIllReserve() {
        hotelPage.reservationPrice.shouldBe(visible);
        hotelPage.iWillReserveButton.shouldBe(allOf(visible, clickable)).click();
    }
}
