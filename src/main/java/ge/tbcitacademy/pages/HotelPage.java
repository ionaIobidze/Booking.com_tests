package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HotelPage extends CommonPage {
    public SelenideElement hotelName = $(".pp-header__title"),
            reserveButton = $("button#hp_book_now_button"),
            reservationPrice = $(".hprt-reservation-total-price"),
            iWillReserveButton = $(".bui-button--primary.js-reservation-button");
}
