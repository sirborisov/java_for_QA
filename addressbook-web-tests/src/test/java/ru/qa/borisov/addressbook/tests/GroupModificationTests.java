package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test

  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test4", "test2", "Test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
