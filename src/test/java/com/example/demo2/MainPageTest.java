package com.example.demo2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainPageTest extends MainPage {
    public static final String QUARTERLY_PERFORMANCE = "Quarterly Performance";
    public static final String TODAYS_EVENTS = "Today's Events";
    public static final String LOGIN_USER = "test.qa.cloudblue@gmail.com";
    public static final String LOGIN_PASSWORD = "T3stQ4CB2023";
    private static final String TODAYS_TASKS = "Today’s Tasks";
    private static final String RECENT_RECORDS = "Recent Records";
    private static final String KEY_DEALS_RECENT_OPPORTUNITIES = "Key Deals - Recent Opportunities";
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://creative-badger-sy9jme-dev-ed.trailblaze.my.salesforce.com/?ec=301&startURL=%2Fvisualforce%2Fsession%3Furl%3Dhttps%253A%252F%252Fcreative-badger-sy9jme-dev-ed.trailblaze.lightning.force.com%252Flightning%252Fpage%252Fhome");
    }

    //Escenario automatizado Login usuario App Luncher
    @Test
    public void login() {
        mainPage.userButton.sendKeys(LOGIN_USER);
        sleep(2000);
        mainPage.passwordButton.sendKeys(LOGIN_PASSWORD);
        sleep(3000);
        mainPage.logInButton.click();
        sleep(20000);
    }

    @Test
    public void validateDashboards() {
        login();
        String boardQuarterly = boardOne.getText();
        assertTrue(boardOne.isDisplayed());
        assertEquals(QUARTERLY_PERFORMANCE, boardQuarterly);

        String boardTodays = boardTwo.getText();
        assertTrue(boardTwo.isDisplayed());
        assertEquals(TODAYS_EVENTS, boardTodays);

        String boardTasks = boardThree.getText();
        assertTrue(boardThree.isDisplayed());
        assertEquals(TODAYS_TASKS, boardTasks);

        String boardRecent = boardFour.getText();
        assertTrue(boardFour.isDisplayed());
        assertEquals(RECENT_RECORDS, boardRecent);

        String boardKeyDeals = boardFive.getText();
        assertTrue(boardFive.isDisplayed());
        assertEquals(KEY_DEALS_RECENT_OPPORTUNITIES, boardKeyDeals);
    }

}
