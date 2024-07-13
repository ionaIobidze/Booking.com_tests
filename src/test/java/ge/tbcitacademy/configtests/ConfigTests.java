package ge.tbcitacademy.configtests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcitacademy.listeners.CustomTestListener;
import ge.tbcitacademy.util.ModdedAllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;

@Listeners({CustomTestListener.class})
public class ConfigTests {
    @BeforeTest(alwaysRun = true)
    public void initialSetup(){
        browser = CHROME;
        ChromeOptions options;

        String isAzureDevOps = System.getenv("TF_BUILD");

        if (isAzureDevOps != null && isAzureDevOps.equalsIgnoreCase("true")) {
            options = azureOptions();
        } else {
            options = localOptions();
        }

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());
        timeout = 20000;
        reopenBrowserOnFail = true;
        screenshots = true;
        fileDownload = FileDownloadMode.HTTPGET;
        pageLoadTimeout = 20000;
    }

    private static ChromeOptions localOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--disable-blink-features=AutomationControlled",
                "--window-size=null"
        );
        return options;
    }

    private static ChromeOptions azureOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless=new",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--window-size=1920,1080",
                "--disable-extensions",
                "--disable-infobars",
                "--disable-gpu",
                "--allow-insecure-localhost",
                "--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3601.0 Safari/537.36",
                "--disable-blink-features=AutomationControlled",
                "--disable-animations"
        );
        return options;
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}