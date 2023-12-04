/**
 * AddressController.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231202
 * 
 */
package org.jsquare.apps.contactslist.controller;

import java.util.List;
import java.util.UUID;

import org.jsquare.apps.contactslist.model.AddressServicesRequest;
import org.jsquare.apps.contactslist.model.LinkedAddress;
import org.jsquare.apps.contactslist.repository.Address;
import org.jsquare.apps.contactslist.repository.AddressLink;
import org.jsquare.apps.contactslist.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * AddressController
 */
@Slf4j
@RestController
@RequestMapping("/services/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping(path="/isUnique", consumes="application/json", produces="application/json")
	public ResponseEntity<Boolean> isUniqueAddress(@RequestBody Address testAddress) {
		ResponseEntity<Boolean> response = null;
		
		Boolean result = addressService.isUniqueAddress(testAddress);
		
		response = ResponseEntity.ok(result);
		
		return response;
	}
	
	@PostMapping(path="/addAddressToContact", consumes="application/json", produces="application/json")
	public ResponseEntity<UUID> addAddressToContact(@RequestBody AddressServicesRequest request) {
		ResponseEntity<UUID> response = null;
		UUID result = addressService.addAddressToContact(request.getId(), request.getAddress(), 
				request.getAddressUsageCode(), request.getIsPrimary());
		
		if (null != result) {
			response = ResponseEntity.ok(result);
		}
		else {
			// TODO log error with appropriate message (including request.getId())
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}
		
		return response;
	}
	
	@PutMapping(path="/update", consumes="application/json", produces="application/json")
	public ResponseEntity<AddressLink> updateAddress(@RequestBody AddressServicesRequest request) {
		ResponseEntity<AddressLink> response = null;
		AddressLink result = addressService.updateAddress(request.getId(), request.getAddress(), 
				request.getAddressUsageCode(), request.getIsPrimary());
		
		if (null != result) {
			response = ResponseEntity.ok(result);
		}
		else {
			// TODO log error with appropriate message (including request.getId())
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}
		
		return response;
	}
	
	@GetMapping(path="/retrieveAddressLinksForContact/{contactId}", produces="application/json")
	public ResponseEntity<List<AddressLink>> getAddressLinksForContact(@PathVariable("contactId") UUID contactId) {
		ResponseEntity<List<AddressLink>> response = null;
		
		List<AddressLink> results = addressService.getAddressLinksForContact(contactId);
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			// TODO log error with appropriate message (including contactId)
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/retrieveLinkedAddressesForContact/{contactId}", produces="application/json")
	public ResponseEntity<List<LinkedAddress>> getLinkedAddressesForContact(@PathVariable("contactId") UUID contactId) {
		ResponseEntity<List<LinkedAddress>> response = null;
		
		List<LinkedAddress> results = addressService.getLinkedAddressesForContact(contactId);
		
		if (null != results) {
			response = ResponseEntity.ok(results);
		}
		else {
			// TODO log error with appropriate message (including contactId)
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/retrieveAddressLink/{addressLinkId}", produces="application/json")
	public ResponseEntity<AddressLink> getAddressLinkForId(@PathVariable("addressLinkId") UUID addressLinkId) {
		ResponseEntity<AddressLink> response = null;
		
		AddressLink result = addressService.getAddressLinkForId(addressLinkId);
		
		if (null != result) {
			response = ResponseEntity.ok(result);
		}
		else {
			// TODO log error with appropriate message (including addressLinkId)
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@GetMapping(path="/retrieveAddress/{addressId}", produces="application/json")
	public ResponseEntity<Address> getAddressForId(@PathVariable("addressId") UUID addressId) {
		ResponseEntity<Address> response = null;
		
		Address result = addressService.getAddressForId(addressId);
		
		if (null != result) {
			response = ResponseEntity.ok(result);
		}
		else {
			// TODO log error with appropriate message (including addressId)
			log.error("");
			response = ResponseEntity.internalServerError().build();
		}

		return response;
	}
	
	@DeleteMapping(path="/removeAddressFromContact/{addressLinkId}", produces="application/json")
    public ResponseEntity<AddressLink> removeAddressFromContact(@PathVariable("addressLinkId") UUID addressLinkId) {
    	ResponseEntity<AddressLink> response = null;
    	
    	addressService.removeAddressFromContact(addressLinkId);
    	
    	response = ResponseEntity.ok().build();
    	
    	return response;
    }
	
}
