package com.neosoft;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.neosoft.model.User;
import com.neosoft.repository.AdminRepository;


@SpringBootApplication//(scanBasePackages = "com.neosoft.repository")
//@ComponentScan(basePackages = "com.neosoft.repository")
//@EnableJpaRepositories(basePackages  = {"com.neosoft.repository"})
@EnableJpaAuditing
public class NeosoftBankApplication {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(NeosoftBankApplication.class, args);
		AdminRepository adminRepository=context.getBean(AdminRepository.class);
		
		/*
		 * User user= adminRepository.findById(1).get(); System.out.println(user);
		 */
		//User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]]
		
		/*
		 * User user=adminRepository.findByAccNo(11110005); System.out.println(user);
		 */
		//User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[com.neosoft.model.Role@1be4f05c]]
		
		/*
		 * List<User> user=adminRepository.findByFirstNameAndLastName("Riddhi",
		 * "Chavan"); System.out.println(user);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findDistinctByFirstNameAndLastName("Riddhi",
		 * "Chavan"); System.out.println(user);
		 */
		//[User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]
		
		/*
		 * List<User> user=adminRepository.findByLastName("Chavan");// same for Is, Equals
		 * System.out.println(user);
		 */
		//[User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByBalanceLessThan(new
		 * BigDecimal("20000")); System.out.println(user);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByBalanceGreaterThanEqual(new
		 * BigDecimal("30000")); System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]]]

		/*
		 * List<User> user=adminRepository.findByFirstNameOrLastName("Riddhi",
		 * "Chavan"); System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByFirstNameLike("R%");
		 * System.out.println(user);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByFirstNameEndingWith("I");
		 * System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByFirstNameStartingWith("s");
		 * System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]]]

		/*
		 * List<User> user=adminRepository.findByFirstNameContaining("idd");
		 * System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByBalanceOrderByLastNameDesc(new
		 * BigDecimal("10000")); System.out.println(user);
		 */
		// [User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByLastNameNot("Chavan");
		 * System.out.println(user);
		 */
		// [User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<Integer> list=new ArrayList<>(); list.add(1); list.add(2); List<User>
		 * user=adminRepository.findByIdIn(list); System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]]]

		/*
		 * List<User> user=adminRepository.findByIsActiveTrue();
		 * System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> user=adminRepository.findByIsActiveFalse();
		 * System.out.println(user);
		 */
		// []
		
		/*
		 * List<User> user=adminRepository.findByLastNameIgnoreCase("chAvaN");
		 * System.out.println(user);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User>
		 * user=adminRepository.findByBalanceLessThanAndBalanceGreaterThanEqual(new
		 * BigDecimal(15000), new BigDecimal(10000)); System.out.println(user);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> list=adminRepository.findByBalanceIsNull();
		 * System.out.println(list);
		 */
		// []
		
		/*
		 * List<User> list=adminRepository.findByBalanceIsNotNull();
		 * System.out.println(list);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> list=adminRepository.findByBalanceBetween(new BigDecimal("9000"),
		 * new BigDecimal("20000")); System.out.println(list);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> list=adminRepository.findByBalanceBefore(new BigDecimal(20000));
		 * System.out.println(list);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		
		/*
		 * List<User> list2=adminRepository.findByBalanceAfter(new BigDecimal(20000));
		 * System.out.println(list2);
		 */
		// [User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110008, mobileNo=8850832361, emailId=ssc@gmail.com, panId=BZSY12709, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]]]

		/*
		 * List<User> list=adminRepository.findNotEmailId("ssc@gmail.com");
		 * System.out.println(list);
		 */
		// [User [firstName=Kajal, middleName=P, lastName=Mishra, accNo=11110005, mobileNo=9876532456, emailId=kajalMishra@gmail.com, panId=BAU223455, balance=10000.00, transaction=[], role=[Role [roleType=USER]]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110009, mobileNo=9969249056, emailId=rsc@gmail.com, panId=BZSY12790, balance=30000.00, transaction=[], role=[]], User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * User user=adminRepository.getByPanId("BYQU78896"); System.out.println(user);
		 */
		// User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]

		/*
		 * User user=adminRepository.getThroughAccNo(11110001);
		 * System.out.println(user);
		 */
		// User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYQU78896, balance=10000.00, transaction=[], role=[Role [roleType=USER]]]

		/*
		 * List<User> list=adminRepository.findByAndSort("Chavan",
		 * Sort.by("firstName")); System.out.println(list);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYJU26728, balance=10000.00, transaction=[], role=[]], User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110002, mobileNo=9757195538, emailId=sschavan1209@gmail.com, panId=BYJU26756, balance=20000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * List<User> list=adminRepository.findByCreatedAt(new Date());
		 * System.out.println(list);
		 */
		// [User [firstName=Riddhi, middleName=Sunil, lastName=Chavan, accNo=11110001, mobileNo=9969249056, emailId=rschavan1709@gmail.com, panId=BYJU26756, balance=10000.00, transaction=[], role=[Role [roleType=ADMIN]]], User [firstName=Siddhi, middleName=Sunil, lastName=Chavan, accNo=11110002, mobileNo=9757195538, emailId=sschavan1209@gmail.com, panId=BYJU27766, balance=20000.00, transaction=[], role=[Role [roleType=USER]]]]

		/*
		 * String s="08-12-2022"; Date date1=new
		 * SimpleDateFormat("dd-MM-yyyy").parse(s); List<User>
		 * list=adminRepository.findByCreatedAtAfter(date1); System.out.println(list);
		 */
		
		SessionFactory sf=context.getBean(SessionFactory.class);
		Session session=sf.openSession();
		
		/*
		 * Query query=session.createQuery("from User"); List<User>
		 * list=query.getResultList(); for(User u:list) { System.out.println(u); }
		 */
		
		/*
		 * Query query1=session.createQuery("from User where firstName=:n");
		 * query1.setParameter("n", "Riddhi"); List<User> list1=query1.getResultList();
		 * for(User u:list1) { System.out.println(u); }
		 */
		
		/*
		 * Query query2=session.createQuery("Select lastName from User"); List<String>
		 * list2=query2.getResultList(); for(String s:list2) { System.out.println(s); }
		 */
		
		/*
		 * Query
		 * query3=session.createQuery("Select lastName from User where balance>=:n");
		 * query3.setParameter("n",new BigDecimal(1900)); List<String>
		 * list3=query3.getResultList(); for(String s:list3) { System.out.println(s); }
		 */
		
		/*
		 * Query query4=session.
		 * createQuery("Select lastName from User where firstName like 'a%'");
		 * List<String> list4=query4.getResultList(); for(String s:list4) {
		 * System.out.println(s); }
		 */
		
		/*
		 * String date="2022-12-15"; Date date2=new
		 * SimpleDateFormat("yyyy-MM-dd").parse(date); String date1="2022-12-17"; Date
		 * date3=new SimpleDateFormat("yyyy-MM-dd").parse(date1); Query query5=session.
		 * createQuery("Select firstName from User where createdAt between :n and :n1");
		 * query5.setDate("n", date2); query5.setDate("n1", date3); List<String>
		 * list5=query5.getResultList(); for(String s:list5) { System.out.println(s); }
		 */
		
		
		/*
		 * String date4="15/12/2022"; Date date5=new
		 * SimpleDateFormat("dd/MM/yyyy").parse(date4); Query
		 * query6=session.createQuery("Select firstName from User where createdAt >:n");
		 * query6.setParameter("n", date5); List<String> list6=query6.getResultList();
		 * for(String s:list6) { System.out.println(s); }
		 */
		 
		
		/*
		 * Query query7=session.createQuery("from User where firstName not like 's%'");
		 * List<User> list7=query7.getResultList(); for(User u:list7) {
		 * System.out.println(u); }
		 */
		
		/*
		 * Query query8=session.createQuery("from User where emailId is not null");
		 * List<User> list8=query8.getResultList(); for(User u:list8) {
		 * System.out.println(u); }
		 */
		
		/*
		 * Query query9=session.createQuery("from User where emailId is null");
		 * List<User> list9=query9.getResultList(); for(User u:list9) {
		 * System.out.println(u); }
		 */
		
		/*
		 * Query query10=session.createQuery("from User where firstName like '%i'");
		 * List<User> list10=query10.getResultList(); for(User u:list10) {
		 * System.out.println(u); }
		 */
		
		/*
		 * Query query11=session.
		 * createQuery("Select accNo from User where firstName like '%dd%'"); List<Long>
		 * list11=query11.getResultList(); for(Long l:list11) { System.out.println(l); }
		 */
		
		/*
		 * Query query12=session.
		 * createQuery("Select accNo from User where balance=:n order by lastName");
		 * query12.setParameter("n", new BigDecimal(2000)); List<Long>
		 * list12=query12.getResultList(); for(Long l:list12) { System.out.println(l); }
		 */
		
		/*
		 * Query
		 * query13=session.createQuery("Select accNo from User where lastName!='chavan'"
		 * ); List<Long> list13=query13.getResultList(); for(Long l:list13) {
		 * System.out.println(l); }
		 */
		
		/*
		 * Query query14=session.createQuery("from User where id in (:n)");
		 * List<Integer> list14=new ArrayList<>(); list14.add(2); list14.add(3);
		 * query14.setParameter("n",list14); List<User> list15=query14.getResultList();
		 * for(User u:list15) { System.out.println(u); }
		 */
		
		/*
		 * Query query15=session.createQuery("from User where id not in (:n)");
		 * query15.setParameter("n", list14); List<User> list16=query15.getResultList();
		 * for(User u:list16) { System.out.println(list16); }
		 */
		
		
	}

}
