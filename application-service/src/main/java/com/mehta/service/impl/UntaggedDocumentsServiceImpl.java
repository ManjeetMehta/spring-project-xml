package com.mehta.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.UntaggedDocumentsVo;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.dao.UntaggedDocumentsDao;
import com.mehta.dao.UserDao;
import com.mehta.model.TaggedDocuments;
import com.mehta.model.UntaggedDocuments;
import com.mehta.model.User;
import com.mehta.service.UntaggedDocumentsService;

@Component
public class UntaggedDocumentsServiceImpl implements UntaggedDocumentsService {

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private UntaggedDocumentsDao untaggedDocumentsDao;

	@Autowired
	private UserDao userDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UntaggedDocumentsServiceImpl.class);

	@Override
	public Long createUntaggedDocumentsService(UntaggedDocumentsVo untaggedDocumentsVo, String loggedUserId) {

		byte[] docContents = null;
		String fileSize = null;
		String fileName = untaggedDocumentsVo.getFileName();

		TaggedDocuments taggedDocuments = null;
		if (untaggedDocumentsVo.getTaggedDocumentsId() != null) {
			taggedDocuments = taggedDocumentsDao.read(untaggedDocumentsVo.getTaggedDocumentsId());
			if (taggedDocuments == null) {
				logger.warn("Parent Id of (taggedDocuments) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else
			logger.warn("Parent Id of (taggedDocuments) is null.... ");

		Boolean deleted = untaggedDocumentsVo.getDeleted();
		String remarks = untaggedDocumentsVo.getRemarks();

		User uploadedBy = null;
		if (untaggedDocumentsVo.getUploadedBy() != null) {
			uploadedBy = userDao.read(untaggedDocumentsVo.getUploadedBy());
			if (uploadedBy == null) {
				logger.warn("Parent Id of (uploadedBy) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else
			logger.warn("Parent Id of (uploadedBy) is null.... ");

		Date taggedOn = null;
		if (untaggedDocumentsVo.getTaggedOn() != null)
			taggedOn = new Date(untaggedDocumentsVo.getTaggedOn());

		User taggedBy = null;
		if (untaggedDocumentsVo.getTaggedBy() != null) {
			taggedBy = userDao.read(untaggedDocumentsVo.getTaggedBy());
			if (taggedBy == null) {
				logger.warn("Parent Id of (taggedBy) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else
			logger.warn("Parent Id of (taggedBy) is null.... ");

		User copiedBy = null;
		if (untaggedDocumentsVo.getCopiedBy() != null) {
			copiedBy = userDao.read(untaggedDocumentsVo.getCopiedBy());
			if (copiedBy == null) {
				logger.warn("Parent Id of (copiedBy) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else
			logger.warn("Parent Id of (copiedBy) is null.... ");

		Date created = new Date();
		Long createdBy = Long.parseLong(loggedUserId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(loggedUserId);
		Long createdByTaskId = Long.parseLong(loggedUserId);

		File file = new File(fileName);
		if (file.exists()) {
			docContents = new byte[(int) file.length()];
			if ((int) file.length() > 1024)
				fileSize = ((float) file.length() / 1024.0f) + " KB";
			else
				fileSize = (int) file.length() + " Byte";
			try {
				// convert file into array of bytes
				FileInputStream fileInputStream = new FileInputStream(file);
				fileInputStream.read(docContents);
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (docContents == null) {
			logger.warn("docContents is not available...");
			return null;
		}
		if (fileName == null) {
			logger.warn("fileName is missing...");
			return null;
		}
		if (fileSize == null) {
			logger.warn("fileSize is missing...");
			return null;
		}

		UntaggedDocuments untaggedDocuments = new UntaggedDocuments(taggedDocuments, docContents, fileName, fileSize,
				deleted, remarks, uploadedBy, taggedOn, taggedBy, copiedBy, created, createdBy, lastModified,
				lastModifiedBy, createdByTaskId);

		return untaggedDocumentsDao.create(untaggedDocuments);

	}

	@Override
	public void updateUntaggedDocumentsService(UntaggedDocumentsVo untaggedDocumentsVo, String loggedUserId) {

		UntaggedDocuments untaggedDocuments = untaggedDocumentsDao.read(untaggedDocumentsVo.getId());

		if (untaggedDocuments != null) {

			TaggedDocuments taggedDocuments = null;
			if (untaggedDocumentsVo.getTaggedDocumentsId() != null) {
				taggedDocuments = taggedDocumentsDao.read(untaggedDocumentsVo.getTaggedDocumentsId());
				if (taggedDocuments == null) {
					logger.warn("Parent Id of (taggedDocuments) is Not Matched.... (Record Not Created)");
					return;
				} else
					untaggedDocuments.setTaggedDocuments(taggedDocuments);
			} else
				logger.warn("Parent Id of (taggedDocuments) is null....");

			if (untaggedDocumentsVo.getDeleted() != null)
				untaggedDocuments.setDeleted(untaggedDocumentsVo.getDeleted());
			if (untaggedDocumentsVo.getRemarks() != null)
				untaggedDocuments.setRemarks(untaggedDocumentsVo.getRemarks());

			User uploadedBy = null;
			if (untaggedDocumentsVo.getUploadedBy() != null) {
				uploadedBy = userDao.read(untaggedDocumentsVo.getUploadedBy());
				if (uploadedBy == null) {
					logger.warn("Parent Id of (uploadedBy) is Not Matched.... (Record Not Created)");
					return;
				} else
					untaggedDocuments.setUploadedBy(uploadedBy);
			} else
				logger.warn("Parent Id of (uploadedBy) is null....");

			if (untaggedDocumentsVo.getTaggedOn() != null)
				untaggedDocuments.setTaggedOn(new Date(untaggedDocumentsVo.getTaggedOn()));

			User taggedBy = null;
			if (untaggedDocumentsVo.getTaggedBy() != null) {
				taggedBy = userDao.read(untaggedDocumentsVo.getTaggedBy());
				if (taggedDocuments == null) {
					logger.warn("Parent Id of (taggedBy) is Not Matched.... (Record Not Created)");
					return;
				} else
					untaggedDocuments.setTaggedBy(taggedBy);
			} else
				logger.warn("Parent Id of (taggedBy) is null....");

			User copiedBy = null;
			if (untaggedDocumentsVo.getCopiedBy() != null) {
				copiedBy = userDao.read(untaggedDocumentsVo.getCopiedBy());
				if (copiedBy == null) {
					logger.warn("Parent Id of (copiedBy) is Not Matched.... (Record Not Created)");
					return;
				} else
					untaggedDocuments.setCopiedBy(copiedBy);
			} else
				logger.warn("Parent Id of (copiedBy) is null....");

			untaggedDocuments.setLastModifiedBy(Long.parseLong(loggedUserId));
			untaggedDocuments.setCreatedByTaskId(Long.parseLong(loggedUserId));

			untaggedDocumentsDao.update(untaggedDocuments);
		} else {
			logger.warn("Record not Found for updatation...");
			return;
		}
	}

	@Override
	public UntaggedDocumentsVo readUntaggedDocumentsService(Long id) {
		UntaggedDocuments untaggedDocuments = untaggedDocumentsDao.read(id);

		if (untaggedDocuments != null) {

			UntaggedDocumentsVo untaggedDocumentsVo = new UntaggedDocumentsVo(untaggedDocuments.getId());
			if (untaggedDocuments.getTaggedDocuments() != null)
				untaggedDocumentsVo.setTaggedDocumentsId(untaggedDocuments.getTaggedDocuments().getDocUuid());

			untaggedDocumentsVo.setDocContents(untaggedDocuments.getDocContents());
			untaggedDocumentsVo.setFileName(untaggedDocuments.getFileName());
			untaggedDocumentsVo.setFileSize(untaggedDocuments.getFileSize());
			untaggedDocumentsVo.setDeleted(untaggedDocuments.getDeleted());
			untaggedDocumentsVo.setRemarks(untaggedDocuments.getRemarks());

			if (untaggedDocuments.getUploadedBy() != null)
				untaggedDocumentsVo.setUploadedBy(untaggedDocuments.getUploadedBy().getId());
			if (untaggedDocuments.getTaggedDocuments() != null)
				untaggedDocumentsVo.setTaggedDocumentsId(untaggedDocuments.getTaggedDocuments().getDocUuid());

			if (untaggedDocuments.getTaggedBy() != null)
				untaggedDocumentsVo.setTaggedBy(untaggedDocuments.getTaggedBy().getId());
			if (untaggedDocuments.getCopiedBy() != null)
				untaggedDocumentsVo.setCopiedBy(untaggedDocuments.getCopiedBy().getId());

			return untaggedDocumentsVo;
		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

	}

	@Override
	public List<UntaggedDocumentsVo> listUntaggedDocumentsService() {
		List<UntaggedDocuments> untaggedDocumentsList = untaggedDocumentsDao.findAll();

		List<UntaggedDocumentsVo> untaggedDocumentsVoList = null;

		if (untaggedDocumentsList.size() > 0) {
			untaggedDocumentsVoList = new ArrayList<UntaggedDocumentsVo>();

			for (UntaggedDocuments untaggedDocuments : untaggedDocumentsList) {
				UntaggedDocumentsVo untaggedDocumentsVo = new UntaggedDocumentsVo(untaggedDocuments.getId());
				if (untaggedDocuments.getTaggedDocuments() != null)
					untaggedDocumentsVo.setTaggedDocumentsId(untaggedDocuments.getTaggedDocuments().getDocUuid());

				untaggedDocumentsVo.setDocContents(untaggedDocuments.getDocContents());
				untaggedDocumentsVo.setFileName(untaggedDocuments.getFileName());
				untaggedDocumentsVo.setFileSize(untaggedDocuments.getFileSize());
				untaggedDocumentsVo.setDeleted(untaggedDocuments.getDeleted());
				untaggedDocumentsVo.setRemarks(untaggedDocuments.getRemarks());

				if (untaggedDocuments.getUploadedBy() != null)
					untaggedDocumentsVo.setUploadedBy(untaggedDocuments.getUploadedBy().getId());
				if (untaggedDocuments.getTaggedDocuments() != null)
					untaggedDocumentsVo.setTaggedDocumentsId(untaggedDocuments.getTaggedDocuments().getDocUuid());

				if (untaggedDocuments.getTaggedBy() != null)
					untaggedDocumentsVo.setTaggedBy(untaggedDocuments.getTaggedBy().getId());
				if (untaggedDocuments.getCopiedBy() != null)
					untaggedDocumentsVo.setCopiedBy(untaggedDocuments.getCopiedBy().getId());

				untaggedDocumentsVoList.add(untaggedDocumentsVo);
			}

		} else {
			untaggedDocumentsVoList = new ArrayList<UntaggedDocumentsVo>(0);

		}
		return untaggedDocumentsVoList;
	}

}
