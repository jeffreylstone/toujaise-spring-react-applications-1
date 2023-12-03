/**
 * ContactServiceImpl.java
 * Concrete implementation of ContactService interface.
 * jeffrey.l.stone@gmail.com
 * 20231003
 * 
 */
package org.jsquare.apps.contactslist.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Contact;
import org.jsquare.apps.contactslist.repository.ContactRepository;
import org.jsquare.apps.contactslist.service.ContactService;
import org.jsquare.apps.contactslist.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * ContactServiceImpl
 */
@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository repository;

	@Override
	public Contact createContact(Contact newContact) {
		Contact contact = null;
		
		try {
			// TODO if contact already exists for this firstName, middleNameOrInitial, 
			//  lastName, suffix, and identifier, return existing contact (which may 
			//  then be compared to input contact for error checking/messaging)
			contact = this.contactExists(newContact);
			if (null == contact) {
				contact = repository.save(newContact);
			}
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return contact;
	}

	private Contact contactExists(Contact newContact) {
		List<Contact> matchingContactsList = null;
		Contact matchingContact = null;
		
		matchingContactsList = this.retrieveMatchingContacts(newContact);
		
		if (null != matchingContactsList) {
			for (Contact current : matchingContactsList) {
				if (newContact.getIdentifier().equalsIgnoreCase(current.getIdentifier())) {
					matchingContact = current;
				}
			}
		}

		return matchingContact;
	}

	@Override
	public List<Contact> retrieveContacts() {
		List<Contact> contacts = null;

		try {
			contacts = repository.findAll();
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
		
		return contacts;
	}

	@Override
	public List<Contact> retrieveFilteredContacts(String searchText) {
		List<Contact> contacts = null;

		String[] searchElements = searchText.split(" ");
		String lastNameToken = null;
		
		if (2 == searchElements.length) {
			lastNameToken = searchElements[1].trim() + "%";
			String firstNameToken = searchElements[0].trim() + "%";

			try {
				contacts = repository.findMatchingContactsFromTwoNames(lastNameToken, firstNameToken);
			}
			catch (DataAccessException dae) {
				log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
			}
		}
		else if (1 == searchElements.length) {
			lastNameToken = searchElements[0].trim() + "%";
			
			try {
				contacts = repository.findMatchingContactsFromSingleName(lastNameToken);
			}
			catch (DataAccessException dae2) {
				log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae2);
			}
		}
		
		return contacts;
	}
	
	@Override
	public Contact retrieveContact(UUID id) {
		Contact contact = null;
		
		try {
			Optional<Contact> result = repository.findById(id);
			if (result.isPresent()) {
				contact = result.get();
			}
			else {
				contact = new Contact();
			}
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return contact;
	}

	@Override
	public Contact updateContact(Contact modifiedContact) {
		Contact contact = null;
		
		try {
			contact = repository.save(modifiedContact);
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return contact;
	}

	@Override
	public void deleteContact(UUID id) {

		try {
			repository.deleteById(id);
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
	}

	@Override
	public List<Contact> retrieveMatchingContacts(Contact searchContact) {
		List<Contact> matchingList = null;
		
		try {
			matchingList = repository.findMatchingContacts(searchContact.getLastName(), 
					searchContact.getFirstName(), searchContact.getMiddleNameOrInitial(),
					searchContact.getSuffix());
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
		
		return matchingList;
	}

	@Override
	public Boolean isUniqueContact(List<Contact> matchingContacts, Contact searchContact) {
		Boolean unique = Boolean.TRUE;
		
		Iterator<Contact> iterator = matchingContacts.iterator();
		
		while (unique && iterator.hasNext()) {
			if (iterator.next().getIdentifier().equalsIgnoreCase(searchContact.getIdentifier())) {
				unique = Boolean.FALSE;
			}
		}
		
		return unique;
	}

	@Override
	public Boolean isValidContact(Contact testContact) {
		Boolean valid = Boolean.FALSE;
		
		if (null == testContact) {
			throw new IllegalArgumentException("testContact MUST NOT be null!");
		}
		
		if ((null != testContact.getLastName() && Constants.LAST_NAME_MAX_LENGTH >= testContact.getLastName().length()) 
			&& (null != testContact.getFirstName() && Constants.FIRST_NAME_MAX_LENGTH >= testContact.getFirstName().length()) 
			&& (null != testContact.getMiddleNameOrInitial() && Constants.MIDDLE_NAME_MAX_LENGTH >= testContact.getMiddleNameOrInitial().length()) 
			&& (null != testContact.getSuffix() && Constants.SUFFIX_NAME_MAX_LENGTH >= testContact.getSuffix().length()) 
			&& (null == testContact.getPreferredFirstName() || Constants.PREFERRED_NAME_MAX_LENGTH >= testContact.getPreferredFirstName().length()) 
			&& (null == testContact.getIdentifier() || Constants.IDENTIFIER_MAX_LENGTH >= testContact.getIdentifier().length()) 
			&& (null != testContact.getId())) {
			valid = Boolean.TRUE;
		}

		return valid;
	}

}
