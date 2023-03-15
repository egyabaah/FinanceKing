/**
 * 
 */
package com.egyabaah.FinanceKing.roles;

import jakarta.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author gyabe
 *
 */

@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(length = 20)
//	@Enumerated(EnumType.STRING)
//	private Role name;
	
	private String name;
	
	public Roles() {
		
	}
	
	public Roles(Role name) {
		this.name = name.toString();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
//	public Role getName() {
////		return name;
//		return Role.ROLE_USER;
//	}
	
	public String getName() {
//		return name;
		return name;
	}

	public void setName(Role name) {
		this.name = name.toString();
	}

	
	
}
