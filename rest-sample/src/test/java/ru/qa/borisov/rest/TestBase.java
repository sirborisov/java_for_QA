package ru.qa.borisov.rest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;

public class TestBase {

  boolean isIssueOpen(int issueId) throws IOException {
    String status = "";
    String json = getExecutor()
            .execute(Request.Get("https://bugify.stqa.ru/api/issues/" + issueId + ".json"))
            .returnContent().asString();
    JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
    JsonArray issues = parsed.getAsJsonArray("issues");
    for (JsonElement state_name : issues) {
//      JsonObject statuses = state_name.getAsJsonObject();
      status = state_name.getAsJsonObject().get("state_name").toString().replaceAll("\"", "");
      System.out.println("Task status = " + status);
    }
    return !status.equals("Resolved");
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  public Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }
}
