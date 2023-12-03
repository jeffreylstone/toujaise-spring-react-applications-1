/**
 * PhoneService.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.service;

import java.util.UUID;

import org.jsquare.apps.contactslist.repository.PhoneNumber;

/**
 * PhoneService
 */
public interface PhoneService {
	
	/**
	 * @param testPhoneNumber PhoneNumber object to be tested against repository
	 * @return (Boolean) true, if testPhoneNumber is unique (by country code/phone number/extension combination) -- (i.e., does not exist), false, otherwise
	 */
	public Boolean isUniquePhoneNumber(PhoneNumber testPhoneNumber);
	
	/**
	 * @param contactId ID of Contact to which PhoneNumber is being added
	 * @param newPhoneNumber PhoneNumber object to "link" to Contact
	 * @param phoneUsageCode
	 * @param isPrimary
	 * @return (UUID) ID of created PhoneLink, null if update was unsuccessful
	 */
	public UUID addPhoneToContact(UUID contactId, PhoneNumber newPhoneNumber, Integer phoneUsageCode, Boolean isPrimary);
	
	/**
	 * @param phoneLinkId ID of PhoneLink object to be "unlinked" from Contact
	 */
	public void removePhoneFromContact(UUID phoneLinkId);
	
	/**
	 * @param phoneLinkId
	 * @param modifiedPhoneNumber modified PhoneNumber object
	 * @param phoneUsageCode
	 * @param isPrimary
	 * @return (PhoneNumber) reference to updated PhoneNumber object, null if update was unsuccessful
	 */
	public PhoneNumber updatePhoneNumber(UUID phoneLinkId, PhoneNumber modifiedPhoneNumber, Integer phoneUsageCode, Boolean isPrimary);

}
