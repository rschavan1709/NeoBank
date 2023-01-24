package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Integer>{
	
}
