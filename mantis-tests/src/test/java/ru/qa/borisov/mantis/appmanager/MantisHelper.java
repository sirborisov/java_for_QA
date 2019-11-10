package ru.qa.borisov.mantis.appmanager;

import org.openqa.selenium.By;

public class MantisHelper extends HelperBase {

  public MantisHelper(ApplicationManager app) {
    super(app);
  }

  public void login() {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), (app.getProperty("web.adminLogin")));
    click(By.cssSelector("input[value='Login']"));
    type(By.name("password"), (app.getProperty("web.adminPassword")));
    click(By.cssSelector("input[value='Login']"));
  }

  public void myAccount() {
    click(By.xpath("//a[@class='dropdown-toggle']/span[@class='user-info']"));
    click(By.xpath("//a[contains(text(),'My Account')]"));
  }

  public void manageOverviewPage() {
    click(By.cssSelector("a[href='/mantisbt/manage_overview_page.php'"));
  }

  public void manageUsersPage() {
    click(By.cssSelector("a[href='/mantisbt/manage_user_page.php'"));
  }


  public void selectUser() {
    click(By.xpath("//a[contains(text(),'user')]"));
  }

  public String getUserName() {
    String name = wd.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
    return name;
  }

  public String getUserEmail() {
    String email = wd.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
    return email;
  }

  public void resetPasswordUser() {
    click(By.xpath("//form[@id='manage-user-reset-form']//input[@class='btn btn-primary btn-white btn-round']"));
  }
}
