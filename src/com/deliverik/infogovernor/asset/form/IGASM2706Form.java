package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 风险点关系管理画面FORM
 * 
 */
public class IGASM2706Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 风险点ID */
	protected String eiid;
	
	/** 删除风险点关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 风险点ID取得
	 * @return 风险点ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 风险点ID设定
	 *
	 * @param eiid 风险点ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除风险点关系对象取得
	 * @return 删除风险点关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除风险点关系对象设定
	 *
	 * @param deleteEirid 删除风险点关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
