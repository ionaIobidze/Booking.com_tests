package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.pages.CommonPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class CommonSteps {
    CommonPage commonPage = new CommonPage();

    @Step("Navigate to previous page")
    public void navigateBack(){
        Selenide.back();
    }

    @Step("Click Sign in button at the top of the page")
    public void clickSignInBtn(){
        commonPage.signInBtn.shouldBe(visible).click();
    }

    @Step("Click 'Register' button")
    public void clickRegisterButton() {
        commonPage.registerBtn.click();
    }

    @Step("Open currency dropdown")
    public CommonSteps openCurrencyDropdown() {
        commonPage.currencyButton.shouldBe(visible).click();
        return this;
    }

    @Step("Select currency: {currency}")
    public void selectCurrency(String currency) {
        commonPage.currencyOption(currency).shouldBe(visible).click();
    }

    @Step("Open language dropdown")
    public CommonSteps openLanguageDropdown() {
        commonPage.languageSwitcherBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Select language: {language}")
    public void selectLanguage(String language) {
        commonPage.languageOption(language).shouldBe(visible).click();
    }
}
