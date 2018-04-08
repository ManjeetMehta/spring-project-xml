package com.mehta.web.utils;

import java.util.List;

import com.mehta.common.vo.ResponseVo;

public class ApiResponseBuilder {

	public static enum Status {
		success, error
	}

	private ResponseVo response;
	private boolean paggingEnabled;

	public ApiResponseBuilder() {
		response = new ResponseVo();
	}

	public ApiResponseBuilder(boolean paggingEnabled) {
		response = new ResponseVo();
		this.paggingEnabled = paggingEnabled;
	}

	public ApiResponseBuilder status(Status status) {
		response.setStatus(status.toString());
		return this;
	}

	public ApiResponseBuilder message(String message) {
		response.setMessage(message);
		return this;
	}

	public ApiResponseBuilder pageNo(int pageNo) {
		if (paggingEnabled) {
			response.setPageNo(pageNo);
		}
		return this;
	}

	public ApiResponseBuilder pageSize(int pageSize) {
		if (paggingEnabled) {
			response.setPageSize(pageSize);
		}
		return this;
	}

	public ApiResponseBuilder listSize(long listSize) {
		response.setListSize(listSize);
		return this;
	}

	public ApiResponseBuilder pageTotal(long listSize, int pageSize) {
		if (paggingEnabled) {
			int pageTotal = 0;
			if (pageSize > 0) {
				pageTotal = (int) Math.ceil((double) listSize / pageSize);
			}
			response.setPageTotal(pageTotal);
		}
		return this;
	}

	public ApiResponseBuilder pagingEnabled(boolean pagingEnabled) {

		response.setPagingEnabled(pagingEnabled);
		return this;
	}

	public ApiResponseBuilder id(Object id) {
		response.setId(id);
		return this;
	}

	public ApiResponseBuilder idList(List<Integer> ids) {
		response.setIdList(ids);
		return this;
	}

	public ApiResponseBuilder object(Object object) {
		response.setObject(object);
		return this;
	}

	public ApiResponseBuilder list(List<?> list) {
		response.setList(list);
		return this;
	}

	public ApiResponseBuilder exception(Exception e) {
		response.setException(e.getClass().getName());
		return this;
	}

	public ResponseVo build() {
		return response;
	}
}
