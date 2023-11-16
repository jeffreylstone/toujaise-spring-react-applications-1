/**
 * AttributesServiceImpl.java
 * Concrete implementation of AttributesService interface
 * jeffrey.l.stone@gmail.com
 * 20231007
 * 
 */
package org.jsquare.apps.contactslist.service.impl;

import java.util.List;

import org.jsquare.apps.contactslist.model.PhoneNumberCountryCodes;
import org.jsquare.apps.contactslist.repository.AttributeUsageCode;
import org.jsquare.apps.contactslist.repository.AttributeUsageRepository;
import org.jsquare.apps.contactslist.repository.CountryCodes;
import org.jsquare.apps.contactslist.repository.CountryCodesRepository;
import org.jsquare.apps.contactslist.repository.PhoneNumberCountryCode;
import org.jsquare.apps.contactslist.repository.PhoneTypeCode;
import org.jsquare.apps.contactslist.repository.PhoneTypeRepository;
import org.jsquare.apps.contactslist.repository.StateProvinceCode;
import org.jsquare.apps.contactslist.repository.StateProvinceCodeRepository;
import org.jsquare.apps.contactslist.service.AttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * AttributesServiceImpl
 */
@Service
@Slf4j
public class AttributesServiceImpl implements AttributesService {
	
	private static final String DATABASE_EXCEPTION_MESSAGE = "Error occurred during database operation!";

	@Autowired
	private AttributeUsageRepository auRepository;
	
	@Autowired
	private CountryCodesRepository ccRepository;
	
	@Autowired
	private PhoneTypeRepository ptRepository;
	
	@Autowired
	private StateProvinceCodeRepository spRepository;
	
	
	@Override
	public List<PhoneNumberCountryCode> getPhoneNumberCountryCodes() {
		return PhoneNumberCountryCodes.getInstance().getPhoneNumberCountryCodes();
	}

	@Override
	public List<PhoneTypeCode> getPhoneTypeCodes() {
		List<PhoneTypeCode> phoneTypeCodes = null;
		
		try {
			phoneTypeCodes = ptRepository.findAll();
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE);
		}

		return phoneTypeCodes;
	}

	@Override
	public List<CountryCodes> getCountryCodesList() {
		List<CountryCodes> countryCodesList = null;
		
		try {
			countryCodesList = ccRepository.findAll();
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE);
		}

		return countryCodesList;
	}

	@Override
	public List<AttributeUsageCode> getAttributeUsageCodes() {
		List<AttributeUsageCode> attributeUsageCodes = null;
		
		try {
			attributeUsageCodes = auRepository.findAll();
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE);
		}

		return attributeUsageCodes;
	}

	@Override
	public List<StateProvinceCode> getStateProvinceCodes() {
		List<StateProvinceCode> stateProvinceCodes = null;
		
		try {
			stateProvinceCodes = spRepository.findAll();
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE);
		}

		return stateProvinceCodes;
	}

	@Override
	public List<StateProvinceCode> getStateProvinceCodes(CountryCodes countryCodes) {
		List<StateProvinceCode> stateProvinceCodes = null;
		
		try {
			stateProvinceCodes = spRepository.findByAlpha2(countryCodes.getAlpha2());
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE);
		}

		return stateProvinceCodes;
	}

	@Override
	public List<StateProvinceCode> getStateProvinceCodes(String countryCode) {
		List<StateProvinceCode> stateProvinceCodes = null;
		
		try {
			stateProvinceCodes = spRepository.findByAlpha2(countryCode);
		}
		catch (DataAccessException dae) {
			log.error(DATABASE_EXCEPTION_MESSAGE);
		}

		return stateProvinceCodes;
	}

}
