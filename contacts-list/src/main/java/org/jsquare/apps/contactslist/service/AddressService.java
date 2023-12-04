/**
 * AddressService.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.service;

import java.util.List;
import java.util.UUID;

import org.jsquare.apps.contactslist.model.LinkedAddress;
import org.jsquare.apps.contactslist.repository.Address;
import org.jsquare.apps.contactslist.repository.AddressLink;

/**
 * AddressService
 */
public interface AddressService {
	
	/**
	 * @param testAddress Address object to be tested against repository
	 * @return (Boolean) true, if testAddress is unique (by ... combination) -- (i.e., does not exist), false, otherwise
	 */
	public Boolean isUniqueAddress(Address testAddress);
	
	/**
	 * @param contactId ID of Contact to which Address is being added
	 * @param newAddress Address object to "link" to Contact
	 * @param addressUsageCode type of address (home, business, etc)
	 * @param isPrimary true if this address link is the primary (of multiple)
	 * @return (UUID) ID of created AddressLink, null if update was unsuccessful
	 */
	public UUID addAddressToContact(UUID contactId, Address newAddress, Integer addressUsageCode, Boolean isPrimary);
	
	/**
	 * @param addressLinkId ID of Address object to be "unlinked" from Contact
	 */
	public void removeAddressFromContact(UUID addressLinkId);
	
	/**
	 * @param addressLinkId ID of AddressLink containing Address to be updated
	 * @param modifiedAddress modified Address object
	 * @param addressUsageCode type of address
	 * @param isPrimary true if this address link is the primary (of multiple)
	 * @return (AddressLink) reference to updated AddressLink object, null if update was unsuccessful
	 */
	public AddressLink updateAddress(UUID addressLinkId, Address modifiedAddress, Integer addressUsageCode, Boolean isPrimary);
	
	/**
	 * @param contactId ID of Contact for which AddressLinks are being retrieved
	 * @return (List<AddressLink>) list of AddressLinks for specified contact
	 */
	public List<AddressLink> getAddressLinksForContact(UUID contactId);
	
	/**
	 * @param contactId ID of Contact for which LinkedAddresses are being retrieved
	 * @return (List<LinkedAddress>) list of LinkedAddress objects for specified contact
	 */
	public List<LinkedAddress> getLinkedAddressesForContact(UUID contactId);
	
	/**
	 * @param addressLinkId ID of AddressLink to be retrieved
	 * @return (AddressLink) AddressLink object for specified ID
	 */
	public AddressLink getAddressLinkForId(UUID addressLinkId);
	
	/**
	 * @param addressId ID of Address to be retrieved
	 * @return (Address) Address object for specified ID
	 */
	public Address getAddressForId(UUID addressId);

}
