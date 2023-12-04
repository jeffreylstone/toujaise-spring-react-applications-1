/**
 * LinkedAddress.java
 * Composite object built from AddressLink object and fully expanded Address object
 * jeffrey.l.stone@gmail.com
 * 20231204
 * 
 */
package org.jsquare.apps.contactslist.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * LinkedAddress
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkedAddress {
	
	public static final int LINKED_ADDRESS_NUMBER_OF_FIELDS = 11;
	
	private UUID id;
	private UUID contactId;
	private UUID addressId;		// equal to "id" in Address
	private String address1;
	private String address2;
	private String city;
	private String countryCode;
	private String stateProvinceCode;
	private String postalCode;
	private Integer addressUsageCode;
	private Boolean isPrimary;

}
