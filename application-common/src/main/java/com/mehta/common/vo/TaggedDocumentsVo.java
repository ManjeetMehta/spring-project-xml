package com.mehta.common.vo;

import java.io.Serializable;

public class TaggedDocumentsVo implements Serializable {
	private static final long serialVersionUID = 7097904494397277425L;
	private String docUuid;

	public TaggedDocumentsVo() {
		super();
	}

	public TaggedDocumentsVo(String docUuid) {
		super();
		this.docUuid = docUuid;
	}

	public String getDocUuid() {
		return docUuid;
	}

	public void setDocUuid(String docUuid) {
		this.docUuid = docUuid;
	}

}
