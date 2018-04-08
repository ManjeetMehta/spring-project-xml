
package com.mehta.eibp.common.framework.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		SpringApplicationContext.applicationContext = applicationContext;
	}

	public static Object getBean(String beanName) {

		return applicationContext.getBean(beanName);
	}

}
