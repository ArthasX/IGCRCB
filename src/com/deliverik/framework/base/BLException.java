package com.deliverik.framework.base;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.utility.BLErrorType;


/**
 *
 */
@SuppressWarnings("serial")
public class BLException extends Exception {

	protected List<BLError> errorList = new ArrayList<BLError>();

	/**
	 *
	 */
	public BLException() {
	}

	/**
	 *
	 * @param type
	 * @param key 
	 * @param mParam 
	 */
	public BLException(BLErrorType type, String key, String... mParam) {
		errorList.add(new BLError(type, key, mParam));
	}


	/**
	 *
	 * @param type
	 * @param key 
	 * @param mParam 
	 */
	public BLException(String key, String... mParam) {
		errorList.add(new BLError(BLErrorType.COMMON_ERROR_TYPE, key, mParam));
	}


	/**
	 * 
	 *
	 * @param type 
	 * @param key 
	 * @param mParam 
	 */
	public void addError(BLErrorType type, String key, String... mParam) {
		errorList.add(new BLError(type, key, mParam));
	}


	/**
	 * 
	 * @param error 
	 */
	public void addError(BLError error) {
		errorList.add(error);
	}

	/**
	 * 
	 * @param errors 
	 */
	public void addError(List<BLError> errors) {
		errorList.addAll(errors);
	}

	/**
	 * 
	 * @return 
	 */
	public List<BLError> getErrors() {
		return errorList;
	}

}
