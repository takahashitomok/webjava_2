package jp.co.systena.tigerscave.rpgapplication.Model;

public class MartialArtist extends Job {
	public MartialArtist() {

	  }

	  public MartialArtist(String name) {
	    this.name = name;
	  }

	  public MartialArtist(String name, String action) {
	    this.name = name;
	    this.action = action;
	  }

	  public String fight() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(name);
	    builder.append("は拳で攻撃した！");

	    return builder.toString();
	  }

	  public String recovery() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(name);
	    builder.append("はやくそうで回復した！");

	    return builder.toString();
	  }
	}
