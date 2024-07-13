package ge.tbcitacademy.tests.functionaltests;

import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.steps.FilterSteps;
import ge.tbcitacademy.steps.OffersSteps;
import ge.tbcitacademy.steps.StaysSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;

@Epic("Functional Tests")
public class FilterTests extends ConfigTests {
    StaysSteps staysSteps;
    FilterSteps filterSteps;
    OffersSteps offersSteps;

    @BeforeClass
    public void beforeClass() {
        staysSteps = new StaysSteps();
        filterSteps = new FilterSteps();
        offersSteps = new OffersSteps();
    }

    @BeforeMethod
    public void setup() {
        open(BOOKING_URL);

        staysSteps
                .validatePageLoad()
                .closeSignInPopUp()
                .clickDestinationSearchBar()
                .chooseFirstDestination()
                .pickDates(CHECK_IN_DATE, CHECK_OUT_DATE)
                .clickSearchBtn();

        offersSteps
                .validateOffersVisibility();
    }


    @Test(description = "Budget Filter Test")
    @Feature("Filters")
    @Story("Budget Filter")
    @Description("""
            Test to filter offers within budget range 100 - 120:
            1. Click on the destination search bar
            2. Choose the first destination
            3. Pick check-in and check-out dates
            4. Perform the search
            5. Set the budget filter to the specified range
            6. Validate that offers are filtered within the budget range
            This test ensures that users can filter search results by budget effectively.""")
    @Severity(SeverityLevel.CRITICAL)
    public void budgetFilterTest() {
        filterSteps
                .setBudgetFilter(BUDGET_MIN, BUDGET_MAX)
                .validateBudgetFilter(BUDGET_MIN, BUDGET_MAX);
    }

    @Test(description = "Review Score Filter Test")
    @Feature("Filters")
    @Story("Review Score Filter")
    @Description("""
            Test to filter offers with review score 'Wonderful: 9+':
            1. Click on the destination search bar
            2. Choose the first destination
            3. Pick check-in and check-out dates
            4. Perform the search
            5. Set the review score filter to 'Wonderful: 9+'
            6. Validate that offers are filtered by the review score
            This test ensures that users can filter search results by review score effectively.""")
    @Severity(SeverityLevel.CRITICAL)
    public void reviewScoreFilterTest() {
        filterSteps
                .setReviewScoreFilterToWonderful()
                .validateReviewScoreFilter();
    }


    @Test(description = "Property Rating Filter Test")
    @Feature("Filters")
    @Story("Property Rating Filter")
    @Description("""
            Test to filter offers with property rating '4 stars':
            1. Click on the destination search bar
            2. Choose the first destination
            3. Pick check-in and check-out dates
            4. Perform the search
            5. Set the property rating filter to '4 stars'
            6. Validate that offers are filtered by property rating
            This test ensures that users can filter search results by property rating effectively.""")
    @Severity(SeverityLevel.CRITICAL)
    public void propertyRatingFilterTest() {
        filterSteps
                .setPropertyRatingFilterToFourStar()
                .validatePropertyRatingFilter();
    }
}