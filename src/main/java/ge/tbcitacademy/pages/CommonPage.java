package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CommonPage {
    public SelenideElement destinationSearchBar = $(byAttribute("name","ss")),
            firstDestination = $("#autocomplete-result-0"),
            datePickerSearchBar = $("div[data-testid='searchbox-dates-container']"),
            registerBtn = $(byAttribute("aria-label", "Create an account")),
            signInBtn = $(byAttribute("aria-label", "Sign in")),
            languageSwitcherBtn = $(byAttribute("data-testid", "header-language-picker-trigger")),
            datePickerTab = $("nav[data-testid='datepicker-tabs']"),
            searchButton = $("button[type='submit']"),
            currencyButton = $("[data-testid='header-currency-picker-trigger']"),
            helpBtn = $(byAttribute("data-testid", "header-help-center"));

    public SelenideElement languageOption(String language) {
        return $(byText(language));
    }
    public SelenideElement currencyOption(String currencyText) {
        return $x(".//span[contains(text(), '" + currencyText + "')]");
    }

    public SelenideElement date(LocalDate date) {
        return $("span[data-date='" + date + "']");
    }

}
