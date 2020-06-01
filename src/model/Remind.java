package model;

import java.io.Serializable;

public class Remind implements Serializable{
	private String id;
	private String remind;
	private String category;

	public Remind(String id,String remind, String category) {
		this.id = id;
		this.remind = remind;
		this.category = category;
	}

	public Remind(String remind, String category) {
		this.remind = remind;
		this.category = category;
	}


	public Remind(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public String getRemind() {
		return remind;
	}

	public String getCategory() {
		return category;
	}


}
