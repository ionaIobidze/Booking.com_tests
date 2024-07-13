package ge.tbcitacademy.tests.uielementstests;

import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;

@Epic("UI Tests")
public class UIElementsTests extends ConfigTests {
    StaysSteps staysSteps;
    CommonSteps commonSteps;
    OffersSteps offerSteps;
    FlightsSteps flightsSteps;
    CarRentalsSteps carRentalsSteps;
    SignInOrCreateSteps signInOrCreateSteps;

    @BeforeClass
    public void classSetup(){
        staysSteps = new StaysSteps();
        commonSteps = new CommonSteps();
        offerSteps = new OffersSteps();
        flightsSteps = new FlightsSteps();
        carRentalsSteps = new CarRentalsSteps();
        signInOrCreateSteps = new SignInOrCreateSteps();
    }
    @BeforeMethod
    public void testSetup(){
        open(Constants.BOOKING_URL);
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp();
    }

    @Test(description = "Home Page UI Test")
    @Feature("Home Page")
    @Story("UI Elements")
    @Description("""
            Verify key UI elements on the home page:\s
            1. Check for the presence and visibility of the search bar\s
            2. Verify presence of 'Register' and 'Sign in' buttons\s
            3. Verify presence of language selection button\s
            This test ensures that all critical navigation and functional elements are present and visible on the home page.""")
    @Severity(SeverityLevel.BLOCKER)
    public void homePageElementsTest(){
        staysSteps
                .validateSearchBarVisibility()
                .validateSearchBtn()
                .validateRegisterBtn()
                .validateSignInBtn()
                .validateLanguageBtn();
    }

    @Test(description = "Search Result UI Test")
    @Feature("Search Results")
    @Story("UI Elements")
    @Description("""
            Verify key elements on the search results page:\s
            1. Perform a search action using the search bar\s
            2. Validate that offers are displayed in the search results\s
            3. Verify the presence of filters for refining search results\s
            4. Verify presence of sort button for organizing search results\s
            This test ensures that after performing a search, users can view, filter, and sort the search results effectively.""")
    @Severity(SeverityLevel.BLOCKER)
    public void searchResultElementsTest(){
        staysSteps
                .enterDestination(TBILISI)
                .clickSearchBtn();
        offerSteps
                .validateOffersVisibility()
                .validateFiltersPresence()
                .validateSortBtn();
    }

    @Test(description = "Navigation Bar UI Test")
    @Feature("Navigation Bar")
    @Story("Navigation")
    @Description("""
            Verify navigation bar functionality across different sections:\s
            1. Open the home page\s
            2. Check that the navigation bar contains links like 'Stays', 'Flights', 'Car rentals', etc.\s
            3. Click each link and verify that it navigates to the correct page:\s
               a. Click on 'Flights' and validate the Flights page\s
               b. Navigate back and click on 'Car rentals', then validate the Car Rentals page\s
               c. Navigate back and click on 'Stays', then validate the Stays page\s
            This test ensures that the main navigation bar is functioning correctly and users can access key sections of the website.""")
    @Severity(SeverityLevel.CRITICAL)
    public void navigationBarTest(){
        staysSteps
                .validateNavBar()
                .clickNavItem(FLIGHTS);
        flightsSteps
                .validateFlightsPage();
        commonSteps
                .navigateBack();
        staysSteps
                .clickNavItem(CAR_RENTALS);
        carRentalsSteps
                .validateRentalsPage();
        commonSteps
                .navigateBack();
        staysSteps
                .clickNavItem(STAYS)
                .validatePageLoad();
    }

    @Test(description = "Sign In UI Test")
    @Feature("Sign In")
    @Story("Authentication")
    @Description("""
            Verify sign-in page elements and functionality:\s
            1. Click on the 'Sign in' button on the home page\s
            2. Verify that the sign-in page loads correctly\s
            3. Verify that the email field is present\s
            4. Verify the presence of the 'Continue with email' button\s
            5. Validate that social login options (Facebook, Google, Apple) are displayed\s
            This test ensures that users can access the sign-in page and that all authentication options are available.""")
    @Severity(SeverityLevel.CRITICAL)
    public void signInPageTest(){
        commonSteps
                .clickSignInBtn();
        signInOrCreateSteps
                .validateSignInOrCreatePage()
                .validateContinueWithEmail()
                .validateSocialButtons();
    }
}
