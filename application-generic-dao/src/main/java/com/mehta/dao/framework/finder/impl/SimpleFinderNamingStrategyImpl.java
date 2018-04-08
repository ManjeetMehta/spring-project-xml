package com.mehta.dao.framework.finder.impl;

import java.lang.reflect.Method;

import com.mehta.dao.framework.finder.FinderNamingStrategy;

public class SimpleFinderNamingStrategyImpl implements FinderNamingStrategy {

	@Override
	public String queryNameFromMethod(Class<?> findTargetType, Method finderMethod) {

		return findTargetType.getSimpleName() + "." + finderMethod.getName();
	}
}
