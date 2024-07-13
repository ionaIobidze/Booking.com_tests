package ge.tbcitacademy.tests.functionaltests;

import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.CommonSteps;
import ge.tbcitacademy.steps.OffersSteps;
import ge.tbcitacademy.steps.StaysSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;

@Epic("Functional Tests")
public class LocalizationTests extends ConfigTests {
    StaysSteps staysSteps;
    OffersSteps offersSteps;
    CommonSteps commonSteps;

    @BeforeClass
    public void setUp() {
        staysSteps = new StaysSteps();
        offersSteps = new OffersSteps();
        commonSteps = new CommonSteps();
    }

    @BeforeMethod
    public void beforeMethod(){
        open(Constants.BOOKING_URL);
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp();
    }

    @Feature("Localization")
    @Story("Currency Switching")
    @Description("""
            Verify that the user can successfully change the currency on Booking.com
            """)
    @Test(priority =1, description = "Change currency and validate it")
    public void testCurrencyChange() {
        staysSteps
                .clickDestinationSearchBar()
                .chooseFirstDestination()
                .pickDates(CHECK_IN_DATE, CHECK_OUT_DATE)
                .clickSearchBtn();
        commonSteps
                .openCurrencyDropdown()
                .selectCurrency(EURO);
        offersSteps
                .verifyCurrency(EUR, PRICE_EUR);
    }

    @Feature("Localization")
    @Story("Language Switching")
    @Description("""
            Verify that the user can successfully change the language on Booking.com
            """)
    @Test(priority = 2,description = "Change language and validate switching")
    public void testLanguageChange() {
        commonSteps
                .openLanguageDropdown()
                .selectLanguage(LANGUAGE);
        staysSteps
                .verifyLanguage(LANGUAGE, DE);
    }

}
