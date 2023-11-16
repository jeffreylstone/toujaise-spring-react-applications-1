/**
 * AttributesService.java
 * Interface for retrieval services for various attributes related to Contacts List 
 * jeffrey.l.stone@gmail.com
 * 20231006
 * 
 */
package org.jsquare.apps.contactslist.service;

import java.util.List;

import org.jsquare.apps.contactslist.repository.AttributeUsageCode;
import org.jsquare.apps.contactslist.repository.CountryCodes;
import org.jsquare.apps.contactslist.repository.PhoneNumberCountryCode;
import org.jsquare.apps.contactslist.repository.PhoneTypeCode;
import org.jsquare.apps.contactslist.repository.StateProvinceCode;

/**
 * AttributesService
 */
public interface AttributesService {
	
	/**
	 * @return
	 */
	public List<PhoneNumberCountryCode> getPhoneNumberCountryCodes();
	
	/**
	 * @return
	 */
	public List<PhoneTypeCode> getPhoneTypeCodes();
	
	/**
	 * @return
	 */
	public List<CountryCodes> getCountryCodesList();
	
	/**
	 * @return
	 */
	public List<AttributeUsageCode> getAttributeUsageCodes();
	
	/**
	 * @return
	 */
	public List<StateProvinceCode> getStateProvinceCodes();
	
	/**
	 * @param countryCodes
	 * @return
	 */
	public List<StateProvinceCode> getStateProvinceCodes(CountryCodes countryCodes);
	
	/**
	 * @param countryCode
	 * @return
	 */
	public List<StateProvinceCode> getStateProvinceCodes(String countryCode);
	
}
