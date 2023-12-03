/**
 * AddressServicesRequest.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231202
 * 
 */
package org.jsquare.apps.contactslist.model;

import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AddressServicesRequest
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressServicesRequest {
	
	private UUID id;
	private Address address;
	private Integer addressUsageCode;
	private Boolean isPrimary;

}
