package com.mehta.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "agent_non_sponsored_has_tagged_document_permissions")
public class AgentNonSponsoredHasTaggedDocumentPermissions implements Serializable {

	private static final long serialVersionUID = -8993443199413020867L;
	private Integer id;
	private TaggedDocuments taggedDocuments;
	private AgentNonSponsored agentNonSponsored;
	private Date startDate;
	private Date endDate;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;
	
	
	public AgentNonSponsoredHasTaggedDocumentPermissions() {

	}
	public AgentNonSponsoredHasTaggedDocumentPermissions(Integer id) {
		this.id = id;
	}
	
	public AgentNonSponsoredHasTaggedDocumentPermissions(Integer id, TaggedDocuments taggedDocuments, AgentNonSponsored agentNonSponsored,
			Date startDate, Date endDate, Date created, Long createdBy, Date lastModified, Long lastModifiedBy,
			Long createdByTaskId) {
		this.id = id;
		this.taggedDocuments = taggedDocuments;
		this.agentNonSponsored = agentNonSponsored;
		this.startDate = startDate;
		this.endDate = endDate;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
	}
	public AgentNonSponsoredHasTaggedDocumentPermissions(TaggedDocuments taggedDocuments,AgentNonSponsored agentNonSponsored, Date startDate,
			Date endDate, Date created, Long createdBy, Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
		this.taggedDocuments = taggedDocuments;
		this.agentNonSponsored = agentNonSponsored;
		this.startDate = startDate;
		this.endDate = endDate;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doc_uuid", nullable = false)
	public TaggedDocuments getTaggedDocuments() {
		return taggedDocuments;
	}
	public void setTaggedDocuments(TaggedDocuments taggedDocuments) {
		this.taggedDocuments = taggedDocuments;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agent_non_sponsored_id", nullable = false)
	public AgentNonSponsored getAgentNonSponsored() {
		return agentNonSponsored;
	}
	public void setAgentNonSponsored(AgentNonSponsored agentNonSponsored) {
		this.agentNonSponsored = agentNonSponsored;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "created_by", length = 20, nullable = false)
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/*@Version*/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified	", nullable = false)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Column(name = "last_modified_by", length = 20, nullable = false)
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Column(name = "created_by_task_id", length = 20, nullable = false)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}
}

