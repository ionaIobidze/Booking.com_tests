package ge.tbcitacademy.util;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;

public class ModdedAllureSelenide extends AllureSelenide {
    private boolean saveScreenshots;
    @Override
    public ModdedAllureSelenide screenshots(boolean saveScreenshots) {
        if (WebDriverRunner.hasWebDriverStarted()){
            this.saveScreenshots = saveScreenshots;
        }

        return this;
    }
}
