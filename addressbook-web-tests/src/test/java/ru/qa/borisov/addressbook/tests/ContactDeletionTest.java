package ru.qa.borisov.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().list().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData("Borisov", "Vladimir", "nick", "Russian Federation",
              "128500", "sir.borisov@gmail.com", "Test1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().visibleHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(after, before);
  }
}
