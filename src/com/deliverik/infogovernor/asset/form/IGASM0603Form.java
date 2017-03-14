package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 软件基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0603Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 软件ID */
	protected Integer eiid;

	/**
	 * 软件ID取得
	 * @return 软件ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 软件ID设定
	 *
	 * @param eiid 软件ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
