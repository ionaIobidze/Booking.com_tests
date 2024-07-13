package ge.tbcitacademy.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.pages.FiltersPage;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilterSteps {

    FiltersPage filtersPage = new FiltersPage();

    @Step("Set budget filter to min - max")
    public FilterSteps setBudgetFilter(int min, int max) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.click(filtersPage.min).clickAndHold(filtersPage.min).perform();
        while (!Objects.equals(filtersPage.minVal.getValue(), String.valueOf(min))) {
            actions.moveByOffset(1, 0).perform();
        }
        actions.click(filtersPage.min).release(filtersPage.min).perform();

        actions.click(filtersPage.max).clickAndHold(filtersPage.max).perform();
        while (!Objects.equals(filtersPage.maxVal.getValue(), String.valueOf(max))) {
            actions.moveByOffset(-1, 0).perform();
        }
        actions.click(filtersPage.max).release(filtersPage.max).perform();
        return this;
    }
    @Step("Check review score filter 'Wonderful: 9+'")
    public FilterSteps setReviewScoreFilterToWonderful() {
        filtersPage.wonderfulReviewScoreCheckbox.scrollIntoView(true).shouldBe(Condition.clickable).click();
        filtersPage.wonderfulReviewScoreCheckbox.shouldBe(Condition.checked);
        return this;
    }

    @Step("Check property rating filter '4 stars'")
    public FilterSteps setPropertyRatingFilterToFourStar() {
        filtersPage.propertyRatingFourStarCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Validate that all offers are within the budget range 100 - 120")
    public void validateBudgetFilter(int min, int max) {
        filtersPage.offerPrices.forEach(priceElement -> {
            String priceText = priceElement.getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);
            assertTrue(price >= min && price <= max, "Price out of range: " + price);
        });
    }

    @Step("Validate that all offers have a review score of at least 9.0")
    public void validateReviewScoreFilter() {
        filtersPage.reviewScores.forEach(scoreElement -> {
            System.out.println(scoreElement.getText());
            String scoreText = scoreElement.getText().replaceAll("[^0-9.]+", "");
            double score = Double.parseDouble(scoreText);
            assertTrue(score >= 9.0, "Review score less than 9: " + score);
        });
    }

    @Step("Validate that all offers have a 4-star rating")
    public void validatePropertyRatingFilter() {
        filtersPage.propertyRatings.forEach(ratingElement -> {
            String rating = ratingElement.getText().replaceAll("[^0-9]", "");
            assertEquals(rating, "4", "Property rating is not 4 stars: " + rating);
        });
    }
}
