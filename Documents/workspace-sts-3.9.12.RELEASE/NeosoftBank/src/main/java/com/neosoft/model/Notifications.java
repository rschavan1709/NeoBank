package com.neosoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Notifications extends CommonDetails {
	
	private String title;
	private String body;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId",referencedColumnName = "id")
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
	this.user = user;
	}

	public Notifications(String title, String body, String status) {
		super();
		this.title = title;
		this.body = body;
		this.status = status;
	}

	public Notifications() {
		super();
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notifications [title=" + title + ", body=" + body + ", status=" + status + "]";
	}
	
}
