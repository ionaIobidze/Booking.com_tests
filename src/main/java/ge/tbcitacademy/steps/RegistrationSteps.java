package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.RegistrationPage;
import io.qameta.allure.Step;

public class RegistrationSteps{

    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Fill enter password and confirm password fields with: {password}")
    public RegistrationSteps fillPasswords(String password) {
        enterPassword(password);
        confirmPassword(password);
        return this;
    }

    @Step("Enter password: {password}")
    private void enterPassword(String password) {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(password);
    }

    @Step("Confirm password: {password}")
    private void confirmPassword(String password) {
        registrationPage.confirmPasswordInput.clear();
        registrationPage.confirmPasswordInput.sendKeys(password);
    }

    @Step("Click 'Create Account' button")
    public RegistrationSteps clickCreateAccountButton() {
        registrationPage.createAccountButton.click();
        return this;
    }
}
