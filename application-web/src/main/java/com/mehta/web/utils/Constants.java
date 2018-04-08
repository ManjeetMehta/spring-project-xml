package com.mehta.web.utils;

public class Constants {

	public static final String URL_API_VERSION = "/v1.0";
	public static final String URL_API_BASE = "/api" + URL_API_VERSION;
	public static final String URL_API_CURRENCY = URL_API_BASE + "/currency";

	public static final String RESPONSE_ID = "id";
	public static final String RESPONSE_OBJECT = "object";
	public static final String RESPONSE_LIST = "list";
	public static final String RESPONSE_STATUS = "status";
	public static final String RESPONSE_STATUS_SUCCESS = "success";
	public static final String RESPONSE_STATUS_ERROR = "error";
	public static final String RESPONSE_MESSAGE = "message";
	public static final String RESPONSE_EXCEPTION = "exception";
	public static final String RESPONSE_PAGE_NO = "pageNo";
	public static final String RESPONSE_PAGE_SIZE = "pageSize";
	public static final String RESPONSE_LIST_SIZE = "listSize";
	public static final String RESPONSE_PAGE_TOTAL = "pageTotal";
	public static final String RESPONSE_PAGING_ENABLED = "pagingEnabled";
	public static final String RESPONSE_USERID = "userId";
	public static final String RESPONSE_ID_LIST = "idList";

	public static final String OPERATION_CREATE = "/create";
	public static final String OPERATION_CREATE_LIST = "/create-list";
	public static final String OPERATION_CREATE_COMPOSITE = "/create-composite";
	public static final String OPERATION_CREATE_FROM_PDF = "/crate-from-pdf";

	public static final String OPERATION_UPDATE = "/update";
	public static final String OPERATION_UPDATE_COMPOSITE = "/update-composite";

	public static final String OPERATION_READ = "/read/{id}";
	public static final String OPERATION_READ_CUSTOMER_CORPORATE = "/read-corporate/{id}";
	public static final String OPERATION_READ_CUSTOMER_INDIVIDUAL = "/read-individual/{id}";
	public static final String OPERATION_READ_COMPOSITE = "/read-composite/{id}";
	public static final String OPERATION_READ_BY_ID_PASSWORD = "/checkuser/{userID}/{password}";
	public static final String OPERATION_READ_BY_PROCESS_SORT_NAME = "list-by-process-short-name/{processShortName}";

	public static final String OPERATION_DELETE = "/delete/{id}";
	public static final String OPERATION_DELETE_COMPOSITE = "/delete-composite/{id}";

	public static final String OPERATION_LIST = "/list";
	public static final String OPERATION_LIST_GROUP = "/listGroup";
	public static final String OPERATION_LIST_COMPOSITE = "/list-composite";
	public static final String OPERATION_LIST_COMPOSITE_SEPERATE_DAO_CALL = "/list-composite-separate-dao";
	public static final String OPERATION_LIST_CURRENCY_CD = "/list-by-currencycd/{currencyCd}";
	public static final String OPERATION_LIST_AGENT_UNION_CUSTOMERINDIVISUAL = "list-agent-union-customer-individual/{nationality}";

	public static final String OPERATION_LISTBY_CompanySize = "/list-by-companysize /{companySize}";
	public static final String OPERATION_LISTBY_COMPANY_NAME = "/list-by-companyname /{companyName}";
	public static final String OPERATION_LISTBY_COMPANY_SIZE_MIN_MAX = "/list-by-companysizeminmax /{minSize}/{maxSize}";
	public static final String OPERATION_LISTBY_NATIONALITY = "/list-by-Nationality /{nationality}";
	public static final String OPERATION_LISTBY_NUMBER_OF_BRANCH_EMPLOYEES = "/list-by-numberofbranchemployees /{numberOfBranchEmployees}";
	public static final String OPERATION_LISTBY_FORM_NAME = "/listByFormName/{actionFormName}";
	public static final String OPERATION_LISTWITHCHILD = "list_with_child";

	// MemCached

	public static final String OPERATION_SET_MEMCACHED = "/set-memcached";
	public static final String OPERATION_GET_MEMCACHED = "/get-memcached";

	public static final String OPERATION_UPDATE_MEMCACHED = "/update-composite";
	public static final String OPERATION_UPDATE_MEMCACHED_COMPOSITE = "/update-composite";

	public static final String OPERATION_DELETE_COMPOSITE_MEMCACHED = "/delete-composite-memcached";
	public static final String OPERATION_SET_COMPOSITE_MEMCACHED = "/set-composite-memcached";
	public static final String OPERATION_GET_COMPOSITE_MEMCACHED = "/get-composite-memcached";

	// AcActionFormController
	public static final String OPERATION_MAP_SET_MEM_PROCESS_ID = "/setpidmem";
	public static final String OPERATION_MAP_GET_MEM_PROCESS_ID = "/getpidmem";
	public static final String OPERATION_MAP_REM_MEM_ACTION_NAME = "/remanmem";
	public static final String OPERATION_LIST_JOIN_MEM_PRO = "/getprocessmem";
	public static final String OPERATION_LIST_JOIN_MEM_GET_PRO = "/setprocessmem";

	// currency
	/*
	 * public static final String OPERATION_COUNT = "/count"; public static
	 * final String OPERATION_LIST_SET_MEM = "/csetmem"; public static final
	 * String OPERATION_LIST_GET_MEM = "/cgetmem"; public static final String
	 * OPERATION_LIST_GET_MEM_REM = "/cremsetmem/{removeKey}"; public static
	 * final String OPERATION_LIST_GET_MEM_REM_CD = "/ccdsetmem/{removeCd}";
	 * public static final String OPERATION_LIST_SET_NON_CACHE = "/csetnonmem";
	 * public static final String OPERATION_LIST_GET_MEM_REM_EXCEPT_KEY =
	 * "/cremsetmemnon/{key}"; public static final String
	 * OPERATION_LIST_SET_NON_CACHE_NAME = "/cnamenonmem"; public static final
	 * String OPERATION_LIST_SET_MEM_REM_CURRENCY_CD =
	 * "/ccdremsetmem/{removeCd}"; public static final String
	 * OPERATION_LIST_VO_MEM = "/custsetmem"; public static final String
	 * OPERATION_LIST_VO_MEMGET = "/custgetmem"; public static final String
	 * OPERATION_LIST_VO_MEMGETUPDATE = "/custupdatemem"; public static final
	 * String OPERATION_MAP = "/map"; public static final String
	 * OPERATION_MAP_SET_MEM_COMPOSITE = "/actionCompositeSetMem"; public static
	 * final String OPERATION_MAP_GET_MEM_COMPOSITE = "/actionCompositeGetMem";
	 * public static final String OPERATION_UPDATE_COMOSITE =
	 * "/update-composite"; public static final String
	 * OPERATION_MAP_GET_UPDATE_MEM_COMPOSITE = "/actionCompositeUpdateSetMem";
	 */
}
