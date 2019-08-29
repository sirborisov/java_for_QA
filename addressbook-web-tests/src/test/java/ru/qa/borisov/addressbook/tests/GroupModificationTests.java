package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test

  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test4", "Test5", "Test6"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
