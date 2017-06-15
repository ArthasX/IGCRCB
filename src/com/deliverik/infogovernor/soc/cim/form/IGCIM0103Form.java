package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备基本信息成功登录后确认画面FORM
 * 
 */
public class IGCIM0103Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 设备ID */
	protected Integer eiid;

	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 *
	 * @param eiid 设备ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
