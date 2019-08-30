package ru.qa.borisov.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void expect (By locator){
    wd.findElement(locator);
  }


  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void accept() {
    wd.switchTo().alert().accept();
  }
}
