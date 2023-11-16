/**
 * 
 */
package org.jsquare.apps.contactslist.controller;

import java.util.List;

import org.jsquare.apps.contactslist.util.EnvironmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeff
 *
 */
@Slf4j
@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    private ConfigurableEnvironment environment;
    
    
    
    @GetMapping
    public ResponseEntity<String> healthCheck() {
    	ResponseEntity<String> response = ResponseEntity.ok("Working");
    	return response;
    }
    
    @GetMapping(path="/configuration", produces="text/plain") 
    public ResponseEntity<String> configuration() {
    	ResponseEntity<String> response = null;
    	StringBuilder buffer = new StringBuilder();
    	
    	List<String> propertiesList = EnvironmentUtil.propertiesListing(environment);
		for (String currentProperty : propertiesList) {
	    	buffer.append(currentProperty).append("\n");
		}
    	
    	response = ResponseEntity.ok(buffer.toString());
    	return response;
    }

}
