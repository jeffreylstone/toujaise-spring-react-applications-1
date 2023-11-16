/**
 * PhoneNumberCountryCodes.java
 * Singleton Map of phone number country codes (keyed by region code)
 * jeffrey.l.stone@gmail.com
 * 20231008
 * 
 */
package org.jsquare.apps.contactslist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jsquare.apps.contactslist.repository.PhoneNumberCountryCode;

import com.google.i18n.phonenumbers.CountryCodeToRegionCodeMap;

/**
 * PhoneNumberCountryCodes
 */
public class PhoneNumberCountryCodes {
	
	private List<PhoneNumberCountryCode> phoneNumberCountryCodes = null;
	
	private PhoneNumberCountryCodes() {
		this.phoneNumberCountryCodes = new ArrayList<>();
		
		Map<Integer, List<String>> countryCodeRegionCodeMap = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap();
		Map<String, Integer> pnccMap = new TreeMap<>();
		
		for (Map.Entry<Integer, List<String>> current : countryCodeRegionCodeMap.entrySet()) {
			for (String nextKey : current.getValue()) {
				pnccMap.put(nextKey, current.getKey());
			}
		}
		for (Map.Entry<String, Integer> nextElement : pnccMap.entrySet()) {
			PhoneNumberCountryCode pncc = new PhoneNumberCountryCode(nextElement.getKey(), nextElement.getValue());
			this.phoneNumberCountryCodes.add(pncc);
		}
	}
	
	/**
	 * Bill Pugh Singleton methodology
	 */
	private static class PNCC_Singleton {
		private static final PhoneNumberCountryCodes INSTANCE = new PhoneNumberCountryCodes();
	}
	
	/**
	 * @return
	 */
	public static PhoneNumberCountryCodes getInstance() {
		return PNCC_Singleton.INSTANCE;
	}
	
	/**
	 * @return
	 */
	public List<PhoneNumberCountryCode> getPhoneNumberCountryCodes() {
		return this.phoneNumberCountryCodes;
	}

}
