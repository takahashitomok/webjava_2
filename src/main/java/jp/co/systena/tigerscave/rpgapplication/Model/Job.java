package jp.co.systena.tigerscave.rpgapplication.Model;

public abstract class Job {
	  public static final String SENSHI = "戦士";
	  public static final String WITCH = "魔法使い";
	  public static final String MARTIALARTIST = "武闘家";

	  public static final String FIGHT = "たたかう";
	  public static final String RECOVERY = "かいふく";

	  protected String name;
	  protected String action;

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

	  public abstract String fight();

	  public abstract String recovery();
	}
