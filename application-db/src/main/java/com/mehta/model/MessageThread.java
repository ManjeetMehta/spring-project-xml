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
@Table(name = "message_thread")
public class MessageThread implements Serializable {

	private Integer id;
	private Message messageId;
	private String message;
	private MessageHashTag messageHashTag;
	private Boolean isReopened;
	private User user;
	private User taggedUser;
	private Date created;
	private Long createdByTaskId;

	public MessageThread() {
		super();
	}

	public MessageThread(Integer id) {
		super();
		this.id = id;
	}

	public MessageThread(Message messageId, String message, MessageHashTag messageHashTag, Boolean isReopened,
			User user, User taggedUser, Date created, Long createdByTaskId) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageHashTag = messageHashTag;
		this.isReopened = isReopened;
		this.user = user;
		this.taggedUser = taggedUser;
		this.created = created;
		this.createdByTaskId = createdByTaskId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "message_id")
	public Message getMessageId() {
		return messageId;
	}

	public void setMessageId(Message messageId) {
		this.messageId = messageId;
	}

	@Column(name = "message", length = 200)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "message_hash_tag")
	public MessageHashTag getMessageHashTag() {
		return messageHashTag;
	}

	public void setMessageHashTag(MessageHashTag messageHashTag) {
		this.messageHashTag = messageHashTag;
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
	@JoinColumn(name = "tagged_user")
	public User getTaggedUser() {
		return taggedUser;
	}

	public void setTaggedUser(User taggedUser) {
		this.taggedUser = taggedUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
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
