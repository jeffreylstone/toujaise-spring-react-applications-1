/**
 * EmailServiceImpl.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.service.impl;

import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Email;
import org.jsquare.apps.contactslist.repository.EmailLinkRepository;
import org.jsquare.apps.contactslist.repository.EmailRepository;
import org.jsquare.apps.contactslist.service.EmailService;
import org.jsquare.apps.contactslist.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * EmailServiceImpl
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private EmailLinkRepository emailLinkRepository;
	
	

	@Override
	public Boolean isUniqueEmail(Email testEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID addEmailToContact(UUID contactId, Email newEmail, Integer emailUsageCode, Boolean isPrimary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmailFromContact(UUID emailLinkId) {
			
		try {
			emailLinkRepository.deleteById(emailLinkId);
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

	}

	@Override
	public Email updateEmail(UUID emailLinkId, Email modifiedEmail, Integer emailUsageCode, Boolean isPrimary) {
		// TODO Auto-generated method stub
		return null;
	}

}
