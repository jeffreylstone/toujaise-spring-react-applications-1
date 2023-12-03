/**
 * AddressLink.java
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
 * AddressLink
 */
@Entity
@Table(name="address_link")
@AllArgsConstructor
@Getter
@Setter
public class AddressLink {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "contact_id")
	private UUID contactId;
	
	@Column(name = "address_id")
	private UUID addressId;
	
	@Column(name = "addr_usage_cd")
	private Integer addressUsageCode;
	
	@Column(name = "is_primary")
	private Boolean isPrimary;

	/**
	 * Default (No args) constructor for this class.  Sets a value for ID with a randomly generated UUID.
	 */
	public AddressLink() {
		
		this.setId(UUID.randomUUID());
		
	}
	
}
