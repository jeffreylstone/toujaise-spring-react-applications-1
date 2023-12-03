/**
 * Email.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231128
 * 
 */
package org.jsquare.apps.contactslist.repository;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Email
 */
@Entity
@Table(name="email")
@AllArgsConstructor
@Getter
@Setter
public class Email {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "email_addr")
	private String emailAddress;

	/**
	 * Default (No args) constructor for this class.  Sets a value for ID with a randomly generated UUID.
	 */
	public Email() {
		
		this.setId(UUID.randomUUID());
		
	}
	
}
