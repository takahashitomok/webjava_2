package jp.co.systena.tigerscave.rpgapplication.Model;

public class Senshi extends Job {

	public Senshi() {

	}

	public Senshi(String name) {
		this.name = name;
	}

	public Senshi(String name, String action) {
		this.name = name;
		this.action = action;
	}

	public String fight() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("は剣で攻撃した！");

		return builder.toString();
	}

	public String recovery() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("はやくそうで回復した！");

		return builder.toString();
	}
}