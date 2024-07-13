package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInOrCreatePage {
    public SelenideElement loginRegistrationPageHeader = $(byText("Sign in or create an account")),
            emailInput = $("#username"),
            continueWithEmailButton = $("button[type='submit']").$(byText("Continue with email")),
            invalidEmailErrorMessage = $("#username-note"),
            signInWithGoogleButton = $("a[title='Sign in with Google']"),
            googleSignInHeader = $(byText("Sign in with Google"));

    public ElementsCollection socialBtns = $$(".access-panel__social-buttons a");
}
