package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ѯHELP������FORM
 * IGCOM0302Form ActionForm
 */
public class IGCIM1632Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	/** �豸ID */
	protected String eiid;
	
	/** ɾ���豸��ϵ���� */
	protected String[] deleteEirid;
	
	/** ��ϵ���� */
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
