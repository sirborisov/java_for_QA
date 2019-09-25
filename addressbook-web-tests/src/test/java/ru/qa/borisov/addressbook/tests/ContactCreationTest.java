package ru.qa.borisov.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().home();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Borisov4").withLastname("Vladimir").withNickname("nick").withAddress("Russian Federation").
            withMobile("128500").withEmail("sir.borisov@gmail.com").withGroup("Test1");
    app.goTo().edit();
    app.contact().create((contact), true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
