package com.deliverik.framework.base;

import java.io.Serializable;

import com.deliverik.framework.utility.BLErrorType;


/**
 *
 *
 */
@SuppressWarnings("serial")
public class BLError implements Serializable {

	protected BLErrorType type;

	protected String key;

	protected String[] mParam;


	/**
	 *
	 * @param type 
	 * @param key 
	 * @param mParam 
	 */
	public BLError(BLErrorType type, String key, String... mParam) {
		this.type = type;
		this.key = key;
		this.mParam = mParam;
	}


	/**
	 * 
	 * @return 
	 */
	public String getKey() {
		return key;
	}


	/**
	 * 
	 * @param key 
	 */
	public void setKey(String key) {
		this.key = key;
	}


	/**
	 * 
	 * @return 
	 */
	public String[] getMParam() {
		return mParam;
	}


	/**
	 * 
	 * @param mParam 
	 */
	public void setMParam(String[] param) {
		mParam = param;
	}


	/**
	 * 
	 * @return 
	 */
	public BLErrorType getType() {
		return type;
	}


	/**
	 * 
	 * @param type 
	 */
	public void setType(BLErrorType type) {
		this.type = type;
	}

}


