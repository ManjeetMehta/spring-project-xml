
package com.mehta.dao.framework.finder.impl;

import java.lang.reflect.Method;

import com.mehta.dao.framework.finder.FinderNamingStrategy;

public class ExtendedFinderNamingStrategyImpl implements FinderNamingStrategy {

	@Override
	public String queryNameFromMethod(Class findTargetType, Method finderMethod) {

		String methodName = finderMethod.getName();
		String methodPart = methodName;
		if (methodName.startsWith("findBy")) {
		} else if (methodName.startsWith("listBy")) {
			methodPart = "findBy" + methodName.substring("listBy".length());
		} else if (methodName.startsWith("iterateBy")) {
			methodPart = "findBy" + methodName.substring("iterateBy".length());
		} else if (methodName.startsWith("scrollBy")) {
			methodPart = "findBy" + methodName.substring("scrollBy".length());
		}
		return findTargetType.getSimpleName() + "." + methodPart;
	}

}
