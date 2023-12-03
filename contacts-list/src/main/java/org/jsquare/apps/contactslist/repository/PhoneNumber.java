/**
 * PhoneNumber.java
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
 * PhoneNumber
 */
@Entity
@Table(name="phone_number")
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumber {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "phone_country_cd")
	private String phoneCountryCode;
	
	@Column(name = "phone_nbr")
	private String phoneNumber;
	
	@Column(name = "phone_nbr_ext")
	private String phoneNumberExt;
	
	@Column(name = "phone_type_cd")
	private Integer phoneTypeCode;

	/**
	 * Default (No args) constructor for this class.  Sets a value for ID with a randomly generated UUID.
	 */
	public PhoneNumber() {
		
		this.setId(UUID.randomUUID());
		
	}
	
}
