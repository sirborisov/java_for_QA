package ru.qa.borisov.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qa.borisov.addressbook.model.GroupData;
import ru.qa.borisov.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> invalidGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test4'").withHeader("header4").withFooter("footer4")});
    list.add(new Object[]{new GroupData().withName("test5'").withHeader("header5").withFooter("footer5")});
    list.add(new Object[]{new GroupData().withName("test6'").withHeader("header6").withFooter("footer6")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(dataProvider = "invalidGroups")
  public void testBadGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }
}
