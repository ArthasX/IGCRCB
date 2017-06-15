package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 服务商关系管理画面FORM
 * 
 */
public class IGASM0906Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 服务商ID */
	protected String eiid;
	
	/** 删除服务商关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 服务商ID取得
	 * @return 服务商ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 服务商ID设定
	 *
	 * @param eiid 服务商ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除服务商关系对象取得
	 * @return 删除服务商关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除服务商关系对象设定
	 *
	 * @param deleteEirid 删除服务商关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
