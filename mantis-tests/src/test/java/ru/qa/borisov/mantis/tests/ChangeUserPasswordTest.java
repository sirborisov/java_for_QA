package ru.qa.borisov.mantis.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.qa.borisov.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ChangeUserPasswordTest extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangeUserPassword() throws IOException, MessagingException {
    app.goTo().login();
    app.goTo().myAccount();
    app.goTo().manageOverviewPage();
    app.goTo().manageUsersPage();
    app.goTo().selectNotAdminUser();
    String userName = app.goTo().getUserName();
    String userEmail = app.goTo().getUserEmail();
//    String password = "password";
    String newPasswordUser = "newpswrd";
    app.goTo().resetPasswordUser();

    List<MailMessage> mailMessages = app.mail().waitForMail(2, 20000);
//    List<MailMessage> mailMessages = app.james().waitForMail(userName, password, 120000);
    String confirmationLink = findConfirmationLink(mailMessages, userEmail);
    app.registration().finish(confirmationLink, newPasswordUser, null);
    AssertJUnit.assertTrue(app.newSession().login(userName, newPasswordUser));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
