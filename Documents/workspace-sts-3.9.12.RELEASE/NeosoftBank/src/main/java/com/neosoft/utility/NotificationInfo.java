package com.neosoft.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neosoft.model.Notifications;

@Component
public class NotificationInfo {

	@Autowired
	Notifications notifications;
	
	public Notifications add() {
		notifications.setTitle("Account Created");
		notifications.setBody("Thank you to choose our bank for your financial partner!! Your Account is created successfully");
		notifications.setStatus("Account Created!!");
		return notifications;
	}
	
}
