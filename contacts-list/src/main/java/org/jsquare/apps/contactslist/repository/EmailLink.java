/**
 * EmailLink.java
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
 * EmailLink
 */
@Entity
@Table(name="email_link")
@AllArgsConstructor
@Getter
@Setter
public class EmailLink {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "contact_id")
	private UUID contactId;
	
	@Column(name = "email_id")
	private UUID emailId;
	
	@Column(name = "email_usage_cd")
	private Integer emailUsageCode;
	
	@Column(name = "is_primary")
	private Boolean isPrimary;

	/**
	 * Default (No args) constructor for this class.  Sets a value for ID with a randomly generated UUID.
	 */
	public EmailLink() {
		
		this.setId(UUID.randomUUID());
		
	}
	
}
