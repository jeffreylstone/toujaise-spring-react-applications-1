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
	
	private static final String DATABASE_EXCEPTION_MESSAGE = "Error occurred during database operation!";
	private static final int LAST_NAME_MAX_LENGTH = 63;
	private static final int FIRST_NAME_MAX_LENGTH = 63;
	private static final int MIDDLE_NAME_MAX_LENGTH = 63;
	private static final int SUFFIX_NAME_MAX_LENGTH = 31;
	private static final int PREFERRED_NAME_MAX_LENGTH = 63;
	private static final int IDENTIFIER_MAX_LENGTH = 127;
	
	@Autowired
	ContactRepository repository;

	@Override
	public Contact createContact(Contact newContact) {
		Contact contact = null;
		
		try {
			contact = repository.save(newContact);
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return contact;
	}

	@Override
	public List<Contact> retrieveContacts() {
		List<Contact> contacts = null;

		try {
			contacts = repository.findAll();
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE, dae);
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
			log.error(DATABASE_EXCEPTION_MESSAGE, dae);
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
			log.error(DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return contact;
	}

	@Override
	public void deleteContact(UUID id) {

		try {
			repository.deleteById(id);
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE, dae);
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
			log.error(DATABASE_EXCEPTION_MESSAGE, dae);
//			matchingList = Collections.emptyList();
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
		
		if ((null != testContact.getLastName() && LAST_NAME_MAX_LENGTH >= testContact.getLastName().length()) 
			&& (null != testContact.getFirstName() && FIRST_NAME_MAX_LENGTH >= testContact.getFirstName().length()) 
			&& (null != testContact.getMiddleNameOrInitial() && MIDDLE_NAME_MAX_LENGTH >= testContact.getMiddleNameOrInitial().length()) 
			&& (null != testContact.getSuffix() && SUFFIX_NAME_MAX_LENGTH >= testContact.getSuffix().length()) 
			&& (null == testContact.getPreferredFirstName() || PREFERRED_NAME_MAX_LENGTH >= testContact.getPreferredFirstName().length()) 
			&& (null == testContact.getIdentifier() || IDENTIFIER_MAX_LENGTH >= testContact.getIdentifier().length()) 
			&& (null != testContact.getId())) {
			valid = Boolean.TRUE;
		}

		return valid;
	}

}
