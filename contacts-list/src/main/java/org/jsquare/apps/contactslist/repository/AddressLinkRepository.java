/**
 * AddressLinkRepository.java
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
 * AddressLinkRepository
 */
@Repository
public interface AddressLinkRepository extends JpaRepository<AddressLink, UUID> {
	
	@Query(value = "select al.id, al.contact_id, al.address_id, al.addr_usage_cd, al.is_primary" +
			" from address_link al" +
			" where al.contact_id = :contactId ;",
			nativeQuery = true)
	public List<AddressLink> getLinksForContact(@Param("contactId") UUID contactId);
	
	@Query(value = "select al.id, al.contact_id, al.address_id, a.address1, a.address2," + 
			" a.city, a.country_cd, a.state_prov_cd, a.postal_code, al.addr_usage_cd, al.is_primary" +
			" from address_link al, address a" +
			" where al.address_id = a.id" + 
			" and al.contact_id = :contactId ;", 
			nativeQuery = true)
	public List<Object[]> getAddressesForContact(@Param("contactId") UUID contactId);

}
