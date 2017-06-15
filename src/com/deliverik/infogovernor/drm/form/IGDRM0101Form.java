package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 场景定义用FORM
 * IGDRM0101Form ActionForm
 */
public class IGDRM0101Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String  stepPdid ; // 资产模型ID
	private String  stepPrid ; // 资产模型ID

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
