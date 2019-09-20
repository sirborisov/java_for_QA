package ru.qa.borisov.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void edit() {
    if (isElementPresent(By.name("submit"))
            && isElementPresent(By.xpath("//input[@value='Enter'"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  public void home() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void visibleHome() {
    expect(By.name("searchstring"));
  }
}
