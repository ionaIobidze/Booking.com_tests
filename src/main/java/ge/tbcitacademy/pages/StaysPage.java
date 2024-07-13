package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StaysPage extends CommonPage{
    public SelenideElement signInPopUpCloseButton = $("button[aria-label*='Dismiss sign']"),
            promotionalOffersHeaderText = $(".fc5c5a92af .b5138f45ca"),
            offersLayout = $("div#basiclayout");
    public ElementsCollection navLinks = $$("nav[data-testid='header-xpb'] a");
}
