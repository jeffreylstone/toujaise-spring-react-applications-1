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
	
	@Query(value = "select * from contact c where c.last_name = :lastName and c.first_name = :firstName and c.middle_name_initial = :middleName and c.suffix = :suffix ;", nativeQuery = true)
	List<Contact> findMatchingContacts(@Param("lastName") String lastName, 
			@Param("firstName") String firstName, 
			@Param("middleName") String middleNameOrInitial,
			@Param("suffix") String suffix);

}
