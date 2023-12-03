/**
 * Address.java
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
 * Address
 */
@Entity
@Table(name="address")
@AllArgsConstructor
@Getter
@Setter
public class Address {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country_cd")
	private String countryCode;
	
	@Column(name = "state_prov_cd")
	private String stateProvinceCode;
	
	@Column(name = "postal_code")
	private String postalCode;

	/**
	 * Default (No args) constructor for this class.  Sets a value for ID with a randomly generated UUID.
	 */
	public Address() {
		
		this.setId(UUID.randomUUID());
		
	}
	
}
