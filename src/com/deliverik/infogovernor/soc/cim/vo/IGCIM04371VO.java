package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0437Info;

/**
 * ��ռ䷥ֵ�趨��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04371VO extends BaseVO implements Serializable{
	
	/** ��ռ䷥ֵ�趨������� */
	protected List<SOC0437Info> entityDataList;
	
	protected List<SOC0118Info> entityEntityDataList;
	
	public IGCIM04371VO(List<SOC0437Info> entityDataList){
		this.entityDataList = entityDataList;
	}

	public List<SOC0437Info> getEntityDataList() {
		return entityDataList;
	}

	public void setEntityDataList(List<SOC0437Info> entityDataList) {
		this.entityDataList = entityDataList;
	}

	public List<SOC0118Info> getEntityEntityDataList() {
		return entityEntityDataList;
	}

	public void setEntityEntityDataList(List<SOC0118Info> entityEntityDataList) {
		this.entityEntityDataList = entityEntityDataList;
	}
	
}


