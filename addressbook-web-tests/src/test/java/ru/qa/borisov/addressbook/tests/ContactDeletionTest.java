package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoEditPage();
      app.getContactHelper().createContact(new ContactData("Borisov", "Vladimir", "nick", "Russian Federation",
              "128500", "sir.borisov@gmail.com", "Test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactDeletionsAlert();
    app.getNavigationHelper().waitForVisibleHomePage();
  }
}
