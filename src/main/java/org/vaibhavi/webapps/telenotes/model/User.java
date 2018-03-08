package org.vaibhavi.webapps.telenotes.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String userName;
	
	public User() {
		//no-arg constructor
	}

	public User(String newUserName) {
		this.userName = newUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
