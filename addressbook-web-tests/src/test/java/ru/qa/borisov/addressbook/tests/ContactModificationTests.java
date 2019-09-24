package ru.qa.borisov.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().list().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData().withFirstname("Borisov").withLastname("Vladimir").withNickname("nick").withAddress("Russian Federation").
              withMobile("128500").withEmail("sir.borisov@gmail.com").withGroup("Test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(before.size() - 1).getId()).withFirstname("Borisov555").withLastname("Vladimir1").withNickname("nick1").
            withAddress("Russian Federation1").withMobile("1285001").withEmail("sir.borisov@gmail.com1");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
