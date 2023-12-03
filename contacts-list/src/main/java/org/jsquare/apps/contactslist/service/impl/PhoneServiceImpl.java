/**
 * PhoneServiceImpl.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.service.impl;

import java.util.UUID;

import org.jsquare.apps.contactslist.repository.PhoneLinkRepository;
import org.jsquare.apps.contactslist.repository.PhoneNumber;
import org.jsquare.apps.contactslist.repository.PhoneNumberRepository;
import org.jsquare.apps.contactslist.service.PhoneService;
import org.jsquare.apps.contactslist.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * PhoneServiceImpl
 */
@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneNumberRepository phoneRepository;
	
	@Autowired
	private PhoneLinkRepository phoneLinkRepository;
	
	@Override
	public Boolean isUniquePhoneNumber(PhoneNumber testPhoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID addPhoneToContact(UUID contactId, PhoneNumber newPhoneNumber, Integer phoneUsageCode,
			Boolean isPrimary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePhoneFromContact(UUID phoneLinkId) {
		
		try {
			phoneLinkRepository.deleteById(phoneLinkId);
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

	}

	@Override
	public PhoneNumber updatePhoneNumber(UUID phoneLinkId, PhoneNumber modifiedPhoneNumber, Integer phoneUsageCode,
			Boolean isPrimary) {
		// TODO Auto-generated method stub
		return null;
	}

}
