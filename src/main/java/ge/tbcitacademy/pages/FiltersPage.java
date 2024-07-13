package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FiltersPage {
    public SelenideElement min = $$(".e8499c6a5c .d6ed9c72b9").first(),
            max = $$(".e8499c6a5c .d6ed9c72b9").last(),
            minVal = $$(".e8499c6a5c .c3e951fba5").first(),
            maxVal = $$(".e8499c6a5c .c3e951fba5").last(),
    //            wonderfulReviewScoreCheckbox = $(byText("Wonderful: 9+")),data-filters-item="review_score:review_score=90"
    wonderfulReviewScoreCheckbox = $(".e8499c6a5c").$(byAttribute("data-filters-item", "review_score:review_score=90")).$("input"),
            propertyRatingFourStarCheckbox = $(byText("4 stars"));
    public ElementsCollection offerPrices = $$("div[data-testid='price-and-discounted-price']"),
            reviewScores = $$("div[data-testid='review-score'] div.f13857cc8c.e008572b71 div"),
            propertyRatings = $$("div[data-testid='rating']");
}
