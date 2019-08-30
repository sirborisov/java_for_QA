package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHome();
    //app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Borisov1", "Vladimir1", "nick1", "Russian Federation1", "1285001", "sir.borisov@gmail.com1"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
