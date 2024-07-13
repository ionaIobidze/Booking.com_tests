package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class RegistrationPage {

    public SelenideElement passwordInput = $("#new_password"),
            confirmPasswordInput = $("#confirmed_password"),
            createAccountButton = $(byText("Create account"));
}
