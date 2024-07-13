package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FlightsPage {
    public SelenideElement title = $x("//h1[contains(text(), 'flight')]");
}
