package com.deliverik.framework.base;

import java.io.Serializable;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Base VO class.
 *
 */
@SuppressWarnings("serial")
public class BaseVO implements Serializable {

	/**
	 * 
	 * @param dest 
	 * @param source 
	 */
	protected void copyProperties(Object dest, Object source){
		try {
			PropertyUtils.copyProperties(dest, source);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}


