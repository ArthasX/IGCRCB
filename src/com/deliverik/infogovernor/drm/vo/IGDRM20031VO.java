/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * ����:  
 * ��������:  
 * ������¼:  
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGDRM20031VO extends BaseVO implements Serializable {
	
	private List<SOC0117Info> entityDataList;

	public List<SOC0117Info> getEntityDataList() {
		return entityDataList;
	}

	public void setEntityDataList(List<SOC0117Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
}
