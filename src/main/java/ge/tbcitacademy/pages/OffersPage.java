package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OffersPage extends CommonPage {
    public SelenideElement sortBtn = $(byAttribute("data-testid", "sorters-dropdown-trigger"));
    public ElementsCollection offers = $$(byAttribute("data-testid","property-card-container")),
            offerAvailabilityButton = $$("a[data-testid='availability-cta-btn']"),
            popularFilters = $$("div[data-filters-group='popular'] div[data-filters-item]"),
            offersPrices = $$(byAttribute("data-testid", "price-and-discounted-price"));
}
