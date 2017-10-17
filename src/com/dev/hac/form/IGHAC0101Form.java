package com.dev.hac.form;

import com.deliverik.framework.base.BaseForm;

/**
 * HAC数据请求form
 * @author lvxin
 *
 */
@SuppressWarnings("serial")
public class IGHAC0101Form  extends BaseForm {
	/** 平台名称 */
	protected String platname;

	public String getPlatname() {
		return platname;
	}

	public void setPlatname(String platname) {
		this.platname = platname;
	}
	
	
}
