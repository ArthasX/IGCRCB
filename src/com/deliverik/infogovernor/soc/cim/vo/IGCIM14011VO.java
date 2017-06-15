package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * ��Ա��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM14011VO extends BaseVO implements Serializable{
	
	/** ��Ա��Ϣ������� */
	protected List<SOC0124Info> entityDataList;
	

	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

	public void setEntityDataList(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}


}


