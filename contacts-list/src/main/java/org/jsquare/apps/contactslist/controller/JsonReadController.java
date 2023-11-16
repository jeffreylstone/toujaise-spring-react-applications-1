/**
 * 
 */
package org.jsquare.apps.contactslist.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsquare.apps.contactslist.repository.CountryCodes;
import org.jsquare.apps.contactslist.repository.CountryCodesRepository;
import org.jsquare.apps.contactslist.repository.CountryCodes_3166_1;
import org.jsquare.apps.contactslist.repository.StateProvinceCode;
import org.jsquare.apps.contactslist.repository.StateProvinceCodeRepository;
import org.jsquare.apps.contactslist.repository.StateProvinceCode_3166_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@RestController
@RequestMapping("/jsonread")
public class JsonReadController {

	@Autowired 
	private ConfigurableEnvironment environment;
	
	@Autowired
	private CountryCodesRepository ccRepository;
	
	@Autowired
	private StateProvinceCodeRepository spRepository;
	
	
	@GetMapping(path="/countryCodes", produces="application/json")
	public ResponseEntity<String> getCountryCodeData() {
		ResponseEntity<String> response = null;
		StringBuilder buffer = new StringBuilder();
		log.info("--countryCodes--");
		
		ObjectMapper mapper = new ObjectMapper();
		String filename = environment.getProperty("country.codes.file.name");
		
		try {
			CountryCodes_3166_1 container = mapper.readValue(new File(filename), CountryCodes_3166_1.class);
			List<CountryCodes> ccList = container.getList3166_1();

			int maxNameLength = 0;
			
			for (CountryCodes current : ccList) {
				if (current.getName().length() > maxNameLength) {
					maxNameLength = current.getName().length();
				}
				if (null != current.getCommonName() && current.getCommonName().length() > maxNameLength) {
					maxNameLength = current.getCommonName().length();
				}
				if (null != current.getOfficialName() && current.getOfficialName().length() > maxNameLength) {
					maxNameLength = current.getOfficialName().length();
				}
			}
			
			buffer.append("Maximum name/common name/official name length is:  " + maxNameLength).append("\n");
		
			response = ResponseEntity.ok(buffer.toString());
		}
		catch (IOException e) {
			response = ResponseEntity.status(500).body("Exception during JSON read!");
		}
		
		return response;
	}

	@GetMapping(path="/stateProvinceCode", produces="application/json")
	public ResponseEntity<String> getStateProvinceCodeData() {
		ResponseEntity<String> response = null;
		StringBuilder buffer = new StringBuilder();
		
		ObjectMapper mapper = new ObjectMapper();
		String filename = environment.getProperty("state.province.code.file.name");

		try {
			StateProvinceCode_3166_2 container = mapper.readValue(new File(filename), StateProvinceCode_3166_2.class); 
			List<StateProvinceCode> spList = container.getList_3166_2();
			
			int maxCodeLength = 0;
			int maxNameLength = 0;
			int maxTypeLength = 0;
			
			for (StateProvinceCode current : spList) {
				
				if (current.getCode().length() > maxCodeLength) {
					maxCodeLength = current.getCode().length();
				}
				
				if (current.getName().length() > maxNameLength) {
					maxNameLength = current.getName().length();
				}
				
				if (null != current.getParent() && current.getParent().length() > maxNameLength) {
					maxNameLength = current.getParent().length();
				}

				if (current.getType().length() > maxTypeLength) {
					maxTypeLength = current.getType().length();
				}
			}
			
			buffer.append("Maximum code length is:  " + maxCodeLength).append("\n");
			buffer.append("Maximum name/parent length is:  " + maxNameLength).append("\n");
			buffer.append("Maximum type length is:  " + maxTypeLength).append("\n");
		
			response = ResponseEntity.ok(buffer.toString());
		}
		catch (IOException e) {
			response = ResponseEntity.status(500).body("Exception during JSON read!");
		}
		
		return response;
	}
	
	@PostMapping(path="/loadSpCode", consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces="application/json")
	public ResponseEntity<String> loadStateProvinceCode(@RequestParam("file") MultipartFile file) {
		ResponseEntity<String> response = null;
		StringBuilder buffer = new StringBuilder();
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			StateProvinceCode_3166_2 container = mapper.readValue(file.getBytes(), StateProvinceCode_3166_2.class); 
			List<StateProvinceCode> spList = container.getList_3166_2();
			
			int recordsWritten = 0;
			
			for (StateProvinceCode current : spList) {
				
				spRepository.save(current);
				if (++recordsWritten % 25 == 0) {
					log.info(recordsWritten + " recordsWritten...");
				}
			}
			
			buffer.append(recordsWritten).append(" records written!").append("\n");
		
			response = ResponseEntity.ok(buffer.toString());
		}
		catch (IOException e) {
			response = ResponseEntity.status(500).body("Exception during JSON read!");
		}
		
		return response;
	}
	
	@PostMapping(path="/loadCtryCodes", consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces="application/json")
	public ResponseEntity<String> loadCountryCodes(@RequestParam("file") MultipartFile file) {
		ResponseEntity<String> response = null;
		StringBuilder buffer = new StringBuilder();
		log.info("--load countryCodes--");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			CountryCodes_3166_1 container = mapper.readValue(file.getBytes(), CountryCodes_3166_1.class);
			List<CountryCodes> ccList = container.getList3166_1();

			int recordsWritten = 0;
			
			for (CountryCodes current : ccList) {
				
				ccRepository.save(current);
				if (++recordsWritten % 25 == 0) {
					log.info(recordsWritten + " records written...");
				}
			}
			
			buffer.append(recordsWritten).append(" records written!").append("\n");
		
			response = ResponseEntity.ok(buffer.toString());
		}
		catch (IOException e) {
			response = ResponseEntity.status(500).body("Exception during JSON read!");
		}
		
		return response;
	}
	
}
