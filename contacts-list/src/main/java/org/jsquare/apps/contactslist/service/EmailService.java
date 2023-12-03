/**
 * EmailService.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.service;

import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Email;


/**
 * EmailService
 */
public interface EmailService {
	
	/**
	 * @param testEmail Email object to be tested against repository
	 * @return (Boolean) true, if testEmail is unique (by ... combination) -- (i.e., does not exist), false, otherwise
	 */
	public Boolean isUniqueEmail(Email testEmail);
	
	/**
	 * @param contactId ID of Contact to which Email is being added
	 * @param newEmail Email object to "link" to Contact
	 * @param emailUsageCode
	 * @param isPrimary
	 * @return (UUID) ID of created EmailLink, null if update was unsuccessful
	 */
	public UUID addEmailToContact(UUID contactId, Email newEmail, Integer emailUsageCode, Boolean isPrimary);
	
	/**
	 * @param emailLinkId ID of EmailLink object to be "unlinked" from Contact
	 */
	public void removeEmailFromContact(UUID emailLinkId);
	
	/**
	 * @param emailLinkId
	 * @param modifiedEmail modified Email object
	 * @param emailUsageCode
	 * @param isPrimary
	 * @return (Email) reference to updated Email object, null if update was unsuccessful
	 */
	public Email updateEmail(UUID emailLinkId, Email modifiedEmail, Integer emailUsageCode, Boolean isPrimary);

}
