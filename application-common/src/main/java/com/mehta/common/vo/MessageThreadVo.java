package com.mehta.common.vo;

import java.io.Serializable;

public class MessageThreadVo implements Serializable {

	private static final long serialVersionUID = 8762541209936059778L;
	private Integer id;
	private Integer messageId;
	private String message;
	private Integer messageHashTag;
	private Boolean isReopened;
	private Integer userId;
	private Integer taggedUser;

	public MessageThreadVo() {
		super();
	}

	public MessageThreadVo(Integer id) {
		super();
		this.id = id;
	}

	public MessageThreadVo(Integer messageId, String message, Integer messageHashTag, Boolean isReopened,
			Integer userId, Integer taggedUser) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageHashTag = messageHashTag;
		this.isReopened = isReopened;
		this.userId = userId;
		this.taggedUser = taggedUser;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMessageHashTag() {
		return messageHashTag;
	}

	public void setMessageHashTag(Integer messageHashTag) {
		this.messageHashTag = messageHashTag;
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

	public Integer getTaggedUser() {
		return taggedUser;
	}

	public void setTaggedUser(Integer taggedUser) {
		this.taggedUser = taggedUser;
	}

}
