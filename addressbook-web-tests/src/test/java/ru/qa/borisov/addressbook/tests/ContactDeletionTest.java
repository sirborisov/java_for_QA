package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;
import ru.qa.borisov.addressbook.model.Contacts;
import ru.qa.borisov.addressbook.model.GroupData;
import ru.qa.borisov.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test_group_before").withHeader("group_before"));
    }

    Groups groups = app.db().groups();
    app.goTo().home();
    if (app.db().contacts().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData()
                      .withFirstname("Borisov").withLastname("Vladimir").withNickname("nick")
                      .withAddress("Russian Federation" + "\n" + "Ulyanovsk" + "\n" + "Lenina str." + "\n" + "+-()#$!^")
                      .withMobile("128500").withWork("489").withHome("5448")
                      .withEmail("sir.borisov@gmail.com").withEmail2("borisov@gmail.com").withEmail3("sir@gmail.com")
                      .inGroup(groups.iterator().next())
              , true);
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().visibleHome();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }
}
