/**
 * CountryCodes_3166_1.java
 * JSON container object for list of CountryCodes objects
 * jeffrey.l.stone@gmail.com
 * 20230927
 */
package org.jsquare.apps.contactslist.repository;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CountryCodes_3166_1
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryCodes_3166_1 {
	
	@JsonProperty("3166-1")
	private List<CountryCodes> list3166_1;

}
