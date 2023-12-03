/**
 * ContactService.java
 * Interface for CRUD (and other) services related to Contact object
 * jeffrey.l.stone@gmail.com
 * 20231003
 * 
 */
package org.jsquare.apps.contactslist.service;

import java.util.List;
import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Contact;
import org.springframework.stereotype.Service;

/**
 * ContactService
 */
//@Service
public interface ContactService {
	
	/**
	 * @param newContact
	 * @return
	 */
	public Contact createContact(Contact newContact);

	/**
	 * @param id
	 * @return
	 */
	public Contact retrieveContact(UUID id);

	/**
	 * @return
	 */
	public List<Contact> retrieveContacts();

	/**
	 * @return
	 */
	public List<Contact> retrieveFilteredContacts(String searchText);

	/**
	 * @param modifiedContact
	 * @return
	 */
	public Contact updateContact(Contact modifiedContact);
	
	/**
	 * @param id
	 */
	public void deleteContact(UUID id);
	
	/**
	 * @param searchContact
	 * @return
	 */
	public List<Contact> retrieveMatchingContacts(Contact searchContact);
	
	/**
	 * @param matchingContacts
	 * @param searchContact
	 * @return
	 */
	public Boolean isUniqueContact(List<Contact> matchingContacts, Contact searchContact);
	
	/**
	 * @param testContact
	 * @return
	 */
	public Boolean isValidContact(Contact testContact);

}
