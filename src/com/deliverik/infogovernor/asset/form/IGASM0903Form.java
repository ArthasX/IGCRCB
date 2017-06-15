package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 服务商基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0903Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 服务商ID */
	protected Integer eiid;

	/**
	 * 服务商ID取得
	 * @return 服务商ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 服务商ID设定
	 *
	 * @param eiid 服务商ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
