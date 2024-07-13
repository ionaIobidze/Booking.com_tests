package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SignInPage;
import io.qameta.allure.Step;

public class SignInSteps {
    SignInPage signInPage = new SignInPage();

    @Step("Enter password: {password}")
    public SignInSteps enterPassword(String password) {
        signInPage.passwordInput.clear();
        signInPage.passwordInput.setValue(password);
        return this;
    }

    @Step("Click 'Sign In' button on sign-in page")
    public void clickSignInButtonOnSignInPage() {
        signInPage.signInButton.click();
    }
}
