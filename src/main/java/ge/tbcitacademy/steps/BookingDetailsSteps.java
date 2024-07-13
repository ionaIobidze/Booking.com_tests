package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.BookingDetailsPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class BookingDetailsSteps {
    BookingDetailsPage detailsPage = new BookingDetailsPage();

    @Step("Validate number of rooms and persons, also check-in and out dates")
    public BookingDetailsSteps validateDetails(String roomsAndPersonsNumber, String checkInDate, String checkOutDate) {
        Assert.assertTrue(detailsPage.roomsAndPersonsChosen.text().contains(roomsAndPersonsNumber));
        detailsPage.checkInDate.shouldHave(text(checkInDate));
        detailsPage.checkOutDate.shouldHave(text(checkOutDate));
        return this;
    }

    @Step("Fill in name field")
    public BookingDetailsSteps fillName(String name) {
        detailsPage.firstNameField.shouldBe(visible).sendKeys(name);
        return this;
    }

    @Step("Fill in lastname field")
    public BookingDetailsSteps fillLastName(String lastName) {
        detailsPage.lastNameField.shouldBe(visible).sendKeys(lastName);
        return this;
    }

    @Step("Fill in email field")
    public BookingDetailsSteps fillMail(String email) {
        detailsPage.emailField.shouldBe(visible).sendKeys(email);
        return this;
    }

    @Step("Fill in number field")
    public BookingDetailsSteps fillNumber(String email) {
        detailsPage.telephoneNumberField.shouldBe(visible).sendKeys(email);
        return this;
    }

    @Step("Click 'Next: final details' button")
    public void clickNext() {
        detailsPage.nextButton.scrollTo().shouldBe(visible).click();
    }

    @Step("Get room price")
    public String getPrice() {
        return detailsPage.totalPrice.shouldBe(visible).innerText();
    }
}
