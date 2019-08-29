package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoEditPage();
    app.getContactHelper().fillContactForm(new ContactData("Borisov", "Vladimir", "nick", "Russian Federation", "128500", "sir.borisov@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }


}
