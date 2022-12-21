package com.claudiourru.capstone.models;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
	private Long id;
	
	@Column(unique = true, nullable = false)
    private String username;
	
	private String password;
	
	private boolean active;
	
	private String fullName;
	
	private String email;
	
	
	@Builder.Default
	@ManyToMany 
	@Enumerated(EnumType.STRING)
    @JoinTable(name = "user_roles", 
    		joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
	private Set<Role> roles = new HashSet();
	
	
    public void addRole( Role r ) {
        this.roles.add( r );
    }


	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean b) {
		active = b;
	}
	
}


