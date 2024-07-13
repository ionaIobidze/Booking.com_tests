package ge.tbcitacademy.steps;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

import static ge.tbcitacademy.data.Constants.TIMING_ATACK_ERROR;
import static ge.tbcitacademy.data.Constants.TIMING_ATACK_NUM;

public class TimingAttackSteps {
    private final SignInSteps signInSteps = new SignInSteps();
    private final List<Long> responseTimes = new ArrayList<>();
    Faker faker = new Faker();

    private TimingAttackSteps generateAndEnterPassword() {
        signInSteps.enterPassword(faker.internet().password(2,4));
        return this;
    }

    private void measureResponseTime() {
        long startTime = System.currentTimeMillis();
        signInSteps.clickSignInButtonOnSignInPage();
        long endTime = System.currentTimeMillis();
        responseTimes.add(endTime - startTime);
    }

    public TimingAttackSteps performAttack() {
        for (int i = 0; i < TIMING_ATACK_NUM; i++) {
            generateAndEnterPassword().measureResponseTime();
        }
        return this;
    }

    public void validateConsistency() {
        double averageResponseTime = responseTimes.stream().mapToLong(Long::longValue).average().orElse(0.0);
        boolean timingConsistent = responseTimes.stream().allMatch(time -> Math.abs(time - averageResponseTime) < 100);
        assert timingConsistent : TIMING_ATACK_ERROR;
    }
}
