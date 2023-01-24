package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Notifications;
import com.neosoft.repository.NotificationsRepository;
@Service
public class NotificationsServiceImpl implements NotificationsService {

	@Autowired
	NotificationsRepository notificationsRepository;
	
	@Override
	public Notifications add(Notifications notifications) {
		
		return notificationsRepository.save(notifications);
	}
	
}
