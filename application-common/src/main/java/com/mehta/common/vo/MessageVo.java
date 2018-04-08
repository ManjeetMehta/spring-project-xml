package com.mehta.common.vo;

import java.io.Serializable;

public class MessageVo implements Serializable {
	private static final long serialVersionUID = 8793874959927639537L;
	private Integer id;
	private String message;
	private Boolean isReopened;
	private Integer userId;
	private Integer messageHashTagId;
	private Integer groupId;
	private Integer taggedUser;

	public MessageVo() {
		super();
	}

	public MessageVo(Integer id) {
		super();
		this.id = id;
	}

	public MessageVo(String message, Boolean isReopened, Integer userId, Integer messageHashTagId, Integer groupId,
			Integer taggedUser) {
		super();
		this.message = message;
		this.isReopened = isReopened;
		this.userId = userId;
		this.messageHashTagId = messageHashTagId;
		this.groupId = groupId;
		this.taggedUser = taggedUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsReopened() {
		return isReopened;
	}

	public void setIsReopened(Boolean isReopened) {
		this.isReopened = isReopened;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMessageHashTagId() {
		return messageHashTagId;
	}

	public void setMessageHashTagId(Integer messageHashTagId) {
		this.messageHashTagId = messageHashTagId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getTaggedUser() {
		return taggedUser;
	}

	public void setTaggedUser(Integer taggedUser) {
		this.taggedUser = taggedUser;
	}

}
