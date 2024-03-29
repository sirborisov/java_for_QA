package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;
import ru.qa.borisov.addressbook.model.Contacts;
import ru.qa.borisov.addressbook.model.GroupData;
import ru.qa.borisov.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test_group_before").withHeader("group_before"));
    }

    app.goTo().home();
    if (app.db().contacts().size() == 0) {
      app.goTo().edit();
      app.contact().create(new ContactData()
                      .withFirstname("Borisov").withLastname("Vladimir").withNickname("nick")
                      .withAddress("Russian Federation" + "\n" + "Ulyanovsk" + "\n" + "Lenina str." + "\n" + "+-()#$!^")
                      .withMobile("128500").withWork("489").withHome("5448")
                      .withEmail("sir.borisov@gmail.com").withEmail2("borisov@gmail.com").withEmail3("sir@gmail.com")
              , true);
    }
  }

  @Test
  public void testContactAddToGroup() {
    Contacts contacts = app.db().contacts();
    ContactData selectContact = contactForAdd(contacts);
    Groups groups = app.db().groups();
    GroupData selectGroup = groups.iterator().next();
    Groups before = selectContact.getGroups();

    app.goTo().home();
    app.contact().addToGroup(selectContact, selectGroup);
    ContactData DbContact = app.db().getContactById(selectContact.getId());
    assertThat(DbContact.getGroups(), equalTo(before.withAdded(selectGroup)));
  }

  private ContactData contactForAdd(Contacts before) {
    for (ContactData contact : before) {
      if (contact.getGroups().size() < app.db().groups().size()) {
        return contact;
      }
    }
    app.goTo().home();
    ContactData newContact = new ContactData()
            .withFirstname("Borisov").withLastname("Vladimir").withNickname("nick")
            .withAddress("Russian Federation" + "\n" + "Ulyanovsk" + "\n" + "Lenina str." + "\n" + "+-()#$!^")
            .withMobile("128500").withWork("489").withHome("5448")
            .withEmail("sir.borisov@gmail.com").withEmail2("borisov@gmail.com").withEmail3("sir@gmail.com");
    app.goTo().edit();
    app.contact().create(newContact, false);
    Contacts after = app.db().contacts();
    newContact.withId(after.stream().mapToInt((c) -> (c).getId()).max().getAsInt());
    int id = newContact.getId();
    ContactData contact = newContact;
    return contact;
  }
}
