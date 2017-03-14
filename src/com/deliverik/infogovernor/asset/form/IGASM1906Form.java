package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备关系管理画面FORM
 * 
 */
public class IGASM1906Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 人员ID */
	protected String eiid;
	
	/** 删除人员关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 人员ID取得
	 * @return 人员ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 人员ID设定
	 *
	 * @param eiid 人员ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除人员关系对象取得
	 * @return 删除人员关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除人员关系对象设定
	 *
	 * @param deleteEirid 删除人员关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
