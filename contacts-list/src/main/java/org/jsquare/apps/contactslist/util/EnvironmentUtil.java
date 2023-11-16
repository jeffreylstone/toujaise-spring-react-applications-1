/**
 * EnvUtil.java
 * 
 * Jeff Stone (jeffrey.l.stone@gmail.com)
 * 20200807
 * 20230827
 */
package org.jsquare.apps.contactslist.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;

/**
 * @author jeffrey.l.stone@gmail.com
 *
 */
public class EnvironmentUtil {
	
	/**
	 * @param environment
	 * @return
	 */
	public static List<String> propertiesListing(ConfigurableEnvironment environment) {
		List<String> propertiesListing = new ArrayList<>();
        propertiesListing.add("-----All Properties---");
		for (PropertySource<?> propertySource : environment.getPropertySources()) {
			if (propertySource instanceof EnumerablePropertySource) {
				propertiesListing.add(MessageFormat.format("--Property Source: {0}", propertySource.getName()));
				@SuppressWarnings("rawtypes")
				String[] propertyNames = ((EnumerablePropertySource) propertySource).getPropertyNames();
				for (String propertyName : propertyNames) {
					String resolvedProperty = environment.getProperty(propertyName);
					String sourceProperty = propertySource.getProperty(propertyName).toString();
					if (resolvedProperty.equals(sourceProperty)) {
						propertiesListing.add(MessageFormat.format("{0}={1}", propertyName, resolvedProperty));
					} else {
						propertiesListing.add(MessageFormat.format("{0}={1} OVERRIDDEN to {2}", propertyName, sourceProperty, resolvedProperty));
					}
				}
			}
		}
		
		return propertiesListing;
	}

	/**
	 * 
	 */
	private EnvironmentUtil() {
		// Cannot instantiate this Library/Utility class!
	}

}
