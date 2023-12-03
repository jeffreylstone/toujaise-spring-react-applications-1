/**
 * AddressRepository.java
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
 * AddressRepository
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
	
	@Query(value = "select count(*)" +
			" from address a" +
			" where lower(a.address1) = :testAddress1" +
			" and lower(a.address2) = :testAddress2" +
			" and lower(a.city) = :testCity " + 
			" and a.state_prov_cd = :testStateProvCd " +
			" and a.country_cd = :testCountryCd " +
			" and lower(a.postal_code) = :testPostalCode ;",
			nativeQuery = true)
	public Integer getCountForUniqueTest(@Param("testAddress1") String testAddress1,
			@Param("testAddress2") String testAddress2, 
			@Param("testCity") String testCity,
			@Param("testStateProvCd") String testStateProvCd,
			@Param("testCountryCd") String testCountryCd,
			@Param("testPostalCode") String testPostalCode);
	
	@Query(value = "select a.id, a.address1, a.address2, a.city, a.postal_code, a.country_cd, a.state_prov_cd" +
			" from address a" +
			" where lower(a.address1) = :testAddress1" +
			" and lower(a.address2) = :testAddress2" +
			" and lower(a.city) = :testCity " + 
			" and a.state_prov_cd = :testStateProvCd " +
			" and a.country_cd = :testCountryCd " +
			" and lower(a.postal_code) = :testPostalCode ;",
			nativeQuery = true)
	public List<Address> getListForUniqueTest(@Param("testAddress1") String testAddress1,
			@Param("testAddress2") String testAddress2, 
			@Param("testCity") String testCity,
			@Param("testStateProvCd") String testStateProvCd,
			@Param("testCountryCd") String testCountryCd,
			@Param("testPostalCode") String testPostalCode);

}
