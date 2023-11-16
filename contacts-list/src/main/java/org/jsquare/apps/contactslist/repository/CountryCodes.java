/**
 * CountryCodes.java
 * JSON POJO and JPA Entity representing various ISO codes for countries of the world
 * jeffrey.l.stone@gmail.com
 * 20230927
 * 
 */
package org.jsquare.apps.contactslist.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CountryCodes
 */
@Entity
@Table(name="country_codes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryCodes {
	
/*
 * 
{
  "$schema": "http://json-schema.org/draft-04/schema#",

  "title": "ISO 3166-1",
  "description": "ISO 3166-1 country codes",
  "type": "object",

  "properties": {
	"3166-1": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "alpha_2": {
            "description": "Two letter alphabetic code of the item",
            "type": "string",
            "pattern": "^[A-Z]{2}$"
          },
          "alpha_3": {
            "description": "Three letter alphabetic code of the item",
            "type": "string",
            "pattern": "^[A-Z]{3}$"
          },
          "flag": {
            "description": "Flag of country, using Unicode regional indicator symbol letters",
            "type": "string",
            "pattern": "^[🇦-🇿]{2}$"
          },
          "name": {
            "description": "Name of the item",
            "type": "string",
            "minLength": 1
          },
          "numeric": {
            "description": "Three digit numeric code of the item, including leading zeros",
            "type": "string",
            "pattern": "^[0-9]{3}$"
          },
          "official_name": {
            "description": "Official name of the item (optional)",
            "type": "string",
            "minLength": 1
          },
          "common_name": {
            "description": "Common name of the item (optional)",
            "type": "string",
            "minLength": 1
          }
        },
        "required": ["alpha_2", "alpha_3", "name", "numeric"],
        "additionalProperties": false
      }
    }
  },
  "additionalProperties": false
}
 * 	
 */
	
	@JsonProperty("alpha_2")
	@Column(name="alpha_2", length=2, nullable=false, unique=true)
	private String alpha2;
	
	@Id
	@JsonProperty("alpha_3")
	@Column(name="alpha_3", length=3, nullable=false, unique=true)
	private String alpha3;
	
	@JsonProperty
	@Column(name="flag", length=2, nullable=true, unique=false)
	private String flag;
	
	@JsonProperty
	@Column(name="name", length=63, nullable=false, unique=true)
	private String name;
	
	@JsonProperty
	@Column(name="iso_numeric", length=3, nullable=false, unique=true)
	private String numeric;
	
	@JsonProperty("official_name")
	@Column(name="official_name", length=63, nullable=true, unique=false)
	private String officialName;
	
	@JsonProperty("common_name")
	@Column(name="common_name", length=63, nullable=true, unique=false)
	private String commonName;

}
