/**
 * ContactController.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20230925
 * 
 */
package org.jsquare.apps.contactslist.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Contact;
import org.jsquare.apps.contactslist.service.ContactService;
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
 * 
 */
@Slf4j
@RestController
@RequestMapping("/services/contacts")
public class ContactController {
	
    @Autowired
    private ContactService service;
    
    @GetMapping(path="/jeff", produces="application/json")
    public ResponseEntity<List<Contact>> matchingList() {
    	ResponseEntity<List<Contact>> response = null;
    	log.info("--/jeff--");
    	
//    	List<Contact> matchingList = repository.findMatchingContacts("Stone", "Jeffrey", "L.", "");
//    	
//    	response = ResponseEntity.ok(matchingList);
    	return response;
    }

    @PostMapping(path="/create", consumes="application/json", produces="application/json")
    public ResponseEntity<Contact> createContact(@RequestBody Contact newContact) throws URISyntaxException {
    	ResponseEntity<Contact> response = null;
    	
    	Contact contact = service.createContact(newContact);
    	
    	if (null != contact) {
    		response = ResponseEntity.created(new URI("/contacts/" + contact.getId())).body(contact);
    	}
    	else {
    		response = ResponseEntity.internalServerError().build();
    	}
    	
    	return response;
    }
    
    @GetMapping(path="/retrieve", produces="application/json")
    public ResponseEntity<List<Contact>> retrieveContacts() {
    	ResponseEntity<List<Contact>> response = null;

    	List<Contact> contacts = service.retrieveContacts();
    	
    	if (null != contacts) {
    		response = ResponseEntity.ok(contacts);
    	}
    	else {
    		response = ResponseEntity.internalServerError().build();
    	}
    	
    	return response;
    }
    
    @GetMapping(path="/retrieve/{id}", produces="application/json")
    public ResponseEntity<Contact> retrieveContact(@PathVariable(value = "id") UUID id) {
    	ResponseEntity<Contact> response = null;

    	Contact contact = service.retrieveContact(id);
    	
    	if (null != contact) {
    		if (null != contact.getId()) {
    			response = ResponseEntity.ok(contact);
    		}
    		else {
    			response = ResponseEntity.noContent().build();
    		}
    	}
    	else {
    		response = ResponseEntity.internalServerError().build();
    	}
    	
    	return response;
    }
    
    @GetMapping(path="/retrieve/filtered/{searchText}", produces="application/json")
    public ResponseEntity<List<Contact>> retrieveFilteredContacts(@PathVariable(value = "searchText") String searchText) {
    	ResponseEntity<List<Contact>> response = null;

    	List<Contact> contacts = service.retrieveFilteredContacts(searchText);
    	
    	if (null != contacts) {
    		if (!contacts.isEmpty()) {
        		response = ResponseEntity.ok(contacts);
    		}
    		else {
    			response = ResponseEntity.noContent().build();
    		}
    	}
    	else {
    		response = ResponseEntity.internalServerError().build();
    	}
    	
    	return response;
    }
    
    @PutMapping(path="/update", consumes="application/json", produces="application/json")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact modifiedContact) {
    	ResponseEntity<Contact> response = null;
    	
    	Contact contact = service.updateContact(modifiedContact);
    	
    	if (null != contact) {
    		response = ResponseEntity.ok(contact);
    	}
    	else {
    		response = ResponseEntity.internalServerError().build();
    	}
    	
    	return response;
    }
    
    @DeleteMapping(path="/delete/{id}", produces="application/json")
    public ResponseEntity<Contact> deleteContact(@PathVariable(value = "id") UUID id) {
    	ResponseEntity<Contact> response = null;
    	
    	service.deleteContact(id);
    	
    	response = ResponseEntity.ok().build();
    	
    	return response;
    }
    
}
