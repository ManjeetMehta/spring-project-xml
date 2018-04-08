
package com.mehta.common.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericComputation {

	private static final Logger logger = LoggerFactory.getLogger(GenericComputation.class);

	public boolean isEquivalent(Object obj1, Object obj2)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		List<String> skipField = new ArrayList<String>();
		skipField.add("lastModified");
		skipField.add("createdBy");
		skipField.add("created");
		@SuppressWarnings("rawtypes")
		Class aClass = obj1.getClass();
		@SuppressWarnings("rawtypes")
		Class bClass = obj2.getClass();
		if (!aClass.equals(bClass)) {
			return false;
		}
		@SuppressWarnings("rawtypes")
		Class reference[] = { Date.class, String.class, Integer.class, Float.class, Boolean.class, Long.class,
				Byte.class, BigDecimal.class, Short.class, Double.class, Character.class };
		@SuppressWarnings("rawtypes")
		Set<Class> refSet = new HashSet<>(Arrays.asList(reference));
		Field flds[] = aClass.getDeclaredFields();
		Field fldsB[] = bClass.getDeclaredFields();
		for (Field fldB : fldsB) {
			fldB.setAccessible(true);
			for (Field fld : flds) {
				fld.setAccessible(true);
				if (fldB.getName().equals(fld.getName())) {
					if (skipField.contains(fldB.getName())) {
						continue;
					}
					Object val1 = fld.get(obj1);
					Object val2 = fldB.get(obj2);
					if (val1 == null && val2 == null) {
						continue;
					}
					if (val1 == null && val2 != null || val2 == null && val1 != null) {
						logger.info("Returned due to one null vale: value 1 is " + val1 + " for field " + fld.getName()
								+ " while value 2 is " + val2 + " for field " + fldB.getName());
						return false;
					}
					Class fClass1 = null;
					if (val1 != null) {
						fClass1 = val1.getClass();
					}
					if (val2 != null) {
						fClass1 = val2.getClass();
					}
					if (refSet.contains(fClass1)) {
						if (!val1.equals(val2)) {
							logger.info("Returned due to different values: value 1 is " + val1 + " for field "
									+ fld.getName() + " while value 2 is " + val2 + " for field " + fldB.getName());
							return false;
						}
					} else {
						boolean chk = isEquivalentById(val1, val2);
						if (!chk) {
							return chk;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isEquivalentById(Object obj1, Object obj2)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Class aClass = obj1.getClass();
		Class bClass = obj2.getClass();
		Field fld = aClass.getDeclaredField("id");
		Field fldB = bClass.getDeclaredField("id");
		fld.setAccessible(true);
		fldB.setAccessible(true);
		Object val1 = fld.get(obj1);
		Object val2 = fldB.get(obj2);
		if (!val1.equals(val2)) {
			logger.info("ID read for object1 of " + aClass.getSimpleName() + " is " + val1
					+ " while ID read for object2 of " + bClass.getSimpleName() + " is " + val2);
			return false;
		}
		return true;

	}

}
