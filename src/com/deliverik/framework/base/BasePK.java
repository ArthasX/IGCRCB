package com.deliverik.framework.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Base PK class.
 */
@SuppressWarnings("serial")
public class BasePK implements Serializable {

	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this,other);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
