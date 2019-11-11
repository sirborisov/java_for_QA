package ru.qa.borisov.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.borisov.mantis.model.Issue;
import ru.qa.borisov.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase {

  @Test
  public void testGetProjects() throws MalformedURLException, RemoteException, ServiceException {
    int issueId = 888;
    skipIfNotFixed(issueId);
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws MalformedURLException, RemoteException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("test issue").withDescription("Test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(), created.getSummary());
  }
}
