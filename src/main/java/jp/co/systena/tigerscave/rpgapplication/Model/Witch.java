package jp.co.systena.tigerscave.rpgapplication.Model;

public class Witch extends Job{

	  public Witch() {

	  }

	  public Witch(String name) {
	    this.name = name;
	  }

	  public Witch(String name, String action) {
	    this.name = name;
	    this.action = action;
	  }

	  public String fight() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(name);
	    builder.append("は杖で攻撃した！");

	    return builder.toString();
	  }

	  public String recovery() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(name);
	    builder.append("はまほうで回復した！");

	    return builder.toString();
	  }
	}