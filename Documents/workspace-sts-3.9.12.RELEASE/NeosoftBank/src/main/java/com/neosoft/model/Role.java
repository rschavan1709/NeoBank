package com.neosoft.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neosoft.utility.RoleType;

@Entity
public class Role extends CommonDetails {

	private RoleType roleType;
	
	@ManyToMany(mappedBy = "role",fetch = FetchType.EAGER)
	@JsonIgnore
    private Set<User> user = new HashSet();

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [roleType=" + roleType + "]";
	}

	
	
}
