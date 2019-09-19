package ru.qa.borisov.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoEditPage();
      app.getContactHelper().createContact(new ContactData("Borisov", "Vladimir", "nick", "Russian Federation",
              "128500", "sir.borisov@gmail.com", "Test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Borisov555", "Vladimir1", "nick1", "Russian Federation1", "1285001", "sir.borisov@gmail.com1", null);
    app.getContactHelper().fillContactForm((contact), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
