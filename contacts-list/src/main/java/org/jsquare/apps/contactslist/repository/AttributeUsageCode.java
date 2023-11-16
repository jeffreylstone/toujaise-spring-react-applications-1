/**
 * AttributeUsageCode.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20230925
 * 
 */
package org.jsquare.apps.contactslist.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name="attribute_usage_code")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttributeUsageCode {

	@Id
	@Column(name = "attr_usage_cd")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer attrUsageCd;
	
	@Column(name = "description")
	private String description;
	
}
