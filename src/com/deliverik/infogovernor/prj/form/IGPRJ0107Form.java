/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;

public class IGPRJ0107Form extends BaseForm {

	private static final long serialVersionUID = -2615999685796024261L;

	private Integer pid;
	private String mode;
	private String[] userids;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String[] getUserids() {
		return userids;
	}

	public void setUserids(String[] userids) {
		this.userids = userids;
	}
	
}
