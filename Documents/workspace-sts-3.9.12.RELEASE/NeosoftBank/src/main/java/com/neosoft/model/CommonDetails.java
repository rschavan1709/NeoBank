package com.neosoft.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.hibernate.envers.Audited;
//import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

public class CommonDetails {
	
	
	@Id
	//@NotAudited
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean isActive = true;
	
	//@NotAudited
		@Column(name = "created_date", nullable = false, updatable = false)
	    @CreatedDate
	    @Temporal(TemporalType.DATE)
	    private Date createdAt;
		
		@Column(name = "modified_date")
	    @LastModifiedDate
	    @Temporal(TemporalType.DATE)
		private Date updatedAt;

	public CommonDetails(int id, boolean isActive, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public CommonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}