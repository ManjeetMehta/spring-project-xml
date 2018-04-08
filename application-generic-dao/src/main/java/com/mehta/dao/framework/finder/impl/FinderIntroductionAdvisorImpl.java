package com.mehta.dao.framework.finder.impl;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class FinderIntroductionAdvisorImpl extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = -12287787102153903L;

	public FinderIntroductionAdvisorImpl() {

		super(new FinderIntroductionInterceptorImpl());
	}
}
