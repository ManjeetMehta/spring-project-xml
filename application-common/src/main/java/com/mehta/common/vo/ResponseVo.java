package com.mehta.common.vo;

import java.io.Serializable;
import java.util.List;

public class ResponseVo implements Serializable {

	private static final long serialVersionUID = 7962385815437857897L;
	private String status;
	private String message;
	private int pageNo;
	private int pageSize;
	private long listSize;
	private int pageTotal;
	private boolean pagingEnabled;
	private Object id;
	private List<Integer> idList;
	private Object object;
	private List<?> list;
	private String expection;

	public ResponseVo() {
		super();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the listSize
	 */
	public long getListSize() {
		return listSize;
	}

	/**
	 * @param listSize
	 *            the listSize to set
	 */
	public void setListSize(long listSize) {
		this.listSize = listSize;
	}

	/**
	 * @return the pageTotal
	 */
	public int getPageTotal() {
		return pageTotal;
	}

	/**
	 * @param pageTotal
	 *            the pageTotal to set
	 */
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	/**
	 * @return the pagingEnabled
	 */
	public boolean isPagingEnabled() {
		return pagingEnabled;
	}

	/**
	 * @param pagingEnabled
	 *            the pagingEnabled to set
	 */
	public void setPagingEnabled(boolean pagingEnabled) {
		this.pagingEnabled = pagingEnabled;
	}

	/**
	 * @return the id
	 */
	public Object getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * @return the e
	 */
	public String getException() {
		return expection;
	}

	/**
	 * @param e
	 *            the e to set
	 */
	public void setException(String expection) {
		this.expection = expection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseVo [status=" + status + ", message=" + message + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", listSize=" + listSize + ", pageTotal=" + pageTotal + ", pagingEnabled=" + pagingEnabled + ", id="
				+ id + ", object=" + object + ", list=" + list + ", expection=" + expection + "]";
	}

	/**
	 * @return the idList
	 */
	public List<Integer> getIdList() {
		return idList;
	}

	/**
	 * @param idList
	 *            the idList to set
	 */
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
}
