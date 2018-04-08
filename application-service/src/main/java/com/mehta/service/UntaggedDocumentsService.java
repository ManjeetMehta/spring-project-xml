package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.UntaggedDocumentsVo;

public interface UntaggedDocumentsService {
	Long createUntaggedDocumentsService(UntaggedDocumentsVo untaggedDocumentsVo, String loggedUserId) ;

	void updateUntaggedDocumentsService(UntaggedDocumentsVo untaggedDocumentsVo, String loggedUserId) ;

	UntaggedDocumentsVo readUntaggedDocumentsService(Long id);

	List<UntaggedDocumentsVo> listUntaggedDocumentsService();
}
