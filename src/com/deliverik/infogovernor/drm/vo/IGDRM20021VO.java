/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * ����:  
 * ��������:  
 * ������¼:  
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGDRM20021VO extends BaseVO implements Serializable {
	
	private String planSectionTreeJson;

	public void setPlanSectionTreeJson(String planSectionTreeJson) {
		this.planSectionTreeJson = planSectionTreeJson;
	}

	public String getPlanSectionTreeJson() {
		return planSectionTreeJson;
	}
	
}
