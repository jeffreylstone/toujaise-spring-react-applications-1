/**
 * PhoneNumberRepository.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * PhoneNumberRepository
 */
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, UUID> {
	
	@Query(value = "select count(*)" +
			" from phone_number pn" +
			" where lower(pn.phone_country_cd) = :testCountryCode" +
			" and lower(pn.phone_nbr) = :testPhoneNumber" +
			" and lower(pn.phone_nbr_ext) = :testPhoneExtension ;",
			nativeQuery = true)
	public Integer getCountForUniqueTest(@Param("testCountryCode") String testCountryCode,
			@Param("testPhoneNumber") String testPhoneNumber, 
			@Param("testPhoneExtension") String testPhoneExtension);
	
	@Query(value = "select pn.id, pn.phone_country_cd, pn.phone_nbr, pn.phone_nbr_ext, pn.phone_type_cd" +
			" from phone_number pn" +
			" where lower(pn.phone_country_cd) = :testCountryCode" +
			" and lower(pn.phone_nbr) = :testPhoneNumber" +
			" and lower(pn.phone_nbr_ext) = :testPhoneExtension ;",
			nativeQuery = true)
	public List<PhoneNumber> getListForUniqueTest(@Param("testCountryCode") String testCountryCode,
			@Param("testPhoneNumber") String testPhoneNumber, 
			@Param("testPhoneExtension") String testPhoneExtension);

}
