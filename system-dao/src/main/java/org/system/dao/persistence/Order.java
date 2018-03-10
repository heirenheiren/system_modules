package org.system.dao.persistence;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 4731962215805812329L;

	private int id;
	
	private String userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
