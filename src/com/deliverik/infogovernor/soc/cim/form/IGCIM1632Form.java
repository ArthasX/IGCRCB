package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产项查询HELP画面用FORM
 * IGCOM0302Form ActionForm
 */
public class IGCIM1632Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	/** 设备ID */
	protected String eiid;
	
	/** 删除设备关系对象 */
	protected String[] deleteEirid;
	
	/** 关系类型 */
	protected String relationType;

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	
	
	
	
	
}
