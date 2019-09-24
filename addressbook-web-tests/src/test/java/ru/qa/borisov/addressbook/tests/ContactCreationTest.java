package ru.qa.borisov.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().home();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Borisov789").withLastname("Vladimir").withNickname("nick").withAddress("Russian Federation").
            withMobile("128500").withEmail("sir.borisov@gmail.com").withGroup("Test1");
    app.goTo().edit();
    app.contact().create((contact), true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
