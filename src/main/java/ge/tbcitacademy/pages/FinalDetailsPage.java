package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FinalDetailsPage {
    public SelenideElement checkYourBookingBtn = $("button[name='review']"),
            offerName = $("#modal-default-title"),
            checkInDate = $("[aria-describedby='bp-checkin-date__label'] p.bui-date__title"),
            checkOutDate = $("[aria-describedby='bp-checkout-date__label'] p.bui-date__title"),
            price = $(".bui-inline-container__end span"),
            looksGoodCompleteBookingBtn = $(".bui-modal__footer button[type='submit']"),
            cardNumberErrorMsg = $("div[id^='pc-card-number-field']"),
            expirationDateErrorMsg = $("div[id^='pc-card-expiration-date']"),
            paymentFrame = $("iframe[title='Payment']"),
            cardDetailsSection = $(".fkgeuQ");
}
