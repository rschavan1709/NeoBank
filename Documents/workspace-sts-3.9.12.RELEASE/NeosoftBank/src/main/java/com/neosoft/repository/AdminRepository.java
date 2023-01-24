package com.neosoft.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.usertype.UserCollectionType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neosoft.model.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {

	User findByAccNo(long accNo);
	
	List<User>  findByFirstNameAndLastName(String firstName,String lastName);
	
	List<User> findDistinctByFirstNameAndLastName(String firstName,String lastName);
	
	List<User> findByLastName(String firstName);
	
	List<User> findByBalanceLessThan(BigDecimal balance);
	
	List<User> findByBalanceGreaterThanEqual(BigDecimal balance);
	
	List<User>  findByFirstNameOrLastName(String firstName,String lastName);
	
	List<User> findByFirstNameLike(String pattern);
	
	List<User> findByFirstNameStartingWith(String prefix);
	
	List<User> findByFirstNameEndingWith(String suffix);
	
	List<User> findByFirstNameContaining(String word);
	
	List<User> findByBalanceOrderByLastNameDesc(BigDecimal balance);
	
	List<User> findByLastNameNot(String lastName);
	
	List<User> findByIdIn(List<Integer> list);
	
	List<User> findByIsActiveTrue();
	
	List<User> findByIsActiveFalse();
	
	List<User> findByLastNameIgnoreCase(String lastName);
	
	List<User> findByBalanceLessThanAndBalanceGreaterThanEqual(BigDecimal balance,BigDecimal balance1);
	
	List<User> findByBalanceIsNull();
	
	List<User> findByBalanceIsNotNull();
	
	List<User> findByBalanceBetween(BigDecimal balance,BigDecimal balance1);
	
	List<User> findByBalanceBefore(BigDecimal balance);
	
	List<User> findByBalanceAfter(BigDecimal balance);
	
	List<User> findNotEmailId(@Param("n") String emailId);
	
	@Query("Select u from User u where u.panId=:n")
	User getByPanId(@Param("n")String panId);
	
	@Query(value="Select * from User where acc_no=:n",nativeQuery = true)
	User getThroughAccNo(@Param("n") long accNo);
	
	@Query("select u from User u where u.lastName=:n")
	List<User> findByAndSort(@Param("n") String lastName,Sort sort);
	
	List<User> findByCreatedAt(Date date);
	
	List<User> findByCreatedAtAfter(Date date);
	
	User findByUsername(String username);

}
