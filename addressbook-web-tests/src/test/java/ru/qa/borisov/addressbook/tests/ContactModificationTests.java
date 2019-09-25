package ru.qa.borisov.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData().withFirstname("Borisov").withLastname("Vladimir").withNickname("nick").withAddress("Russian Federation").
              withMobile("128500").withEmail("sir.borisov@gmail.com").withGroup("Test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Borisov555").withLastname("Vladimir1").withNickname("nick1").
            withAddress("Russian Federation1").withMobile("1285001").withEmail("sir.borisov@gmail.com1");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
