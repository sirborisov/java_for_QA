package ru.qa.borisov.mantis.tests;

import org.testng.annotations.Test;
import ru.qa.borisov.mantis.appmanager.HttpSession;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException, ServiceException {
    int issueId = 1;
    skipIfNotFixed(issueId);
    HttpSession session = app.newSession();
    assertTrue(session.login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword")));
    assertTrue(session.isLoggedInAs(app.getProperty("web.adminLogin")));
  }
}
