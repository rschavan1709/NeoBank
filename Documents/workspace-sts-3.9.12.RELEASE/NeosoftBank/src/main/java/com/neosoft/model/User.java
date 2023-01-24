package com.neosoft.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neosoft.service.AccountNumber;

@Entity
@NamedQuery(name = "User.findNotEmailId",
query = "select u from User u where u.emailId!=:n")
@Component
public class User extends CommonDetails implements Serializable{

	@NotNull(message = "firstname is required")
	private String firstName;
	
	@NotNull(message = "middlename is required")
	private String middleName;
	
	@NotNull(message = "lastname is required")
	private String lastName;
	
	private long accNo;
	
	@Pattern(regexp = "(0|91)?[7-9]{1}[0-9]{9}",message = "mobile number should be 10 digits and starting with 0 or 91")
	private String mobileNo;
	
	@Column(unique=true)
	@Email(message = "invalid emailid")
	private String emailId;
	
	@Column(unique = true)
	@Pattern(regexp = "^[A-Za-z0-9]{5,10}$",message = "username should be alphanumeric and length of username should be minimum 5 and maximum 10")
	private String username;
	
	@Pattern(regexp = "^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$",message = "password should be at least 8 characters and at most 15 characters. password have at least 1 uppercase character, 1 lowercase character, 1 special character and 1 digit")
	private String password;
	
	@Column(unique=true)
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "pan card should be ten characters.The first five upper case alphabets, next four characters should be any number,The last(tenth) character should be any upper case alphabet, It should not contain any white spaces.")
	private String panId;
	
	private BigDecimal balance;
	//private boolean isActive;
	//private LocalDateTime createdAt;
	//private LocalDateTime updatedAt;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "accoNo",referencedColumnName = "accNo" )
	//@JsonIgnore
	private Set<Transaction> transaction;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name="user_role",
			joinColumns = { @JoinColumn(name = "user_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id") }
			)
	//@JsonIgnore
	Set<Role> role = new HashSet<>();
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "userId",referencedColumnName = "id") Set<Notifications>
	 * notifications = new HashSet<>();
	 */
	public User(int id, boolean isActive, Date createdAt, Date updatedAt) {
		super(id, isActive, createdAt, updatedAt);
	}
	
	/*
	 * public Set<Notifications> getNotifications() { return notifications; }
	 * 
	 * public void setNotifications(Set<Notifications> notifications) {
	 * this.notifications = notifications; }
	 */
	/*
	 * public int getUserId() { return userId; }
	 * 
	 * 
	 * public void setUserId(int userId) { this.userId = userId; }
	 */
	
	public User( String firstName, String middleName,String lastName, long accNo, String mobileNo,String emailId,
			String username, String password, String panId,BigDecimal balance, Set<Role> role, Set<Notifications> notifications,Set<Transaction> transactions) {
			super();
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.accNo = accNo;
			this.mobileNo = mobileNo;
			this.emailId = emailId;
			this.username = username;
			this.password = password;
			this.panId = panId;
			this.balance = balance;
			this.role = role;
			//this.notifications = notifications;
			this.transaction = transactions;
		}
	
	public User( String firstName, String middleName,String lastName, long accNo, String mobileNo,String emailId,
			String username, String password, String panId,BigDecimal balance, Set<Role> role, Set<Notifications> notifications) {
			super();
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.accNo = accNo;
			this.mobileNo = mobileNo;
			this.emailId = emailId;
			this.username = username;
			this.password = password;
			this.panId = panId;
			this.balance = balance;
			this.role = role;
			//this.notifications = notifications;
		}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public long getAccNo() {
		return accNo;
	}


	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPanId() {
		return panId;
	}


	public void setPanId(String panId) {
		this.panId = panId;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	/*
	 * public boolean isActive() { return isActive; }
	 * 
	 * 
	 * public void setActive(boolean isActive) { this.isActive = isActive; }
	 * 
	 * 
	 * public LocalDateTime getCreatedAt() { return createdAt; }
	 * 
	 * 
	 * public void setCreatedAt(LocalDateTime createdAt) { this.createdAt =
	 * createdAt; }
	 * 
	 * 
	 * public LocalDateTime getUpdatedAt() { return updatedAt; }
	 * 
	 * 
	 * public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt =
	 * updatedAt; }
	 * 
	 */
	public Set<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public User() {
		super();
		AccountNumber ac=AccountNumber.getInstance();
		this.accNo=ac.getAccountNumber();
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", accNo="
				+ accNo + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", username=" + username + ", password="
				+ password + ", panId=" + panId + ", balance=" + balance + ", transaction=" + transaction + ", role="
				+ role +  "]";
	}

	
}
