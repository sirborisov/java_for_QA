package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.ContactData;
import ru.qa.borisov.addressbook.model.GroupData;
import ru.qa.borisov.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactMainTest extends TestBase {

  public static String cleanedPhone(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  public static String cleanedAddress(String address) {
    return address.replaceAll("\n", "");
  }

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
  public void testContactMain() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(cleanedAddress(contact.getAddress()), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactMainTest::cleanedPhone)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
