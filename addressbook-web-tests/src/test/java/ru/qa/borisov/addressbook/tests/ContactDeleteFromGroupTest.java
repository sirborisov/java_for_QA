package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;
import ru.qa.borisov.addressbook.model.Contacts;
import ru.qa.borisov.addressbook.model.GroupData;
import ru.qa.borisov.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTest extends TestBase {

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

    for (ContactData contact : app.db().contacts()) {
      if (contact.getGroups().size() == 0) {
        Contacts contacts = app.db().contacts();
        ContactData selectContact = contacts.iterator().next();
        GroupData selectGroup = groups.iterator().next();
        app.goTo().home();
        app.contact().addToGroup(selectContact, selectGroup);
      }
    }
  }

  @Test
  public void testContactDeleteFromGroup() {
    Contacts contacts = app.db().contacts();
    ContactData selectContact = contacts.iterator().next();
    Groups groups = app.db().groups();
    GroupData selectGroup = app.db().getGroupById(contactForDeletion(contacts, groups).getId());

    Groups before = selectContact.getGroups();
    app.goTo().home();
    app.contact().deleteFromGroup(selectContact, selectGroup);
    Groups after = selectContact.getGroups();
    assertThat(before, equalTo(after.withAdded(selectGroup)));
  }

  private GroupData contactForDeletion(Contacts contacts, Groups groups) {
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() > 0) {
        Groups groupsWithContacts = contact.getGroups();
        return groupsWithContacts.iterator().next();
      }
    }
    ContactData addedContact = contacts.iterator().next();
    GroupData group = groups.iterator().next();
    app.goTo().home();
    app.contact().addToGroup(addedContact, group);
    app.goTo().selectPage(group);
    return group;
  }
}
