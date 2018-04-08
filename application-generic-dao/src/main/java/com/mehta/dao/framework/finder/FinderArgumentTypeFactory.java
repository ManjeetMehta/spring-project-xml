package com.mehta.dao.framework.finder;

import org.hibernate.type.Type;

public interface FinderArgumentTypeFactory {

	Type getArgumentType(Object object);
}
