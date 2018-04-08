package com.mehta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "message")
public class Message implements Serializable {

	private Integer id;
	private String message;
	private Boolean isReopened;
	private User user;
	private MessageHashTag messageHashTag;
	private Integer groupId;
	private User taggedUser;
	private Date created;
	private Long createdByTaskId;

	public Message() {
		super();
	}

	public Message(Integer id) {
		super();
		this.id = id;
	}

	public Message(String message, Boolean isReopened, User user, MessageHashTag messageHashTag, Integer groupId,
			User taggedUser, Date created, Long createdByTaskId) {
		super();
		this.message = message;
		this.isReopened = isReopened;
		this.user = user;
		this.messageHashTag = messageHashTag;
		this.groupId = groupId;
		this.taggedUser = taggedUser;
		this.created = created;
		this.createdByTaskId = createdByTaskId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 11)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "message", length = 250, nullable = true)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "is_reopened")
	public Boolean getIsReopened() {
		return isReopened;
	}

	public void setIsReopened(Boolean isReopened) {
		this.isReopened = isReopened;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "message_hash_tag_id")
	public MessageHashTag getMessageHashTag() {
		return messageHashTag;
	}

	public void setMessageHashTag(MessageHashTag messageHashTag) {
		this.messageHashTag = messageHashTag;
	}

	@Column(name = "group_id", length=11)
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tagged_user")
	public User getTaggedUser() {
		return taggedUser;
	}

	public void setTaggedUser(User taggedUser) {
		this.taggedUser = taggedUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "created_by_task_id", length = 20)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}

}
