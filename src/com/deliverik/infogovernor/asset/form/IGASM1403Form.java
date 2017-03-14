package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 服务记录基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM1403Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 服务记录ID */
	protected Integer eiid;

	/**
	 * 服务记录ID取得
	 * @return 服务记录ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 服务记录ID设定
	 *
	 * @param eiid 服务记录ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
