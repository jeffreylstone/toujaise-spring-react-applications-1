/**
 * StateProvinceCodeRepository.java
 *
 * jeffrey.l.stone@gmail.com
 * 20230927
 * 
 */
package org.jsquare.apps.contactslist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 */
public interface StateProvinceCodeRepository extends JpaRepository<StateProvinceCode, String> {
	
	public List<StateProvinceCode> findByAlpha2(String alpha2);

}
