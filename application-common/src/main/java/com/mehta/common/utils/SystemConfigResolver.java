package com.mehta.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class SystemConfigResolver extends PropertyPlaceholderConfigurer {

	private final int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;
	private static Map<String, String> propertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {

		super.processProperties(beanFactory, props);

		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
			propertiesMap.put(keyStr, valueStr);
		}
	}

	public static String getProperty(String key, String defaultValue) {

		String value = propertiesMap.get(key) != null ? propertiesMap.get(key).toString() : defaultValue;
		return value;
	}

	/**
	 * @return the propertiesMap
	 */
	public static Map<String, String> getPropertiesMap() {

		return propertiesMap;
	}

}
