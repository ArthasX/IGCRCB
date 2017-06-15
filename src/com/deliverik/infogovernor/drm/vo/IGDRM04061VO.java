package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * Ӧ����Դ����ҳ��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM04061VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<SOC0124Info> entityDataList;

	/**
	 * 
	 * @param entityData
	 */
	public IGDRM04061VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


