package com.example.demo2;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.xml.xpath.XPathConstants;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
  public SelenideElement logInButton = $("input[id='Login']");
  public SelenideElement passwordButton = $("input[id='password']");
  public SelenideElement userButton = $("input[id='username']");
  public SelenideElement boardOne = $x("//span[contains(@title, 'Quarterly')]");
  public SelenideElement boardTwo = $x("//span[@title=\"Today's Events\"]");
  public SelenideElement boardThree = $x("//span[@title='Today’s Tasks']");
  public SelenideElement boardFour = $x("//span[@title='Recent Records']");
  public SelenideElement boardFive = $x("//span[contains(@title, '-')]");

}
