package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoEditPage();
      app.getContactHelper().createContact(new ContactData("Borisov", "Vladimir", "nick", "Russian Federation",
              "128500", "sir.borisov@gmail.com", "Test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Borisov1", "Vladimir1", "nick1", "Russian Federation1", "1285001", "sir.borisov@gmail.com1", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();
  }
}
