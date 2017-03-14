package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 组件关系管理画面FORM
 * 
 */
public class IGASM1706Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 组件ID */
	protected String eiid;
	
	/** 删除组件关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 组件ID取得
	 * @return 组件ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 组件ID设定
	 *
	 * @param eiid 组件ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除组件关系对象取得
	 * @return 删除组件关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除组件关系对象设定
	 *
	 * @param deleteEirid 删除组件关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
