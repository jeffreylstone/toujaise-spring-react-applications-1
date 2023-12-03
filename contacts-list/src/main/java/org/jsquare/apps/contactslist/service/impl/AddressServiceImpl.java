/**
 * AddressServiceImpl.java
 * 
 * jeffrey.l.stone@gmail.com
 * 20231129
 * 
 */
package org.jsquare.apps.contactslist.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jsquare.apps.contactslist.repository.Address;
import org.jsquare.apps.contactslist.repository.AddressLink;
import org.jsquare.apps.contactslist.repository.AddressLinkRepository;
import org.jsquare.apps.contactslist.repository.AddressRepository;
import org.jsquare.apps.contactslist.service.AddressService;
import org.jsquare.apps.contactslist.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * AddressServiceImpl
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressLinkRepository addressLinkRepository;

	@Override
	public Boolean isUniqueAddress(Address testAddress) {
		Boolean isUnique = Boolean.FALSE;
		Address address = null;
		
		try {
			address = this.findExistingAddress(testAddress);
			if (null == address) {
				isUnique = Boolean.TRUE;
			}
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return isUnique;
	}
	
	@Override
	public UUID addAddressToContact(UUID contactId, Address newAddress, Integer addressUsageCode, Boolean isPrimary) {
		Address address = null;
		UUID addressLinkId = null;

		try {
			// fetch or create Address, as necessary
			address = this.findExistingAddress(newAddress);
			if (null == address) {
				address = addressRepository.save(newAddress);
			}
			
			// create new AddressLink, populate with Address and other attributes
			AddressLink addrLink = new AddressLink();
			addrLink.setContactId(contactId);
			addrLink.setAddressId(address.getId());
			addrLink.setAddressUsageCode(addressUsageCode);
			addrLink.setIsPrimary(isPrimary);
			
			// save and retrieve new address link ID
			addrLink = addressLinkRepository.save(addrLink);
			if (null != addrLink) {
				addressLinkId = addrLink.getId();
			}
		}
		catch (DataAccessException | IllegalStateException e) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, e);
		}
		
		return addressLinkId;
	}

	private Address findExistingAddress(Address newAddress) {
		Address existingAddress = null;
		List<Address> addrList = null;
		
		try {
			addrList = addressRepository.getListForUniqueTest(newAddress.getAddress1(), 
					newAddress.getAddress2(), newAddress.getCity(), 
					newAddress.getStateProvinceCode(), newAddress.getCountryCode(),
					newAddress.getPostalCode());
			if (1 == addrList.size()) {
				existingAddress = addrList.get(0);
			}
			else if (2 <= addrList.size()) {
				log.error(Constants.OBJECT_VIOLATING_UNIQUE_CONDITION_MESSAGE, newAddress);
				throw new IllegalStateException(Constants.OBJECT_VIOLATING_UNIQUE_CONDITION_EXCP_MSG);
			}
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
		
		return existingAddress;
	}

	@Override
	public void removeAddressFromContact(UUID addressLinkId) {
		
		try {
			addressLinkRepository.deleteById(addressLinkId);
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
	}

	@Override
	public AddressLink updateAddress(UUID addressLinkId, Address modifiedAddress, Integer addressUsageCode,
			Boolean isPrimary) {
		Address address = null;
		AddressLink addrLink = null;
		
		try {
			// get AddressLink object
			addrLink = this.getAddressLinkForId(addressLinkId);
			if (null == addrLink) {
				throw new IllegalArgumentException("");
			}
			// is modifiedAddress unique
			address = this.findExistingAddress(modifiedAddress);
			if (null == address) {
				// if unique, create new Address
				address = addressRepository.save(modifiedAddress);
				// update AddressLink with new Address
				addrLink.setAddressId(address.getId());
			}
			
			addrLink.setAddressUsageCode(addressUsageCode);
			addrLink.setIsPrimary(isPrimary);
			
			addrLink = addressLinkRepository.save(addrLink);
		}
		catch (DataAccessException | IllegalStateException e) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, e);
		}
		
		return addrLink;
	}

	@Override
	public List<AddressLink> getAddressesForContact(UUID contactId) {
		List<AddressLink> addrLinks = null;
		
		try {
			addrLinks = addressLinkRepository.getLinksForContact(contactId);
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
		
		return addrLinks;
	}

	@Override
	public AddressLink getAddressLinkForId(UUID addressLinkId) {
		AddressLink addrLink = null;

		try {
			Optional<AddressLink> result =  addressLinkRepository.findById(addressLinkId);
			if (result.isPresent()) {
				addrLink = result.get();
			}
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}
	
		return addrLink;
	}

	@Override
	public Address getAddressForId(UUID addressId) {
		Address address = null;
	
		try {
			Optional<Address> result =  addressRepository.findById(addressId);
			if (result.isPresent()) {
				address = result.get();
			}
		}
		catch (DataAccessException dae) {
			log.error(Constants.DATABASE_EXCEPTION_MESSAGE, dae);
		}

		return address;
	}

}
