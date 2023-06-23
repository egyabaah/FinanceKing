/**
 * 
 */
package com.egyabaah.FinanceKing.roles;

import com.egyabaah.FinanceKing.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
	@Enumerated(EnumType.STRING)
	private Role name;

	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
//	private String name;
	
	public Roles() {
		
	}

	public Roles(Role name, User user) {
		this.name = name;
		this.user = user;
	}
	public Roles(Role name) {
		this.name = name;
//		this.user = user;
	}


	//	public Roles(Role name) {
//		this.name = name.toString();
//	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Role getName() {
		return name;
//		return Role.ROLE_USER;
	}

	@Override
	public String toString() {
		return "Roles{" +
				"id=" + id +
				", name=" + name +
//				", user=" + user +
				'}';
	}
//	public String getName() {
////		return name;
//		return name;
//	}

	public void setName(Role name) {
		this.name = name;
	}

	
	
}
