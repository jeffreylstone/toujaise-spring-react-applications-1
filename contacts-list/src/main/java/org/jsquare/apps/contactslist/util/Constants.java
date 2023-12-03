/**
 * Constants.java
 * Constant values used in the contacts-list application
 * jeffrey.l.stone@gmail.com
 * 20231130
 * 
 */
package org.jsquare.apps.contactslist.util;

/**
 * Constants
 */
public class Constants {
	
	
	// Error Messages
	public static final String DATABASE_EXCEPTION_MESSAGE = "Error occurred during database operation!";
	public static final String OBJECT_VIOLATING_UNIQUE_CONDITION_MESSAGE = "Object {} has two or more instances with same field values, when unique combination is required!";
	public static final String OBJECT_VIOLATING_UNIQUE_CONDITION_EXCP_MSG = "Object has two or more instances with same field values, when unique combination is required!";
	
	// Field Length Constants for Contact
	public static final int LAST_NAME_MAX_LENGTH = 63;
	public static final int FIRST_NAME_MAX_LENGTH = 63;
	public static final int MIDDLE_NAME_MAX_LENGTH = 63;
	public static final int SUFFIX_NAME_MAX_LENGTH = 31;
	public static final int PREFERRED_NAME_MAX_LENGTH = 63;
	public static final int IDENTIFIER_MAX_LENGTH = 127;
	
	


}
