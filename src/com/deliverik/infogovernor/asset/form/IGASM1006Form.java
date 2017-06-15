package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产项关系管理画面FORM
 * 
 */
public class IGASM1006Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 资产项ID */
	protected String eiid;
	
	/**
	 * 资产项ID取得
	 * @return 资产项ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产项ID设定
	 *
	 * @param eiid 资产项ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

}
