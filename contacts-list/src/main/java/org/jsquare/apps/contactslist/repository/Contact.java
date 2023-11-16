/**
 * Contact.java
 * JPA Entity for contact table
 * jeffrey.l.stone@gmail.com
 * 20230924
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
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contact
 */
@Entity
@Table(name="contact")
//@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Contact {

	@Id
	@Column(name="id", nullable=false, unique=true)
	private UUID id;
	
	@Column(name="last_name", length=63, nullable=false, unique=false)
	private String lastName;
	
	@Column(name="first_name", length=63, nullable=false, unique=false)
	private String firstName;
	
	@Column(name="preferred_first_name", length=63, nullable=true, unique=false)
	private String preferredFirstName;

	@Column(name="middle_name_initial", length=63, nullable=true, unique=false)
	private String middleNameOrInitial;
	
	@Column(name="suffix", length=31, nullable=true, unique=false)
	private String suffix;
	
	@Column(name="identifier", length=127, nullable=false, unique=false)
	private String identifier;
	
	
	/**
	 * Default (No args) constructor for this class.  Sets a value for ID with a randomly generated UUID.
	 */
	public Contact() {
		
		this.setId(UUID.randomUUID());
		
	}
	
}
