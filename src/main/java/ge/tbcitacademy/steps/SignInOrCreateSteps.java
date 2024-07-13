package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.pages.SignInOrCreatePage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;

public class SignInOrCreateSteps {
    SignInOrCreatePage page = new SignInOrCreatePage();

    @Step("Validate login page is displayed")
    public SignInOrCreateSteps validateSignInOrCreatePage() {
        page.loginRegistrationPageHeader.shouldBe(visible);
        return this;
    }

    @Step("Enter email: {invalidEmail}")
    public SignInOrCreateSteps enterEmail(String email) {
        page.emailInput.setValue(email);
        return this;
    }

    @Step("Click continue with email button")
    public SignInOrCreateSteps clickContinueBtn() {
        page.continueWithEmailButton.click();
        return this;
    }

    @Step("Validate invalid email error message is shown")
    public SignInOrCreateSteps validateInvalidEmailErrorMessage() {
        page.invalidEmailErrorMessage.shouldHave(text(Constants.INVALID_EMAIL_ERROR_MESSAGE));
        return this;
    }

    @Step("Click 'Sign in with Google' button")
    public SignInOrCreateSteps clickSignInWithGoogleButton() {
        page.signInWithGoogleButton.click();
        return this;
    }

    @Step("Check if Google sign-in page is opened")
    public SignInOrCreateSteps validateGoogleSignInPageOpened() {
        Selenide.switchTo().window(1);
        Assert.assertTrue(page.googleSignInHeader.isDisplayed());
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        return this;
    }

    @Step("Validate continue with email is displayed")
    public SignInOrCreateSteps validateContinueWithEmail(){
        page.continueWithEmailButton.shouldHave(text("Continue with email")).shouldBe(visible);
        return this;
    }

    @Step("Validate social buttons are displayed and clickable")
    public void validateSocialButtons(){
        page.socialBtns.forEach(b -> b.shouldBe(visible).shouldBe(clickable));
    }
}
