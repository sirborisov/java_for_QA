package ru.qa.borisov.mantis.model;

public class Issue {

  private int Id;
  private String summary;
  private String description;
  private Project project;

  public int getId() {
    return Id;
  }

  public Issue withId(int id) {
    Id = id;
    return this;
  }

  public String getSummary() {
    return summary;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Project getProject() {
    return project;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }
}
