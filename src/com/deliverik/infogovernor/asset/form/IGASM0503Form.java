package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 文档基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0503Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 文档ID */
	protected Integer eiid;

	/**
	 * 文档ID取得
	 * @return 文档ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 文档ID设定
	 *
	 * @param eiid 文档ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
