/**
 * AttributeController.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20230925
 * 
 */
package org.jsquare.apps.contactslist.controller;

import java.util.List;

import org.jsquare.apps.contactslist.repository.AttributeUsageCode;
import org.jsquare.apps.contactslist.repository.CountryCodes;
import org.jsquare.apps.contactslist.repository.PhoneNumberCountryCode;
import org.jsquare.apps.contactslist.repository.PhoneTypeCode;
import org.jsquare.apps.contactslist.repository.StateProvinceCode;
import org.jsquare.apps.contactslist.service.AttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
@RequestMapping("/attributes")
public class AttributeController {
	
	@Autowired
	private AttributesService service;
	
	
	@GetMapping(path="/phoneCountryCode", produces="application/json")
	public ResponseEntity<List<PhoneNumberCountryCode>> getPhoneCountryCodes() {
		ResponseEntity<List<PhoneNumberCountryCode>> response = null;
		
		List<PhoneNumberCountryCode> results = service.getPhoneNumberCountryCodes();
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}

	@GetMapping(path="/phoneType", produces="application/json")
	public ResponseEntity<List<PhoneTypeCode>> getPhoneTypes() {
		ResponseEntity<List<PhoneTypeCode>> response = null;
		
		List<PhoneTypeCode> results = service.getPhoneTypeCodes();
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/attributeUsage", produces="application/json")
	public ResponseEntity<List<AttributeUsageCode>> getAttributeUsageCodes() {
		ResponseEntity<List<AttributeUsageCode>> response = null;
		
		List<AttributeUsageCode> results = service.getAttributeUsageCodes();
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/countryCodes", produces="application/json")
	public ResponseEntity<List<CountryCodes>> getCountryCodesList() {
		ResponseEntity<List<CountryCodes>> response = null;
		
		List<CountryCodes> results = service.getCountryCodesList();
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/stateProvince", produces="application/json")
	public ResponseEntity<List<StateProvinceCode>> getStateProvinceCodes() {
		ResponseEntity<List<StateProvinceCode>> response = null;
		
		List<StateProvinceCode> results = service.getStateProvinceCodes();
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/stateProvince/{alpha2}", produces="application/json")
	public ResponseEntity<List<StateProvinceCode>> getStateProvinceCodes(@PathVariable("alpha2") String alpha2) {
		ResponseEntity<List<StateProvinceCode>> response = null;
		
		List<StateProvinceCode> results = service.getStateProvinceCodes(alpha2);
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
}
