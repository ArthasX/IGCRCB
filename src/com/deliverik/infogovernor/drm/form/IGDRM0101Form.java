package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����������FORM
 * IGDRM0101Form ActionForm
 */
public class IGDRM0101Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String  stepPdid ; // �ʲ�ģ��ID
	private String  stepPrid ; // �ʲ�ģ��ID

	public String getStepPdid() {
		return stepPdid;
	}

	public void setStepPdid(String stepPdid) {
		this.stepPdid = stepPdid;
	}

	/**
	 * @return the stepPrid
	 */
	public String getStepPrid() {
		return stepPrid;
	}

	/**
	 * @param stepPrid the stepPrid to set
	 */
	public void setStepPrid(String stepPrid) {
		this.stepPrid = stepPrid;
	}

	
	
}
