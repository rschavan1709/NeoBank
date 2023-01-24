package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Authentication;
import com.neosoft.model.User;


@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
	//List<Authentication> findByUsername(String username);
	@Query(value ="Select * From Authentication where username=:n and otp_verfiy=false order by otp_requested_time desc limit 1",nativeQuery = true)
	 Authentication findByUsername(@Param("n") String username);
}
