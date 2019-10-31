package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;
import ru.qa.borisov.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().home();
    if (app.db().contacts().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData()
              .withFirstname("Borisov").withLastname("Vladimir").withNickname("nick")
              .withAddress("Russian Federation" + "\n" + "Ulyanovsk" + "\n" + "Lenina str." + "\n" + "+-()#$!^")
              .withMobile("128500").withWork("489").withHome("5448")
              .withEmail("sir.borisov@gmail.com").withEmail2("borisov@gmail.com").withEmail3("sir@gmail.com")
              .withGroup("Test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstname("Borisov_new").withLastname("Vladimir1").withNickname("nick1")
//            .withAddress("Russian Federation Ulyanovsk Lenina str. +-()#$!^")
            .withAddress("USSR" + "\r\n" + "Simbirsk" + "\r\n" + "First str." + "\r\n" + "+-()#$!^")
            .withMobile("1285001").withWork("+7984").withHome("52 36 98")
            .withEmail("sir.borisov@gmail.com1").withEmail2("sdfsd@fdg.sd").withEmail3("mail@com.ru");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
