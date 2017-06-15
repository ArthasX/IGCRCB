package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 检查项关系管理画面FORM
 * 
 */
public class IGRIS0606Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 检查项ID */
	protected String eiid;
	
	/** 删除检查项关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 检查项ID设定
	 *
	 * @param eiid 检查项ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除检查项关系对象取得
	 * @return 删除检查项关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除检查项关系对象设定
	 *
	 * @param deleteEirid 删除检查项关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
