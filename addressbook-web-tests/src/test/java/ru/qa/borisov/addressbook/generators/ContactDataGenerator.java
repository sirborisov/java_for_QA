package ru.qa.borisov.addressbook.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.qa.borisov.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    saveAsJson(contacts, file);
  }

  private static void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstname(String.format("Firstname %s", i)).withLastname(String.format("Lastname %s", i)).withNickname(String.format("nickname %s", i))
              .withAddress(String.format("Russian Federation  Ulyanovsk  Lenina str. %s", i))
              .withMobile(String.format("mobile phone %s", i)).withWork(String.format("work phone %s", i)).withHome(String.format("home phone %s", i))
              .withEmail(String.format("email  %s", i)).withEmail2(String.format("email %s", i)).withEmail3(String.format("email %s", i))
              .withGroup(String.format("Group  %s", i)));
    }
    return contacts;
  }
}
