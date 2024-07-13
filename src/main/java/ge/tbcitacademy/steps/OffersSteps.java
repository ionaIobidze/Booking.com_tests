package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.pages.OffersPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class OffersSteps {
    OffersPage offersPage = new OffersPage();

    @Step("Click first offers availability button")
    public OffersSteps pickFirstOffer() {
        offersPage.offers.first().shouldBe(visible);
        offersPage.offerAvailabilityButton.first().shouldBe(visible).click();
        return this;
    }

    @Step("Switch to newly opened browser window")
    public void switchWindow() {
        Selenide.switchTo().window(1);
    }

    @Step("Validate offer visibility")
    public OffersSteps validateOffersVisibility() {
        offersPage.offers.get(0).shouldBe(visible);
        return this;
    }

    @Step("Validate filters are visible and interactable")
    public OffersSteps validateFiltersPresence() {
        offersPage.popularFilters.get(0).shouldBe(visible);
        return this;
    }

    @Step("Validate sort button is visible and clickable")
    public void validateSortBtn() {
        offersPage.sortBtn.shouldBe(allOf(visible, clickable));
    }

    @Step("Verify selected currency: {expectedCurrency}")
    public void verifyCurrency(String expectedCurrency, String expectedCurrencyPriceFormat) {
        offersPage.currencyButton.shouldHave(text(expectedCurrency));
        offersPage.offersPrices.first().shouldHave(partialText(expectedCurrencyPriceFormat));
    }
}
