/**
 * PhoneLinkRepository.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PhoneLinkRepository
 */
@Repository
public interface PhoneLinkRepository extends JpaRepository<PhoneLink, UUID> {

}
