package ru.qa.borisov.rest;

import org.testng.annotations.Test;

import java.io.IOException;

public class PrimeTests extends TestBase {

  @Test
  public void testPrime() throws IOException {
    int issueId = 2;
    skipIfNotFixed(issueId);
    System.out.println("TestIssueBugify");
  }
}
