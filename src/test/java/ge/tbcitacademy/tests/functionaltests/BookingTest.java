package ge.tbcitacademy.tests.functionaltests;

import com.github.javafaker.Faker;
import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.steps.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;

@Epic("Functional Tests")
public class BookingTest extends ConfigTests {
    StaysSteps staysSteps;
    OffersSteps offersSteps;
    HotelSteps hotelSteps;
    BookingDetailsSteps detailsSteps;
    FinalDetailsSteps finalDetailsSteps;
    Faker faker;
    String hotelName;
    String price;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        staysSteps = new StaysSteps();
        offersSteps = new OffersSteps();
        hotelSteps = new HotelSteps();
        detailsSteps = new BookingDetailsSteps();
        finalDetailsSteps = new FinalDetailsSteps();
        faker = new Faker();

        open(BOOKING_URL);
    }

    @Feature("Booking Process")
    @Story("Booking without card info")
    @Description("""
            This test case simulates user choosing destination, check-in&out dates and picking first offer.
            User fills personal details, but doesn't provide card info, so he/she gets appropriate error messages.
            """)
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Hotel booking and payment")
    public void bookingAndPaymentTest(){
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp()
                .enterDestination(BAKURIANI)
                .pickDates(CHECK_IN_DATE, CHECK_OUT_DATE)
                .clickSearchBtn();

        offersSteps
                .pickFirstOffer()
                .switchWindow();

        hotelName = hotelSteps.getHotelName();

        hotelSteps.clickReserve();

        hotelSteps.clickIllReserve();

        price = detailsSteps.getPrice();

        detailsSteps
                .validateDetails(ROOMS_AND_PERSONS_DETAIL, CHECK_IN, CHECK_OUT)
                .fillName(faker.name().firstName())
                .fillLastName(faker.name().lastName())
                .fillMail(faker.internet().emailAddress())
                .fillNumber(faker.phoneNumber().cellPhone())
                .clickNext();

        finalDetailsSteps
                .validateLoad()
                .clickCheckBookingBtn()
                .validateFinalDetails(hotelName, CHECK_IN, CHECK_OUT, price)
                .clickLooksGoodSubmit()
                .validateErrors();
    }
}
