package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.ContactPointEmailVo;

public interface ContactPointEmailService {
	Integer create(ContactPointEmailVo contactPointEmailVo);

	void update(ContactPointEmailVo contactPointEmailVo);

	ContactPointEmailVo read(Integer id);

	void delete(Integer id);

	List<ContactPointEmailVo> list();

}
