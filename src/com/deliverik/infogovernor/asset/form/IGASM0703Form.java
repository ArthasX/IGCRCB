package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0703Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 机房ID */
	protected Integer eiid;

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
