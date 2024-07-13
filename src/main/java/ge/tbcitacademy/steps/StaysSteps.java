package ge.tbcitacademy.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.pages.StaysPage;
import io.qameta.allure.Step;
import me.champeau.ld.UberLanguageDetector;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ge.tbcitacademy.data.Constants.NO_POPUP_MSG;
import static ge.tbcitacademy.data.Constants.SQL_INJECTION_SCRIPT;

public class StaysSteps {
    StaysPage staysPage = new StaysPage();

    @Step("Wait for page to load")
    public StaysSteps validatePageLoad() {
        staysPage.offersLayout.shouldBe(visible);
        staysPage.helpBtn.should(appear);
        return this;
    }

    @Step("Close the sign in or register pop up")
    public StaysSteps closeSignInPopUp() {
        try {
            staysPage.signInPopUpCloseButton.should(appear).click();
        } catch (NoSuchElementException | ElementNotFound e) {
            System.out.println(NO_POPUP_MSG);
        }
        return this;
    }

    @Step("Validate search bar is visible")
    public StaysSteps validateSearchBarVisibility() {
        staysPage.searchButton.shouldBe(visible);
        return this;
    }

    @Step("Click search button")
    public StaysSteps clickSearchBtn() {
        staysPage.searchButton.click();
        closeSignInPopUp();
        return this;
    }

    @Step("Validate search button is visible and clickable")
    public StaysSteps validateSearchBtn() {
        staysPage.searchButton.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate register button is visible and clickable")
    public StaysSteps validateRegisterBtn() {
        staysPage.registerBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate sign in button is visible and clickable")
    public StaysSteps validateSignInBtn() {
        staysPage.signInBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate language selector is visible and clickable")
    public void validateLanguageBtn() {
        staysPage.languageSwitcherBtn.shouldBe(visible).shouldBe(clickable);
    }

    @Step("Validate navigation bar")
    public StaysSteps validateNavBar() {
        staysPage.navLinks.shouldHave(CollectionCondition.containExactTextsCaseSensitive(
                Constants.STAYS, Constants.FLIGHTS, Constants.CAR_RENTALS
        ));
        return this;
    }

    @Step("Click navigation item")
    public StaysSteps clickNavItem(String text) {
        staysPage.navLinks.filter(text(text)).get(0).click();
        return this;
    }

    @Step("Verify selected language: {expectedLanguage}")
    public void verifyLanguage(String expectedLanguage, String countryCode) {
        String expectedAriaLabel = "Sprache: " + expectedLanguage;
        staysPage.languageSwitcherBtn.shouldHave(attribute("aria-label", expectedAriaLabel));

        UberLanguageDetector detector = UberLanguageDetector.getInstance();
        Assert.assertEquals(detector.detectLang(staysPage.promotionalOffersHeaderText.getText()), countryCode);
    }

    @Step("Check if SQL Injection error message is visible")
    public void checkIfErrorIsDisplayed() {
        assert !$(byText(Constants.ERROR)).is(visible) : Constants.SQL_ERROR_MES;
    }

    @Step("Click on the destinations search bar")
    public StaysSteps clickDestinationSearchBar() {
        staysPage.destinationSearchBar.shouldBe(clickable).click();
        return this;
    }

    @Step("Choose first offered destination")
    public StaysSteps chooseFirstDestination() {
        staysPage.firstDestination.click();
        return this;
    }

    @Step("Pick stay dates")
    public StaysSteps pickDates(LocalDate startDate, LocalDate endDate){
        if (!staysPage.datePickerTab.is(visible)) {
            staysPage.datePickerSearchBar.click();
        }
        staysPage.date(startDate).click();
        staysPage.date(endDate).click();
        return this;
    }

    @Step("Enter destination: {destination}")
    public StaysSteps enterDestination(String destination) {
        staysPage.destinationSearchBar.sendKeys(destination);
        staysPage.firstDestination.shouldHave(text(destination));
        return this;
    }

    @Step("Inject SQL Script")
    public StaysSteps injectSQL() {
        staysPage.destinationSearchBar.sendKeys(SQL_INJECTION_SCRIPT);
        return this;
    }
}
