package ge.tbcitacademy.tests.security;

import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.SignInOrCreateSteps;
import ge.tbcitacademy.steps.SignInSteps;
import ge.tbcitacademy.steps.StaysSteps;
import ge.tbcitacademy.steps.TimingAttackSteps;
import ge.tbcitacademy.tests.functionaltests.AuthorizationTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;
import static ge.tbcitacademy.data.Constants.ERROR_LOADING_FILE;

@Feature("Security Tests")
public class SecurityTests extends ConfigTests {
    Logger LOGGER = LoggerFactory.getLogger(AuthorizationTests.class);
    SignInOrCreateSteps signInOrCreateSteps;
    SignInSteps signInSteps;
    StaysSteps staysSteps;
    TimingAttackSteps timingAttackSteps;

    @BeforeClass
    public void setUp() {
        signInOrCreateSteps = new SignInOrCreateSteps();
        signInSteps = new SignInSteps();
        staysSteps = new StaysSteps();
        timingAttackSteps = new TimingAttackSteps();
    }

    @Story("SQL Injection")
    @Description("""
            Verify that the application properly handles SQL injection attempts.
            """)
    @Test(priority = 1, description = "Test for SQL injection vulnerability")
    public void testSQLInjection() {
        open(BOOKING_URL);
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp()
                .injectSQL()
                .clickSearchBtn()
                .checkIfErrorIsDisplayed();
    }

    @Story("Timing Attack")
    @Description("""
        Verify that the application properly handles timing attacks to avoid information leakage.
        """)
    @Test(priority = 1, description = "Test for timing attack vulnerability")
    public void testTimingAttack() {
        Properties props = new Properties();
        try (InputStream input = AuthorizationTests.class.getClassLoader().getResourceAsStream(CONFIG)) {
            props.load(input);
        } catch (IOException ex) {
            LOGGER.error(ERROR_LOADING_FILE, ex);
        }

        String email = props.getProperty(EMAIL);

        open(Constants.BOOKING_SIGN_IN_URL);

        signInOrCreateSteps
                .enterEmail(email)
                .clickContinueBtn();

        timingAttackSteps
                .performAttack()
                .validateConsistency();
    }

}
