package ru.qa.borisov.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("23ddc00248c985e7560a27aa9738b4f7dbc6608e");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("sirborisov", "java_for_QA")).commits();
    for (RepoCommit comit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(comit).message()) ;
    }

  }
}
