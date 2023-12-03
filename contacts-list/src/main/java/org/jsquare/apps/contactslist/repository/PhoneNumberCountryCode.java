/**
 * PhoneNumberCountryCode.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231008
 * 
 */
package org.jsquare.apps.contactslist.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumberCountryCode {
	
	private String alpha2;
	
	private String name;
	
	private Integer phoneNbrCtryCd;

	public PhoneNumberCountryCode(String alpha2, Integer phoneNbrCtryCd) {
		this.alpha2 = alpha2;
		this.phoneNbrCtryCd = phoneNbrCtryCd;
	}
}
