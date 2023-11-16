/**
 * StateProvinceCode.java
 * JSON POJO and JPA Entity representing ISO codes for subdivisions (i.e., states, provinces, etc) of countries of the world
 * jeffrey.l.stone@gmail.com
 * 20230927
 * 
 */
package org.jsquare.apps.contactslist.repository;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * StateProvinceCode
 */
@Entity
@Table(name="state_province_code")
@AllArgsConstructor
@NoArgsConstructor
public class StateProvinceCode {

/*
 *
{
  "$schema": "http://json-schema.org/draft-04/schema#",

  "title": "ISO 3166-2",
  "description": "ISO 3166-2 country and subdivision codes",
  "type": "object",

  "properties": {
    "3166-2": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "code": {
            "description": "Code of the country subset item",
            "type": "string",
            "pattern": "^[A-Z]{2}-[A-Z0-9]+$"
          },
          "name": {
            "description": "Name of the country subset item",
            "type": "string",
            "minLength": 1
          },
          "parent": {
            "description": "Parent of the country subset item (optional)",
            "type": "string",
            "minLength": 1
          },
          "type": {
            "description": "Type of subset of the country",
            "type": "string"
          }
        }
      },
      "required": ["code", "name", "type"],
      "additionalProperties": false
    }
  },
  "additionalProperties": false
}
 * 
 */
	
	@Id
	@Column(name="code", length=10, nullable=false, unique=true)
	@JsonProperty
	private String code;
	
	@Column(name="alpha_2", length=2, nullable=false, unique=false)
	@JsonIgnore
	private String alpha2;
	
	@Column(name="state_prov_cd", length=7, nullable=false, unique=false)
	@JsonIgnore
	private String stateProvCd;
	
	@Column(name="name", length=63, nullable=false, unique=false)
	@JsonProperty
	private String name;
	
	@Column(name="parent", length=63, nullable=true, unique=false)
	@JsonProperty
	private String parent;
	
	@Column(name="type", length=63, nullable=false, unique=false)
	@JsonProperty
	private String type;

	/**
	 * Constructor for JSON fields only  
	 * @param code
	 * @param name
	 * @param parent
	 * @param type
	 */
	public StateProvinceCode(String code, String name, String parent, String type) {
		this.setCode(code);
		this.setName(name);
		this.setParent(parent);
		this.setType(type);
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 * Also derives and sets alpha2 and stateProvCd from code
	 */
	public void setCode(String code) {
		this.code = code;
		if (-1 != code.indexOf('-')) {
			String[] elements = code.split("-");
			if (2 == elements.length) {
				this.setAlpha2(elements[0].trim());
				this.setStateProvCd(elements[1].trim());
			}
		}
	}

	/**
	 * @return the alpha2
	 */
	@JsonGetter
	public String getAlpha2() {
		return alpha2;
	}

	/**
	 * @param alpha2 the alpha2 to set
	 */
	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	/**
	 * @return the stateProvCd
	 */
	@JsonGetter
	public String getStateProvCd() {
		return stateProvCd;
	}

	/**
	 * @param stateProvCd the stateProvCd to set
	 */
	public void setStateProvCd(String stateProvCd) {
		this.stateProvCd = stateProvCd;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
