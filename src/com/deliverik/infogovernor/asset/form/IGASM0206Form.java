package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产项关系管理画面FORM
 * 
 */
public class IGASM0206Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 资产项ID */
	protected int eiid;
	
	/** 删除资产项关系对象 */
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
	 * 资产项ID取得
	 * @return 资产项ID
	 */
	public int getEiid() {
		return eiid;
	}

	/**
	 * 资产项ID设定
	 *
	 * @param eiid 资产项ID
	 */
	public void setEiid(int eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除资产项关系对象取得
	 * @return 删除资产项关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除资产项关系对象设定
	 *
	 * @param deleteEirid 删除资产项关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
