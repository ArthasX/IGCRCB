package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 合同关系管理画面FORM
 * 
 */
public class IGASM0406Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 合同ID */
	protected String eiid;
	
	/** 删除合同关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 合同ID取得
	 * @return 合同ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 合同ID设定
	 *
	 * @param eiid 合同ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除合同关系对象取得
	 * @return 删除合同关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除合同关系对象设定
	 *
	 * @param deleteEirid 删除合同关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
