package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;

public class ContactEmailTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData()
              .withFirstname("Borisov").withLastname("Vladimir").withNickname("nick")
              .withAddress("Russian Federation")
              .withMobile("128500").withWork("489").withHome("5448")
              .withEmail("sir.borisov@gmail.com").withEmail2("borisov@gmail.com").withEmail3("sir@gmail.com")
              .withGroup("Test1"), true);
    }
  }

//  @Test

}
