package com.deliverik.framework.utility;

/**
 *
 */
public enum BLErrorType {

	ENTITY_ALREADY_EXISTS("elabel"),
	
	CONFIGURATIONCODEDETAIL_ENTITY_ALREADY_EXISTS("ccdcategory"),
	
	CONFIGURATION_ALREADY_EXISTS("clabel"),
	
	ENTITY_NOT_EXISTS_ERROR ("elabel"),
	
	ENTITY_ITEM_ALREADY_EXISTS("eilabel"),

	ENTITY_CATEGORY_ERROR("elabel"),
	
	ENTITY_ITEM_RELATION_ERROR("eilabel"),
	
	CODECATEGORY_ALREADY_EXISTS_ERROR("ccid"),
	
	CODECATEGORY_NOT_EXISTS_ERROR("ccid"),
	
	CODEDETAIL_ALREADY_EXISTS_ERROR("cid"),
	
	CODEDETAIL_NOT_EXISTS_ERROR("cid"),
	
	RELATION_CODEDETAIL_ERROR("pccid,pcid"),
	
	COMMON_ERROR_TYPE
	;

	protected String[] field;

	/**
	 *
	 * @param field 
	 */
	private BLErrorType(String... field) {
		this.field = field;
	}

	/**
	 *
	 * @return 
	 */
	public String[] getField() {
		return field;
	}

}