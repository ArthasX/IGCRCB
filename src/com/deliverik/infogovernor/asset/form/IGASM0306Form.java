package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备关系管理画面FORM
 * 
 */
public class IGASM0306Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 设备ID */
	protected String eiid;
	
	/** 删除设备关系对象 */
	protected String[] deleteEirid;
	
	/** 关系类型 */
	protected String relationType;
	/**
	 * 关系类型取得
	 * @return 关系类型
	 */
	public String getRelationType() {
		return relationType;
	}
	/**
	 * 关系类型设定
	 *
	 * @param relationType 关系类型
	 */
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 *
	 * @param eiid 设备ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除设备关系对象取得
	 * @return 删除设备关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除设备关系对象设定
	 *
	 * @param deleteEirid 删除设备关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
