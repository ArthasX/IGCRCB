package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 数据基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM1603Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 数据ID */
	protected Integer eiid;

	/**
	 * 数据ID取得
	 * @return 数据ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 数据ID设定
	 *
	 * @param eiid 数据ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
