package com.mehta.web.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseBuilder {

	public static enum Status {
		success, error
	}

	private Map<String, Object> response;
	private boolean paggingEnabled;

	public ResponseBuilder() {

		response = new HashMap<>();
	}

	public ResponseBuilder(boolean paggingEnabled) {

		response = new HashMap<>();
		this.paggingEnabled = paggingEnabled;
	}

	public ResponseBuilder status(Status status) {

		response.put(Constants.RESPONSE_STATUS, status.toString());
		return this;
	}

	public ResponseBuilder message(String message) {

		response.put(Constants.RESPONSE_MESSAGE, message);
		return this;
	}

	public ResponseBuilder pageNo(int pageNo) {

		if (paggingEnabled) {
			response.put(Constants.RESPONSE_PAGE_NO, pageNo);
		}
		return this;
	}

	public ResponseBuilder pageSize(int pageSize) {

		if (paggingEnabled) {
			response.put(Constants.RESPONSE_PAGE_SIZE, pageSize);
		}
		return this;
	}

	public ResponseBuilder listSize(long listSize) {

		response.put(Constants.RESPONSE_LIST_SIZE, listSize);
		return this;
	}

	public ResponseBuilder idList(List<Integer> ids) {

		response.put(Constants.RESPONSE_ID_LIST, ids);
		return this;
	}

	public ResponseBuilder pageTotal(long listSize, int pageSize) {

		if (paggingEnabled) {
			int pageTotal = 0;
			if (pageSize > 0) {
				pageTotal = (int) Math.ceil((double) listSize / pageSize);
			}
			response.put(Constants.RESPONSE_PAGE_TOTAL, pageTotal);
		}
		return this;
	}

	public ResponseBuilder pagingEnabled(boolean pagingEnabled) {

		response.put(Constants.RESPONSE_PAGING_ENABLED, pagingEnabled);
		return this;
	}

	public ResponseBuilder id(Object id) {

		response.put(Constants.RESPONSE_ID, id);
		return this;
	}

	public ResponseBuilder object(Object object) {

		response.put(Constants.RESPONSE_OBJECT, object);
		return this;
	}

	public ResponseBuilder list(List<?> list) {

		response.put(Constants.RESPONSE_LIST, list);
		return this;
	}

	public ResponseBuilder exception(Exception e) {

		response.put(Constants.RESPONSE_EXCEPTION, e.getClass().getName());
		return this;
	}

	public Map<String, Object> build() {

		return response;
	}
}
