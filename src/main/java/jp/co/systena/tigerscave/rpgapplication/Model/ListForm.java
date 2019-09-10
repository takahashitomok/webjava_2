package jp.co.systena.tigerscave.rpgapplication.Model;

public class ListForm {
  String job;
  String name;
  String action;

  public ListForm() {
    // 初期値は戦士とする
    job = Job.SENSHI;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getJob() {
    return job;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getAction() {
    return action;
  }
}