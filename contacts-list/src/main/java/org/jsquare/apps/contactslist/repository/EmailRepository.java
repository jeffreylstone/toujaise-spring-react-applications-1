/**
 * EmailRepository.java
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
 * EmailRepository
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
	
	@Query(value = "select count(*)" +
			" from email e" +
			" where lower(e.email_addr) = :testEmailAddress ;",
			nativeQuery = true)
	public Integer getCountForUniqueTest(@Param("testEmailAddress") String testEmailAddress);

	@Query(value = "select e.id, e.email_addr" +
			" from email e" +
			" where lower(e.email_addr) = :testEmailAddress ;",
			nativeQuery = true)
	public List<Email> getListForUniqueTest(@Param("testEmailAddress") String testEmailAddress);

}
