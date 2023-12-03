/**
 * ContactRepository.java
 * JPA Repository for contact table
 * jeffrey.l.stone@gmail.com
 * 20230924
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
 * ContactRepository
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
	
	@Query(value = "select id, last_name, first_name, preferred_first_name," + 
			" middle_name_initial, suffix, identifier" + 
			" from contact c" + 
			" where c.last_name = :lastName and c.first_name = :firstName" + 
			" and c.middle_name_initial = :middleName and c.suffix = :suffix ;", 
			nativeQuery = true)
	public List<Contact> findMatchingContacts(@Param("lastName") String lastName, 
			@Param("firstName") String firstName, 
			@Param("middleName") String middleNameOrInitial,
			@Param("suffix") String suffix);

	@Query(value = "select id, last_name, first_name, preferred_first_name," + 
			" middle_name_initial, suffix, identifier" + 
			" from contact c" + 
			" where ((lower(c.last_name) like :lastName and lower(c.first_name) like :firstName )" + 
			" or (lower(c.last_name) like :lastName and lower(c.preferred_first_name) like :firstName ));", 
			nativeQuery = true)
	public List<Contact> findMatchingContactsFromTwoNames(@Param("lastName") String lastName, 
			@Param("firstName") String firstName);

	@Query(value = "select id, last_name, first_name, preferred_first_name," + 
			" middle_name_initial, suffix, identifier" + 
			" from contact c" + 
			" where lower(c.last_name) like :lastName ;", 
			nativeQuery = true)
	public List<Contact> findMatchingContactsFromSingleName(@Param("lastName") String lastName);

}
